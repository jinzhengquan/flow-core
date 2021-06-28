package cn.flow.engine.behavior;

public class FlowNodeBehaviorFactory {

    public FlowStartNodeBehavior createFlowStartNodeBehavior() {
        return new FlowStartNodeBehavior();
    }

    public FlowEndNodeBehavior createFlowEndNodeBehavior() {
        return new FlowEndNodeBehavior();
    }

    public FlowApprovalNodeBehavior createFlowApprovalNodeBehavior() {
        return new FlowApprovalNodeBehavior();
    }
}
