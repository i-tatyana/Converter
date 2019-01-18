package irix.data.handler;

import irix.converter.sections.IdIdentificationSectional;
import irix.identification.structure.BaseOrganizationContactInfo;
import irix.identification.structure.BasePersonContactInfo;
import irix.identification.structure.IdIdentifications;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class IdentificationInfoHandler implements OrganizationContactInfoImp, PersonContactInfoImp {
    
    private String csvIdentificationInfoFile;
    
    private PersonContactInfoHandler personContactInfoHandler = new PersonContactInfoHandler();
    private OrganizationContactInfoHandler organizationContactInfoHandler = new OrganizationContactInfoHandler();

    public IdentificationInfoHandler(String csvIdentificationInfoFile, PersonContactInfoHandler personContactInfoHandler, OrganizationContactInfoHandler organizationContactInfoHandler) {
        this.csvIdentificationInfoFile = csvIdentificationInfoFile;
        this.personContactInfoHandler = personContactInfoHandler;
        this.organizationContactInfoHandler = organizationContactInfoHandler;
    }

    public String getCsvIdentificationInfoFile() {
        return csvIdentificationInfoFile;
    }

    public void setCsvIdentificationInfoFile(String csvIdentificationInfoFile) {
        this.csvIdentificationInfoFile = csvIdentificationInfoFile;
    }
    
    public PersonContactInfoHandler getPersonContactInfoHandler() {
        return personContactInfoHandler;
    }

    public void setPersonContactInfoHandler(PersonContactInfoHandler personContactInfoHandler) {
        this.personContactInfoHandler = personContactInfoHandler;
    }

    public OrganizationContactInfoHandler getOrganizationContactInfoHandler() {
        return organizationContactInfoHandler;
    }

    public void setOrganizationContactInfoHandler(OrganizationContactInfoHandler organizationContactInfoHandler) {
        this.organizationContactInfoHandler = organizationContactInfoHandler;
    }
        
    private static String getISODatePattern(){
        return "yyyy-MM-dd'T'HH:mm:ss'Z'";
    }
    
    public static String getUtcCurrentDateTime() {
        String isoDatePattern = getISODatePattern();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(isoDatePattern);
        return simpleDateFormat.format(new Date());
    }
    
    public IdIdentificationSectional getIdentificationInfo() {

//        String csvFile = "./src/resources/IdentificationInfo.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        IdIdentificationSectional identification = null;

        try {

            br = new BufferedReader(new FileReader(csvIdentificationInfoFile));
            while ((line = br.readLine()) != null) {

                String[] identifacation_data = line.split(cvsSplitBy);
                
                String organization_reporting = identifacation_data[0];
                String date_and_time_creation = getUtcCurrentDateTime();
                String report_context = identifacation_data[1];
//              Integer reporting_uuid = Integer.parseInt("3fe1", 16); // 947964f7-3fe1-4b30-8e64-4d473bd0acf3
                String reporting_uuid = "947964f7-3fe1-4b30-8e64-4d473bd0acf3";
                String confidentiality = identifacation_data[2];
                List<BasePersonContactInfo>personContactInfoList = personContactInfoHandler.getPersonContactInfo();
                List<BaseOrganizationContactInfo>organizationContactInfoList = organizationContactInfoHandler.getOrganizationContactInfo();
                    
                identification = new IdIdentificationSectional(organization_reporting,date_and_time_creation, report_context,reporting_uuid,
                    confidentiality,
                        new IdIdentifications(
                            personContactInfoList,
                            organizationContactInfoList));
                
//                System.out.println(organization_reporting + " " + date_and_time_creation + " " + report_context + " " +
//                            reporting_uuid + " " + confidentiality);
//                
//                for(BasePersonContactInfo person : personContactInfoList){
//                    System.out.println(person);
//                }
//                
//                for(BaseOrganizationContactInfo org : organizationContactInfoList){
//                    System.out.println(org);
//                }
                
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
        return identification;
    }
    
    @Override
    public String getCsvOrganizationContactInfoFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BaseOrganizationContactInfo> getOrganizationContactInfo() {
        return organizationContactInfoHandler.getOrganizationContactInfo();
    }

    @Override
    public String getCsvPersonContactInfoFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BasePersonContactInfo> getPersonContactInfo() {
        return personContactInfoHandler.getPersonContactInfo();
    }
    
}
