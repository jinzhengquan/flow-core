package cn.flow.engine.runtime;

public abstract class AbstractEventAtomicOperation implements AtomicOperation {
    protected abstract void eventNotificationsCompleted(InterpretableExecution execution);

    @Override
    public void execute(InterpretableExecution execution) {
        eventNotificationsCompleted(execution);
    }
}
