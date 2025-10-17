package be.burundiroots.BRBLBackEnd.bll.service.impl;

import be.burundiroots.BRBLBackEnd.bll.service.CourseService;
import be.burundiroots.BRBLBackEnd.dal.repositories.CourseRepository;
import jakarta.persistence.Cacheable;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CacheManager cacheManager;

    @Override
    @Cacheable(value = "course", key = "#pageable.pageNumber + '-' + #pageable.pageSize + '-' + #pageable.sort")
}
