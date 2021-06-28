package cn.flow.engine.service;

import cn.flow.engine.exception.FlowDeployNodeNotExistException;
import lombok.RequiredArgsConstructor;
import cn.flow.engine.exception.FlowDeployNodeNotExistStartNodeException;
import cn.flow.engine.model.FlowDeployNode;
import cn.flow.engine.repository.FlowDeployNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowDeployNodeService {
    private final FlowDeployNodeRepository flowDeployNodeRepository;

    public FlowDeployNode getFlowStartNode(String flowDeployModelId) {
        return flowDeployNodeRepository.findFlowStartNode(flowDeployModelId)
                .orElseThrow(() -> new FlowDeployNodeNotExistStartNodeException(flowDeployModelId));
    }

    public FlowDeployNode getFlowDeployNodeById(String flowDeployNodeId) {
        return flowDeployNodeRepository.findById(flowDeployNodeId)
                .orElseThrow(() -> new FlowDeployNodeNotExistException(flowDeployNodeId));
    }

    public FlowDeployNode getFlowEndNode(String flowDeployModelId) {
        return flowDeployNodeRepository.findFlowStartNode(flowDeployModelId)
                .orElseThrow(() -> new FlowDeployNodeNotExistStartNodeException(flowDeployModelId));
    }

}
