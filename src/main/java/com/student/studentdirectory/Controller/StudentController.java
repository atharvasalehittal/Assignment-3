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

    @GetMapping("{surveyId}")
    public ResponseEntity<Student> displayStudent(@PathVariable("surveyId") int surveyId){
        return new ResponseEntity(studentService.displayStudents(surveyId), HttpStatus.OK);
    }

    @DeleteMapping("{surveyId}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("surveyId") int surveyId){
        studentService.deleteStudent(surveyId);
        return new ResponseEntity("Student Deleted",HttpStatus.OK);
    }
}
