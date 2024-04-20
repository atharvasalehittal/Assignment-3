package com.student.studentdirectory.Repository;

import com.student.studentdirectory.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByStudentId(String studentId);
}
