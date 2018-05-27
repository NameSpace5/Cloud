package ai.inlight.model.bean;

import java.util.List;

public class LoginResult {
    private int loginType;
    private int code;
    private Account account;
    private Profile profile;
    private List<Binding> bindings;

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Binding> getBindings() {
        return bindings;
    }

    public void setBindings(List<Binding> bindings) {
        this.bindings = bindings;
    }
}
