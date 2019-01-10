package irix.measurement.structure;

import irix.measurement.service.MeasurementImp;


public class Measurement extends Measurements implements MeasurementImp /*implements Comparable<Measurement>*/ {
        
    private LocationMeasurement locationMeasurement;
    private Value value; 
    private String validated;

    public Measurement() {
    }

    public Measurement(LocationMeasurement locationMeasurement, Value value, String validated) {
        this.locationMeasurement = locationMeasurement;
        this.value = value;
        this.validated = validated;
    }  

    public LocationMeasurement getLocationMeasurement() {
        return locationMeasurement;
    }

    public void setLocationMeasurement(LocationMeasurement locationMeasurement) {
        this.locationMeasurement = locationMeasurement;
    }

    @Override
    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    } 
    
    public String getValidated() {
        return validated;
    }

    public void setValidated(String validated) {
        this.validated = validated;
    }
    
    @Override
    public String toString() {
        return "location=" + locationMeasurement + ", "
                + "value=" + value + ", "
                + "validated=" + validated;
    }
    
    @Override
    public int hashCode() {
        final int prime = 47;
        int hash = 5;
        hash = prime * hash + ((locationMeasurement == null) ? 0 : locationMeasurement.hashCode());
        hash = prime * hash + ((value == null) ? 0 : value.hashCode());
        return hash;
    }
    
    public boolean equals(Object obj) {
        if (!(obj instanceof Measurement)) return false;
        return this.locationMeasurement == ((Measurement)obj).getLocationMeasurement() && this.value == ((Measurement)obj).getValue();
    }

    public int compareTo(Measurement o) {
        Measurement entry = (Measurement) o;            
        int result = entry.locationMeasurement.compareTo(this.locationMeasurement); // значения меняются местами
        if(result != 0) {
            return result;
        }
        else{
            result = entry.value.compareTo(o.getValue()); // значения меняются местами
            if(result != 0) {
               return result;
            }
       }
       return 0;
    }
    
}
