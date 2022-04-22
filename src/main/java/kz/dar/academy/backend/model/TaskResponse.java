package kz.dar.academy.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskResponse {
    private String taskId;
    private String initiatorId;
    private String executorId;
    private String type;
    private String description;
}
