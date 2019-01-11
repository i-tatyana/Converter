package irix.identification.service;

import irix.identification.structure.IdIdentifications;


public interface IdentificationSectionalImp {
    String getIdOrganisationReporting();
    String getIdDateAndTimeOfCreation();
    String getIdReportContext();
    String getIdReportUUID();
    String getIdConfidentiality();
    IdIdentifications getIdIdentifications();
}
