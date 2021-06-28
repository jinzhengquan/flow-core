package cn.flow.engine.model;

import cn.flow.core.enums.FlowNodeType;
import cn.flow.engine.exception.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.flow.engine.exception.*;
import test.flow.engine.exception.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.unmodifiableList;

/**
 * 流程定义
 */
@Entity
@RequiredArgsConstructor
@Table(name = "flow_model")
public class FlowModel {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Getter
    @Column(unique = true, nullable = false)
    private String flowModelName;

    @Getter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private FlowCategory flowCategory;

    @Getter
    @Column(nullable = false)
    private int flowModelVersion;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @Getter
    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private OffsetDateTime lastModifiedAt;

    @Column(nullable = false)
    private String lastModifiedBy;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "flowModel")
    @OrderBy("createdAt asc")
    private List<FlowNode> flowNodes;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "flowModel")
    @OrderBy("createdAt asc")
    private List<FlowNodeLinked> flowNodeLinked;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "flowModel")
    @OrderBy("createdAt asc")
    private List<FlowNodeOperator> flowNodeOperators;

    public FlowModel(String flowModelName, FlowCategory flowCategory, String createdBy) {
        this.flowModelName = flowModelName;
        this.flowCategory = flowCategory;
        this.flowModelVersion = 0;
        this.createdAt = OffsetDateTime.now();
        this.createdBy = createdBy;
        this.lastModifiedAt = OffsetDateTime.now();
        this.lastModifiedBy = createdBy;
    }

    public List<FlowNode> listFlowNode() {
        return unmodifiableList(this.flowNodes);
    }

    public void editFlowModel(String flowName, FlowCategory flowCategory, String editedBy) {
        this.flowModelName = flowName;
        this.flowCategory = flowCategory;
        this.lastModifiedAt = OffsetDateTime.now();
        this.lastModifiedBy = editedBy;
    }

    public void deployFlow(String editedBy) {
        this.flowModelVersion++;
        this.lastModifiedBy = editedBy;
        this.lastModifiedAt = OffsetDateTime.now();

    }

    public void addFlowNode(FlowNode flowNode) {
        listFlowNode().forEach(node -> {
            if (FlowNodeType.START_NODE.equals(flowNode.getNodeType())
                    && FlowNodeType.START_NODE.equals(node.getNodeType())) {
                throw new DuplicatedStartFlowNodeException();
            } else if (FlowNodeType.END_NODE.equals(flowNode.getNodeType())
                    && (FlowNodeType.END_NODE.equals(node.getNodeType()))) {
                throw new DuplicatedEndFlowNodeException();
            }
        });
        this.flowNodes.add(flowNode);
    }

    public FlowNode getFlowNode(String flowNodeId) {
        return listFlowNode().stream().filter(flowNode -> Objects.equals(flowNode.getId(), flowNodeId))
                .findFirst().orElseThrow(() -> new FlowNodeNotExistException(flowNodeId));
    }

    public void deleteFlowNode(String flowNodeId) {
        listFlowNode().stream()
                .filter(node -> Objects.equals(node.getId(), flowNodeId))
                .findFirst().orElseThrow(() -> new FlowNodeNotExistException(flowNodeId));
        this.flowNodes.removeIf(node -> Objects.equals(node.getId(), flowNodeId));
    }

    public List<FlowNodeLinked> listFlowNodeLinked() {
        return unmodifiableList(this.flowNodeLinked);
    }

    public void addFlowNodeLinked(FlowNodeLinked flowNodeLinked) {
        this.flowNodeLinked.add(flowNodeLinked);
    }

    public FlowNodeLinked getFlowNodeLinked(String flowNodeLinkedId) {
        return listFlowNodeLinked().stream()
                .filter(flowNodeLinked -> Objects.equals(flowNodeLinked.getId(), flowNodeLinkedId))
                .findFirst().orElseThrow(() -> new FlowNodeLinkedNotExistException(flowNodeLinkedId));
    }

    public void deleteFlowNodeLinked(String flowNodeLinkedId) {
        listFlowNodeLinked().stream()
                .filter(nodeLinked -> Objects.equals(nodeLinked.getId(), flowNodeLinkedId))
                .findFirst().orElseThrow(() -> new FlowNodeLinkedNotExistException(flowNodeLinkedId));
        this.flowNodeLinked.removeIf(node -> Objects.equals(node.getId(), flowNodeLinkedId));
    }

    public List<FlowNodeOperator> listFlowNodeOperators() {
        return unmodifiableList(this.flowNodeOperators);
    }

    public void addFlowNodeOperator(FlowNodeOperator flowNodeOperator) {
        this.flowNodeOperators.add(flowNodeOperator);
    }

    public FlowNodeOperator getFlowNodeOperator(String flowNodeOperatorId) {
        return listFlowNodeOperators().stream()
                .filter(flowNodeOperator -> Objects.equals(flowNodeOperator.getId(), flowNodeOperatorId))
                .findFirst().orElseThrow(() -> new FlowNodeOperatorNotExistException(flowNodeOperatorId));
    }

    public void deleteFlowNodeOperator(String flowNodeOperatorId) {
        listFlowNodeOperators().stream()
                .filter(nodeOperator -> Objects.equals(nodeOperator.getId(), flowNodeOperatorId))
                .findFirst().orElseThrow(() -> new FlowNodeOperatorNotExistException(flowNodeOperatorId));
        this.flowNodeLinked.removeIf(node -> Objects.equals(node.getId(), flowNodeOperatorId));
    }
}
