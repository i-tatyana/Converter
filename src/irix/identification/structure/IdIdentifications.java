package irix.identification.structure;

import irix.identification.service.IdentificationsImp;
import irix.report.structure.IdIdentificationSectional;

public class IdIdentifications extends IdIdentificationSectional implements IdentificationsImp {
    
    BasePersonContactInfo person;
    BaseOrganizationContactInfo organization;

    public IdIdentifications() {
    }

    public IdIdentifications(BasePersonContactInfo person, BaseOrganizationContactInfo organization) {
        this.person = person;
        this.organization = organization;
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
        return "person=" + person + ", "
                + "organization=" + organization;
    }
    
}
