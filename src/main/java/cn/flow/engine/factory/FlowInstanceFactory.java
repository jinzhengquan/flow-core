package cn.flow.engine.factory;

import lombok.AllArgsConstructor;
import cn.flow.engine.model.FlowInstance;

@AllArgsConstructor
public class FlowInstanceFactory {
    private String deployModelId;
    private String flowOperator;

    public FlowInstance createFlowInstance() {
        return new FlowInstance(deployModelId, flowOperator);
    }
}
