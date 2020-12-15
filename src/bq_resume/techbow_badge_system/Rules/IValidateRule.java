package bq_resume.techbow_badge_system.Rules;

import bq_resume.techbow_badge_system.UserInfo;
import com.sun.istack.internal.NotNull;

/**
 * Created by FLK on 2019-12-27.
 */
public interface IValidateRule {
    boolean isValid(@NotNull final UserInfo userInfo);
}
