package cn.flow.engine.behavior;

import cn.flow.core.enums.FlowNodeStatus;
import cn.flow.engine.factory.FlowTaskFactory;
import cn.flow.engine.interceptor.CommandParam;
import cn.flow.engine.model.FlowDeployNode;
import cn.flow.engine.model.FlowTask;
import cn.flow.engine.runtime.FlowExecution;
import cn.flow.engine.service.FlowDeployNodeService;
import cn.flow.engine.service.FlowTaskService;

import java.util.Objects;

public class FlowStartNodeBehavior extends FlowNodeBehavior {

    @Override
    public void execute(FlowExecution execution) {
        leave(execution);
    }

    public void leave(FlowExecution execution) {
        flowTaskIdNotNull(execution);
        flowTaskIdNull(execution);
    }

    private void flowTaskIdNotNull(FlowExecution execution) {
        CommandParam commandParam = execution.getCommandParam();
        if (Objects.isNull(commandParam.getFlowTaskId())) {
            return;
        }
        FlowTaskService flowNodeProcessService = execution.getFlowTaskService();
        FlowTask flowTask = flowNodeProcessService.getFlowTaskById(commandParam.getFlowTaskId());
        flowTask.editFlowTask(commandParam.getFlowInstanceId(),
                commandParam.getFlowOperator(), FlowNodeStatus.SUBMIT);
        execution.saveFlowTask(flowTask);
        commandParam.setFlowTaskId(flowTask.getId());
    }

    private void flowTaskIdNull(FlowExecution execution) {
        CommandParam commandParam = execution.getCommandParam();
        if (Objects.nonNull(commandParam.getFlowTaskId())) {
            return;
        }
        FlowDeployNodeService flowDeployNodeService = execution.getFlowDeployNodeService();
        FlowDeployNode flowStartNode = flowDeployNodeService.getFlowStartNode(commandParam.getFlowDeployModelId());
        FlowTaskFactory flowTaskFactory = new FlowTaskFactory(commandParam.getFlowInstanceId(),
                commandParam.getFlowDeployModelId(), flowStartNode.getNodeId(), commandParam.getFlowOperator());
        execution.saveFlowTask(flowTaskFactory.createFlowSubmitTask());
    }


}
