package cn.flow.engine.service;

import lombok.RequiredArgsConstructor;
import cn.flow.engine.exception.FlowDeployModelIdNotExistException;
import cn.flow.engine.model.FlowDeployModel;
import cn.flow.engine.repository.FlowDeployModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowDeployModelService {
    private final FlowDeployModelRepository flowDeployModelRepository;

    public FlowDeployModel getFlowDeployModelById(String flowDeployModelId) {
        return flowDeployModelRepository.findById(flowDeployModelId)
                .orElseThrow(() -> new FlowDeployModelIdNotExistException(flowDeployModelId));
    }
}
