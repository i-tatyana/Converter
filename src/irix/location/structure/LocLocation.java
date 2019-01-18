package irix.location.structure;

import irix.converter.sections.LocLocationsSectional;
import irix.location.service.LocationImp;


public class LocLocation extends LocLocationsSectional implements LocationImp /*, Comparable<Location>*/ {
        
    private String locName;
    private LocGeographicCoordinates locGeographicCoordinates;
    private LocationAttributes locationAttributes;

    public LocLocation() {
    }

    public LocLocation(String locName, LocGeographicCoordinates locGeographicCoordinates, LocationAttributes locationAttributes) {
        this.locName = locName;
        this.locGeographicCoordinates = locGeographicCoordinates;
        this.locationAttributes = locationAttributes;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }
    
    public LocGeographicCoordinates getLocGeographicCoordinates() {
        return locGeographicCoordinates;
    }

    public void setLocGeographicCoordinates(LocGeographicCoordinates locGeographicCoordinates) {
        this.locGeographicCoordinates = locGeographicCoordinates;
    }

    public LocationAttributes getLocationAttributes() {
        return locationAttributes;
    }

    public void setLocationAttributes(LocationAttributes locationAttributes) {
        this.locationAttributes = locationAttributes;
    }
    
    @Override
    public String toString() {
        return "locName=" + locName + ", "
                + "locGeographicCoordinates=" + locGeographicCoordinates + ", "
                + "locationAttributes=" + locationAttributes;
    }
 
    @Override
    public int hashCode() {
        final int prime = 97;
        int hash = 3;
        hash = prime * hash + ((locName == null) ? 0 : locName.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LocLocation)) return false;		
	return this.locName == ((LocLocation)obj).getLocName();
    }

    public int compareTo(LocLocation o) {        
        return locGeographicCoordinates.compareTo(o.getLocGeographicCoordinates());
    }
    
}
