package com.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.Data.Course;
import com.Data.Student;
import com.Data.StudentCourse;
import com.Data.Repositories.CoursesRepository;
import com.Data.Repositories.StudentsRepository;
import com.Web.Models.MapStudentsModel;
import com.myy803.business.ICoursesManagementService;

@Controller
public class CoursesController {
	@Autowired
	private CoursesRepository repo;

	@Autowired
	private StudentsRepository studentsRepo;

	@Autowired
	private ICoursesManagementService coursesManagement;

	// Home Page
	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public String index(Model model) {
		Iterable<Course> courses = repo.findAll();
		model.addAttribute("courses", courses);
		return "courses/index.html";
	}

	@RequestMapping(value = "/courses/create", method = RequestMethod.GET)
	public String createCourse(Model model) {
		model.addAttribute("course", new Course());
		return "courses/create.html";
	}

	@RequestMapping(value = "/courses/create", method = RequestMethod.POST)
	public Course createCourse(@ModelAttribute Course courseRequest, BindingResult errors, Model model) {
		return repo.save(courseRequest);
	}

	@RequestMapping(value = "/courses/edit/{id}", method = RequestMethod.GET)
	public String editCourse(@PathVariable(value = "id") int id, Model model) {
		model.addAttribute("course", repo.findById(id));
		return "courses/edit.html";
	}

	@RequestMapping(value = "/courses/edit/{id}", method = RequestMethod.POST)
	public String editCourse(@PathVariable(value = "id") int id, @ModelAttribute Course courseRequest,
			BindingResult errors, Model model) {
		repo.save(courseRequest);
		model.addAttribute("course", courseRequest);

		return "courses/edit.html";
	}

	@RequestMapping(value = "/courses/{id}/students", method = RequestMethod.GET)
	public String createCourse(@PathVariable(value = "id") int id, Model model) {
		Course course = repo.findById(id);
		Iterable<StudentCourse> students = course.getStudents();
		model.addAttribute("students", students);
		model.addAttribute("course", course);
		model.addAttribute("cid", id);
		return "courses/students.html";
	}

	@RequestMapping(value = "/courses/{id}/mapStudents", method = RequestMethod.GET)
	public String mapStudents(@PathVariable(value = "id") int id, Model model) {
		Course course = repo.findById(id);
		Iterable<Student> students = studentsRepo.findAll();
		model.addAttribute("students", students);
		model.addAttribute("course", course);
		model.addAttribute("cid", id);
		model.addAttribute("mapRequest", new MapStudentsModel(id));

		return "courses/mapStudents.html";
	}

	@RequestMapping(value = "/courses/mapStudents", method = RequestMethod.POST)
	public RedirectView mapStudents(@ModelAttribute MapStudentsModel mapRequest, BindingResult errors, Model model) {

		for (int sid : mapRequest.getStudentIds()) {
			coursesManagement.mapStudentToCourse(sid, mapRequest.getCourseId());
		}

		return new RedirectView("/courses/" + mapRequest.getCourseId() + "/students");
	}

	@RequestMapping(value = "/courses/{id}/removeStudent/{sid}", method = RequestMethod.POST)
	public RedirectView mapStudents(@PathVariable(value = "id") int id, @PathVariable(value = "sid") int sid,
			Model model) {

		coursesManagement.removeStudentFromCourse(sid, id);

		return new RedirectView("/courses/" + id + "/students");

	}

	@RequestMapping(value = "/courses/delete/{id}", method = RequestMethod.POST)
	public RedirectView delete(@PathVariable(value = "id") int id, Model model) {
		repo.deleteById(id);

		return new RedirectView("/courses/");

	}
}
