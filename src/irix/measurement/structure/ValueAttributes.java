package irix.measurement.structure;

import irix.measurement.service.ValueAttributesImp;


public class ValueAttributes extends Value implements ValueAttributesImp {
    
    private  String unit;

    public ValueAttributes() {
    }

    public ValueAttributes(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "unit=" + unit;
    }
        
}
