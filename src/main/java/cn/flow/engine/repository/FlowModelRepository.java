package cn.flow.engine.repository;

import cn.flow.engine.model.FlowModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FlowModelRepository extends CrudRepository<FlowModel, String> {

    boolean existsByFlowModelName(String flowName);

    Optional<FlowModel> findFlowModelById(String id);
}
