package cn.flow.engine.factory;

import cn.flow.engine.model.FlowTask;
import cn.flow.core.enums.FlowNodeStatus;

public class FlowTaskFactory {
    private String flowInstanceId;
    private String flowDeployModelId;
    private String flowNodeId;
    private String flowOperator;

    public FlowTaskFactory(String flowInstanceId,
                           String flowDeployModelId,
                           String flowNodeId,
                           String flowOperator) {
        this.flowInstanceId = flowInstanceId;
        this.flowDeployModelId = flowDeployModelId;
        this.flowNodeId = flowNodeId;
        this.flowOperator = flowOperator;
    }

    public FlowTaskFactory(String flowDeployModelId,
                           String flowNodeId,
                           String flowOperator) {
        this.flowDeployModelId = flowDeployModelId;
        this.flowNodeId = flowNodeId;
        this.flowOperator = flowOperator;
    }

    public FlowTask createFlowSaveTask() {
        return new FlowTask(flowDeployModelId,
                flowNodeId,
                flowOperator,
                FlowNodeStatus.SAVE
        );
    }

    public FlowTask createFlowSubmitTask() {
        return new FlowTask(flowInstanceId,
                flowDeployModelId,
                flowNodeId,
                flowOperator,
                FlowNodeStatus.SUBMIT
        );
    }

    public FlowTask createFlowInitTask() {
        return new FlowTask(flowInstanceId,
                flowDeployModelId,
                flowNodeId,
                FlowNodeStatus.INIT
        );
    }
}
