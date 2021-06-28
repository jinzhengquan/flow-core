package cn.flow.engine.repository;

import cn.flow.engine.exception.FlowCategoryParentIdNotExistException;
import cn.flow.engine.model.FlowCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static java.util.Objects.nonNull;

@Repository
public interface FlowCategoryRepository extends CrudRepository<FlowCategory, String> {

    boolean existsByCategoryName(String categoryName);

    Page<FlowCategory> findAll(Pageable pageable);

    Optional<FlowCategory> findFlowCategoryById(String id);

    default FlowCategory findParentId(String parentId) {
        if (nonNull(parentId)) {
            return findById(parentId)
                    .orElseThrow(() -> new FlowCategoryParentIdNotExistException(parentId));
        }
        return null;
    }
}
