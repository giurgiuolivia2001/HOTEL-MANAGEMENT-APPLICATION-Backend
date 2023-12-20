package ro.fortech.project.controllers;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.fortech.project.entities.NotificationCleaning;
import ro.fortech.project.payload.request.AssignCleanerRequest;
import ro.fortech.project.payload.response.MessageResponse;
import ro.fortech.project.services.CleaningService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cleaning")
@PreAuthorize("hasRole('CLEANING')")
public class CleanerController {


    @Autowired
    private CleaningService cleaningService;

    @Operation(summary = "Assign a task", description = "Assign a task to a cleaner")
    @PostMapping("/assign")
    public ResponseEntity<MessageResponse> assignTask(@RequestBody AssignCleanerRequest assignCleanerRequest) {
        cleaningService.markInProgress(assignCleanerRequest.getId(), assignCleanerRequest.getAssignedTo());
        return ResponseEntity.ok(new MessageResponse("Task has now an assigned person"));

    }

    @Operation(summary = "Mark a task as done", description = "Mark a task as done")
    @PutMapping("/markAsDone/{id}")
    public ResponseEntity<MessageResponse> markAsDone(@PathVariable Long id) {
        cleaningService.markDoneNotification(id);
        return ResponseEntity.ok(new MessageResponse("Task marked done successfully"));

    }

    @Operation(summary = "Get all tasks", description = "Get all tasks")
    @GetMapping("/getTasks")
    public List<NotificationCleaning> getCleaningNotifications() {
        return cleaningService.getCleaningNotifications();
    }
}
