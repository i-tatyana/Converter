package irix.measurement.service;

import irix.measurement.structure.MonMeasurements;
import irix.measurement.structure.MonMeasuringPeriod;


public interface DoseRateImp {
    String getMonDoseRateType();
    MonMeasuringPeriod getMonMeasuringPeriod();
    MonMeasurements getMonMeasurements();
}
