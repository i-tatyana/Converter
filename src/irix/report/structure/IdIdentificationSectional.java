package irix.report.structure;

import irix.converter.sections.Sectional;
import irix.identification.service.IdentificationSectionalImp;
import irix.identification.structure.IdIdentifications;


public class IdIdentificationSectional extends Sectional implements IdentificationSectionalImp /*implements IdentificationSectionalImp, IdentificationsImp, PersonContactDetailsImp, OrganizationContactDetailsImp*/ {
    
    String idOrganisationReporting;
    String idDateAndTimeOfCreation;
    String idReportContext;
    String idReportUUID;
    String idConfidentiality;
    IdIdentifications idIdentifications;

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
/*
    @Override
    public String toString() {
        return "reportDetails=" + reportDetails + ", "
                + "identifications=" + identifications;
    }

    @Override
    public String getOrganisationReporting() {
        return this.getReportDetails().getOrganisationReporting();
    }

    @Override
    public String getDateAndTimeOfCreation() {
        return this.getReportDetails().getDateAndTimeOfCreation();
    }

    @Override
    public String getReportContext() {
        return this.getReportDetails().getReportContext();
    }

    @Override
    public String getReportUUID() {
        return this.getReportDetails().getReportUUID();
    }

    @Override
    public String getConfidentiality() {
        return this.getReportDetails().getConfidentiality();
    }

    @Override
    public PersonContactDetails getPerson() {
        return this.getIdentifications().getPerson();
    }

    @Override
    public OrganizationContactDetails getOrganization() {
        return this.getIdentifications().getOrganization();
    }

    @Override
    public String getPersonName() {
        return this.getIdentifications().getPerson().getPersonName();
    }

    @Override
    public String getPersonOrganisationID() {
        return this.getIdentifications().getPerson().getPersonOrganisationID();
    }

    @Override
    public String getPersonEmailAddress() {
        return this.getIdentifications().getPerson().getPersonEmailAddress();
    }
    
    @Override
    public String getName() {
        return this.getIdentifications().getOrganization().getName();
    }

    @Override
    public String getOrganisationID() {
        return this.getIdentifications().getOrganization().getOrganisationID();
    }

    @Override
    public String getCountry() {
        return this.getIdentifications().getOrganization().getCountry();
    }

    @Override
    public String getPhoneNumber() {
        return this.getIdentifications().getOrganization().getPhoneNumber();
    }

    @Override
    public String getFaxNumber() {
        return this.getIdentifications().getOrganization().getFaxNumber();
    }

    @Override
    public String getDescription() {
        return this.getIdentifications().getOrganization().getDescription();
    }

    @Override
    public String getEmailAddress() {
        return this.getIdentifications().getOrganization().getEmailAddress();
    }
    */
}

