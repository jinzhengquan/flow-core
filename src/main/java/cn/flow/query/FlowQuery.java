package cn.flow.query;

import cn.flow.engine.exception.FlowDeployModelIdNotExistException;
import cn.flow.engine.exception.FlowDeployNodeNotExistStartNodeException;
import cn.flow.engine.exception.FlowTaskNotExistException;
import cn.flow.engine.model.FlowDeployModel;
import cn.flow.engine.model.FlowDeployNode;
import cn.flow.engine.model.FlowDeployNodeOperator;
import cn.flow.engine.model.FlowTask;
import cn.flow.engine.repository.FlowDeployModelRepository;
import cn.flow.engine.repository.FlowDeployNodeOperatorRepository;
import cn.flow.engine.repository.FlowDeployNodeRepository;
import cn.flow.engine.repository.FlowTaskRepository;
import cn.flow.query.mapper.*;
import cn.flow.query.view.*;
import lombok.RequiredArgsConstructor;
import org.flow.query.mapper.*;
import org.flow.query.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.flow.query.mapper.*;
import test.flow.query.view.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowQuery {
    private final FlowDeployNodeOperatorRepository flowDeployNodeOperatorRepository;
    private final FlowDeployModelRepository flowDeployModelRepository;
    private final FlowDeployNodeOperatorMapper flowDeployNodeOperatorMapper;
    private final FlowDeployNodeRepository flowDeployNodeRepository;
    private final FlowDeployNodeMapper flowDeployNodeMapper;
    private final FlowTaskRepository flowTaskRepository;
    private final FlowDealWithMapper flowDealWithMapper;
    private final FlowTaskMapper flowTaskMapper;
    private final FlowAlreadyMapper flowAlreadyMapper;
    private final FlowEndMapper flowEndMapper;

    public List<FlowBriefView> searchStartFlowInfo(String operator, String role) {
        List<FlowDeployNodeOperator> flowDeployNodeOperators = flowDeployNodeOperatorRepository
                .findFlowDeployNodeOperatorByOperatorContainingOrRoleContaining(operator, role);

        List<String> flowModelFlowDeployNodeOperators = flowDeployNodeOperators.stream()
                .map(FlowDeployNodeOperator::getFlowModelId).collect(Collectors.toList());

        List<FlowDeployModel> flowDeployModels = flowDeployModelRepository
                .findFlowDeployModelByFlowModelIdIn(flowModelFlowDeployNodeOperators);

        Map<String, FlowDeployModel> flowDeployModelMap = flowDeployModels.parallelStream().collect(
                Collectors.groupingBy(FlowDeployModel::getFlowModelId,
                        Collectors.collectingAndThen(
                                Collectors.reducing((c1, c2)
                                        -> c1.getFlowModelVersion() > c2.getFlowModelVersion() ? c1 : c2),
                                Optional::get)));

        return flowDeployNodeOperatorMapper.flowNodeOperatorToBriefView(flowDeployModelMap.values());
    }

    public FlowNodeBriefView searchFlowStartNode(String flowDeployModelId) {
        flowDeployModelRepository.findById(flowDeployModelId)
                .orElseThrow(() -> new FlowDeployModelIdNotExistException(flowDeployModelId));
        FlowDeployNode flowStartNode = flowDeployNodeRepository
                .findByFlowDeployModelId(flowDeployModelId)
                .orElseThrow(() -> new FlowDeployNodeNotExistStartNodeException(flowDeployModelId));
        return flowDeployNodeMapper.flowDeployNodeToMapper(flowStartNode);
    }

    public List<FlowDealWithBriefView> searchDealWithFlow(String operator, String role) {
        List<FlowDeployNodeOperator> flowDeployNodeOperators = flowDeployNodeOperatorRepository
                .findFlowDeployNodeOperatorByOperatorContainingOrRoleContaining(operator, role);

        List<String> flowNodeIds = flowDeployNodeOperators.stream()
                .map(FlowDeployNodeOperator::getFlowNodeId).collect(Collectors.toList());

        List<FlowTask> flowNodeProcessArrayList = new ArrayList<>();
        List<FlowTask> flowNodeProcesses = flowTaskRepository
                .findByFlowNodeIdInAndFlowOperatorIsNull(flowNodeIds);
        flowNodeProcessArrayList.addAll(flowNodeProcesses);
        flowNodeProcesses = flowTaskRepository.findFlowNodeProcessByFlowOperator(operator);
        flowNodeProcessArrayList.addAll(flowNodeProcesses);
        return flowDealWithMapper.createFlowDealWith(flowNodeProcessArrayList);
    }

    public FlowTaskBriefView searchFlowTask(String flowTaskId) {
        FlowTask flowTask = flowTaskRepository.findById(flowTaskId)
                .orElseThrow(() -> new FlowTaskNotExistException(flowTaskId));
        //todo 分布式锁来锁住节点

        return flowTaskMapper.createFlowTaskBriefView(flowTask);
    }

    public List<FlowAlreadyBriefView> searchFlowAlreadyDeal(String operator) {
        List<FlowTask> flowNodeProcess = flowTaskRepository.findAlreadyFlow(operator);
        return flowAlreadyMapper.createAlreadyFlow(flowNodeProcess);
    }

    public List<FlowEndBriefView> searchFlowEnd(String operator) {
        List<FlowTask> flowNodeProcess = flowTaskRepository.findEndFlow(operator);
        return flowEndMapper.createEndFlow(flowNodeProcess);
    }
}
