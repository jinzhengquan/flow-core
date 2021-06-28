package cn.flow.engine.runtime;

import cn.flow.engine.behavior.IFlowNodeBehavior;
import cn.flow.engine.interceptor.CommandParam;
import cn.flow.engine.model.FlowTask;
import cn.flow.engine.service.*;
import org.flow.engine.service.*;
import test.flow.engine.service.*;

public interface FlowExecution {
    FlowTaskService getFlowTaskService();

    FlowTaskHistoricService getFlowTaskHistoricService();

    FlowDeployModelService getFlowDeployModelService();

    FlowDeployNodeService getFlowDeployNodeService();

    FlowInstanceService getFlowInstanceService();

    IFlowNodeBehavior getFlowNodeBehavior();

    CommandParam getCommandParam();

    void saveFlowTask(FlowTask flowTask);

}
