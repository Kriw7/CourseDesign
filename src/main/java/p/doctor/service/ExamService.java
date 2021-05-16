package p.doctor.service;

import p.doctor.dto.ExamDto;
import p.doctor.dto.PermittedExam;
import p.doctor.entity.Exam;

import java.util.List;

public interface ExamService {
    List<ExamDto> findExamsByPage(Integer pageNo,Integer pageSize);
    Integer getTotalPage(Integer pageSize);
    boolean addNewExam(ExamDto examDto,String userName);
    boolean updateExam(ExamDto examDto,String userName);
    ExamDto findFirstByExamName(String examName);
    boolean deleteOneExam(String examName);
    List<PermittedExam> loadPermittedExams(String userName, Integer pageNo, Integer pageSize);
    Integer getTotalPermittedPage(String userName,Integer pageSize);
    Integer signNewRelation(String userName,String examName);
    Integer cancelOldRelation(String userName,String examName);
    String loadExamRooms(String examName);
}
