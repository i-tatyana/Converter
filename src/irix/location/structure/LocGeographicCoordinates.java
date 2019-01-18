package irix.location.structure;

import irix.location.service.GeographicCoordinatesImp;

public class LocGeographicCoordinates extends LocLocation implements GeographicCoordinatesImp /*, Comparable<GeographicCoordinates>*/ {
    
    private Double locLatitude;
    private Double locLongitude;
    private LocHeight locHeight;

    public LocGeographicCoordinates() {
    }

    public LocGeographicCoordinates(Double locLatitude, Double locLongitude, LocHeight locHeight) {
        this.locLatitude = locLatitude;
        this.locLongitude = locLongitude;
        this.locHeight = locHeight;
    }

    public Double getLocLatitude() {
        return locLatitude;
    }

    public void setLocLatitude(Double locLatitude) {
        this.locLatitude = locLatitude;
    }

    public Double getLocLongitude() {
        return locLongitude;
    }

    public void setLocLongitude(Double locLongitude) {
        this.locLongitude = locLongitude;
    }

    public LocHeight getLocHeight() {
        return locHeight;
    }

    public void setLocHeight(LocHeight locHeight) {
        this.locHeight = locHeight;
    }

    public int compareTo(LocGeographicCoordinates o) {
        LocGeographicCoordinates entry = (LocGeographicCoordinates) o;
            
       int result = (int) entry.locLongitude.compareTo(this.locLongitude); // значения меняются местами
       if(result != 0) {
             return result;
       }
            
       result = (int) (entry.locLatitude - locLatitude); // значения меняются местами
       if(result != 0) {
             return (int) result / Math.abs( result );
       }
       return 0;
    }

    @Override
    public String toString() {
        return "locLatitude=" + locLatitude + ", "
                + "locLongitude=" + locLongitude + ", "
                + "locHeight=" + locHeight;
    }
        
}
