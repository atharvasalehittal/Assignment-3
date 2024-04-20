package com.student.studentdirectory.Service;

import com.student.studentdirectory.Entity.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    Student createStudent(Student student);

    Student updateStudent(Student student);

    Student findStudentById(String studentId);

    void deleteStudent(String studentId);
}
