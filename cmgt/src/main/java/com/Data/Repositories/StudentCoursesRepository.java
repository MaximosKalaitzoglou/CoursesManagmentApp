package com.Data.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.Data.StudentCourse;
import com.Data.StudentCoursesCompositeKey;

public interface StudentCoursesRepository extends CrudRepository<StudentCourse, StudentCoursesCompositeKey>{
	
	Optional<StudentCourse> findById(StudentCoursesCompositeKey id);
    List<StudentCourse> findAll();
    void deleteById(StudentCoursesCompositeKey id);
}
