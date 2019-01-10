package irix.location.structure;

import irix.location.service.HeightImp;


public class Height extends GeographicCoordinates implements HeightImp {
    
    private Integer altitudePhantom;
    private HeightAttributes heightAttributes;

    public Height() {
    }

    public Height(Integer altitudePhantom, HeightAttributes heightAttributes) {
        this.altitudePhantom = altitudePhantom;
        this.heightAttributes = heightAttributes;
    }

    public HeightAttributes getHeightAttributes() {
        return heightAttributes;
    }

    public void setHeightAttributes(HeightAttributes heightAttributes) {
        this.heightAttributes = heightAttributes;
    }

    public Integer getAltitudePhantom() {
        return altitudePhantom;
    }

    public void setAltitudePhantom(Integer altitudePhantom) {
        this.altitudePhantom = altitudePhantom;
    }
    
    @Override
    public String toString() {
        return "altitude=" + altitudePhantom + ", "
                + "heightAttributes=" + heightAttributes;
    }
    
}
