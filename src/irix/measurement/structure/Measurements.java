package irix.measurement.structure;

import irix.measurement.service.MeasurementsImp;


public class Measurements extends DoseRate implements MeasurementsImp /*implements Comparable<Measurements>*/ {
    
    private Measurement measurement;
    
    public Measurements() {
    }

    public Measurements(Measurement measurement) {
        this.measurement = measurement;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }
      
    @Override
    public int hashCode() {
        final int prime = 67;
        int hash = 7;
        hash = prime * hash + ((measurement == null) ? 0 : measurement.hashCode());
        return hash;
    }
    
    public boolean equals(Object obj) {
        if (!(obj instanceof Measurements)) return false;
        return this.measurement == ((Measurements)obj).getMeasurement();
    }

    @Override
    public String toString() {
        return "measurement=" + measurement;
    }

    public int compareTo(Measurements o) {
        return measurement.compareTo(o.getMeasurement());
    }
    
}
