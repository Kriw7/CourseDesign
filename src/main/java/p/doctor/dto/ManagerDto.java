package p.doctor.dto;

import javax.persistence.Column;

public class ManagerDto {
    private int id;
    private String userName;
    private String password;
    private String name;
    private String mobile;
    private String QQ;
    private String email;

    public ManagerDto() {
    }

    public ManagerDto(String userName, String password, String name, String mobile, String QQ, String email) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.mobile = mobile;
        this.QQ = QQ;
        this.email = email;
    }

    public ManagerDto(int id, String userName, String password, String name, String mobile, String QQ, String email) {
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
        return "ManagerDto{" +
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
}
