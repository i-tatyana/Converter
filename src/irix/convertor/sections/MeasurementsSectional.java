package irix.convertor.sections;

import irix.measurement.service.DoseRateImp;
import irix.measurement.service.LocationMeasurementAttributesImp;
import irix.measurement.service.LocationMeasurementImp;
import irix.measurement.service.MeasurementImp;
import irix.measurement.service.MeasurementsImp;
import irix.measurement.service.MeasuringPeriodImp;
import irix.measurement.service.ValueAttributesImp;
import irix.measurement.service.ValueImp;
import irix.measurement.structure.DoseRate;
import irix.measurement.structure.LocationMeasurement;
import irix.measurement.structure.LocationMeasurementAttributes;
import irix.measurement.structure.Measurement;
import irix.measurement.structure.Measurements;
import irix.measurement.structure.MeasurementsSectionalAttributes;
import irix.measurement.structure.MeasuringPeriod;
import irix.measurement.structure.Value;
import irix.measurement.structure.ValueAttributes;
import irix.section.identifier.Sectional;

public class MeasurementsSectional extends Sectional /*implements DoseRateImp, MeasuringPeriodImp, MeasurementsImp, MeasurementImp, LocationMeasurementImp, LocationMeasurementAttributesImp, ValueImp, ValueAttributesImp, Comparable<MeasurementsSectional>*/ {
        
    private DoseRate doseRate;
    private MeasurementsSectionalAttributes measurementsSectionalAttributes;

    public MeasurementsSectional() {
    }

    public MeasurementsSectional(DoseRate doseRate, MeasurementsSectionalAttributes measurementsSectionalAttributes) {
        this.doseRate = doseRate;
        this.measurementsSectionalAttributes = measurementsSectionalAttributes;
    }

    public DoseRate getDoseRate() {
        return doseRate;
    }

    public void setDoseRate(DoseRate doseRate) {
        this.doseRate = doseRate;
    }

    public MeasurementsSectionalAttributes getMeasurementsSectionalAttributes() {
        return measurementsSectionalAttributes;
    }

    public void setMeasurementsSectionalAttributes(MeasurementsSectionalAttributes measurementsSectionalAttributes) {
        this.measurementsSectionalAttributes = measurementsSectionalAttributes;
    }

    @Override
    public String toString() {
        return "doseRate=" + doseRate + ", "
                + "measurementsAttributes=" + measurementsSectionalAttributes;
    }
    
    @Override
    public int hashCode() {
        final int prime = 53;
        int hash = 7;
        hash = prime * hash + ((doseRate == null) ? 0 : doseRate.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MeasurementsSectional)) return false;
        return this.doseRate == ((MeasurementsSectional)obj).getDoseRate();
    }
/*
    @Override
    public int compareTo(MeasurementsSectional o) {
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