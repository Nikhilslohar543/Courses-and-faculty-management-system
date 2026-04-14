package com.springboot.Mappers;

import com.springboot.DTO.FacultyDTO;
import com.springboot.Entity.Faculty;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        uses = {CourseAssignmentMapper.class, AttendanceMapper.class}
)
public interface FacultyMapper {

    // ✅ Entity → DTO
    @Mapping(source = "gender", target = "FGender")
    @Mapping(source = "mobno", target = "mobNo")
    @Mapping(source = "courseAssignment", target = "courseAssignments")
    @Mapping(source = "attendance", target = "attendanceDTOS")
    FacultyDTO toDTO(Faculty faculty);


    // ✅ DTO → Entity
    @Mappings({
            @Mapping(source = "FGender", target = "gender"),
            @Mapping(source = "mobNo", target = "mobno"),
            @Mapping(source = "courseAssignments", target = "courseAssignment"),
            @Mapping(source = "attendanceDTOS", target = "attendance")
    })
    Faculty toEntity(FacultyDTO dto);


    // ✅ Update existing entity (VERY IMPORTANT)
    @Mappings({
            @Mapping(source = "FGender", target = "gender"),
            @Mapping(source = "mobNo", target = "mobno"),
            @Mapping(source = "courseAssignments", target = "courseAssignment"),
            @Mapping(source = "attendanceDTOS", target = "attendance")
    })
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFaculty(FacultyDTO dto, @MappingTarget Faculty faculty);
}
