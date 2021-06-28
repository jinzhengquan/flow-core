package cn.flow.engine.cmd;

import cn.flow.engine.interceptor.Command;
import lombok.RequiredArgsConstructor;
import cn.flow.engine.behavior.FlowNodeBehaviorFactory;
import cn.flow.engine.behavior.IFlowNodeBehavior;
import cn.flow.engine.interceptor.CommandContext;
import cn.flow.engine.interceptor.CommandParam;
import cn.flow.engine.service.FlowTaskService;

import java.io.Serializable;

@RequiredArgsConstructor
public class SubmitFlowStartNodeFromDealWithCmd<T> implements Command<Void>, Serializable {
    private static final long serialVersionUID = 1L;
    private final String flowTaskId;
    private final String flowOperator;

    @Override
    public Void execute(CommandContext commandContext) {
        FlowTaskService processTaskService = commandContext.getFlowTaskService();
        processTaskService.getFlowTaskById(flowTaskId);

        IFlowNodeBehavior flowNodeBehavior = new FlowNodeBehaviorFactory().createFlowStartNodeBehavior();
        commandContext.setFlowNodeBehavior(flowNodeBehavior);

        CommandParam commandParam = new CommandParam(flowTaskId, null, flowOperator);
        commandContext.setCommandParam(commandParam);
        commandContext.start();
        return null;
    }
}
