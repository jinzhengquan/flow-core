package cn.flow.engine.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Entity
@RequiredArgsConstructor
@Table(name = "flow_deploy_node_linked")
@IdClass(FlowDeployNodeLinkedPk.class)
public class FlowDeployNodeLinked implements Serializable {

    @Id
    @Column(nullable = false)
    private String startNodeId;

    @Id
    @Getter
    @Column(nullable = false)
    private String endNodeId;

    @Id
    private String flowDeployModelId;

    @Column(nullable = false)
    private OffsetDateTime deployedAt;

    @Column(nullable = false)
    private String deployedBy;

    public FlowDeployNodeLinked(String startNodeId,
                                String endNodeId,
                                String flowDeployModelId,
                                String createdBy) {
        this.startNodeId = startNodeId;
        this.endNodeId = endNodeId;
        this.flowDeployModelId = flowDeployModelId;
        this.deployedBy = createdBy;
        this.deployedAt = OffsetDateTime.now();
    }

}
