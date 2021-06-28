package cn.flow.engine.service;

import cn.flow.engine.repository.FlowNodeOperatorRepository;
import lombok.RequiredArgsConstructor;
import cn.flow.engine.model.FlowNodeOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowNodeOperatorService {
    private final FlowNodeOperatorRepository flowNodeOperatorRepository;

    public void createFlowNodeOperator(FlowNodeOperator flowNodeOperator) {
        flowNodeOperatorRepository.save(flowNodeOperator);
    }
}
