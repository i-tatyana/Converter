package irix.identification.service;

import irix.identification.structure.BaseOrganizationContactInfo;
import irix.identification.structure.BasePersonContactInfo;
import java.util.List;


public interface IdentificationsImp { 
    BasePersonContactInfo getPerson();
    BaseOrganizationContactInfo getOrganization();
    List<BasePersonContactInfo> getPersonList();
    List<BaseOrganizationContactInfo> getOrganizationList();
}
