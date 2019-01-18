package irix.data.handler;

import irix.identification.structure.BaseOrganizationContactInfo;
import java.util.List;


public interface OrganizationContactInfoImp {
    String getCsvOrganizationContactInfoFile();
    List<BaseOrganizationContactInfo> getOrganizationContactInfo();
}
