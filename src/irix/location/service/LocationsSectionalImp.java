package irix.location.service;

import irix.converter.sections.LocLocationsSectional;
import irix.location.structure.LocLocation;
import java.util.List;


public interface LocationsSectionalImp {
    LocLocation getLocLocation();
    List<LocLocationsSectional> getLocationsList();
}
