package cn.flow.engine.repository;

import cn.flow.engine.model.FlowInstance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowInstanceRepository extends CrudRepository<FlowInstance, String> {

    List<FlowInstance> findByIdIn(List<String> ids);
}
