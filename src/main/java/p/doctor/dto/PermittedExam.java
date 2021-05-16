package p.doctor.dto;

import java.util.Date;

public class PermittedExam {
    private String type;
    private Integer level;
    private String name;
    private Date beginTime;
    private Date endTime;
    private Date signBeginTime;
    private Date signEndTime;
    private boolean relation;

    public PermittedExam() {
    }

    public PermittedExam(String type, Integer level, String name, Date beginTime, Date endTime, Date signBeginTime, Date signEndTime, boolean relation) {
        this.type = type;
        this.level = level;
        this.name = name;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.signBeginTime = signBeginTime;
        this.signEndTime = signEndTime;
        this.relation = relation;
    }

    @Override
    public String toString() {
        return "PermittedExam{" +
                "type='" + type + '\'' +
                ", level=" + level +
                ", name='" + name + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", signBeginTime=" + signBeginTime +
                ", signEndTime=" + signEndTime +
                ", relation=" + relation +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getSignBeginTime() {
        return signBeginTime;
    }

    public void setSignBeginTime(Date signBeginTime) {
        this.signBeginTime = signBeginTime;
    }

    public Date getSignEndTime() {
        return signEndTime;
    }

    public void setSignEndTime(Date signEndTime) {
        this.signEndTime = signEndTime;
    }

    public boolean isRelation() {
        return relation;
    }

    public void setRelation(boolean relation) {
        this.relation = relation;
    }
}
