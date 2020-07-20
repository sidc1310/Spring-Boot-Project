package com.Project.SchoolProject.Controller;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.Project.SchoolProject.Model.Students;
import com.Project.SchoolProject.repo.StudentRepo;


@RestController
public class StudentController {
	
	@Autowired
	StudentRepo repo;
	
	@RequestMapping("/home")
	
	public String getStudents()
	{
		System.out.println("Students");
		
		return "Students.jsp";
	}
	
	@RequestMapping("/addstudent")
	public String addStudents(Students student)
	{
		System.out.println("Add Students");
		repo.save(student);
		return "Students.jsp";
	}
	
	@RequestMapping("/getstudent")
	public ModelAndView getStudent(@RequestParam int id)
	{
		System.out.println("Detail Students");
		ModelAndView mv = new ModelAndView("studentdetails.jsp");
		Students students = repo.findById(id).orElse(new Students());
		
//		System.out.println(repo.findByLname("Sayali"));
//		System.out.println(repo.findByIdGreaterThan(1));
		mv.addObject(students);
		return mv;
	}
//Starting Rest API ---------------------------------//
	
	//To Allow response in only json format
	@GetMapping(path="/students", produces={"application/json"})
	public List<Students> getStudentsRest()
	{
		System.out.println("Rest Get Students");
		
		return repo.findAll();
	}
	
	@GetMapping("/student/{id}")
	public Optional<Students> getStudentsByIdRest(@PathVariable("id") int id)
	{
		System.out.println("Rest Get Students");
		
		return repo.findById(id);
	}
	
	@PostMapping(path="/student",consumes={"application/json"})
	public Students addStudent(@RequestBody Students student)
	{
		repo.save(student);
		return student;
		
	}
	
	@PutMapping(path="/student",consumes={"application/json"})
	public Students updateStudent(@RequestBody Students student)
	{
		repo.save(student);
		return student;
		
	}
	
	@DeleteMapping("/student/{id}")
	public String deleteStudents(@PathVariable("id") int id)
	{
		
		Students std=repo.getOne(id);
		repo.delete(std);
		return "Deleted";
		
	}
}
