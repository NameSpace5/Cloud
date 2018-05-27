package ai.inlight.model.bean;

import java.util.List;

import model.bean.Comment;
import model.bean.HotComment;

public class HotCommentResult {
    private List<model.bean.HotComment> hotComments;
    private Boolean isMusician;
    private  Boolean moreHot;
    private List<model.bean.Comment> comments;
    private Long total;
    private Boolean more;
    private int code;

    public List<model.bean.HotComment> getHotComments() {
        return hotComments;
    }

    public void setHotComments(List<HotComment> hotComments) {
        this.hotComments = hotComments;
    }

    public Boolean getMusician() {
        return isMusician;
    }

    public void setMusician(Boolean musician) {
        isMusician = musician;
    }

    public Boolean getMoreHot() {
        return moreHot;
    }

    public void setMoreHot(Boolean moreHot) {
        this.moreHot = moreHot;
    }

    public List<model.bean.Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Boolean getMore() {
        return more;
    }

    public void setMore(Boolean more) {
        this.more = more;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
