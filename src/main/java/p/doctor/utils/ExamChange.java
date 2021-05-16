package p.doctor.utils;

import org.springframework.beans.BeanUtils;
import p.doctor.dto.ExamDto;
import p.doctor.dto.PermittedExam;
import p.doctor.dto.SignedExam;
import p.doctor.entity.Exam;
import p.doctor.entity.Manager;

import java.util.ArrayList;
import java.util.List;

public class ExamChange {
    public static ExamDto changeToDto(Exam exam){
        ExamDto examDto = new ExamDto();
        BeanUtils.copyProperties(exam,examDto);
        return examDto;
    }
    public  static List<ExamDto> changeToDto(List<Exam> exams){
        List<ExamDto> examDtos = new ArrayList<>();
        for (Exam exam:exams){
            ExamDto examDto = new ExamDto();
            BeanUtils.copyProperties(exam,examDto);
            examDtos.add(examDto);
        }
        return examDtos;
    }
    public static PermittedExam changeToPermitted(Exam exam){
        PermittedExam permittedExam = new PermittedExam();
        BeanUtils.copyProperties(exam,permittedExam);
        return permittedExam;
    }
    public static List<PermittedExam> changeToPermitted(List<Exam> exams){
        List<PermittedExam> permittedExams = new ArrayList<>();
        for (Exam exam:exams){
            PermittedExam permittedExam = new PermittedExam();
            BeanUtils.copyProperties(exam,permittedExam);
            permittedExams.add(permittedExam);
        }
        return permittedExams;
    }
    public static SignedExam changeToSignedExam(Exam exam){
        SignedExam signedExam = new SignedExam();
        BeanUtils.copyProperties(exam,signedExam);
        return signedExam;
    }
    public static List<SignedExam> changeToSignedExam(List<Exam> exams){
        List<SignedExam> signedExams = new ArrayList<>();
        for (Exam exam:exams){
            SignedExam signedExam = new SignedExam();
            BeanUtils.copyProperties(exam,signedExam);
            signedExams.add(signedExam);
        }
        return signedExams;
    }
    public static  Exam updateExam(Exam exam,ExamDto examDto){
        exam.setType(examDto.getType());
        exam.setLevel(examDto.getLevel());
        exam.setName(examDto.getName());
        exam.setContent(examDto.getContent());
        exam.setBeginTime(examDto.getBeginTime());
        exam.setEndTime(examDto.getEndTime());
        exam.setSignBeginTime(examDto.getSignBeginTime());
        exam.setSignEndTime(examDto.getSignEndTime());
        exam.setPermittedMajors(examDto.getPermittedMajors());
        return  exam;
    }
}
