package ca.amdocs.faceuniversity.service;

import ca.amdocs.faceuniversity.dto.GetAllGroupResponseDTO;
import ca.amdocs.faceuniversity.dto.GroupAddRequestDTO;
import ca.amdocs.faceuniversity.dto.GroupResponseDTO;

import java.util.List;

public interface GroupService {
    void add(GroupAddRequestDTO groupAddRequestDTO);

    GroupResponseDTO get(Long id);

    List<GetAllGroupResponseDTO> getAll();
}
