package p.doctor.form;

public class RegisterForm {
    private String userName;
    private String password;
    private String name;
    private String gender;
    private Integer age;
    private Integer grade;
    private Integer classOrder;
    private String major;

    public RegisterForm() {
    }

    public RegisterForm(String userName, String password, String name, String gender, Integer age, Integer grade, Integer classOrder, String major) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.grade = grade;
        this.classOrder = classOrder;
        this.major = major;
    }

    @Override
    public String toString() {
        return "RegisterForm{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                ", classOrder=" + classOrder +
                ", major='" + major + '\'' +
                '}';
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getClassOrder() {
        return classOrder;
    }

    public void setClassOrder(Integer classOrder) {
        this.classOrder = classOrder;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
