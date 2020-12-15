package bq_resume.techbow_badge_system;

import bq_resume.techbow_badge_system.Rules.IValidateRule;
import com.sun.istack.internal.NotNull;
import java.util.ArrayList;
import java.util.List;

public class Checker {
    private final String checkerId;
    private final IValidationService service;
    private int securityLevel;
    //Multiple Rules to Open the door
    private List<IValidateRule> validateRules;

    public Checker(final String id, final IValidationService service) {
        this.checkerId = id;
        this.service = service;
        validateRules = new ArrayList<>();
        updateCheckerSettings();
    }

    private void updateCheckerSettings(){
        securityLevel = service.getCheckerSecurityLevel(checkerId);
        //Multiple Rules to Open the door
        validateRules = service.getCheckerValidationRules(checkerId);
    }

    //Just check for SecurityLevel
    public boolean isValid(@NotNull final String userId){
        int userSecurityLevel = service.getUserSecurityLevel(userId);

        return userSecurityLevel >= securityLevel;
    }

    //For check Security with Badge Lose/Found
    public boolean isValid(@NotNull final String userId,@NotNull final String badgeId){
        final String userCurrentBadgeId = service.getUserCurrentBadgeId(userId);

        return isValid(userId) && badgeId.equals(userCurrentBadgeId);
    }

    //Multiple Rules to Open the door
    public boolean checkValidWithMultiRules(@NotNull final String userId, @NotNull final String badgeId){
        final UserInfo userInfo = service.getUserInfo(userId);

        for (IValidateRule rule : validateRules) {
            if(!rule.isValid(userInfo)) {
                return false;
            }
        }

        return isValid(userId,badgeId);
    }
}
