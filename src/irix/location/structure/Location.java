package irix.location.structure;

import irix.convertor.sections.LocationsSectional;
import irix.location.service.LocationImp;


public class Location extends LocationsSectional implements LocationImp /*, Comparable<Location>*/ {
        
    private String name;
    private GeographicCoordinates geographicCoordinates;
    private LocationAttributes locationAttributes;

    public Location() {
    }

    public Location(String name, GeographicCoordinates geographicCoordinates, LocationAttributes locationAttributes) {
        this.name = name;
        this.geographicCoordinates = geographicCoordinates;
        this.locationAttributes = locationAttributes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "name=" + name + ", "
                + "geographicCoordinates=" + geographicCoordinates + ", "
                + "locationAttributes=" + locationAttributes;
    }
 
    @Override
    public int hashCode() {
        final int prime = 97;
        int hash = 3;
        hash = prime * hash + ((name == null) ? 0 : name.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Location)) return false;		
	return this.name == ((Location)obj).name;
    }

    public int compareTo(Location o) {        
        return geographicCoordinates.compareTo(o.geographicCoordinates);
    }
    
}
