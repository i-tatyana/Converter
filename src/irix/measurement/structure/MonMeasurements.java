package irix.measurement.structure;

import irix.measurement.service.MeasurementsImp;


public class MonMeasurements extends MonDoseRate implements MeasurementsImp /*implements Comparable<Measurements>*/ {
    
    private MonMeasurement monMeasurement;
    
    public MonMeasurements() {
    }

    public MonMeasurements(MonMeasurement monMeasurement) {
        this.monMeasurement = monMeasurement;
    }

    public MonMeasurement getMonMeasurement() {
        return monMeasurement;
    }

    public void setMonMeasurement(MonMeasurement monMeasurement) {
        this.monMeasurement = monMeasurement;
    }
      
    @Override
    public int hashCode() {
        final int prime = 67;
        int hash = 7;
        hash = prime * hash + ((monMeasurement == null) ? 0 : monMeasurement.hashCode());
        return hash;
    }
    
    public boolean equals(Object obj) {
        if (!(obj instanceof MonMeasurements)) return false;
        return this.monMeasurement == ((MonMeasurements)obj).getMonMeasurement();
    }

    @Override
    public String toString() {
        return "monMeasurement=" + monMeasurement;
    }

    public int compareTo(MonMeasurements o) {
        return monMeasurement.compareTo(o.getMonMeasurement());
    }
    
}
