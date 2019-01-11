package irix.location.service;

import irix.location.structure.GeographicCoordinates;
import irix.location.structure.LocationAttributes;


public interface LocationImp {
    String getLocationName();
    GeographicCoordinates getGeographicCoordinates();
    LocationAttributes getLocationAttributes();
}
