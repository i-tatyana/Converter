package irix.converter.main;

import irix.identification.structure.OrganizationContactDetails;
import irix.identification.structure.PersonContactDetails;


public interface IdentificationsImp {    
    PersonContactDetails getPerson();
    OrganizationContactDetails getOrganization();    
}
