package irix.data.handler;

import irix.converter.sections.MonMeasurementsSectional;
import irix.measurement.structure.LocLocationMeasurement;
import irix.measurement.structure.LocationMeasurementAttributes;
import irix.measurement.structure.MeasurementsSectionalAttributes;
import irix.measurement.structure.MonDoseRate;
import irix.measurement.structure.MonMeasurement;
import irix.measurement.structure.MonMeasurements;
import irix.measurement.structure.MonMeasuringPeriod;
import irix.measurement.structure.MonValue;
import irix.measurement.structure.ValueAttributes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MeasurementsInfoHandler {
    
    private String txtMeasurementsInfoFile;

    public MeasurementsInfoHandler() {
    }

    public MeasurementsInfoHandler(String txtMeasurementsInfoFile) {
        this.txtMeasurementsInfoFile = txtMeasurementsInfoFile;
    }
    
//    public static void main(String [] args) throws IOException, ParseException{  
//                                
//        Map <Integer,MonMeasurementsSectional> fullMeasurementsMap = getFullDataArray("./src/resources/Radiation.txt");
//        for (Map.Entry entry: fullMeasurementsMap.entrySet()) { 
//            Integer key = (Integer) entry.getKey(); 
//            MonMeasurementsSectional value = (MonMeasurementsSectional) entry.getValue(); 
//            System.out.println(key + ": " + value); 
//        } 
//    
//    }
    
    private String getLocalDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDateTime now = LocalDateTime.now();
	return dtf.format(now);
    }
    
    private String getLocalTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	return dtf.format(now);
    }
    
    private String correctTime(String expression){
        String hours = null;
        String minutes = null;
        String seconds = null;     
        Integer index = expression.length()-1 - new StringBuilder(expression).reverse().toString().indexOf(':');
        if(isStandartTime(expression)){ 
            hours = expression.substring(0,expression.indexOf(':'));            
            minutes = expression.substring(expression.indexOf(':')+1, index);
            seconds = expression.substring(index+1, expression.length());            
            if(hours == null || hours.equals("") || hours.isEmpty()){
                hours = "00";
            }
            if( minutes == null || minutes.equals("") || minutes.isEmpty()){
                minutes = "00";
            }
            if(seconds == null || seconds.equals("") || seconds.isEmpty()){
                seconds = "00";
            }            
        }
        return hours.concat(":").concat(minutes).concat(":").concat(seconds);
    }
    
    private boolean isStandartTime(String expression){
        String regex = "[0-9]{0,2}:[0-9]{0,2}:[0-9]{0,2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);
        return matcher.find() == true ? true : false;
    }
    
    private String getISODatePattern(){
        return "yyyy-MM-dd'T'HH:mm:ss'Z'";
    }
    
    private String getISOStandartDate(String localDate){
        String localTime = getLocalTime(); 
        return localDate.concat("T" + localTime + "Z");
    }
    
    private String getISOStandartDate(String localDate, String localTime){        
        return localDate.concat("T" + localTime + "Z");
    }
    
    private String getUtcDateTime(String date, String time) throws ParseException {
        String isoDatePattern = getISODatePattern();
        DateFormat formatterIST = new SimpleDateFormat(isoDatePattern);
        formatterIST.setTimeZone(TimeZone.getTimeZone("Europe/Kiev")); 
        String isoStandartDate = null;
        if(time == null){
            isoStandartDate = getISOStandartDate(date); 
        }
        else{
            isoStandartDate = getISOStandartDate(date, time);
        }        
        Date isoStandartedDate = formatterIST.parse(isoStandartDate);
        String output = formatterIST.format(isoStandartedDate);
        return output;
    }
    
    private String getUtcCurrentDateTime() throws ParseException {
        String isoDatePattern = getISODatePattern();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(isoDatePattern);
        return simpleDateFormat.format(new Date());
    }
    
    private boolean isInMap(Map <Integer,MonMeasurementsSectional> inputMap, Integer stationCode){
        Integer itemsNumberCounter = 0;
        boolean flag = false;
	for (Map.Entry entry: inputMap.entrySet()) {
            Integer key = (Integer) entry.getKey(); 
            if(!key.equals(stationCode)){
		itemsNumberCounter++;	
            }	
            else{
                flag = true;
		break;
            }
	}
	return !flag && itemsNumberCounter == inputMap.size() ? false : true;
    }
    
    private String clearFromNonASCIISymbols(String expression){
        String regex = "[^\\x20-\\x7e]"; 
        return expression.replaceAll(regex, "");
    }
    
    private Map <Integer,MonMeasurementsSectional> getDataArrayByTime(Integer time) {	
        
        File file = new File(txtMeasurementsInfoFile); 
  
        BufferedReader bufferedReader = null; 
        String readLine;
        Map <Integer,MonMeasurementsSectional> measurementsMap = new HashMap<Integer,MonMeasurementsSectional>();
        
        try {
            bufferedReader = new BufferedReader(new FileReader(file));            
            while ((readLine = bufferedReader.readLine()) != null) {
                readLine = clearFromNonASCIISymbols(readLine);
                String measurementDate = getLocalDate();
                String validAt = null;
                try {
                    validAt = getUtcCurrentDateTime();
                } catch (ParseException ex) {
                    Logger.getLogger(MeasurementsInfoHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(!readLine.isEmpty()){
                    String[] sublines = readLine.split("\\s+"); 
                    String measurementHours = ""; String measurementMinutes = ""; String measurementSeconds = ""; 
                    String startTime = null; String endTime = null;
                    Double microroentgen = null;
                    Double nanosievert = null;
                    Integer stationCode = null;
                    if(sublines.length >= 3 && !sublines[2].equals("")){
                        stationCode = Integer.valueOf(sublines[0]); 
                        measurementHours = sublines[1].substring(3, 5); 
                        String measurementStartTime = correctTime(measurementHours.concat(":").concat(measurementMinutes).concat(":").concat(measurementSeconds));
                        String measurementEndTime = correctTime(String.valueOf(Integer.valueOf(measurementHours)-1).concat(":").concat(measurementMinutes).concat(":").concat(measurementSeconds));
                        try {
                            startTime = getUtcDateTime(measurementDate,measurementStartTime);
                            endTime = getUtcDateTime(measurementDate,measurementEndTime);
                        } catch (ParseException ex) {
                            Logger.getLogger(MeasurementsInfoHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        microroentgen = Double.valueOf(sublines[2].substring(3, 5));
                        nanosievert = 8.73 * microroentgen;
                    } 
                    
                    MonMeasurementsSectional measurements = new MonMeasurementsSectional(
                        new MonDoseRate(
                            "Gamma", 
                            new MonMeasuringPeriod(startTime, endTime), 
                                new MonMeasurements(
                                    new MonMeasurement(
                                        new LocLocationMeasurement(
                                            new LocationMeasurementAttributes(String.valueOf(stationCode))), 
                                        new MonValue(nanosievert, 
                                            new ValueAttributes("Sv/h")),
                                                "NotValidated"))),
                        new MeasurementsSectionalAttributes(validAt));
                    
                    if(stationCode!=null && !isInMap(measurementsMap,stationCode)) {   
                        if(Integer.valueOf(measurementHours).equals(time)){
                            measurementsMap.put(stationCode, measurements);
                        }
                    }
                }                
            } 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MeasurementsInfoHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(MeasurementsInfoHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return measurementsMap;
    }
    
    public Map <Integer,MonMeasurementsSectional> getMeasurementsInfo /* getFullDataArray */(){
	Map <Integer,MonMeasurementsSectional> fullMeasurementsMap = new HashMap<Integer,MonMeasurementsSectional>();
	Map <Integer,MonMeasurementsSectional> timeMeasurementsMap = new HashMap<Integer,MonMeasurementsSectional>();
	for(int i = 9; i >= 6; i--){
            timeMeasurementsMap = getDataArrayByTime(i);
            for (Map.Entry entry: timeMeasurementsMap.entrySet()) {
                Integer key = (Integer) entry.getKey(); 
                MonMeasurementsSectional value = (MonMeasurementsSectional) entry.getValue();
		if(!isInMap(fullMeasurementsMap, key)){
                    fullMeasurementsMap.put(key,value);
		}
            }			
	}
	return fullMeasurementsMap;
    }
    
}
