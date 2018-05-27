package ai.inlight.model.bean;

import java.util.List;

import model.bean.BeReplied;

public class Comment {
    private List<BeReplied> beReplied;
    private Boolean liked;
    private int commentId;
    private int likedCount;
    private Long time;
    private String content;

    public List<BeReplied> getBeReplied() {
        return beReplied;
    }

    public void setBeReplied(List<BeReplied> beReplied) {
        this.beReplied = beReplied;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getLikedCount() {
        return likedCount;
    }

    public void setLikedCount(int likedCount) {
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
