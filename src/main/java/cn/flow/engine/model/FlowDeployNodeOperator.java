package cn.flow.engine.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@RequiredArgsConstructor
@Table(name = "flow_deploy_node_operator")
public class FlowDeployNodeOperator {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Getter
    private String flowModelId;

    @Getter
    private String flowNodeId;

    @Getter
    @Column(nullable = false)
    private String operator;

    @Getter
    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String flowDeployModelId;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @Column(nullable = false)
    private String createdBy;

    public FlowDeployNodeOperator(String flowModelId,
                                  String flowNodeId,
                                  String operator,
                                  String role,
                                  String flowDeployModelId,
                                  String createdBy) {
        this.flowModelId = flowModelId;
        this.flowNodeId = flowNodeId;
        this.operator = operator;
        this.role = role;
        this.flowDeployModelId = flowDeployModelId;
        this.createdAt = OffsetDateTime.now();
        this.createdBy = createdBy;
    }

}
