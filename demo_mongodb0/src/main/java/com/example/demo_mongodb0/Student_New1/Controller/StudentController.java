package com.example.demo_mongodb0.Student_New1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_mongodb0.Student_New1.Model.Student;
import com.example.demo_mongodb0.Student_New1.Service.StudentService;

@RestController
@RequestMapping("/api/student")

public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.saveStudent(student),HttpStatus.CREATED);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentBYId(@PathVariable String id){
        return new ResponseEntity<>(studentService.getStudentById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable String id,@RequestBody Student student){
        return new ResponseEntity<>(studentService.updateStudent(student,id),HttpStatus.OK);
    }

    //@DeleteMapping("/{id}")
    //public ResponseEntity<Student> deleteStudent(@PathVariable String id){
       // studentService.deleteStudent(id);
       // return new ResponseEntity<>(body:"student deleted successfully",HttpStatus.OK);
    //}
}
