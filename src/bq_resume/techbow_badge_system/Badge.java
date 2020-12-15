package bq_resume.techbow_badge_system;

/*
题目描述：design一个门禁系统，要求可以刷卡进门
1. Badge
2. Checker

1. Checker read data from Badge
2. Validation

1. badge(single boolean) --> (validation by the field): local
2. boolean isTechbow, Priority/Security, position, Org

1. Badge --> Checker --> Cloud(Service, DB) --> Checker --> Validation
2. Employee Management Application
    application(front end) --> service(middle layer) --> DB(Backend)
 */
public class Badge {

    private final String badgeId;
    private String userId;

    public Badge(final String badgeId){
        this.badgeId = badgeId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getBadgeId(){
        return badgeId;
    }

    public String getUserId(){
        return userId;
    }
}
