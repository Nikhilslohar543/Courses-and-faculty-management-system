package com.springboot.services;

import com.springboot.DTO.AttendanceDTO;

import java.util.List;

public interface AttendanceService {

    List<AttendanceDTO> getAttendance(int fId);

    AttendanceDTO getAttendanceById(int fId, int aId);

    AttendanceDTO addAttendance(int fId, AttendanceDTO attendanceDTO);

    AttendanceDTO updateAttendance(int fId, AttendanceDTO attendanceDTO);

    String deleteAttendance(int fId, int aId);
}