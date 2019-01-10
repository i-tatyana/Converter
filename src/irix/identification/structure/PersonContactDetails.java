package irix.identification.structure;

import irix.converter.main.PersonContactDetailsImp;

public class PersonContactDetails extends Identifications implements PersonContactDetailsImp {
    
    String name;
    String organisationID;
    String emailAddress;

    public PersonContactDetails() {
    }

    public PersonContactDetails(String name, String organisationID, String emailAddress) {
        this.name = name;
        this.organisationID = organisationID;
        this.emailAddress = emailAddress;
    }

    public String getPersonName() {
        return name;
    }

    public void setPersonName(String name) {
        this.name = name;
    }

    public String getPersonOrganisationID() {
        return organisationID;
    }

    public void setPersonOrganisationID(String organisationID) {
        this.organisationID = organisationID;
    }

    public String getPersonEmailAddress() {
        return emailAddress;
    }

    public void setPersonEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "name=" + name + ", "
                + "organisationID=" + organisationID + ", "
                + "emailAddress=" + emailAddress;
    }
    
}
