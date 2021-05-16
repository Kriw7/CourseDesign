package p.doctor.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String type;
    @Column
    private Integer level;
    @Column
    private String name;
    @Column
    private String content;
    @Column(name = "begintime")
    private Date beginTime;
    @Column(name = "endtime")
    private Date endTime;
    @Column(name = "sign_begintime")
    private Date signBeginTime;
    @Column(name = "sign_endtime")
    private Date signEndTime;
    @Column
    private Integer nums;
    @Column
    private String status;
    @Column(name = "maxgrade")
    private Integer maxGrade;
    @Column(name = "permittedmajors")
    private String permittedMajors;


//表关联的地方
    //一场考试需要用到多个教室
    @OneToMany(mappedBy = "exam",fetch = FetchType.EAGER)
    private Set<Room> roomSet = new HashSet<>();

    //考试的设置可由管理员来修改
    @ManyToOne()
    @JoinColumn(name = "manager_id")
    private Manager manager;

    //学生可报考不同的考试，考试可被不同的学生报考
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "signRelation",
            joinColumns = {@JoinColumn(name = "exam_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id",referencedColumnName = "id")})
    private Set<Student> students = new HashSet<>();

    public Exam() {
    }

    public Exam(Integer id, String type, Integer level, String name, String content, Date beginTime, Date endTime, Date signBeginTime, Date signEndTime, Integer nums, String status, Integer maxGrade, String permittedMajors) {
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

    public Exam(String type, Integer level, String name, String content, Date beginTime, Date endTime, Date signBeginTime, Date signEndTime, Integer nums, String status) {
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

    public Exam(Integer id, String type, Integer level, String name, String content, Date beginTime, Date endTime, Date signBeginTime, Date signEndTime, Integer nums, String status) {
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
        return "Exam{" +
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
                '}';
    }

    public String getPermittedMajors() {
        return permittedMajors;
    }

    public void setPermittedMajors(String permittedMajors) {
        this.permittedMajors = permittedMajors;
    }

    public Integer getMaxGrade() {
        return maxGrade;
    }

    public void setMaxGrade(Integer maxGrade) {
        this.maxGrade = maxGrade;
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

    @JsonBackReference
    public Set<Room> getRoomSet() {
        return roomSet;
    }

    public void setRoomSet(Set<Room> roomSet) {
        this.roomSet = roomSet;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
    @JsonBackReference
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
