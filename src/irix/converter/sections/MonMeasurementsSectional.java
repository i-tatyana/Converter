package irix.converter.sections;

import irix.measurement.service.DoseRateImp;
import irix.measurement.service.LocationMeasurementAttributesImp;
import irix.measurement.service.LocationMeasurementImp;
import irix.measurement.service.MeasurementImp;
import irix.measurement.service.MeasurementsImp;
import irix.measurement.service.MeasurementsSectionalAttributesImp;
import irix.measurement.service.MeasuringPeriodImp;
import irix.measurement.service.ValueAttributesImp;
import irix.measurement.service.ValueImp;
import irix.measurement.structure.LocLocationMeasurement;
import irix.measurement.structure.LocationMeasurementAttributes;
import irix.measurement.structure.MeasurementsSectionalAttributes;
import irix.measurement.structure.MonDoseRate;
import irix.measurement.structure.MonMeasurement;
import irix.measurement.structure.MonMeasurements;
import irix.measurement.structure.MonMeasuringPeriod;
import irix.measurement.structure.MonValue;
import irix.measurement.structure.ValueAttributes;
import java.util.ArrayList;
import java.util.List;


public class MonMeasurementsSectional extends General implements MeasurementsSectionalAttributesImp, DoseRateImp, MeasuringPeriodImp, MeasurementsImp, MeasurementImp, LocationMeasurementImp, LocationMeasurementAttributesImp,ValueImp, ValueAttributesImp {
        
    private MonDoseRate monDoseRate;
    private MeasurementsSectionalAttributes measurementsSectionalAttributes;
    private List<MonMeasurementsSectional>measurementsList = new ArrayList<MonMeasurementsSectional>();
//    private Map<Integer,MonMeasurementsSectional>measurementsMap = new HashMap<Integer,MonMeasurementsSectional>();

    public MonMeasurementsSectional() {
    }

    public MonMeasurementsSectional(MonDoseRate monDoseRate, MeasurementsSectionalAttributes measurementsSectionalAttributes) {
        this.monDoseRate = monDoseRate;
        this.measurementsSectionalAttributes = measurementsSectionalAttributes;
        
        measurementsList.add(this);
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

    public List<MonMeasurementsSectional> getMeasurementsList() {
        return measurementsList;
    }

    public void setMeasurementsList(List<MonMeasurementsSectional> measurementsList) {
        this.measurementsList = measurementsList;
    }

    public int compareTo(MonMeasurementsSectional o) {
        return monDoseRate.compareTo(o.getMonDoseRate());
    }
    
    @Override
    public String getValidAt() {
        return this.getMeasurementsSectionalAttributes().getValidAt();
    }

    @Override
    public String getMonDoseRateType() {
        return this.getMonDoseRate().getMonDoseRateType();
    }

    @Override
    public MonMeasuringPeriod getMonMeasuringPeriod() {
        return this.getMonDoseRate().getMonMeasuringPeriod();
    }

    @Override
    public MonMeasurements getMonMeasurements() {
        return this.getMonMeasurements();
    }

    @Override
    public String getMonStartTime() {
        return this.getMonDoseRate().getMonMeasuringPeriod().getMonStartTime();
    }

    @Override
    public String getMonEndTime() {
        return this.getMonDoseRate().getMonMeasuringPeriod().getMonEndTime();
    }

    @Override
    public MonMeasurement getMonMeasurement() {
        return this.getMonMeasurements().getMonMeasurement();
    }

    @Override
    public LocLocationMeasurement getLocLocationMeasurement() {
        return this.getMonDoseRate().getMonMeasurements().getMonMeasurement().
                getLocLocationMeasurement();
    }

    @Override
    public MonValue getMonValue() {
        return this.getMonDoseRate().getMonMeasurements().getMonMeasurement().
                getMonValue();
    }

    @Override
    public String getMonValidated() {
        return this.getMonDoseRate().getMonMeasurements().getMonMeasurement().
                getMonValidated();
    }

    @Override
    public LocationMeasurementAttributes getLocationMeasurementAttributes() {
        return this.getMonDoseRate().getMonMeasurements().getMonMeasurement().
                getLocLocationMeasurement().getLocationMeasurementAttributes();
    }

    @Override
    public String getRef() {
        return this.getMonDoseRate().getMonMeasurements().getMonMeasurement().
                getLocLocationMeasurement().getLocationMeasurementAttributes().getRef();
    }

    @Override
    public Double getDosePhantom() {
        return this.getMonDoseRate().getMonMeasurements().getMonMeasurement().
                getMonValue().getDosePhantom();
    }

    @Override
    public ValueAttributes getValueAttributes() {
        return this.getMonDoseRate().getMonMeasurements().getMonMeasurement().
                getMonValue().getValueAttributes();
    }

    @Override
    public String getValueUnit() {
        return this.getMonDoseRate().getMonMeasurements().getMonMeasurement().
                getMonValue().getValueAttributes().getValueUnit();
    }
    
}