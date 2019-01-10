package irix.measurement.structure;

import irix.convertor.sections.MeasurementsSectional;



public class MeasurementsSectionalAttributes extends MeasurementsSectional /*implements MeasurementsSectionalAttributesImp*/  {
     
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
