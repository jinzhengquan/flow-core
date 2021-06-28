package cn.flow.engine.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

/**
 * 节点操作人
 */
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "flow_node_operator")
public class FlowNodeOperator {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Getter
    @ManyToOne
    @JoinColumn(name = "flow_model_id", referencedColumnName = "id")
    private FlowModel flowModel;

    @Getter
    @ManyToOne
    @JoinColumn(name = "flow_node_id", referencedColumnName = "id")
    private FlowNode flowNode;

    @Getter
    @Column(nullable = false)
    private String operator;

    @Getter
    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private OffsetDateTime lastModifiedAt;

    @Column(nullable = false)
    private String lastModifiedBy;

    public FlowNodeOperator(FlowModel flowModel, FlowNode flowNode, String operator, String role, String createdBy) {
        this.flowModel = flowModel;
        this.flowNode = flowNode;
        this.operator = operator;
        this.role = role;
        this.createdBy = createdBy;
        this.createdAt = OffsetDateTime.now();
        this.lastModifiedAt = OffsetDateTime.now();
        this.lastModifiedBy = createdBy;
    }


    public void editFlowNodeOperator(FlowModel flowModel, FlowNode flowNode, String operator, String role, String editedBy) {
        this.flowModel = flowModel;
        this.flowNode = flowNode;
        this.operator = operator;
        this.role = role;
        this.lastModifiedAt = OffsetDateTime.now();
        this.lastModifiedBy = editedBy;
    }
}
