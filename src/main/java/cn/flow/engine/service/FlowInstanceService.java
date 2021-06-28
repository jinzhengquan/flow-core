package cn.flow.engine.service;

import lombok.RequiredArgsConstructor;
import cn.flow.engine.exception.FlowInstanceNotExistException;
import cn.flow.engine.model.FlowInstance;
import cn.flow.engine.repository.FlowInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowInstanceService {
    private final FlowInstanceRepository flowInstanceRepository;

    public void saveFlowInstance(FlowInstance flowInstance) {
        flowInstanceRepository.save(flowInstance);
    }

    public FlowInstance getById(String flowInstanceId) {
        return flowInstanceRepository.findById(flowInstanceId).orElseThrow(() -> new FlowInstanceNotExistException(flowInstanceId));
    }
}