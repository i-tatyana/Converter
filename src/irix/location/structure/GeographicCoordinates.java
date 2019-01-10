package irix.location.structure;

import irix.location.service.GeographicCoordinatesImp;

public class GeographicCoordinates extends Location implements GeographicCoordinatesImp /*, Comparable<GeographicCoordinates>*/ {
    
    private Double latitude;
    private Double longitude;
    private Height height;

    public GeographicCoordinates() {
    }

    public GeographicCoordinates(Double latitude, Double longitude, Height height) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.height = height;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Height getHeight() {
        return height;
    }

    public void setHeight(Height height) {
        this.height = height;
    }
    
    @Override
    public String toString() {
        return "latitude=" + latitude + ", "
                + "longitude=" + longitude + ", "
                + "height=" + height;
    }

    public int compareTo(GeographicCoordinates o) {
        GeographicCoordinates entry = (GeographicCoordinates) o;
            
       int result = (int) entry.longitude.compareTo(this.longitude); // значения меняются местами
       if(result != 0) {
             return result;
       }
            
       result = (int) (entry.latitude - latitude); // значения меняются местами
       if(result != 0) {
             return (int) result / Math.abs( result );
       }
       return 0;
    }
        
}
