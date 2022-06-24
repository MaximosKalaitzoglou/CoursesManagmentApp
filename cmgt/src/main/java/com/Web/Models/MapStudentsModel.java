package com.Web.Models;

import java.util.ArrayList;
import java.util.List;

public class MapStudentsModel {
	public MapStudentsModel() {
		super();

	}
	public MapStudentsModel(Integer courseId) {
		super();
		this.courseId = courseId;
	}
	private List<Integer> studentIds = new ArrayList<Integer>();
	private Integer courseId;
	public List<Integer> getStudentIds() {
		return studentIds;
	}
	public void setStudentIds(List<Integer> studentIds) {
		this.studentIds = studentIds;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	
}