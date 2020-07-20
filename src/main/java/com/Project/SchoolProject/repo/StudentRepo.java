package com.Project.SchoolProject.repo;
import com.Project.SchoolProject.Model.Students;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Students,Integer>
{
	List<Students> findByLname(String lname);
	List<Students> findByIdGreaterThan(int id);
}
