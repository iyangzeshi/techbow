package bq_resume.techbow_badge_system.Rules;


import bq_resume.techbow_badge_system.Position;
import bq_resume.techbow_badge_system.UserInfo;
import com.sun.istack.internal.NotNull;

/**
 * Created by FLK on 2019-12-27.
 */
public class PositionRule implements IValidateRule{

    private final Position position;

    public PositionRule(final Position position){
        this.position = position;
    }

    public Position getPosition(){
        return position;
    }

    @Override
    public boolean isValid(@NotNull final UserInfo userInfo) {
        return position == userInfo.getPosition();
    }
}
