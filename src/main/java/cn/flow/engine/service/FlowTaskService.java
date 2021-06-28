package cn.flow.engine.service;

import cn.flow.engine.model.FlowTask;
import cn.flow.engine.repository.FlowTaskRepository;
import lombok.RequiredArgsConstructor;
import cn.flow.engine.exception.FlowTaskNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowTaskService {
    private final FlowTaskRepository flowTaskRepository;

    public void saveFlowTask(FlowTask flowTask) {
        flowTaskRepository.save(flowTask);
    }

    public FlowTask getFlowTaskById(String flowTaskId) {
        return flowTaskRepository.findById(flowTaskId)
                .orElseThrow(() -> new FlowTaskNotExistException(flowTaskId));
    }
}
