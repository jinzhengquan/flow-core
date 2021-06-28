package cn.flow.engine.runtime;

public class AtomicOperationActivityStart extends AbstractEventAtomicOperation {
    @Override
    protected void eventNotificationsCompleted(InterpretableExecution execution) {
        execution.performOperation(ACTIVITY_EXECUTE);
    }
}
