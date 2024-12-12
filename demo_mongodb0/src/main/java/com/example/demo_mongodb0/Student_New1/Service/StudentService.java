package com.example.demo_mongodb0.Student_New1.Service;

import java.util.List;

import com.example.demo_mongodb0.Student_New1.Model.Student;

public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(String id);

    Student updateStudent(Student student,String id);

    void deleteStudent(String id);
    
    List<Student> getStudentByYearOfEnrollment(int yearOfEnrollment);

    String getDepartmentById(String id);

    void removeStudentByYearOfEnrollment(int yearOfEnrollment);
}
