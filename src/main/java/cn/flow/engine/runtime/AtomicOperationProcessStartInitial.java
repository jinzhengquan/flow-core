package cn.flow.engine.runtime;

public class AtomicOperationProcessStartInitial extends AbstractEventAtomicOperation {
    @Override
    protected void eventNotificationsCompleted(InterpretableExecution execution) {
        execution.performOperation(ACTIVITY_START);
    }
}
