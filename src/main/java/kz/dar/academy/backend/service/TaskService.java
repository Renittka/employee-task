package kz.dar.academy.backend.service;

import kz.dar.academy.backend.model.TaskRequest;
import kz.dar.academy.backend.model.TaskResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {
    TaskResponse createTask(TaskRequest taskRequest);

    TaskResponse updateTask(TaskRequest taskRequest);

    Page<TaskResponse> getAllTasksByExecutorId(String executorId, Pageable pageable);

    Page<TaskResponse> getAllTasksByInitiatorId(String initiatorId, Pageable pageable);

    TaskResponse getTaskById(String taskId);

    void deleteTaskById(String taskId);
}
