package com.springboot.Mappers;

import com.springboot.DTO.AttendanceDTO;
import com.springboot.Entity.Attendance;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AttendanceMapper {

    @Mapping(source = "facultyId.fId", target = "facultyId")
    AttendanceDTO toDTO(Attendance entity);

    @Mapping(source = "facultyId", target = "facultyId.fId")
    Attendance toEntity(AttendanceDTO dto);

    @Mapping(target = "facultyId", ignore = true)
    void updateAttendance(AttendanceDTO dto, @MappingTarget Attendance attendance);
}