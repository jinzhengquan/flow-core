package cn.flow.engine.behavior;

import cn.flow.engine.runtime.FlowExecution;

import java.io.Serializable;

public interface IFlowNodeBehavior extends Serializable {

    void execute(FlowExecution execution);

}
