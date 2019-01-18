package irix.identification.structure;

import irix.identification.service.PersonContactInfoImp;
import java.util.ArrayList;
import java.util.List;


public class BasePersonContactInfo extends IdIdentifications implements PersonContactInfoImp {
    
    String basePersonName;
    String basePersonOrganisationID;
    String basePersonEmailAddress;
    List<BasePersonContactInfo>personContactInfoList = new ArrayList<BasePersonContactInfo>();

    public BasePersonContactInfo() {
    }

    public BasePersonContactInfo(String basePersonName, String basePersonOrganisationID, String basePersonEmailAddress) {
        this.basePersonName = basePersonName;
        this.basePersonOrganisationID = basePersonOrganisationID;
        this.basePersonEmailAddress = basePersonEmailAddress;
        
        this.personContactInfoList.add(this);
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

    public List<BasePersonContactInfo> getPersonContactInfoList() {
        return personContactInfoList;
    }

    public void setPersonContactInfoList(List<BasePersonContactInfo> personContactInfoList) {
        this.personContactInfoList = personContactInfoList;
    }
    
    
}
