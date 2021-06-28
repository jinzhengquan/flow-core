package cn.flow.engine.repository;

import cn.flow.engine.model.FlowNode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlowNodeRepository extends CrudRepository<FlowNode, String> {

    boolean existsByNodeNameAndFlowModel_Id(String nodeName, String flowModelId);

    Optional<FlowNode> findFlowNodeById(String id);
}
