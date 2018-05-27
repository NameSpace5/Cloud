package ai.inlight.model.bean;

import java.util.List;

public class UserProfileResult {
    private List<Profile> userProfile;
    private int userProfileCount;

    public List<Profile> getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(List<Profile> userProfile) {
        this.userProfile = userProfile;
    }

    public int getUserProfileCount() {
        return userProfileCount;
    }

    public void setUserProfileCount(int userProfileCount) {
        this.userProfileCount = userProfileCount;
    }
}
