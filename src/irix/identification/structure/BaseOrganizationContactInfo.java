package irix.identification.structure;

import irix.identification.service.OrganizationContactInfoImp;


public class BaseOrganizationContactInfo extends IdIdentifications implements OrganizationContactInfoImp {
    
    String baseName;
    String baseOrganisationID;
    String baseCountry;
    String basePhoneNumber;
    String baseFaxNumber;
    String baseEmailAddress;
    String baseDescription;

    public BaseOrganizationContactInfo() {
    }

    public BaseOrganizationContactInfo(String baseName, String baseOrganisationID, String baseCountry, String basePhoneNumber, String baseFaxNumber, String baseEmailAddress, String baseDescription) {
        this.baseName = baseName;
        this.baseOrganisationID = baseOrganisationID;
        this.baseCountry = baseCountry;
        this.basePhoneNumber = basePhoneNumber;
        this.baseFaxNumber = baseFaxNumber;
        this.baseEmailAddress = baseEmailAddress;
        this.baseDescription = baseDescription;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getBaseOrganisationID() {
        return baseOrganisationID;
    }

    public void setBaseOrganisationID(String baseOrganisationID) {
        this.baseOrganisationID = baseOrganisationID;
    }

    public String getBaseCountry() {
        return baseCountry;
    }

    public void setBaseCountry(String baseCountry) {
        this.baseCountry = baseCountry;
    }

    public String getBasePhoneNumber() {
        return basePhoneNumber;
    }

    public void setBasePhoneNumber(String basePhoneNumber) {
        this.basePhoneNumber = basePhoneNumber;
    }

    public String getBaseFaxNumber() {
        return baseFaxNumber;
    }

    public void setBaseFaxNumber(String baseFaxNumber) {
        this.baseFaxNumber = baseFaxNumber;
    }

    public String getBaseEmailAddress() {
        return baseEmailAddress;
    }

    public void setBaseEmailAddress(String baseEmailAddress) {
        this.baseEmailAddress = baseEmailAddress;
    }

    public String getBaseDescription() {
        return baseDescription;
    }

    public void setBaseDescription(String baseDescription) {
        this.baseDescription = baseDescription;
    }
    
}
