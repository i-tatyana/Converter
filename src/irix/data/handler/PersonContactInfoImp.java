package irix.data.handler;

import irix.identification.structure.BasePersonContactInfo;
import java.util.List;


public interface PersonContactInfoImp {
    String getCsvPersonContactInfoFile();
    List<BasePersonContactInfo> getPersonContactInfo();
}
