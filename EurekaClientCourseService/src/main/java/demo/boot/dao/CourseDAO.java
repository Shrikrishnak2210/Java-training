package demo.boot.dao;

import org.springframework.stereotype.Repository; 
import org.springframework.transaction.annotation.Transactional;

import demo.boot.model.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

import java.util.Optional;

@Repository
@Transactional
public class CourseDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Course> getAllCourses() {
        return entityManager.createQuery("SELECT c FROM Course c", Course.class).getResultList();
    }

    public Optional<Course> getCourseById(Long id) {
        return Optional.ofNullable(entityManager.find(Course.class, id));
    }

    public Course createCourse(Course course) {
        entityManager.persist(course);
        return course;
    }

    public Course updateCourse(Course course) {
        return entityManager.merge(course);
    }

    public void deleteCourse(Course course) {
        entityManager.remove(course);
    }
}
