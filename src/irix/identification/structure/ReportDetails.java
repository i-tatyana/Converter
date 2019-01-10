package irix.identification.structure;

import irix.converter.main.IdentificationSectionalImp;
import irix.convertor.sections.IdentificationSectional;


public class ReportDetails extends IdentificationSectional implements IdentificationSectionalImp {
    
    String organisationReporting;
    String dateAndTimeOfCreation;
    String reportContext;
    String reportUUID;
    String confidentiality;

    public ReportDetails() {
    }

    public ReportDetails(String organisationReporting, String dateAndTimeOfCreation, String reportContext, 
            String reportUUID, String confidentiality) {
        this.organisationReporting = organisationReporting;
        this.dateAndTimeOfCreation = dateAndTimeOfCreation;
        this.reportContext = reportContext;
        this.reportUUID = reportUUID;
        this.confidentiality = confidentiality;
    }

    public String getOrganisationReporting() {
        return organisationReporting;
    }

    public void setOrganisationReporting(String organisationReporting) {
        this.organisationReporting = organisationReporting;
    }

    public String getDateAndTimeOfCreation() {
        return dateAndTimeOfCreation;
    }

    public void setDateAndTimeOfCreation(String dateAndTimeOfCreation) {
        this.dateAndTimeOfCreation = dateAndTimeOfCreation;
    }

    public String getReportContext() {
        return reportContext;
    }

    public void setReportContext(String reportContext) {
        this.reportContext = reportContext;
    }

    public String getReportUUID() {
        return reportUUID;
    }

    public void setReportUUID(String reportUUID) {
        this.reportUUID = reportUUID;
    }

    public String getConfidentiality() {
        return confidentiality;
    }

    public void setConfidentiality(String confidentiality) {
        this.confidentiality = confidentiality;
    }

    @Override
    public String toString() {
        return "organisationReporting=" + organisationReporting + ", "
                + "dateAndTimeOfCreation=" + dateAndTimeOfCreation + ", "
                + "reportContext=" + reportContext + ", "
                + "reportUUID=" + reportUUID + ", "
                + "confidentiality=" + confidentiality;
    }
    
}
