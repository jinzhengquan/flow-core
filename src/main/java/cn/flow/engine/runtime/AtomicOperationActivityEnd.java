package cn.flow.engine.runtime;

import cn.flow.core.enums.FlowNodeStatus;
import cn.flow.core.enums.FlowNodeType;
import cn.flow.engine.interceptor.CommandContext;
import cn.flow.engine.model.FlowDeployNode;
import cn.flow.engine.model.FlowDeployNodeLinked;
import cn.flow.engine.model.FlowTask;
import cn.flow.engine.service.FlowDeployNodeLinkedService;
import cn.flow.engine.service.FlowDeployNodeService;
import org.flow.engine.model.*;
import org.flow.engine.service.*;

public class AtomicOperationActivityEnd extends AbstractEventAtomicOperation {
    @Override
    protected void eventNotificationsCompleted(InterpretableExecution execution) {
        CommandContext commandContext = (CommandContext)execution;
        FlowDeployNodeLinkedService flowDeployNodeLinkedService = commandContext.getFlowDeployNodeLinkedService();

        FlowDeployNodeLinked flowDeployNodeLinked = flowDeployNodeLinkedService
                .getByFlowDeployModelIdAndStartNodeId(commandContext.getFlowDeployModelId(), commandContext.getFlowNodeId());

        FlowDeployNodeService flowDeployNodeService = commandContext.getFlowDeployNodeService();
        FlowDeployNode flowDeployNode = flowDeployNodeService.getFlowDeployNodeById(flowDeployNodeLinked.getEndNodeId());
        if (FlowNodeType.END_NODE.equals(flowDeployNode.getNodeType())) {
            execution.performOperation(PROCESS_END);
            return;
        }

        FlowTask nextFlowTask = FlowTask.builder()
                .flowInstanceId(commandContext.getFlowInstanceId())
                .flowDeployModelId(commandContext.getFlowDeployModelId())
                .flowNodeId(flowDeployNodeLinked.getEndNodeId())
                .flowNodeStatus(FlowNodeStatus.INIT)
                .build();
        commandContext.saveFlowTask(nextFlowTask);
    }
}
