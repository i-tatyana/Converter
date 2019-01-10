package irix.measurement.service;

import irix.measurement.structure.LocationMeasurement;
import irix.measurement.structure.Value;


public interface MeasurementImp {
    LocationMeasurement getLocationMeasurement();
    Value getValue();    
    String getValidated();
}
