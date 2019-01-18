package irix.measurement.structure;

import irix.measurement.service.ValueAttributesImp;


public class ValueAttributes extends MonValue implements ValueAttributesImp {
    
    private  String valueUnit;

    public ValueAttributes() {
    }

    public ValueAttributes(String valueUnit) {
        this.valueUnit = valueUnit;
    }

    public String getValueUnit() {
        return valueUnit;
    }

    public void setValueUnit(String valueUnit) {
        this.valueUnit = valueUnit;
    }

    @Override
    public String toString() {
        return "valueUnit=" + valueUnit;
    }    
        
}
