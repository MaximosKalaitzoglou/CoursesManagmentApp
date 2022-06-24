package com.Web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.Data.Student;
import com.Data.StudentCourse;
import com.Data.Repositories.StudentsRepository;
import com.Web.Models.StudentGradesModel;

@Controller
public class StudentsController {
	@Autowired
	private StudentsRepository repo;

	// Home Page
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public String index(Model model) {
		Iterable<Student> students = repo.findAll();
		model.addAttribute("students", students);
		return "students/index.html";
	}

	@RequestMapping(value = "/students/create", method = RequestMethod.GET)
	public String createCourse(Model model) {
		model.addAttribute("student", new Student());
		return "students/create.html";
	}

	@RequestMapping(value = "/students/create", method = RequestMethod.POST)
	public RedirectView createCourse(@ModelAttribute Student studentRequest, BindingResult errors, Model model) {

		repo.save(studentRequest);

		return new RedirectView("/students/create");
	}

	@RequestMapping(value = "/students/edit/{id}", method = RequestMethod.GET)
	public String editStudent(@PathVariable(value = "id") int id, Model model) {

		model.addAttribute("student", repo.findById(id));

		return "students/edit.html";
	}

	@RequestMapping(value = "/students/edit/{id}", method = RequestMethod.POST)
	public RedirectView editStudent(@PathVariable(value = "id") int id, @ModelAttribute Student studentRequest,
			BindingResult errors, Model model) {
		repo.save(studentRequest);
		return new RedirectView("/students/edit/" + id);
	}

	@RequestMapping(value = "/students/{id}/courses", method = RequestMethod.GET)
	public String createCourse(@PathVariable(value = "id") int id, Model model) {
		Student student = repo.findById(id);
		Iterable<StudentCourse> courses = student.getCourses();
		model.addAttribute("student", student);
		model.addAttribute("courses", courses);
		model.addAttribute("sid", id);
		return "students/courses.html";
	}

	@RequestMapping(value = "/students/{sid}/grades/{cid}", method = RequestMethod.GET)
	public String createGrades(@PathVariable(value = "sid") int sid, @PathVariable(value = "cid") int cid,
			Model model) {
		Student student = repo.findById(sid);
		Optional<StudentCourse> course = student.getCourses().stream().filter(x -> x.getCourse().getId() == cid)
				.findFirst();

		StudentGradesModel grades = new StudentGradesModel();
		grades.setFinal_grade(course.get().getGrade());
		grades.setProject_grade(course.get().getProject_grade());

		model.addAttribute("student", student);
		model.addAttribute("course", course.get());
		model.addAttribute("sid", sid);
		model.addAttribute("cid", cid);
		model.addAttribute("grades", grades);

		return "students/courses_grades.html";
	}

	@RequestMapping(value = "/students/{sid}/grades/{cid}", method = RequestMethod.POST)
	public RedirectView createGrades(@PathVariable(value = "sid") int sid, @PathVariable(value = "cid") int cid,
			@ModelAttribute StudentGradesModel studentGradesRequest, BindingResult errors, Model model) {
		Student student = repo.findById(sid);
		Optional<StudentCourse> _course = student.getCourses().stream().filter(x -> x.getCourse().getId() == cid)
				.findFirst();
		StudentCourse course = _course.get();
		course.setGrade(studentGradesRequest.getFinal_grade());
		course.setProject_grade(studentGradesRequest.getProject_grade());

		repo.save(student);

		return new RedirectView("/students/" + sid + "/courses/");
	}

	@RequestMapping(value = "/students/delete/{id}", method = RequestMethod.POST)
	public RedirectView delete(@PathVariable(value = "id") int id, Model model) {
		repo.deleteById(id);

		return new RedirectView("/students/");

	}
}
