package irix.identification.structure;

import irix.identification.service.PersonContactInfoImp;


public class BasePersonContactInfo extends IdIdentifications implements PersonContactInfoImp {
    
    String basePersonName;
    String basePersonOrganisationID;
    String basePersonEmailAddress;

    public BasePersonContactInfo() {
    }

    public BasePersonContactInfo(String basePersonName, String basePersonOrganisationID, String basePersonEmailAddress) {
        this.basePersonName = basePersonName;
        this.basePersonOrganisationID = basePersonOrganisationID;
        this.basePersonEmailAddress = basePersonEmailAddress;
    }

    public String getBasePersonName() {
        return basePersonName;
    }

    public void setBasePersonName(String basePersonName) {
        this.basePersonName = basePersonName;
    }

    public String getBasePersonOrganisationID() {
        return basePersonOrganisationID;
    }

    public void setBasePersonOrganisationID(String basePersonOrganisationID) {
        this.basePersonOrganisationID = basePersonOrganisationID;
    }

    public String getBasePersonEmailAddress() {
        return basePersonEmailAddress;
    }

    public void setBasePersonEmailAddress(String basePersonEmailAddress) {
        this.basePersonEmailAddress = basePersonEmailAddress;
    }    

    @Override
    public String toString() {
        return "basePersonName=" + basePersonName + ", "
                + "basePersonOrganisationID=" + basePersonOrganisationID + ", "
                + "basePersonEmailAddress=" + basePersonEmailAddress;
    }
    
}
