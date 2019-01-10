package irix.identification.structure;

import irix.converter.main.OrganizationContactDetailsImp;

public class OrganizationContactDetails extends Identifications implements OrganizationContactDetailsImp {
    
    String name;
    String organisationID;
    String country;
    String phoneNumber;
    String faxNumber;
    String emailAddress;
    String description;

    public OrganizationContactDetails() {
    }

    public OrganizationContactDetails(String name, String organisationID, String country, String phoneNumber, 
            String faxNumber, String emailAddress, String description) {
        this.name = name;
        this.organisationID = organisationID;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.emailAddress = emailAddress;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganisationID() {
        return organisationID;
    }

    public void setOrganisationID(String organisationID) {
        this.organisationID = organisationID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "name=" + name + ", "
                + "organisationID=" + organisationID + ", "
                + "country=" + country + ", "
                + "phoneNumber=" + phoneNumber + ", "
                + "faxNumber=" + faxNumber + ", "
                + "emailAddress=" + emailAddress + ", "
                + "description=" + description;
    }
    
}
