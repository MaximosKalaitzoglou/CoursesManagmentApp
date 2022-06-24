package com.Data.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Data.Student;


public interface InstructorRepository extends CrudRepository<Student,Integer>{
	
	Student findById(int id);
    List<Student> findAll();
    void deleteById(int id);

}
