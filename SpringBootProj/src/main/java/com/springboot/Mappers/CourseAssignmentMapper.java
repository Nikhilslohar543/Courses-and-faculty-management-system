package com.springboot.Mappers;

import com.springboot.DTO.CourseAssignmentDTO;
import com.springboot.Entity.CourseAssignment;
import com.springboot.Entity.Courses;
import com.springboot.Entity.Faculty;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CourseAssignmentMapper {

    // ✅ Entity → DTO
    @Mapping(source = "facultyId.fId", target = "facultyId")
    @Mapping(source = "coursesId.cId", target = "coursesId")
    CourseAssignmentDTO toDTO(CourseAssignment entity);

    // ✅ DTO → Entity
    @Mapping(source = "facultyId", target = "facultyId", qualifiedByName = "mapFaculty")
    @Mapping(source = "coursesId", target = "coursesId", qualifiedByName = "mapCourse")
    CourseAssignment toEntity(CourseAssignmentDTO dto);

    // 🔥 Helper methods
    @Named("mapFaculty")
    default com.springboot.Entity.Faculty mapFaculty(int id) {
        com.springboot.Entity.Faculty f = new com.springboot.Entity.Faculty();
        f.setfId(id);   // ✅ correct field
        return f;
    }

    @Named("mapCourse")
    default com.springboot.Entity.Courses mapCourse(int id) {
        com.springboot.Entity.Courses c = new com.springboot.Entity.Courses();
        c.setcId(id);   // ✅ FIX HERE
        return c;
    }
}