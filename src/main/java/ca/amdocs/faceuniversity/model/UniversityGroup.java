package ca.amdocs.faceuniversity.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UniversityGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private LocalDate creatAt;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    List<Student> students;
}
