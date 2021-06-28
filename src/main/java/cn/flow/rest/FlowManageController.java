package cn.flow.rest;

import cn.flow.engine.ProcessManageService;
import cn.flow.engine.application.command.FlowNodeEditCmd;
import cn.flow.engine.application.command.FlowNodeLinkedCreateCmd;
import cn.flow.engine.application.command.FlowNodeLinkedDeleteCmd;
import cn.flow.engine.application.command.FlowNodeLinkedEditCmd;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/flow-manage")
@Tag(name = "flow manage command APIs")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowManageController {

    private final ProcessManageService processManageService;

    @PostMapping("/flow-category/create")
    public void createFlowCategory(@Valid @RequestBody FlowCategoryCreateCmd command) {
        processManageService.createFlowCategory(command);
    }

    @PostMapping("/flow-category/edit")
    public void editFlowCategory(@Valid @RequestBody FlowCategoryEditCmd command) {
        processManageService.editFlowCategory(command);
    }

    @PostMapping("/flow-category/delete")
    public void deleteFlowCategory(@Valid @RequestBody FlowCategoryDeleteCmd command) {
        processManageService.deleteFlowCategory(command);
    }

    @PostMapping("/flow-model/create")
    public void createFlowModel(@Valid @RequestBody FlowModelCreateCmd command) {
        processManageService.createFlowModel(command);
    }

    @PostMapping("/flow-model/edit")
    public void editFlowModel(@Valid @RequestBody FlowModelEditCmd command) {
        processManageService.editFlowModel(command);
    }

    @PostMapping("/flow-model/delete")
    public void deleteFlowModel(@Valid @RequestBody FlowModelDeleteCmd command) {
        processManageService.deleteFlowModel(command);
    }

    @PostMapping("/flow-model/deploy")
    public void deployFlowModel(@Valid @RequestBody FlowModelDeployCmd command) {
        processManageService.deployFlowModel(command);
    }

    @PostMapping("/flow-node/create")
    public void createFlowNode(@Valid @RequestBody FlowNodeCreateCmd command) {
        processManageService.createFlowNode(command);
    }

    @PostMapping("/flow-node/edit")
    public void editFlowNode(@Valid @RequestBody FlowNodeEditCmd command) {
        processManageService.editFlowNode(command);
    }

    @PostMapping("/flow-node/delete")
    public void deleteFlowNode(@Valid @RequestBody FlowNodeDeleteCmd command) {
        processManageService.deleteFlowNode(command);
    }

    @PostMapping("/flow-node-linked/create")
    public void createFlowNodeLinked(@Valid @RequestBody FlowNodeLinkedCreateCmd command) {
        processManageService.createFlowNodeLinked(command);
    }

    @PostMapping("/flow-node-linked/edit")
    public void editFlowNodeLinked(@Valid @RequestBody FlowNodeLinkedEditCmd command) {
        processManageService.editFlowNodeLinked(command);
    }

    @PostMapping("/flow-node-linked/delete")
    public void deleteFlowNodeLinked(@Valid @RequestBody FlowNodeLinkedDeleteCmd command) {
        processManageService.deleteFlowNodeLinked(command);
    }

    @PostMapping("/flow-node-operator/create")
    public void createFlowNodeOperator(@Valid @RequestBody FlowNodeOperatorCreateCmd command) {
        processManageService.createFlowNodeOperator(command);
    }

    @PostMapping("/flow-node-operator/edit")
    public void editFlowNodeLinked(@Valid @RequestBody FlowNodeOperatorEditCmd command) {
        processManageService.editFlowNodeOperator(command);
    }

    @PostMapping("/flow-node-operator/delete")
    public void deleteFlowNodeLinked(@Valid @RequestBody FlowNodeOperatorDeleteCmd command) {
        processManageService.deleteFlowNodeOperator(command);
    }
}
