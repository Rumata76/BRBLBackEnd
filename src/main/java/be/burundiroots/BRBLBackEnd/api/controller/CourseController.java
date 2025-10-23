package be.burundiroots.BRBLBackEnd.api.controller;


import be.burundiroots.BRBLBackEnd.api.models.course.CourseForm;
import be.burundiroots.BRBLBackEnd.api.models.course.CourseIndexDto;
import be.burundiroots.BRBLBackEnd.bll.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;


import java.net.URI;
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

        List<CourseIndexDto> courseIndexDtos = courseService.findAllCourses(pageable)
                .getContent()
                .stream().map(CourseIndexDto::fromEntity)
                .toList();

        return ResponseEntity.ok(courseIndexDtos);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseIndexDto> getCourseById(@PathVariable Long id){
        CourseIndexDto course = CourseIndexDto.fromEntity(courseService.findCourseById(id));
        return ResponseEntity.ok(course);
    }

    @PostMapping
    public ResponseEntity<Void> createCourse(
            @Valid @RequestBody CourseForm courseForm
    ){
       Long id = courseService.save(courseForm.ToEntity());

       UriBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}");

       URI uri = builder.build(id);

       return ResponseEntity.created(uri).build();
    }

    @PreAuthorize("hasAuthority('COURSE_WRITE')")
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCourse(
            @PathVariable Long id,
            @Valid @RequestBody CourseForm courseForm
    ){
        courseService.update(id, courseForm.ToEntity());
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAuthority('COURSE_DELETE')")
    @DeleteMapping
    public ResponseEntity<Void> deleteCourse(
        @PathVariable Long id
    ){
        courseService.delete(id);
        return ResponseEntity.accepted().build();
    }

}
