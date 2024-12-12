package com.example.demo_mongodb0.Student_New1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo_mongodb0.Student_New1.Model.Student;
import com.example.demo_mongodb0.Student_New1.Repo.StudentRepo;

@Service

public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student saveStudent(Student student){
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentById(String id){
        return studentRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("student not found"));
    }

    @Override
    public Student updateStudent(Student student, String id){
        Student existingStudent = getStudentById(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setYearOfEnrollment(student.getYearOfEnrollment());
        return studentRepo.save(existingStudent);
    }

    @Override
    public void deleteStudent(String id){
        studentRepo.deleteById(id);
    }

    @Override
    public List<Student> getStudentByYearOfEnrollment(int yearOfEnrollment){
        return studentRepo.findByYearOfEnrollment(yearOfEnrollment);
    }

    @Override
    public String getDepartmentById(String id){
        return studentRepo.findDepartmentById(id);
    }

    @Transactional
    @Override
    public void removeStudentByYearOfEnrollment(int yearOfEnrollment){
        studentRepo.deleteByYearOfEnrollment(yearOfEnrollment);
    }

}
