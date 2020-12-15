package bq_resume.techbow_badge_system.Rules;

import bq_resume.techbow_badge_system.UserInfo;
import com.sun.istack.internal.NotNull;

/**
 * Created by FLK on 2019-12-27.
 */
public class SecurityLevelRule implements IValidateRule{

    private final int securityLevel;

    public SecurityLevelRule(final int securityLevel){
        this.securityLevel = securityLevel;
    }

    public int getSecurityLevel(){
        return securityLevel;
    }

    @Override
    public boolean isValid(@NotNull final UserInfo userInfo) {
        return userInfo.getSecurityLevel() >= securityLevel;
    }
}
