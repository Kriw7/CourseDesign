package p.doctor.entity;

import javax.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private Integer size;
    @Column
    private String place;
    @Column
    private String status;

    @ManyToOne()
    @JoinColumn(name = "exam_id")
    private Exam exam;

    public Room() {
    }

    public Room(Integer size, String place, String status, Exam exam) {
        this.size = size;
        this.place = place;
        this.status = status;
        this.exam = exam;
    }

    public Room(Integer id, Integer size, String place, String status, Exam exam) {
        this.id = id;
        this.size = size;
        this.place = place;
        this.status = status;
        this.exam = exam;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", size=" + size +
                ", place='" + place + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
}
