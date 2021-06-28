package cn.flow.engine.service;

import cn.flow.engine.application.command.FlowModelEditCmd;
import cn.flow.engine.factory.*;
import cn.flow.engine.model.*;
import cn.flow.engine.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.var;
import cn.flow.engine.application.command.FlowModelCreateCmd;
import cn.flow.engine.exception.FlowCategoryIdNotExistException;
import org.flow.engine.factory.*;
import org.flow.engine.model.*;
import org.flow.engine.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.flow.engine.factory.*;
import test.flow.engine.model.*;
import test.flow.engine.repository.*;

import java.util.List;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowModelService {
    private final FlowCategoryRepository flowCategoryRepository;
    private final FlowModelRepository flowModelRepository;
    private final FlowNodeLinkedDeployFactory flowNodeLinkedDeployFactory;
    private final FlowDeployNodeLinkedRepository flowDeployNodeLinkedRepository;
    private final FlowModelDeployFactory flowModelDeployFactory;
    private final FlowDeployModelRepository flowDeployModelRepository;
    private final FlowNodeDeployFactory flowNodeDeployFactory;
    private final FlowDeployNodeRepository flowDeployNodeRepository;
    private final FlowDeployNodeOperatorFactory flowDeployNodeOperatorFactory;
    private final FlowDeployNodeOperatorRepository flowDeployNodeOperatorRepository;

    public void createFlowModel(FlowModelCreateCmd command) {
        FlowCategory flowCategory = flowCategoryRepository.findById(command.getFlowCategoryId())
                .orElseThrow(() -> new FlowCategoryIdNotExistException(command.getFlowCategoryId()));
        FlowModelFactory flowModelFactory = new FlowModelFactory();
        flowModelRepository.save(flowModelFactory.createFlowModel(command, flowCategory));
    }

    public void deleteFlowModel(FlowModel flowModel) {
        flowModelRepository.deleteById(flowModel.getId());
    }

    public void editFlowModel(FlowModel flowModel, FlowModelEditCmd command) {
        var flowCategory = flowCategoryRepository.findById(command.getFlowCategoryId())
                .orElseThrow(() -> new FlowCategoryIdNotExistException(command.getFlowCategoryId()));
        flowModel.editFlowModel(command.getFlowModelName(), flowCategory, command.getEditedBy());
    }

    @Transactional
    public void deployFlowModel(FlowModel flowModel, String createdBy) {
        flowModel.deployFlow(createdBy);
        var flowDeployModel = flowModelDeploy(flowModel, createdBy);
        flowNodeDeploy(flowModel.listFlowNode(), flowDeployModel, createdBy);
        flowNodeLinkedDeploy(flowModel.listFlowNodeLinked(), flowDeployModel, createdBy);
        flowNodeOperatorDeploy(flowModel.listFlowNodeOperators(), flowDeployModel, createdBy);
    }

    private FlowDeployModel flowModelDeploy(FlowModel flowModel, String createdBy) {
        var flowDeployModel = flowModelDeployFactory.createFlowModelDeploy(flowModel, createdBy);
        flowDeployModelRepository.save(flowDeployModel);
        return flowDeployModel;
    }

    private void flowNodeDeploy(List<FlowNode> flowNodes, FlowDeployModel flowDeployModel, String createdBy) {
        var flowDeployNodes = flowNodeDeployFactory.createFlowNodeDeploy(flowNodes,
                flowDeployModel,
                createdBy);
        flowDeployNodeRepository.saveAll(flowDeployNodes);
    }

    private void flowNodeLinkedDeploy(List<FlowNodeLinked> flowNodeLinked, FlowDeployModel flowDeployModel, String createdBy) {
        var flowDeployNodeLinked = flowNodeLinkedDeployFactory
                .createFlowNodeLinkedDeploy(flowNodeLinked, flowDeployModel, createdBy);
        flowDeployNodeLinkedRepository.saveAll(flowDeployNodeLinked);
    }

    private void flowNodeOperatorDeploy(List<FlowNodeOperator> flowNodeOperators, FlowDeployModel flowDeployModel, String createdBy) {
        var deployNodeOperators = flowDeployNodeOperatorFactory
                .createFlowDeployNodeOperatorFactory(flowNodeOperators, flowDeployModel.getId(), createdBy);
        flowDeployNodeOperatorRepository.saveAll(deployNodeOperators);
    }
}
