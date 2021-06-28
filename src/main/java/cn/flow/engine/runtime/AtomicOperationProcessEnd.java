package cn.flow.engine.runtime;

import cn.flow.engine.behavior.FlowNodeBehaviorFactory;
import cn.flow.engine.behavior.IFlowNodeBehavior;

public class AtomicOperationProcessEnd extends AbstractEventAtomicOperation {
    @Override
    protected void eventNotificationsCompleted(InterpretableExecution execution) {
        IFlowNodeBehavior IFlowNodeBehavior = new FlowNodeBehaviorFactory().createFlowEndNodeBehavior();
        IFlowNodeBehavior.execute(execution);
    }
}
