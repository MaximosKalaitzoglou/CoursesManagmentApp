package com.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "student_courses")
public class StudentCourse {
	@EmbeddedId
	StudentCoursesCompositeKey id;

	@ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    Student student;

	@ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    Course course;
    
	private double grade;
	
	private double project_grade;

	@DateTimeFormat(pattern = "yyyy")
	private Date enrolledTime;

	public StudentCoursesCompositeKey getId() {
		return id;
	}
	public void setId(StudentCoursesCompositeKey id) {
		this.id = id;
	}
    public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}	
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public Date getEnrolledTime() {
		return enrolledTime;
	}
	public void setEnrolledTime(Date enrolledTime) {
		this.enrolledTime = enrolledTime;
	}
	public double getProject_grade() {
		return project_grade;
	}
	public void setProject_grade(double project_grade) {
		this.project_grade = project_grade;
	}
}
