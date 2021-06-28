package cn.flow.engine.service;

import cn.flow.engine.repository.FlowNodeRepository;
import lombok.RequiredArgsConstructor;
import cn.flow.engine.model.FlowNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowNodeService {
    private final FlowNodeRepository flowNodeRepository;

    public void createFlowNode(FlowNode flowNode) {
        flowNodeRepository.save(flowNode);
    }
}
