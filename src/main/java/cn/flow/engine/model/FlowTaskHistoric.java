package cn.flow.engine.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import cn.flow.core.enums.FlowNodeStatus;
import cn.flow.core.utils.IdGenerateUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "flow_task_historic")
public class FlowTaskHistoric {
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

    @Column(nullable = false)
    private OffsetDateTime endTime;

    @Column(nullable = false)
    private String flowOperator;

    @Column(nullable = false)
    private FlowNodeStatus flowNodeStatus;

    public FlowTaskHistoric(String flowInstanceId,
                            String flowDeployModelId,
                            String flowNodeId,
                            String flowOperator,
                            FlowNodeStatus flowNodeStatus,
                            OffsetDateTime startedTime,
                            OffsetDateTime endTime) {
        this.id = IdGenerateUtil.generate();
        this.flowInstanceId = flowInstanceId;
        this.flowDeployModelId = flowDeployModelId;
        this.flowNodeId = flowNodeId;
        this.flowOperator = flowOperator;
        this.flowNodeStatus = flowNodeStatus;
        this.startedTime = startedTime;
        this.endTime = endTime;
    }
}
