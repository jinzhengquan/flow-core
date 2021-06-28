package cn.flow.engine.repository;

import cn.flow.engine.model.FlowDeployNodeLinked;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowDeployNodeLinkedRepository extends CrudRepository<FlowDeployNodeLinked, String> {

    FlowDeployNodeLinked findByFlowDeployModelIdAndStartNodeId(String flowDeployModelId, String startNodeId);
}
