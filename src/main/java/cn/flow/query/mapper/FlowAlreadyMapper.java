package cn.flow.query.mapper;

import cn.flow.engine.model.FlowTask;
import cn.flow.engine.repository.FlowDeployNodeRepository;
import lombok.RequiredArgsConstructor;
import cn.flow.engine.exception.FlowDeployNodeNotExistStartNodeException;
import cn.flow.engine.model.FlowDeployNode;
import cn.flow.query.view.FlowAlreadyBriefView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowAlreadyMapper {
    private final FlowDeployNodeRepository flowDeployNodeRepository;

    public List<FlowAlreadyBriefView> createAlreadyFlow(List<FlowTask> flowNodeProcesses) {
        return flowNodeProcesses.stream().map(this::createAlreadyFlow).collect(Collectors.toList());
    }

    private FlowAlreadyBriefView createAlreadyFlow(FlowTask flowNodeProcess) {
        FlowDeployNode flowDeployNode = flowDeployNodeRepository.findByNodeIdAndFlowDeployModelId(
                flowNodeProcess.getFlowNodeId(),
                flowNodeProcess.getFlowDeployModelId())
                .orElseThrow(()->new FlowDeployNodeNotExistStartNodeException(flowNodeProcess.getFlowNodeId()));
        return new FlowAlreadyBriefView(
                flowNodeProcess.getId(),
                flowDeployNode.getFlowTitle(),
                flowNodeProcess.getStartedTime());
    }

}
