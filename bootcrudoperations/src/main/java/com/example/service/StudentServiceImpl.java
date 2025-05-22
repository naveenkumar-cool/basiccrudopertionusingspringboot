package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.converter.StudentConverter;
import com.example.dto.Studentdto;
import com.example.entity.Student;
import com.example.exception.ResourceNotFoundExe;
import com.example.repo.StudentRepository;
import com.example.serviceLayer.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentConverter studentConverter;

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee id not found"));
	}
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student deleteStudent(Long id) {
		Student rdStudent = studentRepository.findById(id).orElseThrow();
		if (rdStudent != null) {
			studentRepository.delete(rdStudent);
		}
		return rdStudent;
	}

	@Override
	public Student UpdateStudent(Long id, Student student) {
		Student rdstudent = studentRepository.findById(id).orElseThrow();
		if (rdstudent != null) {
			rdstudent.setName(student.getName());
			rdstudent.setEmail(student.getEmail());
			rdstudent.setAge(student.getAge());
			studentRepository.save(rdstudent);
		}
		return rdstudent;
	}

	@Override
	public Student findByStudentName(String name) {
		Student student = studentRepository.findByName(name);
		return student;
	}

	@Override
	public Studentdto saveStudent1(Studentdto dto) {
		Student std = studentConverter.dtoToEntity(dto);
		studentRepository.save(std);
		return dto;
	}

	@Override
	public Studentdto findById(Long id) {
		
		//Student sdto = studentRepository.findById(id).orElseThrow();
		//Studentdto sdto1 = studentConverter.entityToDto(sdto);
		//return sdto1;
		//Student sdto = studentRepository.findById(id).orElseThrow();
		return studentConverter.entityToDto(studentRepository.findById(id).orElseThrow());
	}

	@Override
	public List<Studentdto> findAll() {
		List<Student> dtos = studentRepository.findAll();
		List<Studentdto> studentDtos = dtos.stream().map(student -> studentConverter.entityToDto(student)).collect(Collectors.toList());
		return studentDtos;
		
		
		
	}

}
