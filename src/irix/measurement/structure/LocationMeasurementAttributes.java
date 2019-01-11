package irix.measurement.structure;

import irix.measurement.service.LocationMeasurementAttributesImp;


public class LocationMeasurementAttributes extends LocLocationMeasurement implements LocationMeasurementAttributesImp /*implements Comparable<LocationAttributesMeasurement>*/ {
    
    private String ref;

    public LocationMeasurementAttributes() {
    }

    public LocationMeasurementAttributes(String ref) {
        this.ref = ref;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    @Override
    public String toString() {
        return "ref=" + ref;
    }

    @Override
    public int hashCode() {
        final int prime = 47;
        int hash = 7;
        hash = prime * hash + ((ref == null) ? 0 : ref.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LocLocationMeasurement)) return false;		
	return this.ref == ((LocationMeasurementAttributes)obj).ref;
    }

    public int compareTo(LocationMeasurementAttributes o) {
        return ref.compareTo(o.ref);
    }
    
}
