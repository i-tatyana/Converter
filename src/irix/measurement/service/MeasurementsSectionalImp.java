package irix.measurement.service;

import irix.converter.sections.MonMeasurementsSectional;
import irix.measurement.structure.MonDoseRate;
import irix.measurement.structure.MeasurementsSectionalAttributes;
import java.util.List;


public interface MeasurementsSectionalImp {
    MonDoseRate getMonDoseRate();
    MeasurementsSectionalAttributes getMeasurementsSectionalAttributes();
    List<MonMeasurementsSectional> getMeasurementsList();   
}
