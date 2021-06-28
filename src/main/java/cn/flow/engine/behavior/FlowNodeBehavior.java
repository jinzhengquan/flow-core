package cn.flow.engine.behavior;

import cn.flow.engine.runtime.FlowExecution;

public abstract class FlowNodeBehavior implements IFlowNodeBehavior {

    public abstract void leave(FlowExecution execution);
}
