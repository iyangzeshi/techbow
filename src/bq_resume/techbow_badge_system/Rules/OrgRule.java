package bq_resume.techbow_badge_system.Rules;

import bq_resume.techbow_badge_system.UserInfo;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by FLK on 2019-12-27.
 */
public class OrgRule implements IValidateRule{

    private final String orgId;

    private final Set<String> subOrgs;

    public OrgRule(final String orgId) {
        this.orgId = orgId;
        subOrgs = new HashSet<>();
    }

    public String getOrgId(){
        return orgId;
    }

    public boolean isSubOrg(final String orgId){
        return subOrgs.contains(orgId);
    }

    @Override
    public boolean isValid(UserInfo userInfo) {
        final String userOrgId = userInfo.getOrgId();
        return orgId.equals(userOrgId) || subOrgs.contains(userOrgId);
    }
}
