package p.doctor.dto;

public class StudentDto {
    private Integer id;
    private String userName;
    private String name;
    private Integer age;
    private String  gender;
    private Integer grade;
    private String major;
    private Integer classOrder;
    private String path;

    public StudentDto() {
    }

    public StudentDto(String userName, String name, Integer age, String gender, Integer grade, String major, Integer classOrder, String path) {
        this.userName = userName;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.grade = grade;
        this.major = major;
        this.classOrder = classOrder;
        this.path = path;
    }

    public StudentDto(Integer id, String userName, String name, Integer age, String gender, Integer grade, String major, Integer classOrder, String path) {
        this.id = id;
        this.userName = userName;
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
        return "StudentDto{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", grade=" + grade +
                ", major='" + major + '\'' +
                ", classOrder=" + classOrder +
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
}
