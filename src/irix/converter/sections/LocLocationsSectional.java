package irix.converter.sections;

import irix.location.service.GeographicCoordinatesImp;
import irix.location.service.HeightAttributesImp;
import irix.location.service.HeightImp;
import irix.location.service.LocationAttributesImp;
import irix.location.service.LocationImp;
import irix.location.structure.LocLocation;
import irix.location.service.LocationsSectionalImp;
import irix.location.structure.HeightAttributes;
import irix.location.structure.LocGeographicCoordinates;
import irix.location.structure.LocHeight;
import irix.location.structure.LocationAttributes;
import java.util.ArrayList;
import java.util.List;


public class LocLocationsSectional extends General implements LocationsSectionalImp, LocationImp, LocationAttributesImp, GeographicCoordinatesImp, HeightImp, HeightAttributesImp /*implements LocationImp, GeographicCoordinatesImp, HeightImp, HeightAttributesImp, Comparable<LocationsSectional>*/ {
    
    private LocLocation locLocation;  
    private List<LocLocationsSectional>locationsList = new ArrayList<LocLocationsSectional>();

    public LocLocationsSectional() {
    }

    public LocLocationsSectional(LocLocation locLocation) {
        this.locLocation = locLocation;
        
        locationsList.add(this);
    }

    public LocLocation getLocLocation() {
        return locLocation;
    }

    public List<LocLocationsSectional> getLocationsList() {
        return locationsList;
    }

    public void setLocationsList(List<LocLocationsSectional> locationsList) {
        this.locationsList = locationsList;
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

    @Override
    public String toString() {
        return "locLocation=" + locLocation;
    }
    
     @Override
    public String getLocName() {
        return this.getLocLocation().getLocName();
    }

    @Override
    public LocGeographicCoordinates getLocGeographicCoordinates() {
        return this.getLocLocation().getLocGeographicCoordinates();
    }

    @Override
    public LocationAttributes getLocationAttributes() {
        return this.getLocLocation().getLocationAttributes();
    }

    @Override
    public Double getLocLatitude() {
        return this.getLocLocation().getLocGeographicCoordinates().getLocLatitude();
    }

    @Override
    public Double getLocLongitude() {
        return this.getLocLocation().getLocGeographicCoordinates().getLocLongitude();
    }

    @Override
    public LocHeight getLocHeight() {
        return this.getLocLocation().getLocGeographicCoordinates().getLocHeight();
    }

    @Override
    public Integer getAltitudePhantom() {
        return this.getLocLocation().getLocGeographicCoordinates().getLocHeight().getAltitudePhantom();
    }

    @Override
    public HeightAttributes getHeightAttributes() {
        return this.getLocLocation().getLocGeographicCoordinates().getLocHeight().getHeightAttributes();
    }

    @Override
    public String getAbove() {
        return this.getLocLocation().getLocGeographicCoordinates().getLocHeight().getHeightAttributes().getAbove();
    }

    @Override
    public String getUnit() {
        return this.getLocLocation().getLocGeographicCoordinates().getLocHeight().getHeightAttributes().getUnit();
    }    

    @Override
    public Integer getId() {
        return this.getLocLocation().getLocationAttributes().getId();
    }

    
}

