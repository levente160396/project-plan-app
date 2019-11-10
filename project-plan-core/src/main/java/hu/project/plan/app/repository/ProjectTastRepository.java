package hu.project.plan.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hu.project.plan.app.domain.ProjectTask;

@Repository
public interface ProjectTastRepository extends CrudRepository<ProjectTask, Long>{

}
