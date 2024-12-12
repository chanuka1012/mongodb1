package com.example.demo_mongodb0.Student_New1.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo_mongodb0.Student_New1.Model.Student;
import java.util.List;


public interface StudentRepo extends MongoRepository<Student, String>{

    List<Student> findByYearOfEnrollment(int yearOfEnrollment);

    @Query(value = "{'_id': ?0 }", fields = "{'department':1}")
    String  findDepartmentById(String id);

    void deleteByYearOfEnrollment(int yearOfEnrollment);

}
