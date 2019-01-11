package irix.measurement.service;

import irix.measurement.structure.LocLocationMeasurement;
import irix.measurement.structure.MonValue;


public interface MeasurementImp {
    LocLocationMeasurement getLocLocationMeasurement();
    MonValue getMonValue();    
    String getMonValidated();
}
