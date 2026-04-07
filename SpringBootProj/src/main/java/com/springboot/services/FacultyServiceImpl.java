package com.springboot.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.springboot.Common.CustomQuerySpecification;
import com.springboot.DTO.FacultyDTO;
import com.springboot.Mappers.FacultyMapper;
import com.springboot.Responses.CFMSException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.Repository.CourseAssignmentDao;
import com.springboot.Repository.CoursesDao;
import com.springboot.Repository.FacultyDao;
import com.springboot.Entity.CourseAssignment;
import com.springboot.Entity.Courses;
import com.springboot.Entity.Faculty;

import jakarta.servlet.http.HttpSession;

@Service
public class FacultyServiceImpl implements FacultyService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private FacultyDao fDao;

    @Autowired
    private CoursesDao cDao;

    @Autowired
    private CourseAssignmentDao caDao;

    @Autowired
    private FacultyMapper facultyMapper;

    public Map<String, Object> getAllFaculties(Map<String, Object> filter) {

        CustomQuerySpecification<Faculty> specification = CustomQuerySpecification.getInstance(filter);
        List<Faculty> facultyList = fDao.findAll(specification);

        List<FacultyDTO> list = facultyList.stream()
                .map(f -> facultyMapper.toDTO(f)).collect(Collectors.toList());

        Map<String, Object> data = new HashMap<>();
        data.put("data", list);
        return data;

    }

    public FacultyDTO getFacultyById(int fId) {
        Faculty exist = fDao.findById(fId).orElseThrow(() -> new CFMSException("Faculty not found!", HttpStatus.NOT_FOUND));

        FacultyDTO dto = facultyMapper.toDTO(exist);

        return dto;
    }

    public FacultyDTO getFacultyByUsername(String fUsername) {

        Faculty faculty = fDao.findByfUsername(fUsername)
                .orElseThrow(() -> new CFMSException("Faculty not found", HttpStatus.NOT_FOUND));
        FacultyDTO dto = facultyMapper.toDTO(faculty);

        return dto;
    }

    public FacultyDTO addFaculty(Faculty faculty) {

        Faculty exist;

        if (faculty.getfUsername() != null) {
            exist = fDao.findByfUsername(faculty.getfUsername())
                    .orElseThrow(() -> new CFMSException("Faculty with same name exists!", HttpStatus.FOUND));
        }

        Faculty savedFaculty = fDao.save(faculty);
        FacultyDTO savedFacultyDTO = facultyMapper.toDTO(savedFaculty);

        return savedFacultyDTO;
    }

    public FacultyDTO updateFaculty(int fId, Faculty faculty) {

        Faculty existing = fDao.findById(fId)
                .orElseThrow(() -> new CFMSException("Faculty not found", HttpStatus.NOT_FOUND));

        Faculty facultyWithSameUsername = fDao.findByfUsername(faculty.getfUsername())
                .orElseThrow(() -> new CFMSException("Username already taken!", HttpStatus.FOUND));

        existing.setfId(faculty.getfId());
        existing.setfName(faculty.getfName());
        existing.setfEmail(faculty.getfEmail());
        existing.setfRole(faculty.getfRole());
        existing.setGender(faculty.getGender());
        existing.setMobno(faculty.getMobno());
        existing.setfUsername(faculty.getfUsername());
        existing.setfPassword(faculty.getfPassword());
        existing.setStatus(faculty.getStatus());

        Faculty updatedFaculty = fDao.save(faculty);
        FacultyDTO updatedFacultyDTO = facultyMapper.toDTO(updatedFaculty);

        return updatedFacultyDTO;

    }

    public String deleteFaculty(int fId) {

        Faculty exist = fDao.findById(fId)
                .orElseThrow(() -> new CFMSException("Faculty not found", HttpStatus.NOT_FOUND));

        fDao.delete(exist);

        return "Faculty deleted successfully";
    }

    public String assignCourseToFaculty(int fIds[], int cId) {

        Courses course = cDao.findById(cId)
                .orElseThrow(() -> new CFMSException("Course not found", HttpStatus.NOT_FOUND));

        for (int fId : fIds) {
            Optional<Faculty> fexist = fDao.findById(fId);

            if (fexist.isPresent()) {
                Faculty faculty = fexist.get();

                if (caDao.existsByCoursesIdAndFacultyId(course, faculty)) {
                    System.out.println("Course already assigned to faculty with ID: " + fId);
                    continue;
                } else {
                    CourseAssignment assign = new CourseAssignment();
                    assign.setCoursesId(course);
                    assign.setFacultyId(faculty);
                    caDao.save(assign);
                }
            } else {
                throw new CFMSException("Faculty with ID " + fexist.get().getfId() + " does not exists!");
            }
        }
        return "Course assigned to selected faculties (excluding already assigned ones).";

    }

    public String unassignCourses(int fId, int cId) {

        Optional<Courses> cexist = cDao.findById(cId);
        Optional<Faculty> fexist = fDao.findById(fId);

        if (cexist.isPresent() && fexist.isPresent()) {
            Courses course = cexist.get();
            Faculty faculty = fexist.get();

            Optional<CourseAssignment> caexist = caDao.getByCoursesIdAndFacultyId(course, faculty);

            if (caexist.isPresent()) {
                CourseAssignment unassign = caexist.get();

                caDao.delete(unassign);

                return "Course has been unassigned from faculty.";

            } else {
                throw new CFMSException("Course is not assigned to spcified faculty!", HttpStatus.PRECONDITION_FAILED);
            }

        } else {
            throw new CFMSException("Either the course or the faculty does not exist.", HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<?> signup(Faculty faculty) {

        if (faculty != null) {

            if (fDao.findByfUsername(faculty.getfUsername()) == null) {

                fDao.save(faculty);
                return ResponseEntity.ok("Registered with " + faculty.getfUsername() + " username.");

            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Username already exists!");
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid credentials!");
        }
    }

    public ResponseEntity<?> signin(Faculty faculty, HttpSession session) {

        Faculty existing = fDao.findByfUsername(faculty.getfUsername())
                .orElseThrow(() -> new CFMSException("Faculty not found!", HttpStatus.NOT_FOUND));

        if (existing != null && existing.getfUsername().equals(faculty.getfUsername())
                && existing.getfPassword().equals(faculty.getfPassword())) {

            session.setAttribute("fId", existing.getfId());

            return ResponseEntity
                    .ok(new Faculty(existing.getfId(), existing.getfName(), existing.getfEmail(), existing.getfRole(),
                            existing.getfUsername(), existing.getMobno(), existing.getStatus(), existing.getGender(),
                            existing.getfPassword(), existing.getCourseAssignment(), existing.getAttendance()));

        } else {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found!");

        }

    }

}
