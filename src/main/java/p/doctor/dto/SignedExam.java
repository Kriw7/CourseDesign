package p.doctor.dto;

import java.util.Date;

public class SignedExam {
    private String type;
    private Integer level;
    private String name;
    private Date beginTime;
    private Date endTime;
    private String place;

    public SignedExam() {
    }

    public SignedExam(String type, Integer level, String name, Date beginTime, Date endTime, String place) {
        this.type = type;
        this.level = level;
        this.name = name;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.place = place;
    }

    @Override
    public String toString() {
        return "SignedExam{" +
                "type='" + type + '\'' +
                ", level=" + level +
                ", name='" + name + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", place='" + place + '\'' +
                '}';
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
