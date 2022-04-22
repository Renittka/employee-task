package kz.dar.academy.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends ElasticsearchRepository<TaskEntity, String> {
    Page<TaskEntity> getTaskEntitiesByType(String type, Pageable pageable);

    TaskEntity getTaskEntityByTaskId(String taskId);

    TaskEntity deleteTaskEntityByTaskId(String taskId);

    Page<TaskEntity> getTaskEntitiesByInitiatorId(String initiatorId, Pageable pageable);

    Page<TaskEntity> getTaskEntitiesByExecutorId(String executorId, Pageable pageable);
}
