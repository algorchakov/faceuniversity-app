package ca.amdocs.faceuniversity.controller;


import ca.amdocs.faceuniversity.dto.GetAllGroupResponseDTO;
import ca.amdocs.faceuniversity.dto.GroupAddRequestDTO;
import ca.amdocs.faceuniversity.dto.GroupResponseDTO;
import ca.amdocs.faceuniversity.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/group")
public class GroupController {


    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }


    @PostMapping(path = "/add")
    public void add(@RequestBody GroupAddRequestDTO groupAddRequestDTO) {
        groupService.add(groupAddRequestDTO);
    }


    @GetMapping(path = "/get/{id}")
    public GroupResponseDTO getGroup(@PathVariable Long id) {
        return groupService.get(id);
    }

    @GetMapping(path = "/getAll")
    public List<GetAllGroupResponseDTO> getAll() {
        return groupService.getAll();
    }
}
