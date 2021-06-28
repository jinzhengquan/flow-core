package cn.flow.engine.model;


import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * 流程分类
 * <p>
 * 不能使用@Data注解，one2many 会引起jpa的stack益出
 */
@Entity
@Table(name = "flow_category")
@RequiredArgsConstructor
@AllArgsConstructor
public class FlowCategory {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Getter
    @Column(unique = true, nullable = false)
    private String categoryName;

    @Getter
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private FlowCategory parentFlowCategory;

    @Getter
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "parentFlowCategory")
    private List<FlowCategory> flowCategories;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private OffsetDateTime lastModifiedAt;

    @Column(nullable = false)
    private String lastModifiedBy;

    public FlowCategory(String categoryName, FlowCategory parentFlowCategory, String createdBy) {
        this.categoryName = categoryName;
        this.parentFlowCategory = parentFlowCategory;
        this.createdAt = OffsetDateTime.now();
        this.createdBy = createdBy;
        this.lastModifiedAt = OffsetDateTime.now();
        this.lastModifiedBy = createdBy;
    }

    public void editCategory(String categoryName, FlowCategory parentFlowCategory, String editedBy) {
        this.parentFlowCategory = parentFlowCategory;
        this.categoryName = categoryName;
        this.lastModifiedBy = editedBy;
        this.lastModifiedAt = OffsetDateTime.now();
    }

}
