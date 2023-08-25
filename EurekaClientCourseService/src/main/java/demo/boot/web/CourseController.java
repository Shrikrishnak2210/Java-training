package demo.boot.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import demo.boot.dao.CourseDAO;
import demo.boot.model.Course;

@RestController
@RequestMapping("/course")
public class CourseController {

	private final CourseDAO courseDAO;

	@Autowired
	public CourseController(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	@GetMapping
	public ResponseEntity<List<Course>> getAllCourses() {
		List<Course> courses = courseDAO.getAllCourses();
		return ResponseEntity.ok(courses);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
		Optional<Course> course = courseDAO.getCourseById(id);
		return course.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Course> createCourse(@RequestBody Course course) {
		Course createdCourse = courseDAO.createCourse(course);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdCourse);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {
		Optional<Course> existingCourseOptional = courseDAO.getCourseById(id);

		if (existingCourseOptional.isPresent()) {
			Course existingCourse = existingCourseOptional.get();
			existingCourse.setCategory(updatedCourse.getCategory());

			// Update the relationship, assuming updatedCourse has a valid category
			existingCourse.setCategory(updatedCourse.getCategory());

			Course updated = courseDAO.updateCourse(existingCourse);
			return ResponseEntity.ok(updated);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
		Optional<Course> course = courseDAO.getCourseById(id);

		if (course.isPresent()) {
			courseDAO.deleteCourse(course.get());
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
