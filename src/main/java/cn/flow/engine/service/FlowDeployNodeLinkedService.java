package cn.flow.engine.service;

import cn.flow.engine.factory.FlowNodeLinkedDeployFactory;
import lombok.RequiredArgsConstructor;
import cn.flow.engine.model.FlowDeployNodeLinked;
import cn.flow.engine.repository.FlowDeployNodeLinkedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowDeployNodeLinkedService {
    private final FlowNodeLinkedDeployFactory flowNodeLinkedDeployFactory;
    private final FlowDeployNodeLinkedRepository flowDeployNodeLinkedRepository;

    public FlowDeployNodeLinked getByFlowDeployModelIdAndStartNodeId(String flowDeployModelId, String flowNodeId){
        return flowDeployNodeLinkedRepository
                .findByFlowDeployModelIdAndStartNodeId(flowDeployModelId, flowNodeId);
    }

}
