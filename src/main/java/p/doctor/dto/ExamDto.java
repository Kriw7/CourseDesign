package p.doctor.dto;

import javax.persistence.Column;
import java.util.Date;

public class ExamDto {
    private Integer id;
    private String type;
    private Integer level;
    private String name;
    private String content;
    private Date beginTime;
    private Date endTime;
    private Date signBeginTime;
    private Date signEndTime;
    private Integer nums;
    private String status;
    private Integer maxGrade;
    private String permittedMajors;
    private String examController;

    public ExamDto() {
    }

    public ExamDto(Integer id, String type, Integer level, String name, String content, Date beginTime, Date endTime, Date signBeginTime, Date signEndTime, Integer nums, String status, Integer maxGrade, String permittedMajors) {
        this.id = id;
        this.type = type;
        this.level = level;
        this.name = name;
        this.content = content;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.signBeginTime = signBeginTime;
        this.signEndTime = signEndTime;
        this.nums = nums;
        this.status = status;
        this.maxGrade = maxGrade;
        this.permittedMajors = permittedMajors;
    }

    public ExamDto(String type, Integer level, String name, String content, Date beginTime, Date endTime, Date signBeginTime, Date signEndTime) {
        this.type = type;
        this.level = level;
        this.name = name;
        this.content = content;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.signBeginTime = signBeginTime;
        this.signEndTime = signEndTime;
    }

    public ExamDto(String type, Integer level, String name, String content, Date beginTime, Date endTime, Date signBeginTime, Date signEndTime, Integer nums, String status) {
        this.type = type;
        this.level = level;
        this.name = name;
        this.content = content;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.signBeginTime = signBeginTime;
        this.signEndTime = signEndTime;
        this.nums = nums;
        this.status = status;
    }

    public ExamDto(Integer id, String type, Integer level, String name, String content, Date beginTime, Date endTime, Date signBeginTime, Date signEndTime, Integer nums, String status) {
        this.id = id;
        this.type = type;
        this.level = level;
        this.name = name;
        this.content = content;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.signBeginTime = signBeginTime;
        this.signEndTime = signEndTime;
        this.nums = nums;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ExamDto{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", level=" + level +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", signBeginTime=" + signBeginTime +
                ", signEndTime=" + signEndTime +
                ", nums=" + nums +
                ", status='" + status + '\'' +
                ", maxGrade=" + maxGrade +
                ", permittedMajors='" + permittedMajors + '\'' +
                ", examController='" + examController + '\'' +
                '}';
    }

    public String getExamController() {
        return examController;
    }

    public void setExamController(String examController) {
        this.examController = examController;
    }

    public Integer getMaxGrade() {
        return maxGrade;
    }

    public void setMaxGrade(Integer maxGrade) {
        this.maxGrade = maxGrade;
    }

    public String getPermittedMajors() {
        return permittedMajors;
    }

    public void setPermittedMajors(String permittedMajors) {
        this.permittedMajors = permittedMajors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
