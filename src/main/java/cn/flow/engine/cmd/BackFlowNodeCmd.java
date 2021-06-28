package cn.flow.engine.cmd;

import lombok.RequiredArgsConstructor;
import cn.flow.engine.ProcessResult;
import cn.flow.engine.factory.FlowTaskFactory;
import cn.flow.engine.interceptor.Command;
import cn.flow.engine.interceptor.CommandContext;
import cn.flow.engine.model.FlowDeployNode;
import cn.flow.engine.model.FlowTask;
import cn.flow.engine.service.FlowDeployModelService;
import cn.flow.engine.service.FlowDeployNodeService;
import cn.flow.engine.service.FlowTaskService;

import java.io.Serializable;

@RequiredArgsConstructor
public class BackFlowNodeCmd<T> implements Command<ProcessResult>, Serializable {
    private static final long serialVersionUID = 1L;
    private final String flowTaskId;
    private final String flowOperator;

    @Override
    public ProcessResult execute(CommandContext commandContext) {
        FlowTaskService flowTaskService = commandContext.getFlowTaskService();
        FlowTask flowTask = flowTaskService.getFlowTaskById(flowTaskId);

        FlowDeployModelService deployModelService = commandContext.getFlowDeployModelService();
        deployModelService.getFlowDeployModelById(flowTask.getFlowDeployModelId());

        FlowDeployNodeService flowDeployNodeService = commandContext.getFlowDeployNodeService();

        FlowDeployNode flowStartNode = flowDeployNodeService.getFlowStartNode(flowTask.getFlowDeployModelId());
        FlowTaskFactory flowTaskFactory = new FlowTaskFactory(flowTask.getFlowDeployModelId(),
                flowStartNode.getNodeId(), flowOperator);
        FlowTask nextFlowNodeProcess = flowTaskFactory.createFlowSaveTask();
        flowTaskService.saveFlowTask(nextFlowNodeProcess);

        commandContext.saveFlowTask(nextFlowNodeProcess);
        return new ProcessResult(nextFlowNodeProcess.getId());
    }
}
