package cn.flow.engine.repository;

import cn.flow.engine.model.FlowNodeOperator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FlowNodeOperatorRepository extends CrudRepository<FlowNodeOperator, String> {

    Optional<FlowNodeOperator> findFlowNodeOperatorById(String id);
}
