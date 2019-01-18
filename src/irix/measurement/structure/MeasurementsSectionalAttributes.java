package irix.measurement.structure;

import irix.converter.sections.MonMeasurementsSectional;
import irix.measurement.service.MeasurementsSectionalAttributesImp;



public class MeasurementsSectionalAttributes extends MonMeasurementsSectional implements MeasurementsSectionalAttributesImp /*implements MeasurementsSectionalAttributesImp*/ /*implements MeasurementsSectionalAttributesImp*/  {
     
    private String validAt;

    public MeasurementsSectionalAttributes() {
    }

    public MeasurementsSectionalAttributes(String validAt) {
        this.validAt = validAt;
    }
        
    public String getValidAt() {
        return validAt;
    }

    public void setValidAt(String validAt) {
        this.validAt = validAt;
    }

    @Override
    public String toString() {
        return "validAt=" + validAt;
    }
    
}
