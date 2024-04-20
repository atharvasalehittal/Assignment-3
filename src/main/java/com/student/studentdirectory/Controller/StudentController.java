package com.student.studentdirectory.Controller;

import com.student.studentdirectory.Entity.Student;
import com.student.studentdirectory.Repository.StudentRepository;
import com.student.studentdirectory.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return new ResponseEntity(studentService.createStudent(student), HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        return new ResponseEntity(studentService.updateStudent(student), HttpStatus.OK);
    }

    @GetMapping("{studentId}")
    public ResponseEntity<Student> displayStudent(@PathVariable("studentId") String studentId){
        return new ResponseEntity(studentService.findStudentById(studentId), HttpStatus.OK);
    }

    @DeleteMapping("{studentId}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("studentId") String studentId){
        studentService.deleteStudent(studentId);
        return new ResponseEntity("Student Deleted",HttpStatus.OK);
    }
}
