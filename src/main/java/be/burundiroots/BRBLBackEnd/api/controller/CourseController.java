package be.burundiroots.BRBLBackEnd.api.controller..controller;


import be.burundiroots.BRBLBackEnd.api.models.course.CourseForm;
import be.burundiroots.BRBLBackEnd.api.models.course.CourseIndexDto;
import be.burundiroots.BRBLBackEnd.dal.repositories.CourseRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/course")
@CrossOrigin("*")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseIndexDto>> getAllCourses(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "name") String sort
    ){

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));

        List<CourseIndexDto> courseIndexDtos = courseRepository.findAll(pageable)
                .getContent()
                .stream().map(CourseIndexDto::fromEntity)
                .toList();

        return ResponseEntity.ok(courseIndexDtos);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseIndexDto> getCourseById(@PathVariable Long id){
        CourseIndexDto course = CourseIndexDto.fromEntity(courseRepository.findById(id).get());
        return ResponseEntity.ok(course);
    }

    @PostMapping
    public ResponseEntity<Void> createCourse(
            @Valid @ResquestBody CourseForm courseForm
    ){
       Long id = courseService.
    }

}
