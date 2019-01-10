package irix.identification.structure;

import irix.converter.main.IdentificationsImp;
import irix.convertor.sections.IdentificationSectional;

public class Identifications extends IdentificationSectional implements IdentificationsImp {
    
    PersonContactDetails person;
    OrganizationContactDetails organization;

    public Identifications() {
    }

    public Identifications(PersonContactDetails person, OrganizationContactDetails organization) {
        this.person = person;
        this.organization = organization;
    }

    public PersonContactDetails getPerson() {
        return person;
    }

    public void setPerson(PersonContactDetails person) {
        this.person = person;
    }

    public OrganizationContactDetails getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationContactDetails organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "person=" + person + ", "
                + "organization=" + organization;
    }
    
}
