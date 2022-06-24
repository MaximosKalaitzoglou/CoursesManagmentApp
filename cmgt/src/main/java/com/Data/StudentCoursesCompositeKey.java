package com.Data;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StudentCoursesCompositeKey implements Serializable {

	public StudentCoursesCompositeKey() {
		super();
	}

	public StudentCoursesCompositeKey(int courseId, int studentId) {
		super();
		this.courseId = courseId;
		this.studentId = studentId;
	}

	@Column(name = "course_id")
	private int courseId;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Column(name = "student_id")
	private int studentId;

	@Override
	public int hashCode() {
		return Objects.hash(courseId, studentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentCoursesCompositeKey other = (StudentCoursesCompositeKey) obj;
		return courseId == other.courseId && studentId == other.studentId;
	}
}
