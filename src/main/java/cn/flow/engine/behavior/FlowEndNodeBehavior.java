package cn.flow.engine.behavior;

import cn.flow.core.enums.FlowNodeStatus;
import cn.flow.engine.interceptor.CommandContext;
import cn.flow.engine.model.FlowDeployNode;
import cn.flow.engine.model.FlowInstance;
import cn.flow.engine.model.FlowTask;
import cn.flow.engine.runtime.FlowExecution;
import cn.flow.engine.service.FlowDeployNodeService;
import cn.flow.engine.service.FlowInstanceService;

public class FlowEndNodeBehavior extends FlowNodeBehavior {
    @Override
    public void execute(FlowExecution execution) {
        leave(execution);
    }

    public void leave(FlowExecution execution) {
        CommandContext commandContext = (CommandContext) execution;

        FlowInstanceService flowInstanceService = commandContext.getFlowInstanceService();
        FlowInstance flowInstance = flowInstanceService.getById(commandContext.getFlowInstanceId());
        flowInstance.setFlowInstanceEnd();

        FlowDeployNodeService flowDeployNodeService = execution.getFlowDeployNodeService();
        FlowDeployNode flowStartNode = flowDeployNodeService.getFlowEndNode(commandContext.getFlowDeployModelId());
        FlowTask endFlowTask = FlowTask.builder()
                .flowInstanceId(commandContext.getFlowInstanceId())
                .flowDeployModelId(commandContext.getFlowDeployModelId())
                .flowNodeId(flowStartNode.getNodeId())
                .flowNodeStatus(FlowNodeStatus.SUBMIT)
                .build();

        commandContext.saveFlowTask(endFlowTask);
    }
}
