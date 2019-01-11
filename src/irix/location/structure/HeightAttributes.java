package irix.location.structure;

import irix.location.service.HeightAttributesImp;

public class HeightAttributes extends LocHeight implements HeightAttributesImp {
    
    private String above;
    private String unit;

    public HeightAttributes() {
    }

    public HeightAttributes(String above, String unit) {
        this.above = above;
        this.unit = unit;
    }

    public String getAbove() {
        return above;
    }

    public void setAbove(String above) {
        this.above = above;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "above=" + above + ", "
                + "unit=" + unit;
    }
    
}
