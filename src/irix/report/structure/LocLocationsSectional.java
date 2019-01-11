package irix.report.structure;

import irix.converter.sections.Sectional;
import irix.location.structure.LocLocation;
import irix.location.service.LocationsSectionalImp;


public class LocLocationsSectional extends Sectional implements LocationsSectionalImp /*implements LocationImp, GeographicCoordinatesImp, HeightImp, HeightAttributesImp, Comparable<LocationsSectional>*/ {
    
    private LocLocation locLocation;    

    public LocLocationsSectional() {
    }

    public LocLocationsSectional(LocLocation locLocation) {
        this.locLocation = locLocation;
    }

    public LocLocation getLocLocation() {
        return locLocation;
    }

    public void setLocLocation(LocLocation locLocation) {
        this.locLocation = locLocation;
    }

    @Override
    public int hashCode() {
        final int prime = 13;
        int hash = 7;
        hash = prime * hash + ((locLocation == null) ? 0 : locLocation.hashCode());
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LocLocationsSectional)) return false;
        return this.locLocation == ((LocLocationsSectional)obj).getLocLocation();
    }
/*
    @Override
    public int compareTo(LocLocationsSectional o) {
        return location.compareTo(o.getLocation());
    }

    @Override
    public String toString() {
        return "location=" + location;
    }

    @Override
    public String getName() {
        return this.getLocation().getName();
    }

    @Override
    public GeographicCoordinates getGeographicCoordinates() {
        return this.getLocation().getGeographicCoordinates();
    }

    @Override
    public LocationAttributes getLocationAttributes() {
        return this.getLocation().getLocationAttributes();
    }

    @Override
    public Double getLatitude() {
        return this.getLocation().getGeographicCoordinates().getLatitude();
    }

    @Override
    public Double getLongitude() {
        return this.getLocation().getGeographicCoordinates().getLongitude();
    }

    @Override
    public Height getHeight() {
        return this.getLocation().getGeographicCoordinates().getHeight();
    }

    @Override
    public Integer getAltitudePhantom() {
        return this.getLocation().getGeographicCoordinates().getHeight().getAltitudePhantom();
    }

    @Override
    public HeightAttributes getHeightAttributes() {
        return this.getLocation().getGeographicCoordinates().getHeight().getHeightAttributes();
    }

    @Override
    public String getAbove() {
        return this.getLocation().getGeographicCoordinates().getHeight().getHeightAttributes().getAbove();
    }

    @Override
    public String getUnit() {
        return this.getLocation().getGeographicCoordinates().getHeight().getHeightAttributes().getUnit();
    }

    public Integer getId() {
        return this.getLocation().getLocationAttributes().getId();
    }
    */
}

