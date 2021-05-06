package ca.amdocs.faceuniversity.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private LocalDate createAt;

    @ManyToOne
    @JoinColumn(name = "group_id", foreignKey = @ForeignKey(name = "student_to_group"))
    private UniversityGroup group;
}
