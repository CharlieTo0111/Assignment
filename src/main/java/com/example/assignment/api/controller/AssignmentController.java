
package com.example.assignment.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.assignment.api.model.AssignmentInput;
import com.example.assignment.service.AssignmentService;
import com.example.assignment.api.model.AssignmentOutput;


@RestController
@RequestMapping("/api/assignment")
public class AssignmentController {

    private AssignmentService assignmentService;

    @Autowired
    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping("/process")
    public AssignmentOutput clean(@RequestBody AssignmentInput input) {
        return AssignmentService.processCoords(input);
    }
}
