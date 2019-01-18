package irix.data.handler;

import irix.converter.sections.LocLocationsSectional;
import irix.location.structure.HeightAttributes;
import irix.location.structure.LocGeographicCoordinates;
import irix.location.structure.LocHeight;
import irix.location.structure.LocLocation;
import irix.location.structure.LocationAttributes;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LocationsInfoHandler {
    
    private String urlLocationsInfoFile;

    public LocationsInfoHandler() {
    }

    public LocationsInfoHandler(String urlLocationsInfoFile) {
        this.urlLocationsInfoFile = urlLocationsInfoFile;
    }
    
    private Integer getAltitude(String expression){
        String regex = "[^\\d+]";     
        return Integer.valueOf(expression.replaceAll(regex, ""));
    }
    
    private Double getGeoCoordinate(String expression){
        String regex = "[^\\d+\\.\\d+]";     
        return Double.valueOf(expression.replaceAll(regex, ""));
    }
        
    private String getStationName(String expression){
        String regex = "[^a-zA-Z]";     
        return expression.replaceAll(regex, "");
    }
    
    private Integer getLocationId(String expression){
        String regex = "[\\d]{5}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);
        Integer stationCode = null;
        if(matcher.find()){  
            stationCode = Integer.valueOf(expression.substring(matcher.start(), matcher.start() + 5)); 
        }        
        return stationCode;
    } 
    
    public Map<Integer, LocLocationsSectional> getLocationsInfo/* getStationsData */ () throws IOException{
        Map<Integer, LocLocationsSectional>locationsMap = new HashMap<Integer, LocLocationsSectional>();
        URL connectURL = new File(urlLocationsInfoFile/* "./src/resources/rodoseStationsList.php" */).toURI().toURL();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connectURL.openStream()))) {
            
            StringBuilder sb = new StringBuilder();
            String inputLine;
            
            Integer id = null;
            String name = null;
            Double lat = null;
            Double lon = null;
            Integer alt = null;
            boolean flag = false;
            
            while ((inputLine = in.readLine()) != null){
                if(inputLine.contains(" => array")){
                    id = getLocationId(inputLine);
                }
                if(inputLine.contains("station_name")){
                    name = getStationName(inputLine.substring(inputLine.indexOf("station_name") + "station_name".length()));
                } 
                if(inputLine.contains("latitude")){
                    lat = getGeoCoordinate(inputLine);
                } 
                if(inputLine.contains("longitude")){
                    lon = getGeoCoordinate(inputLine);
                }
                if(inputLine.contains("altitude")){
                    alt = getAltitude(inputLine);    
                    flag = true;
                }
                
                if(flag){
                    flag = false;
                    
                    locationsMap.putIfAbsent(id,new LocLocationsSectional(
                        new LocLocation(name, 
                        new LocGeographicCoordinates(lat,lon, 
                            new LocHeight(alt, 
                                new HeightAttributes("Sea", "m"))), 
                        new LocationAttributes(id))));
                    
                }  
                sb.append(inputLine);
            }            
        }
        return locationsMap;
    }
            
//    public static void main(String [] args) throws IOException{        
//        
///*
//        Iterator<LocLocationsSectional> it = locationsSet.iterator();
//        while(it.hasNext()){
//           System.out.println(it.next().getLocLocation().getLocName());
//        }
//*/
//    }
    
}
