package irix.identification.service;

import irix.identification.structure.BaseOrganizationContactInfo;
import irix.identification.structure.BasePersonContactInfo;


public interface IdentificationsImp {    
    BasePersonContactInfo getPerson();
    BaseOrganizationContactInfo getOrganization();    
}
