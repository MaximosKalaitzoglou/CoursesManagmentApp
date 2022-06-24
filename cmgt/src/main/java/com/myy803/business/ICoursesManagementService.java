package com.myy803.business;

public interface ICoursesManagementService {
	void mapStudentToCourse(int studentId, int courseId);
	void removeStudentFromCourse(int studentId, int courseId);
}
