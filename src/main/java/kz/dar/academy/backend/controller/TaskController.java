package kz.dar.academy.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.dar.academy.backend.model.TaskRequest;
import kz.dar.academy.backend.model.TaskResponse;
import kz.dar.academy.backend.service.message.SendService;
import kz.dar.academy.backend.service.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private SendService sendService;

    ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping
    public TaskResponse createTask(@RequestBody TaskRequest taskRequest) throws JsonProcessingException {
        TaskResponse taskResponse = taskService.createTask(taskRequest);
        sendService.send(objectMapper.writeValueAsString(taskResponse));
        return taskResponse;
    }

    @PutMapping
    public TaskResponse updateTask(@RequestParam String taskId, @RequestBody TaskRequest taskRequest) {
        taskRequest.setTaskId(taskId);
        return taskService.updateTask(taskRequest);
    }

    @GetMapping
    public TaskResponse getTaskById(@RequestParam String taskId) {
        return taskService.getTaskById(taskId);
    }

    @GetMapping("/initiator")
    public Page<TaskResponse> getAllTasksByInitiator(@RequestParam String initiatorId, Pageable pageable) {
        return taskService.getAllTasksByInitiatorId(initiatorId, pageable);
    }

    @GetMapping("/executor")
    public Page<TaskResponse> getAllTasksByExecutor(@RequestParam String executorId, Pageable pageable) {
        return taskService.getAllTasksByExecutorId(executorId, pageable);
    }

    @DeleteMapping
    public void deleteTask(@RequestParam String taskId) {
        taskService.deleteTaskById(taskId);
    }
}
