package cn.flow.engine.runtime;

public interface InterpretableExecution extends FlowExecution {
    void performOperation(AtomicOperation atomicOperation);
}
