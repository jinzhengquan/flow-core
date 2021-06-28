package cn.flow.engine.factory;

import cn.flow.engine.application.command.FlowNodeOperatorCreateCmd;
import cn.flow.engine.exception.FlowModelIdNotExistException;
import cn.flow.engine.exception.FlowNodeNotExistException;
import cn.flow.engine.model.FlowNodeOperator;
import cn.flow.engine.repository.FlowModelRepository;
import cn.flow.engine.repository.FlowNodeRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.join;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowNodeOperatorFactory {
    private final FlowModelRepository flowModelRepository;
    private final FlowNodeRepository flowNodeRepository;

    public FlowNodeOperator createFlowNodeOperator(FlowNodeOperatorCreateCmd command) {
        var flowModel = flowModelRepository.findFlowModelById(command.getFlowModelId())
                .orElseThrow(() -> new FlowModelIdNotExistException(command.getFlowModelId()));
        var flowNode = flowNodeRepository.findFlowNodeById(command.getFlowNodeId())
                .orElseThrow(() -> new FlowNodeNotExistException(command.getFlowNodeId()));
        String operator = nonNull(command.getOperator()) ? join(command.getOperator(), ",") : null;
        String role = nonNull(command.getRole()) ? join(command.getRole(), ",") : null;
        return new FlowNodeOperator(flowModel, flowNode, operator, role, command.getCreatedBy());
    }
}
