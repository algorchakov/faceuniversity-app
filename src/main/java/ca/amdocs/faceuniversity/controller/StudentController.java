package ca.amdocs.faceuniversity.controller;


import ca.amdocs.faceuniversity.dto.StudentAddRequestDTO;
import ca.amdocs.faceuniversity.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping(path = "/add")
    public void add(@RequestBody StudentAddRequestDTO studentAddRequestDTO) {
        studentService.add(studentAddRequestDTO);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }




}
