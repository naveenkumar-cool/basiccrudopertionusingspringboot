package com.example.serviceLayer;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dto.Studentdto;
import com.example.entity.Student;
import com.example.repo.StudentRepository;



public interface StudentService {

    public List<Student> getAllStudents();

    public Student getStudentById(Long id);

    public Student saveStudent(Student student);

    public Student deleteStudent(Long id);
    
    public Student UpdateStudent(Long id,Student student);
    
    public Student findByStudentName(String name);
    
    //DTO
    public Studentdto saveStudent1(@RequestBody Studentdto dto);
    
    public Studentdto findById(@PathVariable(value = "ID") Long id);
    
    public List<Studentdto> findAll();

	
}
