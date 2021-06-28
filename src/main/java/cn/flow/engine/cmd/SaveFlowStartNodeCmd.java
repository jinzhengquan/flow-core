package cn.flow.engine.cmd;

import cn.flow.engine.ProcessResult;
import cn.flow.engine.factory.FlowTaskFactory;
import cn.flow.engine.interceptor.Command;
import cn.flow.engine.interceptor.CommandContext;
import cn.flow.engine.model.FlowDeployModel;
import cn.flow.engine.model.FlowDeployNode;
import cn.flow.engine.model.FlowTask;
import cn.flow.engine.service.FlowDeployModelService;
import cn.flow.engine.service.FlowDeployNodeService;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@RequiredArgsConstructor
public class SaveFlowStartNodeCmd<T> implements Command<ProcessResult>, Serializable {
    private static final long serialVersionUID = 1L;
    private final String flowDeployModelId;
    private final String flowOperator;

    @Override
    public ProcessResult execute(CommandContext commandContext) {
        FlowDeployModelService flowDeployModelService = commandContext.getFlowDeployModelService();
        FlowDeployModel flowDeployModel = flowDeployModelService.getFlowDeployModelById(flowDeployModelId);

        FlowDeployNodeService flowDeployNodeService = commandContext.getFlowDeployNodeService();
        FlowDeployNode flowStartNode = flowDeployNodeService.getFlowStartNode(flowDeployModel.getId());
        FlowTaskFactory flowTaskFactory = new FlowTaskFactory(flowDeployModel.getId(),
                flowStartNode.getNodeId(), flowOperator);

        FlowTask flowTask = flowTaskFactory.createFlowSaveTask();
        commandContext.saveFlowTask(flowTask);
        return new ProcessResult(flowTask.getId());
    }
}
