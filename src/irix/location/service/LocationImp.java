package irix.location.service;

import irix.location.structure.LocGeographicCoordinates;
import irix.location.structure.LocationAttributes;


public interface LocationImp {
    String getLocName();
    LocGeographicCoordinates getLocGeographicCoordinates();
    LocationAttributes getLocationAttributes();
}
