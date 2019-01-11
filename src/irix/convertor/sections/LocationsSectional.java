package irix.convertor.sections;

import irix.location.service.GeographicCoordinatesImp;
import irix.location.service.HeightAttributesImp;
import irix.location.service.HeightImp;
import irix.location.service.LocationImp;
import irix.location.structure.GeographicCoordinates;
import irix.location.structure.Height;
import irix.location.structure.HeightAttributes;
import irix.location.structure.Location;
import irix.location.structure.LocationAttributes;
import irix.section.identifier.Sectional;


public class LocationsSectional extends Sectional /*implements LocationImp, GeographicCoordinatesImp, HeightImp, HeightAttributesImp, Comparable<LocationsSectional>*/ {
    
    private Location location;    

    public LocationsSectional() {
    }

    public LocationsSectional(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public int hashCode() {
        final int prime = 13;
        int hash = 7;
        hash = prime * hash + ((location == null) ? 0 : location.hashCode());
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LocationsSectional)) return false;
        return this.location == ((LocationsSectional)obj).getLocation();
    }
/*
    @Override
    public int compareTo(LocationsSectional o) {
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

