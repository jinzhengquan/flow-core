package cn.flow.engine.repository;

import cn.flow.engine.model.FlowNodeLinked;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FlowNodeLinkedRepository extends CrudRepository<FlowNodeLinked, String> {

    Optional<FlowNodeLinked> findFlowNodeLinkedById(String id);

}
