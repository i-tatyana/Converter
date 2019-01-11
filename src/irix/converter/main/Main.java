package irix.converter.main;

import irix.convertor.sections.IdentificationSectional;
import irix.convertor.sections.LocationsSectional;
import irix.convertor.sections.MeasurementsSectional;
import irix.identification.structure.Identifications;
import irix.identification.structure.OrganizationContactDetails;
import irix.identification.structure.PersonContactDetails;
import irix.identification.structure.ReportDetails;
import irix.location.structure.GeographicCoordinates;
import irix.location.structure.Height;
import irix.location.structure.HeightAttributes;
import irix.location.structure.Location;
import irix.location.structure.LocationAttributes;
import irix.measurement.structure.DoseRate;
import irix.measurement.structure.LocationMeasurement;
import irix.measurement.structure.LocationMeasurementAttributes;
import irix.measurement.structure.Measurement;
import irix.measurement.structure.Measurements;
import irix.measurement.structure.MeasurementsSectionalAttributes;
import irix.measurement.structure.MeasuringPeriod;
import irix.measurement.structure.Value;
import irix.measurement.structure.ValueAttributes;
import irix.section.identifier.Sectional;
import irix.xml.service.XmlBuilder;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    
    public static void main(String [] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException{
       
        processing(new File("./"));
        
    }
    
    static <T> Field[] inspect(Class<T> klazz) {
        Field[] fields = klazz.getDeclaredFields();
        return fields;
    }
    
    
    static Object createObject(String className) {
        Object object = null;
        try {
            Class classDefinition = Class.forName(className);
            object = classDefinition.newInstance();
        } 
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
    
    private static boolean isSectional(String classPath){
        return classPath.contains("sections");
    }
    
    private static boolean hasPrefix(String classPath, String prefix){
        return classPath.contains(prefix);
    }
    
    private static String getPackageName(String className){
        String prefix = ".\\build\\classes\\";
        List<File> files = getFileList(new File("./"));
        String packageName = null;
        
        for(File file : files){
            if(file.getPath().endsWith(className.concat(".class")) && isClass(file.getPath())){
                if(hasPrefix(file.getPath(), prefix)){
                    Integer start_index = file.getPath().indexOf(prefix) + prefix.length();
                    Integer end_index = file.getPath().indexOf(className);
                    packageName = file.getPath().substring(start_index, end_index-1);
                }  
                else{
                    return packageName.concat(".").concat(className);
                }
            }
        }
        return clearClassPath(packageName).concat(".").concat(className);
    }
    
    private static boolean isInnerClass(String packageName){
        Class clazz = null;
        try {
            clazz = Class.forName(packageName);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clazz.getEnclosingClass()!= null ? true : false;
    }
    
    private static List<File> getFileList(File folder){
        File[] folderEntries = folder.listFiles();
        List<File> files = new ArrayList<File>();
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                List<File> subFolderEntries = getFileList(entry);    
                for (File subEntry : subFolderEntries) {
                    if(subEntry.isFile())
                    files.add(subEntry);
                }
            }
            if(entry.isFile()){
                files.add(entry);
            }
        }
        return files;
    }
    
    public static void processing(File folder) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException{       
        List<File> files = getFileList(folder);
        XmlBuilder xml = new XmlBuilder("irix:Report");
        Set<Class>objects = new LinkedHashSet<Class>();
        for(File file : files){
            if(isSectional(file.getPath())) {
                if(isClass(file.getPath())){
                    String class_name = file.getName().replace(".class", "");  
                    String package_name = getPackageName(class_name);
                    Class sectionalClass = Class.forName(package_name);
                                        
                    Map<Class, List<Field>> elements = getAllIrixElements(class_name);
                    
                    IdentificationSectional identification = new IdentificationSectional(
                            new ReportDetails("met.gov", "09.01.2019", "secret", "45", "super confidial"), 
                            new Identifications(
                                    new PersonContactDetails("Vasya", "met.gov", "met@gmail.com"), 
                                    new OrganizationContactDetails("Vasya","organisationID", "country", "phoneNumber", "faxNumber", "emailAddress", "description")));

                    MeasurementsSectional measurement = new MeasurementsSectional(
                            new DoseRate(
                                "Gamma", 
                                new MeasuringPeriod("12.1.2019", "25.1.2019"), 
                                new Measurements(
                                    new Measurement(
                                        new LocationMeasurement(
                                            new LocationMeasurementAttributes("?????")), 
                                        new Value(12.0, 
                                            new ValueAttributes("Sv/h")),
                                        "Validated"))),
                            new MeasurementsSectionalAttributes("2019.01.02"));
                      
//                        System.out.println(
//                                measurement.getDoseRate().getDoseRateType() + " " +
//                                        
//                                measurement.getDoseRate().getMeasuringPeriod().getStartTime() + " " +
//                                measurement.getDoseRate().getMeasuringPeriod().getEndTime() + " " +
//                                        
//                                measurement.getDoseRate().getMeasurements().getMeasurement().getLocationMeasurement().getLocationMeasurementAttributes().getRef() + " " +
//                                measurement.getDoseRate().getMeasurements().getMeasurement().getValue().getDosePhantom() + " " +
//                                measurement.getDoseRate().getMeasurements().getMeasurement().getValue().getValueAttributes().getUnit() + " " +
//                                measurement.getDoseRate().getMeasurements().getMeasurement().getValidated() + " " + 
//                                measurement.getMeasurementsSectionalAttributes().getValidAt()
//                        );

                        
                        
                    LocationsSectional location = new LocationsSectional(
                            new Location("Snovsk", 
                            new GeographicCoordinates(35.78,23.67, 
                                    new Height(145, 
                                            new HeightAttributes("Sea", "m"))), 
                            new LocationAttributes(34)));
//                    System.out.println(
//                            location.getLocation().getLocationName() + " " +
//                            location.getLocation().getGeographicCoordinates().getLatitude()+ " " + 
//                            location.getLocation().getGeographicCoordinates().getLongitude()+ " " + 
//                            location.getLocation().getGeographicCoordinates().getHeight().getAltitudePhantom()+ " " + 
//                            location.getLocation().getGeographicCoordinates().getHeight().getHeightAttributes().getAbove()+ " " + 
//                            location.getLocation().getGeographicCoordinates().getHeight().getHeightAttributes().getUnit()+ " " +
//                            location.getLocation().getLocationAttributes().getId());

                    Sectional sectional = new Sectional(identification, measurement, location);
//                    System.out.println(sectional);
                    
                        
//                        System.out.println(
//                                sectional.getMeasurementsSectional().getDoseRate().getDoseRateType()  + " " +
//                                        
//                                sectional.getMeasurementsSectional().getDoseRate().getMeasuringPeriod().getStartTime() + " " +
//                                sectional.getMeasurementsSectional().getDoseRate().getMeasuringPeriod().getEndTime() + " " +
//                                        
//                                sectional.getMeasurementsSectional().getDoseRate().getMeasurements().getMeasurement().getLocationMeasurement().getLocationMeasurementAttributes().getRef() + " " +
//                                sectional.getMeasurementsSectional().getDoseRate().getMeasurements().getMeasurement().getValue().getDosePhantom() + " " +
//                                sectional.getMeasurementsSectional().getDoseRate().getMeasurements().getMeasurement().getValue().getValueAttributes().getUnit() + " " +
//                                sectional.getMeasurementsSectional().getDoseRate().getMeasurements().getMeasurement().getValidated() + " " + 
//                                sectional.getMeasurementsSectional().getMeasurementsSectionalAttributes().getValidAt()
//                        );
           
                    for (Map.Entry entry: elements.entrySet()) {
                        Class key = (Class) entry.getKey();
                        List<Field> value = (List<Field>) entry.getValue(); 
                        List<Field> fields = getHierarchy(value);
                       
                        Method method = null; 
                        
                        if(class_name.contains("Sectional")){
                            if(key.getPackage().getName().contains("sections")){
                                System.out.println(key.getSimpleName());
                                xml.createElement(key.getSimpleName());
                            }
                            else{
                                if(!fields.isEmpty()){   
                                    if(!key.getSimpleName().contains("Attributes")){
                                        xml.createElement(key.getSuperclass().getSimpleName(), key.getSimpleName());
                                        for(Field field : fields){
                                            method = getMethod(sectionalClass,field.getName()); 
                                            if(field.getName().contains("Phantom")){
                                                System.out.println("Phantom");
                                                xml.setElementValue(key.getSimpleName(), String.valueOf(method.invoke(sectional, null)));
                                                System.out.println(key.getSimpleName() + " " + String.valueOf(method.invoke(sectional, null)));
                                            }
                                            else{                                                
                                                System.out.println(field.getName() + " " + method.getName() + " " + String.valueOf(method.invoke(sectional, null)) + " " + key.getSimpleName());                                        
                                                xml.createElement(key.getSimpleName(), field.getName().substring(0, 1).toUpperCase().concat(field.getName().substring(1)), String.valueOf(method.invoke(sectional, null)));
                                            }
                                        }
                                    }
                                    else{                                        
                                        for(Field field : fields){ 
                                            method = getMethod(sectionalClass,field.getName()); 
                                            System.out.println("Troubles!!! " + field.getName() + " " + method.getName() + " " + String.valueOf(method.invoke(sectional, null)) + " " + key.getSimpleName());                                        
                                            xml.createAttribute(key.getSuperclass().getSimpleName(), field.getName(), String.valueOf(method.invoke(sectional, null)));
                                        }
                                    }                                    
                                }
                                else{
                                    // fields are empty
                                    System.out.println(key.getSimpleName());
                                    xml.createElement(key.getSuperclass().getSimpleName(), key.getSimpleName());
                                }
                            }                        
                        } 
                    }                    
                    xml.writeContentIntoFile("C:\\Users\\user\\Desktop\\file.xml");  
                }  
            }
        }
    }
    
    private static XmlBuilder chooseSection(Class sectionalClass, String class_name, Class key, List<Field> fields, Sectional object, XmlBuilder xml) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        switch(class_name){
            case "IdentificationSectional":{
                xml = convertToXml(sectionalClass, key, fields, object, xml);
                break;
            }
            case "MeasurementsSectional":{
                xml = convertToXml(sectionalClass, key, fields, object, xml);
                break;
            }
            case "LocationsSectional":{
                xml = convertToXml(sectionalClass, key, fields, object, xml);
                break;
            }
        }
        return xml;
    }
    
    private static XmlBuilder convertToXml(Class sectionalClass, Class key, List<Field> fields, Sectional object, XmlBuilder xml) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        Method method = null;                         
        if(key.getPackage().getName().contains("sections")){
            System.out.println(key.getSimpleName());
            xml.createElement(key.getSimpleName());
        }
        else{
            if(!fields.isEmpty()){   
                if(!key.getSimpleName().contains("Attributes")){
                    xml.createElement(key.getSuperclass().getSimpleName(), key.getSimpleName());
                    for(Field field : fields){
                        method = getMethod(sectionalClass,field.getName()); 
                        if(field.getName().contains("Phantom")){
                            System.out.println("Phantom");
                            xml.setElementValue(key.getSimpleName(), String.valueOf(method.invoke(object, null)));
                            System.out.println(key.getSimpleName() + " " + String.valueOf(method.invoke(object, null)));
                        }
                        else{                                                
                            System.out.println(field.getName() + " " + method.getName() + " " + String.valueOf(method.invoke(object, null)) + " " + key.getSimpleName());                                        
                            xml.createElement(key.getSimpleName(), field.getName().substring(0, 1).toUpperCase().concat(field.getName().substring(1)), String.valueOf(method.invoke(object, null)));
                        }
                    }
                }
                else{                                        
                    for(Field field : fields){ 
                        method = getMethod(sectionalClass,field.getName()); 
                        System.out.println(field.getName() + " " + method.getName() + " " + String.valueOf(method.invoke(object, null)) + " " + key.getSimpleName());                                        
                        xml.createAttribute(key.getSuperclass().getSimpleName(), field.getName(), String.valueOf(method.invoke(object, null)));
                    }
                }                                    
            }
            else{
                // fields are empty
                System.out.println(key.getSimpleName());
                xml.createElement(key.getSuperclass().getSimpleName(), key.getSimpleName());
            }
        }
        return xml;
    }
    
    private static List<Field> getHierarchy(List<Field>inputFields){
        List<Field>outputFields = new LinkedList<Field>();
        for(Field field : inputFields){                            
            if(isPrimitiveType(field)){
                outputFields.add(field);   
            }  
        }
        return outputFields;
    }
      
    private static boolean isInList(List <Class> inputList, Class clazz){
        Integer itemsNumberCounter = 0;
        boolean flag = false;
	for (Class cla_s : inputList) {
            if(!cla_s.getSimpleName().equals(clazz.getSimpleName())){
		itemsNumberCounter++;	
            }	
            else{
                flag = true;
		break;
            }
	}
	return !flag && itemsNumberCounter == inputList.size() ? false : true;
    }
    
    private static Method getMethod(Class clazz, String fieldName){
        Method [] methods = clazz.getMethods();       
        for(Method method : methods){
            String methodName = fieldName.substring(0, 1).toUpperCase().concat(fieldName.substring(1));
            if(method.getName().equals("get".concat(methodName))){
                return method;
            } 
            else{
                continue;
            }
        }
        return null;
    }
    
    private static Class getClass(String packageName){
        Class clazz = null;
        try {
            clazz = Class.forName(packageName);            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clazz;
    }
    
    private static boolean hasPackage(String path, String packageName){
        return path.contains(packageName);
    }
    
    private static String getClassObject(Object classObject) {
        String packageName = classObject.getClass().getPackage().getName();
        List<File> files = getFileList(new File("./"));
        for(File file : files){
            if(hasPackage(file.getPath(),packageName)){
                System.out.println(file);
            }            
        }        
        return packageName;
    }
    
    private static boolean isPrimitiveType(Field field){
        String fieldType = field.getType().getSimpleName();
        return fieldType.equals("Double") || fieldType.equals("String") || fieldType.equals("Integer") || fieldType.equals("Date");
    }
    
    private static Map<Class, List<Field>> getAllIrixElements(String class_name) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException{
        String package_name = getPackageName(class_name);        
        Class clazz = getClass(package_name);
        Field[] fields = inspect(clazz);
        Map<Class, List<Field>> fieldsMap = new LinkedHashMap<Class, List<Field>>();
        List<Field> fieldsList = new ArrayList<Field>();
        if(fields.length>=0){
            for(int i = 0; i < fields.length; i++){
                String fieldType = fields[i].getType().getSimpleName();
                if(fieldType.equals("Double") || fieldType.equals("String") || fieldType.equals("Integer") || fieldType.equals("Date")){
                    fieldsList.add(fields[i]);
                    fieldsMap.put(clazz, fieldsList);
                }
                else{
                    fieldsList.add(fields[i]);
                    fieldsMap.put(clazz, fieldsList);
                    fieldsMap.putAll(getAllIrixElements(fieldType));                    
                }
            }            
        }    
        return fieldsMap;
    }

    private static boolean isClass(String path){
        return String.valueOf(path).endsWith(".class");
    }
    
    private static String clearAllSymbolsInPathBeginning(String expression){
        String regex = "(?m)^\\.*\\\\*";     
        return expression.replaceAll(regex, "");
    }
    
    private static String clearFromEnd(String expression){
        String regex = "\\\\$";     
        return expression.replaceAll(regex, "");
    }
    
    private static String clearClassPath(String path){
       // String prefix = ".\";
        String clearedPath = clearAllSymbolsInPathBeginning(path);
        clearedPath = clearedPath.replace(".class", "");
//        if(prefix != null){
//            clearedPath = clearedPath.substring(clearedPath.indexOf(prefix), clearedPath.length());
//        }
        return clearedPath.replaceAll("\\\\","\\.");
    }
         
}