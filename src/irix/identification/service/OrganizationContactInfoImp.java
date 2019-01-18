package irix.identification.service;

import irix.identification.structure.BaseOrganizationContactInfo;
import java.util.List;


public interface OrganizationContactInfoImp {
    String getBaseName();
    String getBaseOrganisationID();
    String getBaseCountry();
    String getBasePhoneNumber() ;
    String getBaseFaxNumber();
    String getBaseEmailAddress();
    String getBaseDescription();
    List<BaseOrganizationContactInfo> getOrganizationContactInfoList();
}
