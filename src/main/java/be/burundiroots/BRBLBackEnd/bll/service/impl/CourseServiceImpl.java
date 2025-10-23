package be.burundiroots.BRBLBackEnd.bll.service.impl;

import be.burundiroots.BRBLBackEnd.bll.service.CourseService;
import be.burundiroots.BRBLBackEnd.dal.repositories.CourseRepository;
import be.burundiroots.BRBLBackEnd.dl.entities.Course;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CacheManager cacheManager;

    @Override
    @Cacheable(value = "courses", key = "#pageable.pageNumber + '-' + #pageable.pageSize + '-' + #pageable.sort")
    public Page<Course> findAllCourses(Pageable pageable){
        return courseRepository.findAll(pageable);
    }

    @Override
    @Cacheable(value = "course", key = "#id")
    public Course findCourseById(Long id){
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public Long save(Course course){
        Long id = courseRepository.save(course).getId();

        Objects.requireNonNull(cacheManager.getCache("courses")).clear();

        return id;
    }

    @Override
    public void update(Long id, Course course){

        Course existing = courseRepository.findById(id).orElseThrow();

        existing.setName(course.getName());
        existing.setDescription(course.getDescription());

        courseRepository.save(existing);

        Objects.requireNonNull(cacheManager.getCache("courses")).clear();
        Objects.requireNonNull(cacheManager.getCache("course")).clear();

    }

    @Override
    public void delete(Long id){

        if(!courseRepository.existsById(id)){
            throw new EntityNotFoundException("Course with id: " + id + " not found");
        }

        courseRepository.deleteById(id);

        Objects.requireNonNull(cacheManager.getCache("courses")).clear();
        Objects.requireNonNull(cacheManager.getCache("course")).evict(id);
    }
}
