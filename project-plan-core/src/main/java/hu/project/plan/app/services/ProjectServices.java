package hu.project.plan.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.project.plan.app.domain.Project;
import hu.project.plan.app.exceptions.ProjectIdException;
import hu.project.plan.app.repository.ProjectRepository;

@Service
public class ProjectServices {

	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdateProject(Project project) {
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectRepository.save(project);
		}catch (Exception e) {
			throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exsts");
		}
		
		
	}
}
