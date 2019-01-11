package irix.report.structure;

import irix.converter.sections.Sectional;
import irix.measurement.service.MeasurementsSectionalImp;
import irix.measurement.structure.MonDoseRate;
import irix.measurement.structure.MeasurementsSectionalAttributes;

public class MonMeasurementsSectional extends Sectional implements MeasurementsSectionalImp /*implements DoseRateImp, MeasuringPeriodImp, MeasurementsImp, MeasurementImp, LocationMeasurementImp, LocationMeasurementAttributesImp, ValueImp, ValueAttributesImp, Comparable<MeasurementsSectional>*/ {
        
    private MonDoseRate monDoseRate;
    private MeasurementsSectionalAttributes measurementsSectionalAttributes;

    public MonMeasurementsSectional() {
    }

    public MonMeasurementsSectional(MonDoseRate monDoseRate, MeasurementsSectionalAttributes measurementsSectionalAttributes) {
        this.monDoseRate = monDoseRate;
        this.measurementsSectionalAttributes = measurementsSectionalAttributes;
    }

    public MonDoseRate getMonDoseRate() {
        return monDoseRate;
    }

    public void setMonDoseRate(MonDoseRate monDoseRate) {
        this.monDoseRate = monDoseRate;
    }

    public MeasurementsSectionalAttributes getMeasurementsSectionalAttributes() {
        return measurementsSectionalAttributes;
    }

    public void setMeasurementsSectionalAttributes(MeasurementsSectionalAttributes measurementsSectionalAttributes) {
        this.measurementsSectionalAttributes = measurementsSectionalAttributes;
    }

    @Override
    public String toString() {
        return "monDoseRate=" + monDoseRate + ", "
                + "measurementsAttributes=" + measurementsSectionalAttributes;
    }
    
    @Override
    public int hashCode() {
        final int prime = 53;
        int hash = 7;
        hash = prime * hash + ((monDoseRate == null) ? 0 : monDoseRate.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MonMeasurementsSectional)) return false;
        return this.monDoseRate == ((MonMeasurementsSectional)obj).getMonDoseRate();
    }
/*
    @Override
    public int compareTo(MonMeasurementsSectional o) {
        return doseRate.compareTo(o.getDoseRate());
    }

    @Override
    public MeasuringPeriod getMeasuringPeriod() {
        return this.getDoseRate().getMeasuringPeriod();
    }

    @Override
    public Measurements getMeasurements() {
        return this.getDoseRate().getMeasurements();
    }

    @Override
    public String getStartTime() {
        return this.getDoseRate().getMeasuringPeriod().getStartTime();
    }

    @Override
    public String getEndTime() {
        return this.getDoseRate().getMeasuringPeriod().getEndTime();
    }

    @Override
    public Measurement getMeasurement() {
        return this.getDoseRate().getMeasurements().getMeasurement();
    }

    @Override
    public LocationMeasurement getLocationMeasurement() {
        return this.getDoseRate().getMeasurements().getMeasurement().getLocationMeasurement();
    }

    @Override
    public Value getValue() {
        return this.getDoseRate().getMeasurements().getMeasurement().getValue();
    }

    @Override
    public String getValidated() {
        return this.getDoseRate().getMeasurements().getMeasurement().getValidated();
    }

    @Override
    public LocationMeasurementAttributes getLocationMeasurementAttributes() {
        return this.getDoseRate().getMeasurements().getMeasurement().getLocationMeasurement().getLocationMeasurementAttributes();
    }

    @Override
    public String getRef() {
        return this.getDoseRate().getMeasurements().getMeasurement().getLocationMeasurement().getLocationMeasurementAttributes().getRef();
    }

    @Override
    public Double getDosePhantom() {
        return this.getDoseRate().getMeasurements().getMeasurement().getValue().getDosePhantom();
    }

    @Override
    public ValueAttributes getValueAttributes() {
        return this.getDoseRate().getMeasurements().getMeasurement().getValue().getValueAttributes();
    }

    @Override
    public String getUnit() {
        return this.getDoseRate().getMeasurements().getMeasurement().getValue().getValueAttributes().getUnit();
    }

    @Override
    public String getDoseRateType() {
        return this.getDoseRate().getDoseRateType();
    }
    
    public String getValidAt() {
        return this.getMeasurementsSectionalAttributes().getValidAt();
    }    
    */
}