package io.hly.ppmtool.web;


import io.hly.ppmtool.domain.Project;
import io.hly.ppmtool.services.MapValidationErrorService;
import io.hly.ppmtool.services.ProjectService;
import jakarta.validation.Valid;
import org.antlr.v4.runtime.misc.MultiMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
//used to map web requests to Spring Controller methods
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private MapValidationErrorService mapValidationErrorService;
    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if( errorMap != null) return errorMap ;

        Project newProject = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }
    @GetMapping("/{projectId}")
    public ResponseEntity<Project>getProjectById(@PathVariable String projectId){
        Project project = projectService.findByProjectIdentifier(projectId);
        return new ResponseEntity<Project>(project,HttpStatus.OK);
    }
}
