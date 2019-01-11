package irix.convertor.sections;

import irix.converter.main.IdentificationSectionalImp;
import irix.converter.main.IdentificationsImp;
import irix.converter.main.OrganizationContactDetailsImp;
import irix.converter.main.PersonContactDetailsImp;
import irix.identification.structure.Identifications;
import irix.identification.structure.OrganizationContactDetails;
import irix.identification.structure.PersonContactDetails;
import irix.identification.structure.ReportDetails;
import irix.section.identifier.Sectional;


public class IdentificationSectional extends Sectional /*implements IdentificationSectionalImp, IdentificationsImp, PersonContactDetailsImp, OrganizationContactDetailsImp*/ {
    
    ReportDetails reportDetails;
    Identifications identifications;

    public IdentificationSectional() {
    }

    public IdentificationSectional(ReportDetails reportDetails, Identifications identifications) {
        this.reportDetails = reportDetails;
        this.identifications = identifications;
    }

    public ReportDetails getReportDetails() {
        return reportDetails;
    }

    public void setReportDetails(ReportDetails reportDetails) {
        this.reportDetails = reportDetails;
    }

    public Identifications getIdentifications() {
        return identifications;
    }

    public void setIdentifications(Identifications identifications) {
        this.identifications = identifications;
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

