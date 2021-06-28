package cn.flow.rest;

import cn.flow.engine.ProcessTaskService;
import cn.flow.engine.application.command.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.flow.engine.application.command.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.flow.engine.application.command.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/flow-process")
@Tag(name = "flow process command APIs")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowTaskController {
    private final ProcessTaskService processTaskService;

    @PostMapping("/save-start-node")
    public void saveStartNode(@Valid @RequestBody FlowStartNodeSaveCmd cmd) {
        processTaskService.saveFlowStartNode(cmd.getFlowDeployModelId(), cmd.getFlowOperator());
    }

    @PostMapping("/submit-start-node-from-deal-with")
    public void submitStartNodeFromDealWith(@Valid @RequestBody FlowStartNodeSubmitCommand command) {
        processTaskService.submitFlowStartNodeFromDealWith(command.getFlowTaskId(),command.getFlowOperator());
    }

    @PostMapping("/submit-start-node-from-new-create")
    public void submitStartNodeFromNewCreate(@Valid @RequestBody FlowStartNodeSubmitCommand command) {
        processTaskService.submitFlowStartNodeFromNewCreate(command.getFlowTaskId(),command.getFlowOperator());
    }

    @PostMapping("/save-approval-node")
    public void saveApprovalNode(@Valid @RequestBody FlowApprovalNodeSaveCmd command) {
        processTaskService.saveApprovalNode(command.getFlowTaskId(), command.getFlowOperator());
    }

    @PostMapping("/submit-approval-node")
    public void submitApprovalNode(@Valid @RequestBody FlowApprovalNodeSubmitCmd command) {
        processTaskService.submitApprovalNode(command.getFlowTaskId(), command.getFlowOperator());
    }

    @PostMapping("/back-flow-node")
    public void flowBackStartNode(FlowBackNodeCommand command) {
        processTaskService.flowBackStartNode(command.getFlowTaskId(), command.getFlowOperator());
    }
}
