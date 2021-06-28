package cn.flow.engine.cmd;

import lombok.RequiredArgsConstructor;
import cn.flow.engine.behavior.FlowNodeBehaviorFactory;
import cn.flow.engine.behavior.IFlowNodeBehavior;
import cn.flow.engine.interceptor.Command;
import cn.flow.engine.interceptor.CommandContext;
import cn.flow.engine.interceptor.CommandParam;

import java.io.Serializable;

import static cn.flow.engine.runtime.AtomicOperation.ACTIVITY_START;

@RequiredArgsConstructor
public class SubmitFlowApprovalNodeCmd<V> implements Command<Void>, Serializable {
    private final String flowTaskId;
    private final String flowOperator;

    @Override
    public Void execute(CommandContext commandContext) {
        IFlowNodeBehavior flowNodeBehavior = new FlowNodeBehaviorFactory().createFlowApprovalNodeBehavior();
        commandContext.setFlowNodeBehavior(flowNodeBehavior);

        CommandParam commandParam = new CommandParam(flowTaskId, null, flowOperator);
        commandContext.setCommandParam(commandParam);

        commandContext.performOperation(ACTIVITY_START);
        return null;
    }
}
