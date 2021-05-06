package ca.amdocs.faceuniversity.repository;

import ca.amdocs.faceuniversity.model.UniversityGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends CrudRepository<UniversityGroup, Long> {

    List<UniversityGroup> findAll();
}
