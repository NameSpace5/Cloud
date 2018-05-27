package ai.inlight.model.bean;

import java.util.List;

import model.bean.Account;
import model.bean.Binding;
import model.bean.Profile;

public class LoginResult {
    private int loginType;
    private int code;
    private model.bean.Account account;
    private model.bean.Profile profile;
    private List<model.bean.Binding> bindings;

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

    public model.bean.Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public model.bean.Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<model.bean.Binding> getBindings() {
        return bindings;
    }

    public void setBindings(List<Binding> bindings) {
        this.bindings = bindings;
    }
}
