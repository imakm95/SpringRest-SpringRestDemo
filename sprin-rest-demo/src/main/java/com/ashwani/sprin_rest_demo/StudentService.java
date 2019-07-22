package com.ashwani.sprin_rest_demo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashwani.sprin_rest_demo.exception.StudentNotFoundException;
import com.ashwani.sprin_rest_demo.pojo.Student;

@RestController
@RequestMapping("/api")
public class StudentService {
	private List<Student> studentList;

/*
 Spring calls methods annotated with @PostConstruct only once, just after the initialization of bean properties. Keep in mind that these methods will run even if there is nothing to initialize.
The method annotated with @PostConstruct can have any access level but it can’t be static.
One example usage of @PostConstruct is populating a database. During development, for instance, we might want to create some default users: 	 
	 */
@PostConstruct
public void loadDataOnce() {
		 studentList = new ArrayList<Student>();
		 Student s1 = new Student("Ashwani","Maurya");
		 Student s2 = new Student("Anjani","Maurya");
		 Student s3 = new Student("Sonam","Maurya");
		 Student s4 = new Student("Neelam","Maurya");
		 studentList.add(s1);
		 studentList.add(s2);
		 studentList.add(s3);
		 studentList.add(s4);
	}
	
	@GetMapping(value="/getstudents")
	public List<Student> getStudents(){
		return studentList;		
	}
	
	@GetMapping(value="/getstudents/{id}")
	public Student getStudentsById(@PathVariable("id") Integer id){
		if(id>studentList.size() || id<0) {
			throw new  StudentNotFoundException("Student id not found - "+id );
		}
		return studentList.get(id);
	
	}
	
}
