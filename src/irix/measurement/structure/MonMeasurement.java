package irix.measurement.structure;

import irix.measurement.service.MeasurementImp;


public class MonMeasurement extends MonMeasurements implements MeasurementImp /*implements Comparable<Measurement>*/ {
        
    private LocLocationMeasurement locLocationMeasurement;
    private MonValue monValue; 
    private String monValidated;

    public MonMeasurement() {
    }

    public MonMeasurement(LocLocationMeasurement locLocationMeasurement, MonValue monValue, String monValidated) {
        this.locLocationMeasurement = locLocationMeasurement;
        this.monValue = monValue;
        this.monValidated = monValidated;
    }

    public LocLocationMeasurement getLocLocationMeasurement() {
        return locLocationMeasurement;
    }

    public void setLocLocationMeasurement(LocLocationMeasurement locLocationMeasurement) {
        this.locLocationMeasurement = locLocationMeasurement;
    }

    public MonValue getMonValue() {
        return monValue;
    }

    public void setMonValue(MonValue monValue) {
        this.monValue = monValue;
    }

    public String getMonValidated() {
        return monValidated;
    }

    public void setMonValidated(String monValidated) {
        this.monValidated = monValidated;
    }
    
    @Override
    public String toString() {
        return "locLocationMeasurement=" + locLocationMeasurement + ", "
                + "monValue=" + monValue + ", "
                + "monValidated=" + monValidated;
    }
    
    @Override
    public int hashCode() {
        final int prime = 47;
        int hash = 5;
        hash = prime * hash + ((locLocationMeasurement == null) ? 0 : locLocationMeasurement.hashCode());
        hash = prime * hash + ((monValue == null) ? 0 : monValue.hashCode());
        return hash;
    }
    
    public boolean equals(Object obj) {
        if (!(obj instanceof MonMeasurement)) return false;
        return this.locLocationMeasurement == ((MonMeasurement)obj).getLocLocationMeasurement() && this.monValue == ((MonMeasurement)obj).getMonValue();
    }

    public int compareTo(MonMeasurement o) {
        MonMeasurement entry = (MonMeasurement) o;            
        int result = entry.locLocationMeasurement.compareTo(this.locLocationMeasurement); // значения меняются местами
        if(result != 0) {
            return result;
        }
        else{
            result = entry.monValue.compareTo(o.getMonValue()); // значения меняются местами
            if(result != 0) {
               return result;
            }
       }
       return 0;
    }
    
}
