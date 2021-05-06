package ca.amdocs.faceuniversity.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupResponseDTO {
    Long id;
    String name;
    List<StudentResponseDTO> students;
}
