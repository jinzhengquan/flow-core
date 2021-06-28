package cn.flow.engine.application;

import cn.flow.core.specification.Pair;
import cn.flow.engine.ProcessManageService;
import cn.flow.engine.application.command.FlowNodeEditCmd;
import cn.flow.engine.application.command.FlowNodeLinkedCreateCmd;
import cn.flow.engine.application.command.FlowNodeLinkedDeleteCmd;
import cn.flow.engine.application.command.FlowNodeLinkedEditCmd;
import cn.flow.engine.application.validate.FlowModelValidate;
import cn.flow.engine.exception.*;
import cn.flow.engine.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.var;
import cn.flow.core.exception.FlowException;
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
import cn.flow.engine.application.spec.FlowNodeNameCreateSpec;
import cn.flow.engine.application.spec.FlowNodeNameEditSpec;
import cn.flow.engine.application.validate.FlowCategoryValidate;
import org.flow.engine.exception.*;
import test.flow.engine.exception.*;
import cn.flow.engine.factory.FlowNodeFactory;
import cn.flow.engine.factory.FlowNodeLinkedFactory;
import cn.flow.engine.factory.FlowNodeOperatorFactory;
import org.flow.engine.repository.*;
import test.flow.engine.repository.*;
import cn.flow.engine.service.FlowCategoryService;
import cn.flow.engine.service.FlowModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.join;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProcessManageServiceImpl implements ProcessManageService {
    private final FlowCategoryRepository flowCategoryRepository;
    private final FlowCategoryValidate flowCategoryValidate;
    private final FlowCategoryService flowCategoryService;
    private final FlowModelService flowModelService;
    private final FlowModelValidate flowModelValidate;
    private final FlowModelRepository flowModelRepository;
    private final FlowNodeFactory flowNodeFactory;
    private final FlowNodeNameCreateSpec flowNodeNameCreateSpec;
    private final FlowNodeRepository flowNodeRepository;
    private final FlowNodeNameEditSpec flowNodeNameEditSpec;
    private final FlowNodeLinkedFactory flowNodeLinkedFactory;
    private final FlowNodeLinkedRepository flowNodeLinkedRepository;
    private final FlowNodeOperatorFactory flowNodeOperatorFactory;
    private final FlowNodeOperatorRepository flowNodeOperatorRepository;

    @Override
    @Transactional
    public void createFlowCategory(FlowCategoryCreateCmd command) {
        flowCategoryValidate.validCreateCommand(command);
        flowCategoryService.createFlowCategory(command);
    }

    @Override
    @Transactional
    public void deleteFlowCategory(FlowCategoryDeleteCmd command) {
        var flowCategory = flowCategoryRepository.findFlowCategoryById(command.getId())
                .orElseThrow(() -> new FlowException(command.getId()));
        flowCategoryValidate.validDeleteCommand(flowCategory);
        flowCategoryService.deleteFlowCategory(flowCategory, command);
    }

    @Override
    @Transactional
    public void editFlowCategory(FlowCategoryEditCmd command) {
        var flowCategory = flowCategoryRepository.findFlowCategoryById(command.getId())
                .orElseThrow(() -> new FlowCategoryIdNotExistException(command.getId()));
        flowCategoryValidate.validEditCommand(flowCategory.getCategoryName(), command);
        flowCategoryService.editFlowCategory(flowCategory, command);
    }

    @Override
    @Transactional
    public void createFlowModel(FlowModelCreateCmd command) {
        flowModelValidate.validateCreateCommand(command);
        flowModelService.createFlowModel(command);
    }

    @Override
    @Transactional
    public void editFlowModel(FlowModelEditCmd command) {
        var flowModel = flowModelRepository.findFlowModelById(command.getId())
                .orElseThrow(() -> new FlowModelIdNotExistException(command.getId()));
        flowModelValidate.validateEditCommand(flowModel.getFlowModelName(), command);
        flowModelService.editFlowModel(flowModel, command);
    }

    @Override
    @Transactional
    public void deleteFlowModel(FlowModelDeleteCmd command) {
        var flowModel = flowModelRepository.findFlowModelById(command.getId())
                .orElseThrow(() -> new FlowModelIdNotExistException(command.getId()));
        flowModelValidate.validateDeleteCommand(flowModel);
        flowModelService.deleteFlowModel(flowModel);
    }

    @Override
    @Transactional
    public void deployFlowModel(FlowModelDeployCmd command) {
        var flowModel = flowModelRepository.findFlowModelById(command.getId())
                .orElseThrow(() -> new FlowModelIdNotExistException(command.getId()));
        flowModelService.deployFlowModel(flowModel, command.getDeployBy());
    }

    @Override
    @Transactional
    public void createFlowNode(FlowNodeCreateCmd command) {
        var flowModel = flowModelRepository.findFlowModelById(command.getFlowModelId())
                .orElseThrow(() -> new FlowModelIdNotExistException(command.getFlowModelId()));
        flowNodeNameCreateSpec.verify(Pair.of(command.getNodeName(), command.getFlowModelId()));
        var flowNode = flowNodeFactory.createFlowNode(command, flowModel);
        flowModel.addFlowNode(flowNode);
    }

    @Override
    @Transactional
    public void editFlowNode(FlowNodeEditCmd command) {
        var flowNode = flowNodeRepository.findFlowNodeById(command.getId())
                .orElseThrow(() -> new FlowNodeNotExistException(command.getId()));
        flowNodeNameEditSpec.verify(Pair.of(flowNode, command.getNodeName()));
        flowNode.editNode(command.getNodeName(), command.getEditedBy());
    }

    @Override
    @Transactional
    public void deleteFlowNode(FlowNodeDeleteCmd command) {
        var flowNode = flowNodeRepository.findFlowNodeById(command.getId())
                .orElseThrow(() -> new FlowNodeNotExistException(command.getId()));
        var flowModel = flowNode.getFlowModel();
        flowModel.deleteFlowNode(command.getId());
    }

    @Override
    @Transactional
    public void createFlowNodeLinked(FlowNodeLinkedCreateCmd command) {
        var flowModel = flowModelRepository.findFlowModelById(command.getFlowModeId())
                .orElseThrow(() -> new FlowModelIdNotExistException(command.getFlowModeId()));
        var startFlowNode = flowModel.getFlowNode(command.getStartNodeId());
        var endFlowNode = flowModel.getFlowNode(command.getEndNodeId());
        var flowNodeLinked = flowNodeLinkedFactory.createFlowNodeLinked(startFlowNode,
                endFlowNode, flowModel, command.getCreatedBy());
        flowModel.addFlowNodeLinked(flowNodeLinked);
    }

    @Override
    @Transactional
    public void editFlowNodeLinked(FlowNodeLinkedEditCmd command) {
        var flowModel = flowModelRepository.findFlowModelById(command.getFlowModeId())
                .orElseThrow(() -> new FlowModelIdNotExistException(command.getFlowModeId()));
        var flowNodeLinked = flowModel.getFlowNodeLinked(command.getId());
        var startFlowNode = flowModel.getFlowNode(command.getStartNodeId());
        var endFlowNode = flowModel.getFlowNode(command.getEndNodeId());
        flowNodeLinked.editNodeLinked(startFlowNode, endFlowNode, command.getEditedBy());
    }

    @Override
    @Transactional
    public void deleteFlowNodeLinked(FlowNodeLinkedDeleteCmd command) {
        var flowNodeLinked = flowNodeLinkedRepository.findFlowNodeLinkedById(command.getId())
                .orElseThrow(() -> new FlowNodeLinkedNotExistException(command.getId()));
        var flowModel = flowNodeLinked.getFlowModel();
        flowModel.deleteFlowNodeLinked(command.getId());
    }

    @Override
    @Transactional
    public void createFlowNodeOperator(FlowNodeOperatorCreateCmd command) {
        var flowNodeOperator = flowNodeOperatorFactory.createFlowNodeOperator(command);
        flowNodeOperatorRepository.save(flowNodeOperator);
    }

    @Override
    @Transactional
    public void editFlowNodeOperator(FlowNodeOperatorEditCmd command) {
        var flowModel = flowModelRepository.findFlowModelById(command.getFlowModelId())
                .orElseThrow(() -> new FlowModelIdNotExistException(command.getFlowModelId()));
        var flowNodeOperator = flowModel.getFlowNodeOperator(command.getId());
        var flowNode = flowNodeRepository.findFlowNodeById(command.getFlowNodeId())
                .orElseThrow(() -> new FlowNodeNotExistException(command.getFlowNodeId()));
        String operator = nonNull(command.getOperator()) ? join(command.getOperator(), ",") : null;
        String role = nonNull(command.getRole()) ? join(command.getRole(), ",") : null;
        flowNodeOperator.editFlowNodeOperator(flowModel, flowNode, operator, role, command.getEditedBy());
    }

    @Override
    @Transactional
    public void deleteFlowNodeOperator(FlowNodeOperatorDeleteCmd command) {
        var flowNodeOperator = flowNodeOperatorRepository.findFlowNodeOperatorById(command.getId())
                .orElseThrow(() -> new FlowNodeOperatorNotExistException(command.getId()));
        var flowModel = flowNodeOperator.getFlowModel();
        flowModel.deleteFlowNodeOperator(flowNodeOperator.getId());
    }
}
