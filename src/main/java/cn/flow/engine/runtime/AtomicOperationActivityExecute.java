package cn.flow.engine.runtime;


import cn.flow.engine.behavior.IFlowNodeBehavior;

public class AtomicOperationActivityExecute implements AtomicOperation {
    @Override
    public void execute(InterpretableExecution execution) {
        IFlowNodeBehavior IFlowNodeBehavior = execution.getFlowNodeBehavior();
        IFlowNodeBehavior.execute(execution);

        execution.performOperation(ACTIVITY_END);
    }
}
