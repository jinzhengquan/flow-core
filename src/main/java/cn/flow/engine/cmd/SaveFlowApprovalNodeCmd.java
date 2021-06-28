package cn.flow.engine.cmd;

import lombok.RequiredArgsConstructor;
import cn.flow.core.enums.FlowNodeStatus;
import cn.flow.engine.ProcessResult;
import cn.flow.engine.interceptor.Command;
import cn.flow.engine.interceptor.CommandContext;
import cn.flow.engine.model.FlowTask;
import cn.flow.engine.service.FlowTaskService;

import java.io.Serializable;

@RequiredArgsConstructor
public class SaveFlowApprovalNodeCmd<T> implements Command<ProcessResult>, Serializable {
    private static final long serialVersionUID = 1L;
    private final String flowTaskId;
    private final String flowOperator;

    @Override
    public ProcessResult execute(CommandContext commandContext) {
        FlowTaskService flowTaskService = commandContext.getFlowTaskService();
        FlowTask flowTask = flowTaskService.getFlowTaskById(flowTaskId);
        flowTask.editFlowTask(flowOperator, FlowNodeStatus.SAVE);

        commandContext.saveFlowTask(flowTask);
        return new ProcessResult(flowTask.getId());
    }
}
