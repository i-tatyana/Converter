package irix.data.handler;

import irix.identification.structure.BasePersonContactInfo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PersonContactInfoHandler implements PersonContactInfoImp {
    
    private String csvPersonContactInfoFile;

    public PersonContactInfoHandler() {
    }

    public PersonContactInfoHandler(String csvPersonContactInfoFile) {
        this.csvPersonContactInfoFile = csvPersonContactInfoFile;
    }

    public String getCsvPersonContactInfoFile() {
        return csvPersonContactInfoFile;
    }

    public void setCsvPersonContactInfoFile(String csvPersonContactInfoFile) {
        this.csvPersonContactInfoFile = csvPersonContactInfoFile;
    }
        
    public List<BasePersonContactInfo> getPersonContactInfo() {
        
        List<BasePersonContactInfo>personContactInfoList = new ArrayList<BasePersonContactInfo>();
//        String csvFile = "./src/resources/PersonContactInfo.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        try {

            br = new BufferedReader(new FileReader(csvPersonContactInfoFile));
            while ((line = br.readLine()) != null) {

                String[] person_contact_info = line.split(cvsSplitBy);
                
                String name = person_contact_info[0];
                String org_id = person_contact_info[1];
                String email = person_contact_info[2];
                    
                personContactInfoList.add(new BasePersonContactInfo(name, org_id, email));
                
//                System.out.println(name + " " + org_id + " " + email);
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
        return personContactInfoList;
    }

    @Override
    public String toString() {
        return "PersonContactInfoHandler{" + "csvFile=" + csvPersonContactInfoFile + '}';
    }
    
}
