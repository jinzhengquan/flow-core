package cn.flow.query.mapper;

import cn.flow.engine.exception.FlowDeployNodeNotExistStartNodeException;
import cn.flow.engine.model.FlowTask;
import cn.flow.engine.repository.FlowDeployNodeRepository;
import lombok.RequiredArgsConstructor;
import cn.flow.engine.model.FlowDeployNode;
import cn.flow.query.view.FlowDealWithBriefView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowDealWithMapper {
    private final FlowDeployNodeRepository flowDeployNodeRepository;

    public List<FlowDealWithBriefView> createFlowDealWith(List<FlowTask> flowNodeProcesses) {
        return flowNodeProcesses.stream().map(this::createFlowDealWith).collect(Collectors.toList());
    }

    private FlowDealWithBriefView createFlowDealWith(FlowTask flowNodeProcess) {
        FlowDeployNode flowDeployNode = flowDeployNodeRepository.findByNodeIdAndFlowDeployModelId(
                flowNodeProcess.getFlowNodeId(),
                flowNodeProcess.getFlowDeployModelId())
                .orElseThrow(()->new FlowDeployNodeNotExistStartNodeException(flowNodeProcess.getFlowNodeId()));
        return new FlowDealWithBriefView(
                flowNodeProcess.getId(),
                flowDeployNode.getFlowTitle(),
                flowNodeProcess.getStartedTime());
    }

}
