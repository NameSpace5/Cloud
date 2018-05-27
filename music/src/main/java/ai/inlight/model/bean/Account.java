package ai.inlight.model.bean;

public class Account {
    private Long id;
    private Long createTime;
    private int vipType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public int getVipType() {
        return vipType;
    }

    public void setVipType(int vipType) {
        this.vipType = vipType;
    }

    public int getVipTypeVersion() {
        return vipTypeVersion;
    }

    public void setVipTypeVersion(int vipTypeVersion) {
        this.vipTypeVersion = vipTypeVersion;
    }

    private int vipTypeVersion;
}
