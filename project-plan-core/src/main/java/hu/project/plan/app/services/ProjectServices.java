package hu.project.plan.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.project.plan.app.domain.Backlog;
import hu.project.plan.app.domain.Project;
import hu.project.plan.app.exceptions.ProjectIdException;
import hu.project.plan.app.repository.BacklogRepository;
import hu.project.plan.app.repository.ProjectRepository;

@Service
public class ProjectServices {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	BacklogRepository backlogRepository;
	
	
	public Project saveOrUpdateProject(Project project) {
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			
			if(project.getId() == null) {
				Backlog backlog = new Backlog();
				project.setBacklog(backlog);
				backlog.setProject(project);
				backlog.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			}
			if(project.getId() != null) {
				project.setBacklog(backlogRepository.findByProjectIdentifier(project.getProjectIdentifier().toUpperCase()));
			}
			
			return projectRepository.save(project);
		}catch (Exception e) {
			throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exsts");
		}
	}
	
	public Project findByProjectIdentifier(String projectId) {
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		
		if(project == null) {
			throw new ProjectIdException("Project ID '" + projectId.toUpperCase() + "' doed not exist");

		}
		
		return project;
	}
	
	public Iterable<Project> findAllProject(){
		
		return projectRepository.findAll();
	}
	
	public void deleteProjectByIdentifiere(String projectId) {
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		
		if(project == null) {
			throw new ProjectIdException("Cannot Project with Id '" + projectId.toUpperCase() + "'. This project does not exist.");
		}
		
		projectRepository.delete(project);
	}
	
}
