package cn.flow.engine.cmd;

import cn.flow.engine.behavior.FlowNodeBehaviorFactory;
import cn.flow.engine.behavior.IFlowNodeBehavior;
import cn.flow.engine.interceptor.Command;
import cn.flow.engine.interceptor.CommandContext;
import cn.flow.engine.interceptor.CommandParam;
import cn.flow.engine.service.FlowDeployModelService;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@RequiredArgsConstructor
public class SubmitFlowStartNodeFromNewCreateCmd<T> implements Command<Void>, Serializable {
    private static final long serialVersionUID = 1L;
    private final String flowDeployModelId;
    private final String flowOperator;

    @Override
    public Void execute(CommandContext commandContext) {
        FlowDeployModelService flowDeployModelService = commandContext.getFlowDeployModelService();
        flowDeployModelService.getFlowDeployModelById(flowDeployModelId);

        IFlowNodeBehavior IFlowNodeBehavior = new FlowNodeBehaviorFactory().createFlowStartNodeBehavior();
        commandContext.setFlowNodeBehavior(IFlowNodeBehavior);

        CommandParam commandParam = new CommandParam(null, flowDeployModelId, flowOperator);
        commandContext.setCommandParam(commandParam);
        commandContext.start();
        return null;
    }
}
