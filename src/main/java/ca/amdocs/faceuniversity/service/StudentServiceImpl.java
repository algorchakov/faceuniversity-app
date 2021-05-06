package ca.amdocs.faceuniversity.service;

import ca.amdocs.faceuniversity.dto.StudentAddRequestDTO;
import ca.amdocs.faceuniversity.model.Student;
import ca.amdocs.faceuniversity.model.UniversityGroup;
import ca.amdocs.faceuniversity.repository.GroupRepository;
import ca.amdocs.faceuniversity.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StudentServiceImpl implements StudentService {


    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;

    public StudentServiceImpl(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void add(StudentAddRequestDTO studentAddRequestDTO) {
        UniversityGroup universityGroup = groupRepository
                .findById(studentAddRequestDTO.getGroupId())
                .orElseThrow(() -> new IllegalStateException("Такой группы нет"));

        Student studentToDB = getStudentFromStudentAddRequestDTO(studentAddRequestDTO);
        studentToDB.setGroup(universityGroup);
        studentRepository.save(studentToDB);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    private Student getStudentFromStudentAddRequestDTO(StudentAddRequestDTO studentAddRequestDTO) {
        return Student.builder()
                .name(studentAddRequestDTO.getName())
                .createAt(LocalDate.now())
                .build();
    }
}
