package irix.measurement.structure;

import irix.convertor.sections.MeasurementsSectional;
import irix.measurement.service.DoseRateImp;


public class DoseRate extends MeasurementsSectional implements DoseRateImp {
        
    private String doseRateType;
    private MeasuringPeriod measuringPeriod;
    private Measurements measurements;

    public DoseRate() {
    }

    public DoseRate(String doseRateType, MeasuringPeriod measuringPeriod, Measurements measurements) {
        this.doseRateType = doseRateType;
        this.measuringPeriod = measuringPeriod;
        this.measurements = measurements;        
    }

    public String getDoseRateType() {
        return doseRateType;
    }

    public void setDoseRateType(String doseRateType) {
        this.doseRateType = doseRateType;
    }

    public MeasuringPeriod getMeasuringPeriod() {
        return measuringPeriod;
    }

    public void setMeasuringPeriod(MeasuringPeriod measuringPeriod) {
        this.measuringPeriod = measuringPeriod;
    }

    public Measurements getMeasurements() {
        return measurements;
    }

    public void setMeasurements(Measurements measurements) {
        this.measurements = measurements;
    }
    
    @Override
    public int hashCode() {
        final int prime = 41;
        int hash = 7;
        hash = prime * hash + ((measurements == null) ? 0 : measurements.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DoseRate)) return false;
        return this.measurements == ((DoseRate)obj).getMeasurements();
    }    

    @Override
    public String toString() {
        return "doseRateType=" + doseRateType + ", "
                + "measuringPeriod=" + measuringPeriod + ", "
                + "measurements=" + measurements;
    }

    public int compareTo(DoseRate o) {
        return measurements.compareTo(o.getMeasurements());
    }
    
}
