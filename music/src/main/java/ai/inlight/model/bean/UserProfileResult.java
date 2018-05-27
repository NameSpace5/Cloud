package ai.inlight.model.bean;

import java.util.List;

import model.bean.Profile;

public class UserProfileResult {
    private List<model.bean.Profile> userProfile;
    private int userProfileCount;

    public List<model.bean.Profile> getUserProfile() {
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
