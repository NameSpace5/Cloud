package ai.inlight.model.bean;

import model.bean.User;

public class BeReplied {
    private model.bean.User user;
    private String content;
    private int status;

    public model.bean.User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
