package ca.amdocs.faceuniversity.service;

import ca.amdocs.faceuniversity.dto.GetAllGroupResponseDTO;
import ca.amdocs.faceuniversity.dto.GroupAddRequestDTO;
import ca.amdocs.faceuniversity.dto.GroupResponseDTO;
import ca.amdocs.faceuniversity.dto.StudentResponseDTO;
import ca.amdocs.faceuniversity.model.UniversityGroup;
import ca.amdocs.faceuniversity.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public void add(GroupAddRequestDTO groupAddRequestDTO) {
        groupRepository.save(getGroupFromGroupAddRequestDTO(groupAddRequestDTO));
    }

    @Override
    public GroupResponseDTO get(Long id) {
        UniversityGroup universityGroup = groupRepository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException("Группы с таким ID - нет"));
        return getGroupResponseDTOFromUniversityGroup(universityGroup);
    }

    @Override
    public List<GetAllGroupResponseDTO> getAll() {
        return groupRepository.findAll().stream()
                .map(this::getAllGroupResponseDTOFromUniversityGroup)
                .collect(Collectors.toList());
    }


    private GetAllGroupResponseDTO getAllGroupResponseDTOFromUniversityGroup(UniversityGroup universityGroup) {
        return GetAllGroupResponseDTO.builder()
                .id(universityGroup.getId())
                .name(universityGroup.getName())
                .quantity(universityGroup.getStudents().size())
                .build();
    }

    private UniversityGroup getGroupFromGroupAddRequestDTO(GroupAddRequestDTO groupAddRequestDTO) {
        return UniversityGroup.builder()
                .name(groupAddRequestDTO.getName())
                .creatAt(LocalDate.now())
                .build();
    }


    private GroupResponseDTO getGroupResponseDTOFromUniversityGroup(UniversityGroup universityGroup) {

        List<StudentResponseDTO> collect = universityGroup.getStudents().stream()
                .map(student -> StudentResponseDTO.builder()
                        .id(student.getId())
                        .name(student.getName())
                        .build())
                .collect(Collectors.toList());

        return GroupResponseDTO.builder()
                .id(universityGroup.getId())
                .name(universityGroup.getName())
                .students(collect)
                .build();
    }


}
