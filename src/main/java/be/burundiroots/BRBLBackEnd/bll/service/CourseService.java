package be.burundiroots.BRBLBackEnd.bll.service;

import be.burundiroots.BRBLBackEnd.dl.entities.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {

    Page<Course> findAllCourse(Pageable pageable);
    Course findCourseById(Long id);
    Long save(Course course);
    void update(Long id, Course course);
    void delete(Course course);
}
