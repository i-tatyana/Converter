package irix.measurement.structure;

import irix.converter.sections.MonMeasurementsSectional;
import irix.measurement.service.DoseRateImp;


public class MonDoseRate extends MonMeasurementsSectional implements DoseRateImp {
        
    private String monDoseRateType;
    private MonMeasuringPeriod monMeasuringPeriod;
    private MonMeasurements monMeasurements;

    public MonDoseRate() {
    }

    public MonDoseRate(String monDoseRateType, MonMeasuringPeriod monMeasuringPeriod, MonMeasurements monMeasurements) {
        this.monDoseRateType = monDoseRateType;
        this.monMeasuringPeriod = monMeasuringPeriod;
        this.monMeasurements = monMeasurements;        
    }

    public String getMonDoseRateType() {
        return monDoseRateType;
    }

    public void setMonDoseRateType(String monDoseRateType) {
        this.monDoseRateType = monDoseRateType;
    }

    public MonMeasuringPeriod getMonMeasuringPeriod() {
        return monMeasuringPeriod;
    }

    public void setMonMeasuringPeriod(MonMeasuringPeriod monMeasuringPeriod) {
        this.monMeasuringPeriod = monMeasuringPeriod;
    }

    public MonMeasurements getMonMeasurements() {
        return monMeasurements;
    }

    public void setMeasurements(MonMeasurements monMeasurements) {
        this.monMeasurements = monMeasurements;
    }
    
    @Override
    public int hashCode() {
        final int prime = 41;
        int hash = 7;
        hash = prime * hash + ((monMeasurements == null) ? 0 : monMeasurements.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MonDoseRate)) return false;
        return this.monMeasurements == ((MonDoseRate)obj).getMonMeasurements();
    }    

    @Override
    public String toString() {
        return "monDoseRateType=" + monDoseRateType + ", "
                + "monMeasuringPeriod=" + monMeasuringPeriod + ", "
                + "monMeasurements=" + monMeasurements;
    }

    public int compareTo(MonDoseRate o) {
        return monMeasurements.compareTo(o.getMonMeasurements());
    }
    
}
