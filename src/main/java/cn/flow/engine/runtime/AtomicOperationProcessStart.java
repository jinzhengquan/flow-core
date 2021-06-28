package cn.flow.engine.runtime;

import cn.flow.engine.factory.FlowInstanceFactory;
import cn.flow.engine.interceptor.CommandParam;
import cn.flow.engine.model.FlowInstance;
import cn.flow.engine.service.FlowInstanceService;

public class AtomicOperationProcessStart extends AbstractEventAtomicOperation {
    @Override
    protected void eventNotificationsCompleted(InterpretableExecution execution) {
        CommandParam commandParam = execution.getCommandParam();
        FlowInstanceFactory flowInstanceFactory = new FlowInstanceFactory(commandParam.getFlowDeployModelId(),
                commandParam.getFlowOperator());
        FlowInstance flowInstance = flowInstanceFactory.createFlowInstance();
        FlowInstanceService flowInstanceService = execution.getFlowInstanceService();
        flowInstanceService.saveFlowInstance(flowInstance);
        commandParam.setFlowInstanceId(flowInstance.getId());

        execution.performOperation(PROCESS_START_INITIAL);
    }
}
