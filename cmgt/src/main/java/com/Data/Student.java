package com.Data;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String surname;

	private int semester;

	@DateTimeFormat(pattern = "yyyy")
	private Date yearOfEnrollment;

	@OneToMany(mappedBy = "student")
	private Set<StudentCourse> courses;

	public Set<StudentCourse> getCourses() {
		return courses;
	}

	public void setCourses(Set<StudentCourse> courses) {
		this.courses = courses;
	}

	public void addCourse(StudentCourse course) {
		this.courses.add(course);
	}

	public void remoceCourse(StudentCourse course) {
		this.courses.remove(course);
	}

	public void setYearOfEnrollment(Date yearOfEnrollment) {
		this.yearOfEnrollment = yearOfEnrollment;
	}

	public int getId() {

		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getYearOfEnrollment() {
		return this.yearOfEnrollment;
	}

	public int getSemester() {
		return this.semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

}
