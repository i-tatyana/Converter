package irix.identification.service;

import irix.identification.structure.BasePersonContactInfo;
import java.util.List;


public interface PersonContactInfoImp {
    String getBasePersonName();
    String getBasePersonOrganisationID();
    String getBasePersonEmailAddress();
    List<BasePersonContactInfo> getPersonContactInfoList();
}
