package cn.flow.engine;

import cn.flow.engine.application.command.FlowNodeEditCmd;
import cn.flow.engine.application.command.FlowNodeLinkedCreateCmd;
import cn.flow.engine.application.command.FlowNodeLinkedDeleteCmd;
import cn.flow.engine.application.command.FlowNodeLinkedEditCmd;
import cn.flow.engine.application.command.FlowCategoryCreateCmd;
import cn.flow.engine.application.command.FlowCategoryDeleteCmd;
import cn.flow.engine.application.command.FlowCategoryEditCmd;
import cn.flow.engine.application.command.FlowModelCreateCmd;
import cn.flow.engine.application.command.FlowModelDeleteCmd;
import cn.flow.engine.application.command.FlowModelDeployCmd;
import cn.flow.engine.application.command.FlowModelEditCmd;
import cn.flow.engine.application.command.FlowNodeCreateCmd;
import cn.flow.engine.application.command.FlowNodeDeleteCmd;
import cn.flow.engine.application.command.FlowNodeOperatorCreateCmd;
import cn.flow.engine.application.command.FlowNodeOperatorDeleteCmd;
import cn.flow.engine.application.command.FlowNodeOperatorEditCmd;

public interface ProcessManageService {

    void createFlowCategory(FlowCategoryCreateCmd command);

    void deleteFlowCategory(FlowCategoryDeleteCmd command);

    void editFlowCategory(FlowCategoryEditCmd command);

    void createFlowModel(FlowModelCreateCmd command);

    void editFlowModel(FlowModelEditCmd command);

    void deleteFlowModel(FlowModelDeleteCmd command);

    void deployFlowModel(FlowModelDeployCmd command);

    void createFlowNode(FlowNodeCreateCmd command);

    void editFlowNode(FlowNodeEditCmd command);

    void deleteFlowNode(FlowNodeDeleteCmd command);

    void createFlowNodeLinked(FlowNodeLinkedCreateCmd command);

    void editFlowNodeLinked(FlowNodeLinkedEditCmd command);

    void deleteFlowNodeLinked(FlowNodeLinkedDeleteCmd command);

    void createFlowNodeOperator(FlowNodeOperatorCreateCmd command);

    void editFlowNodeOperator(FlowNodeOperatorEditCmd command);

    void deleteFlowNodeOperator(FlowNodeOperatorDeleteCmd command);
}
