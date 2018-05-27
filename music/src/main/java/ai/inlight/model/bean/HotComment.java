package ai.inlight.model.bean;

import java.util.List;

import model.bean.BeReplied;
import model.bean.User;

public class HotComment {
    private List<model.bean.BeReplied> beReplied;
    private model.bean.User user;
    private Boolean liked;
    private Long likedCount;
    private Long time;
    private String content;

    public List<model.bean.BeReplied> getBeReplied() {
        return beReplied;
    }

    public void setBeReplied(List<BeReplied> beReplied) {
        this.beReplied = beReplied;
    }

    public model.bean.User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }

    public Long getLikedCount() {
        return likedCount;
    }

    public void setLikedCount(Long likedCount) {
        this.likedCount = likedCount;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
