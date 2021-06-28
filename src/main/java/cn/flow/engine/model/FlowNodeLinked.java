package cn.flow.engine.model;

import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

/**
 * 节点关系
 */
@Entity
@RequiredArgsConstructor
@Table(name = "flow_node_linked")
public class FlowNodeLinked {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @ManyToOne
    @JoinColumn(name = "start_node_id", referencedColumnName = "id")
    private FlowNode startNode;

    @ManyToOne
    @JoinColumn(name = "end_node_id", referencedColumnName = "id")
    private FlowNode endNode;

    @ManyToOne
    @JoinColumn(name = "flow_model_id", referencedColumnName = "id")
    private FlowModel flowModel;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private OffsetDateTime lastModifiedAt;

    @Column(nullable = false)
    private String lastModifiedBy;

    public String getId() {
        return id;
    }

    public FlowModel getFlowModel() {
        return flowModel;
    }

    public FlowNode getStartNode() {
        return startNode;
    }

    public FlowNode getEndNode() {
        return endNode;
    }

    public FlowNodeLinked(FlowNode startNode, FlowNode endNode, FlowModel flowModel, String createdBy) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.flowModel = flowModel;
        this.createdAt = OffsetDateTime.now();
        this.createdBy = createdBy;
        this.lastModifiedAt = OffsetDateTime.now();
        this.lastModifiedBy = createdBy;
    }

    public void editNodeLinked(FlowNode beginNode, FlowNode endNode, String editedBy) {
        this.startNode = beginNode;
        this.endNode = endNode;
        this.lastModifiedAt = OffsetDateTime.now();
        this.lastModifiedBy = editedBy;
    }
}
