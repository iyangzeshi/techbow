package bq_resume.techbow_badge_system;

import bq_resume.techbow_badge_system.Rules.IValidateRule;
import java.util.List;

/**
 * controller
 * Created by FLK on 2019-12-27.
 */
public interface IValidationService {
    int getUserSecurityLevel(final String userid);

    int getCheckerSecurityLevel(final String checkerId);

    UserInfo getUserInfo(final String userId);

    List<IValidateRule> getCheckerValidationRules(String checkerId);

    String getUserCurrentBadgeId(String userId);
}
