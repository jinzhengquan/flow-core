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
@Table(name = "flow_node")
public class FlowNode {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Getter
    @Column(unique = true, nullable = false)
    private String nodeName;

    @Getter
    @Column(nullable = false)
    private FlowNodeType nodeType;

    @Getter
    @ManyToOne
    @JoinColumn(name = "flow_model_id", referencedColumnName = "id")
    private FlowModel flowModel;

    @Getter
    @Column(nullable = false)
    private String flowTitle;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private OffsetDateTime lastModifiedAt;

    @Column(nullable = false)
    private String lastModifiedBy;

    public FlowNode(String nodeName, FlowNodeType nodeType, FlowModel flowModel, String createdBy) {
        this.nodeName = nodeName;
        this.nodeType = nodeType;
        this.flowModel = flowModel;
        this.flowTitle = flowModel.getFlowModelName();
        this.createdAt = OffsetDateTime.now();
        this.createdBy = createdBy;
        this.lastModifiedAt = OffsetDateTime.now();
        this.lastModifiedBy = createdBy;
    }

    public void editNode(String nodeName, String editedBy) {
        this.nodeName = nodeName;
        this.lastModifiedBy = editedBy;
        this.lastModifiedAt = OffsetDateTime.now();
    }

}
