package com.Web;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.Data.Repositories.StudentCoursesRepository;
import com.Web.Models.CourseStatsModel;

@Controller
public class StudentGradesStatsController {
	@Autowired
	private StudentCoursesRepository repo;

	// Home Page
	@RequestMapping(value = "/stats/course/{id}", method = RequestMethod.GET)
	public String index(@PathVariable(value = "id") int id, Model model) {
		model.addAttribute("courseId", id);
		model.addAttribute("courseStats", getStatsForCourse(id));

		return "stats/index.html";
	}

	private CourseStatsModel getStatsForCourse(int courseId) {
		Stream<Double> grades = repo.findAll().stream().filter(c -> c.getCourse().getId() == courseId).map(f -> f.getGrade());

		DescriptiveStatistics ds = new DescriptiveStatistics();
		grades.forEach(ds::addValue);

		CourseStatsModel m = new CourseStatsModel();
		
		m.setWeightedAverage(ds.getMean());
		m.setMin(ds.getMin());
		m.setMax(ds.getMax());
		m.setMean(ds.getMean());
		m.setStdDeviation(ds.getStandardDeviation());
		m.setVariance(ds.getVariance());
		m.setPercentiles(ds.getPercentile(100));
		m.setSkewness(ds.getSkewness());
		m.setKurtosis(ds.getKurtosis());
		m.setMedian(ds.getPercentile(50));

		return m;
	}
}
