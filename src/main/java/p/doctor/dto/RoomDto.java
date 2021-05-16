package p.doctor.dto;

import javax.persistence.Column;

public class RoomDto {
    private Integer id;
    private Integer size;
    private String place;
    private String status;

    public RoomDto() {
    }

    public RoomDto(Integer id, Integer size, String place, String status) {
        this.id = id;
        this.size = size;
        this.place = place;
        this.status = status;
    }

    @Override
    public String toString() {
        return "RoomDto{" +
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
}
