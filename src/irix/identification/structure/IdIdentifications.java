package irix.identification.structure;

import irix.converter.sections.IdIdentificationSectional;
import irix.identification.service.IdentificationsImp;
import java.util.ArrayList;
import java.util.List;

public class IdIdentifications extends IdIdentificationSectional implements IdentificationsImp {
    
    BasePersonContactInfo person;
    BaseOrganizationContactInfo organization;
    List<BasePersonContactInfo> personList = new ArrayList<BasePersonContactInfo>();
    List<BaseOrganizationContactInfo> organizationList = new ArrayList<BaseOrganizationContactInfo>();
    
    public IdIdentifications() {
    }

    public IdIdentifications(BasePersonContactInfo person, BaseOrganizationContactInfo organization) {
        this.person = person;
        this.organization = organization;
        
        this.personList.add(person);
        this.organizationList.add(organization);
    }

    public IdIdentifications(List<BasePersonContactInfo> personList, List<BaseOrganizationContactInfo> organizationList) {
        this.personList = personList;
        this.organizationList = organizationList;
    }

    public List<BasePersonContactInfo> getPersonList() {
        return personList;
    }

    public void setPersonList(List<BasePersonContactInfo> personList) {
        this.personList = personList;
    }

    public List<BaseOrganizationContactInfo> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(List<BaseOrganizationContactInfo> organizationList) {
        this.organizationList = organizationList;
    }

    public BasePersonContactInfo getPerson() {
        return person;
    }

    public void setPerson(BasePersonContactInfo person) {
        this.person = person;
    }

    public BaseOrganizationContactInfo getOrganization() {
        return organization;
    }

    public void setOrganization(BaseOrganizationContactInfo organization) {
        this.organization = organization;
    }
    
    @Override
    public String toString() {
        return "personList=" + personList + ", "
                + "organizationList=" + organizationList;
    }
    
}
