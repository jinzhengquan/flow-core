package cn.flow.engine;

public interface ProcessTaskService {

    ProcessResult saveFlowStartNode(String flowDeployModelId, String flowOperator);

    void submitFlowStartNodeFromDealWith(String flowTaskId, String flowOperator);

    void submitFlowStartNodeFromNewCreate(String flowDeployModelId, String flowOperator);

    void saveApprovalNode(String flowTaskId, String flowOperator);

    void submitApprovalNode(String flowTaskId, String flowOperator);

    void flowBackStartNode(String flowTaskId, String flowOperator);
}
