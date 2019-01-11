package irix.measurement.structure;

import irix.measurement.service.LocationMeasurementImp;


public class LocLocationMeasurement extends MonMeasurement implements LocationMeasurementImp /*implements Comparable<LocationMeasurement>*/ {
    
    private LocationMeasurementAttributes locationMeasurementAttributes;

    public LocLocationMeasurement() {
    }

    public LocLocationMeasurement(LocationMeasurementAttributes locationMeasurementAttributes) {
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
        if (!(obj instanceof LocLocationMeasurement)) return false;		
	return this.locationMeasurementAttributes == ((LocLocationMeasurement)obj).locationMeasurementAttributes;
    }

    public int compareTo(LocLocationMeasurement o) {
        return locationMeasurementAttributes.compareTo(o.getLocationMeasurementAttributes());
    }    
           
}
