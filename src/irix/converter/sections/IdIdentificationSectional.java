package irix.converter.sections;

import irix.identification.service.IdentificationSectionalImp;
import irix.identification.structure.IdIdentifications;


public class IdIdentificationSectional extends General implements IdentificationSectionalImp /*implements IdentificationSectionalImp, IdentificationsImp, PersonContactDetailsImp, OrganizationContactDetailsImp*/ {
    
    private String idOrganisationReporting;
    private String idDateAndTimeOfCreation;
    private String idReportContext;
    private String idReportUUID;
    private String idConfidentiality;
    private IdIdentifications idIdentifications;

    public IdIdentificationSectional() {
    }

    public IdIdentificationSectional(String idOrganisationReporting, String idDateAndTimeOfCreation, String idReportContext, String idReportUUID, String idConfidentiality, IdIdentifications idIdentifications) {
        this.idOrganisationReporting = idOrganisationReporting;
        this.idDateAndTimeOfCreation = idDateAndTimeOfCreation;
        this.idReportContext = idReportContext;
        this.idReportUUID = idReportUUID;
        this.idConfidentiality = idConfidentiality;
        this.idIdentifications = idIdentifications;
    }

    public String getIdOrganisationReporting() {
        return idOrganisationReporting;
    }

    public void setIdOrganisationReporting(String idOrganisationReporting) {
        this.idOrganisationReporting = idOrganisationReporting;
    }

    public String getIdDateAndTimeOfCreation() {
        return idDateAndTimeOfCreation;
    }

    public void setIdDateAndTimeOfCreation(String idDateAndTimeOfCreation) {
        this.idDateAndTimeOfCreation = idDateAndTimeOfCreation;
    }

    public String getIdReportContext() {
        return idReportContext;
    }

    public void setIdReportContext(String idReportContext) {
        this.idReportContext = idReportContext;
    }

    public String getIdReportUUID() {
        return idReportUUID;
    }

    public void setIdReportUUID(String idReportUUID) {
        this.idReportUUID = idReportUUID;
    }

    public String getIdConfidentiality() {
        return idConfidentiality;
    }

    public void setIdConfidentiality(String idConfidentiality) {
        this.idConfidentiality = idConfidentiality;
    }

    public IdIdentifications getIdIdentifications() {
        return idIdentifications;
    }

    public void setIdIdentifications(IdIdentifications idIdentifications) {
        this.idIdentifications = idIdentifications;
    }

    @Override
    public String toString() {
        return "idOrganisationReporting=" + idOrganisationReporting + ", "
                + "idDateAndTimeOfCreation=" + idDateAndTimeOfCreation + ", "
                + "idReportContext=" + idReportContext + ", "
                + "idReportUUID=" + idReportUUID + ", "
                + "idConfidentiality=" + idConfidentiality + ", "
                + "idIdentifications=" + idIdentifications;
    }   

}

