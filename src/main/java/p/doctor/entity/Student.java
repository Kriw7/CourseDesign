package p.doctor.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column(name = "username")
    private String userName;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private Integer age;
    @Column
    private String gender;
    @Column
    private Integer grade;
    @Column
    private String major;
    @Column
    private Integer classOrder;
    @Column
    private String path;

    //mappedBy定义了关系的维护者是Exam，他有个外键指向Student表
    @ManyToMany(mappedBy = "students",fetch = FetchType.EAGER)
    public Set<Exam> exams = new HashSet<>();

    public Student() {
    }

    public Student(String userName, String password, String name, Integer age, String gender, Integer grade, String major, Integer classOrder, String path) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.grade = grade;
        this.major = major;
        this.classOrder = classOrder;
        this.path = path;
    }

    public Student(Integer id, String userName, String password, String name, Integer age, String gender, Integer grade, String major, Integer classOrder, String path) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.grade = grade;
        this.major = major;
        this.classOrder = classOrder;
        this.path = path;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", grade=" + grade +
                ", major='" + major + '\'' +
                ", classOrder=" + classOrder +
                ", path='" + path + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getClassOrder() {
        return classOrder;
    }

    public void setClassOrder(Integer classOrder) {
        this.classOrder = classOrder;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    @JsonBackReference
    public Set<Exam> getExams() {
        return exams;
    }

    public void setExams(Set<Exam> exams) {
        this.exams = exams;
    }
}
