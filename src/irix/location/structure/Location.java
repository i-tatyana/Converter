package irix.location.structure;

import irix.convertor.sections.LocationsSectional;
import irix.location.service.LocationImp;


public class Location extends LocationsSectional implements LocationImp /*, Comparable<Location>*/ {
        
    private String locationName;
    private GeographicCoordinates geographicCoordinates;
    private LocationAttributes locationAttributes;

    public Location() {
    }

    public Location(String locationName, GeographicCoordinates geographicCoordinates, LocationAttributes locationAttributes) {
        this.locationName = locationName;
        this.geographicCoordinates = geographicCoordinates;
        this.locationAttributes = locationAttributes;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public GeographicCoordinates getGeographicCoordinates() {
        return geographicCoordinates;
    }

    public void setGeographicCoordinates(GeographicCoordinates geographicCoordinates) {
        this.geographicCoordinates = geographicCoordinates;
    }

    public LocationAttributes getLocationAttributes() {
        return locationAttributes;
    }

    public void setLocationAttributes(LocationAttributes locationAttributes) {
        this.locationAttributes = locationAttributes;
    }
    
    @Override
    public String toString() {
        return "locationName=" + locationName + ", "
                + "geographicCoordinates=" + geographicCoordinates + ", "
                + "locationAttributes=" + locationAttributes;
    }
 
    @Override
    public int hashCode() {
        final int prime = 97;
        int hash = 3;
        hash = prime * hash + ((locationName == null) ? 0 : locationName.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Location)) return false;		
	return this.locationName == ((Location)obj).locationName;
    }

    public int compareTo(Location o) {        
        return geographicCoordinates.compareTo(o.geographicCoordinates);
    }
    
}
