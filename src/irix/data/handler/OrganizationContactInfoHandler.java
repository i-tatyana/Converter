package irix.data.handler;

import irix.identification.structure.BaseOrganizationContactInfo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class OrganizationContactInfoHandler implements OrganizationContactInfoImp {
    
    private String csvOrganizationContactInfoFile;
    
    public OrganizationContactInfoHandler() {
    }

    public OrganizationContactInfoHandler(String csvOrganizationContactInfoFile) {
        this.csvOrganizationContactInfoFile = csvOrganizationContactInfoFile;
    }

    public String getCsvOrganizationContactInfoFile() {
        return csvOrganizationContactInfoFile;
    }

    public void setCsvOrganizationContactInfoFile(String csvOrganizationContactInfoFile) {
        this.csvOrganizationContactInfoFile = csvOrganizationContactInfoFile;
    }
        
    public List<BaseOrganizationContactInfo> getOrganizationContactInfo() {

        List<BaseOrganizationContactInfo>organizationContactInfoList = new ArrayList<BaseOrganizationContactInfo>();
//        String csvFile = "./src/resources/OrganizationContactInfo.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        try {

            br = new BufferedReader(new FileReader(csvOrganizationContactInfoFile));
            while ((line = br.readLine()) != null) {

                String[] org_contact_info = line.split(cvsSplitBy);
                
                String name = org_contact_info[0];
                String org_id = org_contact_info[1];
                String country = org_contact_info[2];
                String phone_num = org_contact_info[3];
                String fax_num = org_contact_info[4];
                String email = org_contact_info[5];            
                String description = org_contact_info[6];
                
                organizationContactInfoList.add(new BaseOrganizationContactInfo(name, org_id, country, phone_num, fax_num, email, description));
                
//                System.out.println(name + " " + org_id + " " + country + " " + phone_num + " " + email + " " + description);
                
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return organizationContactInfoList;
    }

    @Override
    public String toString() {
        return "csvOrganizationContactInfoFile=" + csvOrganizationContactInfoFile;
    }
    
}
