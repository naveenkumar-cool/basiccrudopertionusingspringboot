package com.example.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.example.dto.Studentdto;
import com.example.entity.Student;

@Component
public class StudentConverter {

	public Studentdto entityToDto(Student student) {
		
		Studentdto dto = new Studentdto();
		dto.setName(student.getName());
		dto.setAge(student.getAge());
		dto.setEmail(student.getEmail());
		
		return dto;
		
	}
		public List<Studentdto> getAllStudents(List<Student> student) {
			
			//List<Studentdto> al = new ArrayList<Studentdto>();
			
			/*
			 * for(int i=0;i<student.size();i++) {
			 * 
			 * Student student1 = student.get(i); //Studentdto studentDto =
			 * entityToDto(student1); al.add(entityToDto(student1));
			 * 
			 * } return al;
			 */
			return student.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
			
		}
	public Student dtoToEntity(Studentdto dto) {
		
		Student st = new Student();
		st.setName(dto.getName());
		st.setAge(dto.getAge());
		st.setEmail(dto.getEmail());
		
		return st;
	}
    public List<Student> dtoToEntity(List<Studentdto> dto) {
		
    	return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}
