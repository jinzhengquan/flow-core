package cn.flow.engine.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

/**
 * 流程发布
 */
@Entity
@RequiredArgsConstructor
@Table(name = "flow_deploy_model")
public class FlowDeployModel {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Getter
    @Column(nullable = false)
    private String flowModelId;

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
    private OffsetDateTime deployedAt;

    @Column(nullable = false)
    private String deployedBy;

    public FlowDeployModel(String flowModelId,
                           String flowModelName,
                           FlowCategory flowCategory,
                           int flowModelVersion,
                           String createdBy) {
        this.flowModelId = flowModelId;
        this.flowModelName = flowModelName;
        this.flowCategory = flowCategory;
        this.flowModelVersion = flowModelVersion;
        this.deployedAt = OffsetDateTime.now();
        this.deployedBy = createdBy;
    }
}
