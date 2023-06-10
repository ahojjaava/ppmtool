package io.hly.ppmtool.services;

import io.hly.ppmtool.domain.Project;
import io.hly.ppmtool.exceptions.ProjectIdException;
import io.hly.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        //Logic: filter the existed project entries out and catch the exception
        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch(Exception e){
            throw new ProjectIdException("Project ID " + project.getProjectIdentifier().toUpperCase() + " already exists.");
        }

    }

    public Project findByProjectIdentifier (String projectIdentifier){
         Project project = projectRepository.findByProjectIdentifier(projectIdentifier.toUpperCase());

         if(project == null){
             throw new ProjectIdException("Project ID does not exist.");
         }

        return project;

    }
}
