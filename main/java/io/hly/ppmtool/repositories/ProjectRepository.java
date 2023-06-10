package io.hly.ppmtool.repositories;

import io.hly.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {
   // @Override
    //Iterable<Project> findAllById(Iterable<Long> longs);
    Project findByProjectIdentifier (String projectIdentifier);



}
