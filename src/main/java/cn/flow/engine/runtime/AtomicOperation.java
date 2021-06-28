package cn.flow.engine.runtime;

public interface AtomicOperation {
    AtomicOperation PROCESS_START = new AtomicOperationProcessStart();
    AtomicOperation PROCESS_START_INITIAL = new AtomicOperationProcessStartInitial();
    AtomicOperation PROCESS_END = new AtomicOperationProcessEnd();
    AtomicOperation ACTIVITY_START = new AtomicOperationActivityStart();
    AtomicOperation ACTIVITY_EXECUTE = new AtomicOperationActivityExecute();
    AtomicOperation ACTIVITY_END = new AtomicOperationActivityEnd();
    void execute(InterpretableExecution execution);
}
