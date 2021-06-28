package cn.flow.engine.model;

import lombok.Getter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FlowDeployNodeLinkedPk implements Serializable {

    @Getter
    private String startNodeId;

    @Getter
    private String endNodeId;

    @Getter
    private String flowDeployModelId;

    public FlowDeployNodeLinkedPk() {

    }

    public FlowDeployNodeLinkedPk(String startNodeId, String endNodeId,String flowDeployModelId) {
        this.startNodeId = startNodeId;
        this.endNodeId = endNodeId;
        this.flowDeployModelId = flowDeployModelId;
    }
}
