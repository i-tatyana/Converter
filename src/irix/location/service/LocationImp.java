package irix.location.service;

import irix.location.structure.GeographicCoordinates;
import irix.location.structure.LocationAttributes;


public interface LocationImp {
    String getName();
    GeographicCoordinates getGeographicCoordinates();
    LocationAttributes getLocationAttributes();
}
