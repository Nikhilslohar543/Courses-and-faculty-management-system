package com.springboot.Mappers;

import com.springboot.DTO.CourseDTO;
import com.springboot.Entity.Courses;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    // ✅ Entity → DTO
    @Mappings({
            @Mapping(source = "courseAssignment", target = "courseAssignment")
    })
    CourseDTO toDTO(Courses course);


    // ✅ DTO → Entity
    @Mappings({
            @Mapping(source = "courseAssignment", target = "courseAssignment")
    })
    Courses toEntity(CourseDTO dto);


    // ✅ Update existing entity (IMPORTANT 🔥)
    @Mappings({
            @Mapping(source = "courseAssignment", target = "courseAssignment")
    })
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCourse(CourseDTO dto, @MappingTarget Courses course);
}