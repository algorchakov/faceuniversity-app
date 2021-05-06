package ca.amdocs.faceuniversity.service;

import ca.amdocs.faceuniversity.dto.StudentAddRequestDTO;

public interface StudentService {
    void add(StudentAddRequestDTO studentAddRequestDTO);

    void delete(Long id);
}
