package cn.flow.engine.interceptor;

import cn.flow.engine.behavior.IFlowNodeBehavior;
import cn.flow.engine.model.FlowTaskHistoric;
import cn.flow.engine.runtime.AtomicOperation;
import cn.flow.engine.runtime.InterpretableExecution;
import cn.flow.engine.service.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import cn.flow.engine.factory.FlowTaskHistoricFactory;
import cn.flow.engine.model.FlowTask;
import org.flow.engine.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.flow.engine.service.*;

@Slf4j
@Component
@Getter
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CommandContext implements InterpretableExecution {
    private final FlowTaskService flowTaskService;
    private final FlowTaskHistoricService flowTaskHistoricService;
    private final FlowDeployModelService flowDeployModelService;
    private final FlowDeployNodeService flowDeployNodeService;
    private final FlowInstanceService flowInstanceService;
    private final FlowDeployNodeLinkedService flowDeployNodeLinkedService;

    private IFlowNodeBehavior flowNodeBehavior;
    private CommandParam commandParam;
    private String flowDeployModelId;
    private String flowNodeId;
    private String flowInstanceId;

    public void initCommandContext(String flowInstanceId,
                                   String flowNodeId,
                                   String flowDeployModelId) {
        this.flowDeployModelId = flowDeployModelId;
        this.flowNodeId = flowNodeId;
        this.flowInstanceId = flowInstanceId;
    }

    public void saveFlowTask(FlowTask flowTask) {
        flowTaskService.saveFlowTask(flowTask);
        saveFlowTaskHistoric(flowTask);
    }

    private void saveFlowTaskHistoric(FlowTask flowNodeProcess) {
        FlowTaskHistoricFactory flowTaskHistoricFactory = new FlowTaskHistoricFactory(flowNodeProcess);
        FlowTaskHistoric flowTaskHistoric = flowTaskHistoricFactory.createFlowNodeProcessHis();
        flowTaskHistoricService.saveFlowTaskHistoric(flowTaskHistoric);
    }

    public void performOperation(AtomicOperation executionOperation) {
        executionOperation.execute(this);
    }

    public void start() {
        performOperation(AtomicOperation.PROCESS_START);
    }

    public CommandParam getCommandParam() {
        return commandParam;
    }

    public void setCommandParam(CommandParam commandParam) {
        this.commandParam = commandParam;
    }

    public IFlowNodeBehavior getFlowNodeBehavior() {
        return flowNodeBehavior;
    }

    public void setFlowNodeBehavior(IFlowNodeBehavior flowNodeBehavior) {
        this.flowNodeBehavior = flowNodeBehavior;
    }

}

