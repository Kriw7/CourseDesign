package p.doctor.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(name = "username")
    private String userName;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String mobile;
    @Column
    private String QQ;
    @Column
    private String email;

    @OneToMany(mappedBy = "manager")
    private Set<Exam> exams = new HashSet<>();

    public Manager() {
    }

    public Manager(String userName, String password, String name, String mobile, String QQ, String email) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.mobile = mobile;
        this.QQ = QQ;
        this.email = email;
    }

    public Manager(int id, String userName, String password, String name, String mobile, String QQ, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.mobile = mobile;
        this.QQ = QQ;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", QQ='" + QQ + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @JsonBackReference
    public Set<Exam> getExams() {
        return exams;
    }

    public void setExams(Set<Exam> exams) {
        this.exams = exams;
    }
}
