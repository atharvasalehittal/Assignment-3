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
        Student updateStudent = studentRepository.findByStudentId(student.getStudentId());

        updateStudent.setStudentId(student.getStudentId());
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
    public Student findStudentById(String studentId) {
        return studentRepository.findByStudentId(studentId);
    }

    @Override
    public void deleteStudent(String studentId) {
        Student student = findStudentById(studentId);
        studentRepository.delete(student);
    }
}
