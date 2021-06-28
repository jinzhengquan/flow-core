package cn.flow.engine.repository;

import cn.flow.engine.model.FlowDeployModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowDeployModelRepository extends CrudRepository<FlowDeployModel, String> {

    List<FlowDeployModel> findFlowDeployModelByFlowModelIdIn(List<String> flowModelIds);

}
