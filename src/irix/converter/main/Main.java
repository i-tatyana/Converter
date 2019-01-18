package irix.converter.main;

import irix.converter.sections.General;
import irix.converter.sections.IdIdentificationSectional;
import irix.converter.sections.LocLocationsSectional;
import irix.converter.sections.MonMeasurementsSectional;
import irix.data.handler.IdentificationInfoHandler;
import irix.data.handler.LocationsInfoHandler;
import irix.data.handler.MeasurementsInfoHandler;
import irix.data.handler.OrganizationContactInfoHandler;
import irix.data.handler.PersonContactInfoHandler;
import irix.xml.service.XmlBuilder;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Main {
    
    public static void main(String [] args) throws IOException{
       
        processing(new File("./"));
        
    }
    
    public static void processing(File folder) throws IOException{    
        
        IdentificationInfoHandler identification_data = new IdentificationInfoHandler(
                "./src/resources/IdentificationInfo.csv", 
                new PersonContactInfoHandler("./src/resources/PersonContactInfo.csv"), 
                new OrganizationContactInfoHandler("./src/resources/OrganizationContactInfo.csv"));

        IdIdentificationSectional identification = identification_data.getIdentificationInfo();
        
        MeasurementsInfoHandler measurements_data = new MeasurementsInfoHandler("./src/resources/Radiation.txt");
        Map<Integer, MonMeasurementsSectional>measurements = measurements_data.getMeasurementsInfo();
        
        LocationsInfoHandler locations_data = new LocationsInfoHandler("./src/resources/rodoseStationsList.php");
        Map<Integer, LocLocationsSectional>locations = locations_data.getLocationsInfo();
        
        List<MonMeasurementsSectional>measurementsList = new ArrayList<MonMeasurementsSectional>();
        List<LocLocationsSectional>locationsList = new ArrayList<LocLocationsSectional>();
        
        for (Map.Entry measurement : measurements.entrySet()) {
            MonMeasurementsSectional measurements_list = (MonMeasurementsSectional) measurement.getValue();
            for (Map.Entry location : locations.entrySet()) {
                LocLocationsSectional locations_list = (LocLocationsSectional) location.getValue();
                if(measurement.getKey().equals(location.getKey())){                    
                    measurementsList.add(measurements_list);
                    locationsList.add(locations_list);
                }                
            } 
        }

        General general = new General(identification, measurementsList, locationsList);
        
        XmlBuilder xml = new XmlBuilder("irix:Report");
        xml.createIdentification(general);
        xml.createMeasurement(general);
        xml.createLocationElement(general);
        xml.writeContentIntoFile("./src/resources/RadiationDose.xml");
                
    }
}