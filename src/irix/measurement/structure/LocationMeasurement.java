package irix.measurement.structure;

import irix.measurement.service.LocationMeasurementImp;


public class LocationMeasurement extends Measurement implements LocationMeasurementImp /*implements Comparable<LocationMeasurement>*/ {
    
    private LocationMeasurementAttributes locationMeasurementAttributes;

    public LocationMeasurement() {
    }

    public LocationMeasurement(LocationMeasurementAttributes locationMeasurementAttributes) {
        this.locationMeasurementAttributes = locationMeasurementAttributes;
    }

    public LocationMeasurementAttributes getLocationMeasurementAttributes() {
        return locationMeasurementAttributes;
    }

    public void setLocationMeasurementAttributes(LocationMeasurementAttributes locationMeasurementAttributes) {
        this.locationMeasurementAttributes = locationMeasurementAttributes;
    }    

    @Override
    public String toString() {
        return "locationAttributes=" + locationMeasurementAttributes;
    }

    @Override
    public int hashCode() {
        final int prime = 19;
        int hash = 5;
        hash = prime * hash + ((locationMeasurementAttributes == null) ? 0 : locationMeasurementAttributes.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LocationMeasurement)) return false;		
	return this.locationMeasurementAttributes == ((LocationMeasurement)obj).locationMeasurementAttributes;
    }

    public int compareTo(LocationMeasurement o) {
        return locationMeasurementAttributes.compareTo(o.getLocationMeasurementAttributes());
    }    
           
}
