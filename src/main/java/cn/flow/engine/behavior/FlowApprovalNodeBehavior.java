package cn.flow.engine.behavior;

import cn.flow.core.enums.FlowNodeStatus;
import cn.flow.engine.interceptor.CommandContext;
import cn.flow.engine.interceptor.CommandParam;
import cn.flow.engine.model.FlowTask;
import cn.flow.engine.runtime.FlowExecution;
import cn.flow.engine.service.FlowTaskService;

import static cn.flow.engine.runtime.AtomicOperation.ACTIVITY_END;

public class FlowApprovalNodeBehavior extends FlowNodeBehavior {

    @Override
    public void leave(FlowExecution execution) {
        CommandContext commandContext = (CommandContext) execution;
        CommandParam commandParam = commandContext.getCommandParam();
        FlowTaskService flowTaskService = commandContext.getFlowTaskService();
        FlowTask flowTask = flowTaskService.getFlowTaskById(commandParam.getFlowTaskId());
        flowTask.editFlowTask(commandParam.getFlowOperator(), FlowNodeStatus.SUBMIT);
        commandContext.saveFlowTask(flowTask);
        commandContext.performOperation(ACTIVITY_END);
    }

    @Override
    public void execute(FlowExecution execution) {
        leave(execution);
    }
}
