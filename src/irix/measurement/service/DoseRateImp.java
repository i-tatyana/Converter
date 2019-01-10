package irix.measurement.service;

import irix.measurement.structure.Measurements;
import irix.measurement.structure.MeasuringPeriod;


public interface DoseRateImp {
    String getDoseRateType();
    MeasuringPeriod getMeasuringPeriod();
    Measurements getMeasurements() ;
}
