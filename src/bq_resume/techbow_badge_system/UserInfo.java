package bq_resume.techbow_badge_system;

/**
 * Created by FLK on 2019-12-27.
 */
public class UserInfo {
    //Must-have fields
    private final String userId;
    private Position position;
    public int securityLevel;

    //Nice-to-have fields
    private int tenure;
    private String orgId;

    //For Lost Badge Usage
    private String currentBadgeId;

    private UserInfo(final Builder b) {
        userId = b.userId;
        position = b.position;
        securityLevel = b.securityLevel;
        tenure = b.tenure;
        orgId = b.orgId;
        currentBadgeId = b.currentBadgeId;
    }

    public String getUserId(){
        return userId;
    }

    public Position getPosition(){
        return position;
    }

    public int getSecurityLevel(){
        return securityLevel;
    }

    public int getTenure() {
        return tenure;
    }

    public String getOrgId(){
        return orgId;
    }

    public String getCurrentBadgeId(){
        return currentBadgeId;
    }

    public class Builder {
        //Must-have fields
        private final String userId;
        private Position position;
        private int securityLevel;

        //Nice-to-have fields
        private int tenure;
        private String orgId;

        //For Lost Badge Usage
        private String currentBadgeId;

        public Builder(final String userId) {
            this.userId = userId;
            securityLevel = 0;
            tenure = 0;
        }

        public Builder withPosition(final Position position) {
            this.position = position;
            return this;
        }

        public Builder withSecurityLevel(final int securityLevel){
            this.securityLevel = securityLevel;
            return this;
        }

        public Builder withTenure(final int tenure) {
            this.tenure = tenure;
            return this;
        }

        public Builder withOrgId(final String org) {
            this.orgId = org;
            return this;
        }

        public Builder withCurrentBadgeId(final String currentBadgeId) {
            this.currentBadgeId = currentBadgeId;
            return this;
        }

        public UserInfo build(){
            return new UserInfo(this);
        }
    }
}
