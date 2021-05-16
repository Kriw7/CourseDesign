package p.doctor.form;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

public class NewExamForm {
    private String type;
    private String level;
    private String name;
    private String beginTime;
    private String endTime;
    private String signBeginTime;
    private String signEndTime;
    private String content;
    private Integer maxGrade;
    private List<String> permittedMajors;

    public NewExamForm() {
    }

    public NewExamForm(String type, String level, String name, String beginTime, String endTime, String signBeginTime, String signEndTime, String content, Integer maxGrade, List<String> permittedMajors) {
        this.type = type;
        this.level = level;
        this.name = name;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.signBeginTime = signBeginTime;
        this.signEndTime = signEndTime;
        this.content = content;
        this.maxGrade = maxGrade;
        this.permittedMajors = permittedMajors;
    }

    @Override
    public String toString() {
        return "NewExamForm{" +
                "type='" + type + '\'' +
                ", level='" + level + '\'' +
                ", name='" + name + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", signBeginTime='" + signBeginTime + '\'' +
                ", signEndTime='" + signEndTime + '\'' +
                ", content='" + content + '\'' +
                ", maxGrade=" + maxGrade +
                ", permittedMajors的size=" + permittedMajors.size() +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSignBeginTime() {
        return signBeginTime;
    }

    public void setSignBeginTime(String signBeginTime) {
        this.signBeginTime = signBeginTime;
    }

    public String getSignEndTime() {
        return signEndTime;
    }

    public void setSignEndTime(String signEndTime) {
        this.signEndTime = signEndTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getMaxGrade() {
        return maxGrade;
    }

    public void setMaxGrade(Integer maxGrade) {
        this.maxGrade = maxGrade;
    }

    public List<String> getPermittedMajors() {
        return permittedMajors;
    }

    public void setPermittedMajors(List<String> permittedMajors) {
        this.permittedMajors = permittedMajors;
    }
}
