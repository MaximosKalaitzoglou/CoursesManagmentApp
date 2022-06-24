package com.myy803.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Data.Course;
import com.Data.Student;
import com.Data.StudentCourse;
import com.Data.StudentCoursesCompositeKey;
import com.Data.Repositories.CoursesRepository;
import com.Data.Repositories.StudentCoursesRepository;
import com.Data.Repositories.StudentsRepository;

@Component
public class CoursesmanagementService implements ICoursesManagementService {

	@Autowired
	private CoursesRepository repo;

	@Autowired
	private StudentCoursesRepository studentCoursesRepo;

	@Autowired
	private StudentsRepository studentsRepo;
	
	public CoursesmanagementService() { }
	
	@Override
	public void mapStudentToCourse(int studentId, int courseId) {
		Course course = repo.findById(courseId);

		Student student = studentsRepo.findById(studentId);

		var sc = new StudentCourse();
		sc.setCourse(course);
		sc.setStudent(student);
		sc.setId(new StudentCoursesCompositeKey(course.getId(), studentId));

		course.getStudents().add(sc);
		student.getCourses().add(sc);

		studentCoursesRepo.save(sc);
		
	}

	@Override
	public void removeStudentFromCourse(int studentId, int courseId) {

		Course course = repo.findById(courseId);

		var relationship = course.getStudents().stream().filter(x -> x.getStudent().getId() == studentId).findFirst();

		studentCoursesRepo.delete(relationship.get());
		
	}

}
