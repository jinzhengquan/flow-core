package cn.flow.engine.repository;

import cn.flow.engine.model.FlowDeployNode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlowDeployNodeRepository extends CrudRepository<FlowDeployNode, String> {

    @Query("from FlowDeployNode t where t.flowDeployModelId = :flowDeployModelId and t.nodeType = '0'")
    Optional<FlowDeployNode> findByFlowDeployModelId(@Param("flowDeployModelId") String flowDeployModelId);

    Optional<FlowDeployNode> findByNodeIdAndFlowDeployModelId(String nodeId, String deployModelId);

    @Query("from FlowDeployNode t where t.flowDeployModelId = :flowDeployModelId and t.nodeType = '0'")
    Optional<FlowDeployNode> findFlowStartNode(@Param("flowDeployModelId") String flowDeployModelId);

}
