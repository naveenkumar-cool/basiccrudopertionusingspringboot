package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.converter.StudentConverter;
import com.example.dto.Studentdto;
import com.example.entity.Student;
import com.example.repo.StudentRepository;
import com.example.serviceLayer.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
//Controller is only used to call 
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentConverter converter;

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		return new ResponseEntity<Student>(studentService.getStudentById(id), HttpStatus.OK);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student requestStudent) {

	    return new ResponseEntity<Student>(studentService.UpdateStudent(id, requestStudent), HttpStatus.OK);
	}

	 @DeleteMapping("/{id}") 
	 public ResponseEntity<Student>deleteStudent(@PathVariable Long id) {
		 
		return new ResponseEntity<Student>(studentService.deleteStudent(id), HttpStatus.OK);
		
	 }
	 @GetMapping("/name/{name}")
	 public Student findByStudentName(@PathVariable String name)
	 {
		 return studentService.findByStudentName(name);
	 }
	 
	 //DTO
	 @PostMapping("/saveStudent")
	 public Studentdto saveStudent1(@RequestBody Studentdto student) {
		 
		 return studentService.saveStudent1(student);
	 }
	 
	 @GetMapping("/getById/{id}")
	 public Studentdto findById(@PathVariable Long id) {
		 
		 return studentService.findById(id);
	 }
	 
	 @GetMapping("/getAll")
	 public List<Studentdto> findAll() {
		 
		 return studentService.findAll();
	 }
}
