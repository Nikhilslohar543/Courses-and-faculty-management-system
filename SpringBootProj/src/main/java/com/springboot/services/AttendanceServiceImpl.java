package com.springboot.services;

import java.util.List;
import java.util.stream.Collectors;

import com.springboot.DTO.AttendanceDTO;
import com.springboot.Entity.Attendance;
import com.springboot.Entity.Faculty;
import com.springboot.Mappers.AttendanceMapper;
import com.springboot.Repository.AttendanceDao;
import com.springboot.Repository.FacultyDao;
import com.springboot.Responses.CFMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceDao aDao;

    @Autowired
    private FacultyDao fDao;

    @Autowired
    private AttendanceMapper attendanceMapper;

    @Override
    public List<AttendanceDTO> getAttendance(int fId) {

        Faculty faculty = fDao.findById(fId)
                .orElseThrow(() -> new CFMSException("Faculty not found!", HttpStatus.NOT_FOUND));

        List<Attendance> list = aDao.findByFacultyId_fId(fId);

        return list.stream()
                .map(attendanceMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AttendanceDTO getAttendanceById(int fId, int aId) {

        fDao.findById(fId)
                .orElseThrow(() -> new CFMSException("Faculty not found!", HttpStatus.NOT_FOUND));

        Attendance attendance = aDao.findById(aId)
                .orElseThrow(() -> new CFMSException("Attendance not found!", HttpStatus.NOT_FOUND));

        return attendanceMapper.toDTO(attendance);
    }

    @Override
    public AttendanceDTO addAttendance(int fId, AttendanceDTO dto) {

        Faculty faculty = fDao.findById(fId)
                .orElseThrow(() -> new CFMSException("Faculty not found!", HttpStatus.NOT_FOUND));

        Attendance attendance = attendanceMapper.toEntity(dto);
        attendance.setFacultyId(faculty);

        Attendance saved = aDao.save(attendance);

        return attendanceMapper.toDTO(saved);
    }

    @Override
    public AttendanceDTO updateAttendance(int fId, AttendanceDTO dto) {

        Faculty faculty = fDao.findById(fId)
                .orElseThrow(() -> new CFMSException("Faculty not found!", HttpStatus.NOT_FOUND));

        Attendance existing = aDao.findById(dto.getAId())
                .orElseThrow(() -> new CFMSException("Attendance not found!", HttpStatus.NOT_FOUND));

        attendanceMapper.updateAttendance(dto, existing);
        existing.setFacultyId(faculty);

        Attendance updated = aDao.save(existing);

        return attendanceMapper.toDTO(updated);
    }

    @Override
    public String deleteAttendance(int fId, int aId) {

        fDao.findById(fId)
                .orElseThrow(() -> new CFMSException("Faculty not found!", HttpStatus.NOT_FOUND));

        Attendance attendance = aDao.findById(aId)
                .orElseThrow(() -> new CFMSException("Attendance not found!", HttpStatus.NOT_FOUND));

        aDao.delete(attendance);

        return "Attendance deleted successfully";
    }
}