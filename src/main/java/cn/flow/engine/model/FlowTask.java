package cn.flow.engine.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import cn.flow.core.enums.FlowNodeStatus;
import cn.flow.core.utils.IdGenerateUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;

@Builder
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "flow_task")
public class FlowTask {
    @Id
    @Getter
    private String id;

    @Getter
    @Column
    private String flowInstanceId;

    @Getter
    @Column(nullable = false)
    private OffsetDateTime startedTime;

    @Getter
    @Column(nullable = false)
    private String flowDeployModelId;

    @Getter
    @Column(nullable = false)
    private String flowNodeId;

    @Getter
    @Column(nullable = false)
    private OffsetDateTime endTime;

    @Getter
    private String flowOperator;

    @Getter
    @Column(nullable = false)
    private FlowNodeStatus flowNodeStatus;

    public FlowTask(String flowInstanceId,
                    String flowDeployModelId,
                    String flowNodeId,
                    String flowOperator,
                    FlowNodeStatus flowNodeStatus) {
        this.id = IdGenerateUtil.generate();
        this.flowInstanceId = flowInstanceId;
        this.flowDeployModelId = flowDeployModelId;
        this.flowNodeId = flowNodeId;
        this.flowOperator = flowOperator;
        this.flowNodeStatus = flowNodeStatus;
        this.startedTime = OffsetDateTime.now();
        this.endTime = OffsetDateTime.now();
    }

    public FlowTask(String flowDeployModelId,
                    String flowNodeId,
                    String flowOperator,
                    FlowNodeStatus flowNodeStatus) {
        this.id = IdGenerateUtil.generate();
        this.flowDeployModelId = flowDeployModelId;
        this.flowNodeId = flowNodeId;
        this.flowOperator = flowOperator;
        this.flowNodeStatus = flowNodeStatus;
        this.startedTime = OffsetDateTime.now();
        this.endTime = OffsetDateTime.now();
    }

    public void editFlowTask(String flowInstanceId,
                             String flowOperator,
                             FlowNodeStatus flowNodeStatus) {
        this.flowInstanceId = flowInstanceId;
        this.flowOperator = flowOperator;
        this.flowNodeStatus = flowNodeStatus;
        this.endTime = OffsetDateTime.now();
    }

    public void editFlowTask(String flowOperator,
                             FlowNodeStatus flowNodeStatus) {
        this.flowOperator = flowOperator;
        this.flowNodeStatus = flowNodeStatus;
        this.endTime = OffsetDateTime.now();
    }
}
