package com.Data.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Data.Course;
import com.Data.Student;

public interface CoursesRepository extends CrudRepository<Course,Integer>{
	
	Course findById(int id);
    List<Course> findAll();
    void deleteById(int id);
}
