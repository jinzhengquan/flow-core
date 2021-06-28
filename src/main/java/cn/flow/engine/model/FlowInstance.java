package cn.flow.engine.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import cn.flow.core.enums.FlowStatus;
import cn.flow.core.utils.IdGenerateUtil;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@RequiredArgsConstructor
@Table(name = "flow_instance")
public class FlowInstance {
    @Id
    @Getter
    private String id;

    @Column(nullable = false)
    private String flowDeployModelId;

    @Column(nullable = false)
    private FlowStatus flowStatus;

    @Getter
    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @Column(nullable = false)
    private String createdBy;

    private OffsetDateTime endAt;

    public FlowInstance(String flowDeployModelId, String createdBy) {
        this.id = IdGenerateUtil.generate();
        this.flowDeployModelId = flowDeployModelId;
        this.createdBy = createdBy;
        this.flowStatus = FlowStatus.START;
        this.createdAt = OffsetDateTime.now();
    }

    public void setFlowInstanceEnd() {
        this.flowStatus = FlowStatus.START;
        this.endAt = OffsetDateTime.now();
    }
}
