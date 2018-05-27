package ai.inlight.model.bean;

import java.util.List;

import model.bean.Creator;
import model.bean.Track;

public class TracksResult {
    private model.bean.Creator creator;
    private List<model.bean.Track> tracks;
    private Long trackNumberUpdateTime;
    private Boolean ordered;
    private List<String> tags;
    private Long userId;
    private Long createTime;
    private Long trackUpdateTime;
    private int trackCount;
    private Long playCount;
    private String description;
    private Long subscribedCount;
    private String name;
    private Long id;
    private int shareCount;
    private int commentCount;

    public model.bean.Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public List<model.bean.Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public Long getTrackNumberUpdateTime() {
        return trackNumberUpdateTime;
    }

    public void setTrackNumberUpdateTime(Long trackNumberUpdateTime) {
        this.trackNumberUpdateTime = trackNumberUpdateTime;
    }

    public Boolean getOrdered() {
        return ordered;
    }

    public void setOrdered(Boolean ordered) {
        this.ordered = ordered;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getTrackUpdateTime() {
        return trackUpdateTime;
    }

    public void setTrackUpdateTime(Long trackUpdateTime) {
        this.trackUpdateTime = trackUpdateTime;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    public Long getPlayCount() {
        return playCount;
    }

    public void setPlayCount(Long playCount) {
        this.playCount = playCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSubscribedCount() {
        return subscribedCount;
    }

    public void setSubscribedCount(Long subscribedCount) {
        this.subscribedCount = subscribedCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}
