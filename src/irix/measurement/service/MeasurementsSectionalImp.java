package irix.measurement.service;

import irix.measurement.structure.MonDoseRate;
import irix.measurement.structure.MeasurementsSectionalAttributes;


public interface MeasurementsSectionalImp {
    MonDoseRate getMonDoseRate();
    MeasurementsSectionalAttributes getMeasurementsSectionalAttributes();
}
