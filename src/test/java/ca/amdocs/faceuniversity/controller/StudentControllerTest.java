package ca.amdocs.faceuniversity.controller;

import ca.amdocs.faceuniversity.dto.StudentAddRequestDTO;
import ca.amdocs.faceuniversity.model.Student;
import ca.amdocs.faceuniversity.model.UniversityGroup;
import ca.amdocs.faceuniversity.repository.GroupRepository;
import ca.amdocs.faceuniversity.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {


    UniversityGroup universityGroup;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ObjectMapper objectMapper;


    @BeforeEach
    void setUp() {

        universityGroup = UniversityGroup.builder()
                .name("English")
                .build();

        groupRepository.save(universityGroup);
    }


    @Autowired
    MockMvc mockMvc;

    @Test
    void add() throws Exception {
        StudentAddRequestDTO anton = StudentAddRequestDTO.builder()
                .groupId(universityGroup.getId())
                .name("ANTON")
                .build();

        String content = objectMapper.writeValueAsString(anton);

        mockMvc.perform(post("/student/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

        List<Student> allByGroupId = studentRepository.findAllByGroupId(universityGroup.getId());

        Assertions.assertEquals(1, allByGroupId.size());
    }

    @Test
    void delete() {
    }
}