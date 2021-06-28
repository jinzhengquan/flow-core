package cn.flow.engine.application;

import cn.flow.engine.ProcessResult;
import cn.flow.engine.cmd.*;
import lombok.RequiredArgsConstructor;
import cn.flow.engine.ProcessTaskService;
import org.flow.engine.cmd.*;
import test.flow.engine.cmd.*;
import cn.flow.engine.interceptor.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowTaskServiceImpl implements ProcessTaskService {
    private final CommandExecutor commandExecutor;

    @Override
    @Transactional
    public ProcessResult saveFlowStartNode(String flowDeployModelId, String flowOperator) {
        return commandExecutor.execute(new SaveFlowStartNodeCmd<ProcessResult>(flowDeployModelId, flowOperator));
    }

    @Override
    @Transactional
    public void submitFlowStartNodeFromDealWith(String flowNodeProcessId, String flowOperator) {
        commandExecutor.execute(new SubmitFlowStartNodeFromDealWithCmd<Void>(flowNodeProcessId, flowOperator));
    }

    @Override
    @Transactional
    public void submitFlowStartNodeFromNewCreate(String flowDeployModelId, String flowOperator) {
        commandExecutor.execute(new SubmitFlowStartNodeFromNewCreateCmd<Void>(flowDeployModelId, flowOperator));
    }

    @Override
    @Transactional
    public void saveApprovalNode(String flowTaskId, String flowOperator) {
        commandExecutor.execute(new SaveFlowApprovalNodeCmd<Void>(flowTaskId, flowOperator));
    }

    @Override
    @Transactional
    public void submitApprovalNode(String flowTaskId, String flowOperator) {
        commandExecutor.execute(new SubmitFlowApprovalNodeCmd<Void>(flowTaskId, flowOperator));
    }

    @Override
    @Transactional
    public void flowBackStartNode(String flowTaskId, String flowOperator) {
        commandExecutor.execute(new BackFlowNodeCmd<Void>(flowTaskId, flowOperator));
    }
}
