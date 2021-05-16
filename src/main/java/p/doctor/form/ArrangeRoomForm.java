package p.doctor.form;

import java.util.List;

public class ArrangeRoomForm {
    List<Integer> selectRoomId;
    String examName;

    public ArrangeRoomForm() {
    }

    public ArrangeRoomForm(List<Integer> selectRoomId, String examName) {
        this.selectRoomId = selectRoomId;
        this.examName = examName;
    }

    @Override
    public String toString() {
        return "ArrangeRoomForm{" +
                "selectRoomId.size=" + selectRoomId.size() +
                ", examName='" + examName + '\'' +
                '}';
    }

    public List<Integer> getSelectRoomId() {
        return selectRoomId;
    }

    public void setSelectRoomId(List<Integer> selectRoomId) {
        this.selectRoomId = selectRoomId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }
}
