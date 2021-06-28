package cn.flow.engine.model;

import cn.flow.core.enums.FlowNodeType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

/**
 * 流程节点
 */
@Entity
@RequiredArgsConstructor
@Table(name = "flow_deploy_node")
public class FlowDeployNode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Getter
    @Column(unique = true, nullable = false)
    private String nodeId;

    @Getter
    @Column(unique = true, nullable = false)
    private String nodeName;

    @Getter
    @Column(nullable = false)
    private FlowNodeType nodeType;

    @Getter
    @Column(nullable = false)
    private String flowTitle;

    @Getter
    private String flowDeployModelId;

    @Column(nullable = false)
    private OffsetDateTime deployedAt;

    @Column(nullable = false)
    private String deployedBy;

    public FlowDeployNode(String nodeId,
                          String nodeName,
                          FlowNodeType nodeType,
                          String flowDeployModelId,
                          String flowTitle,
                          String createdBy) {
        this.nodeId = nodeId;
        this.nodeName = nodeName;
        this.nodeType = nodeType;
        this.flowTitle = flowTitle;
        this.flowDeployModelId = flowDeployModelId;
        this.deployedAt = OffsetDateTime.now();
        this.deployedBy = createdBy;
    }

}
