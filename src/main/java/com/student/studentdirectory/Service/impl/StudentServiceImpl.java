package com.student.studentdirectory.Service.impl;

import com.student.studentdirectory.Entity.Student;
import com.student.studentdirectory.Repository.StudentRepository;
import com.student.studentdirectory.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public Student updateStudent(Student student) {
        Student updateStudent = studentRepository.findBySurveyId(student.getSurveyId());

        updateStudent.setSurveyId(student.getSurveyId());
        updateStudent.setFirstName(student.getFirstName());
        updateStudent.setLastName(student.getLastName());
        updateStudent.setAddress(student.getAddress());
        updateStudent.setCity(student.getCity());
        updateStudent.setZip(student.getZip());
        updateStudent.setPhoneNumber(student.getPhoneNumber());
        updateStudent.setSurveyDate(student.getSurveyDate());
        updateStudent.setCampusLovedThing(student.getCampusLovedThing());
        updateStudent.setWhyJoinUni(student.getWhyJoinUni());
        updateStudent.setRecommendFriends(student.getRecommendFriends());

        studentRepository.save(updateStudent);
        return updateStudent;
    }

    @Override
    public Student displayStudents(int surveyId) {
        return studentRepository.findBySurveyId(surveyId);
    }

    @Override
    public void deleteStudent(int surveyId) {
        Student student = studentRepository.findBySurveyId(surveyId);
        studentRepository.delete(student);
    }
}
