package cn.flow.engine.repository;

import cn.flow.engine.model.FlowTask;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowTaskRepository extends CrudRepository<FlowTask, String> {

    List<FlowTask> findByFlowNodeIdInAndFlowOperatorIsNull(List<String> flowNodeIds);

    List<FlowTask> findFlowNodeProcessByFlowOperator(String flowOperator);

//    List<FlowNodeProcess> findFlowNodeProcessByFlowOperatorAndFlowNodeStatus_Save(String flowOperator);

    //    @Query(nativeQuery = true, name = "select t.id, t.flow_instance_id, t.started_time, t.flow_deploy_model_id from flow_node_process t " +
//            " where t.flow_operator =: flowOperator " +
//            "   and t.flow_node_status = 2" +
//            "   and t.flow_instance_id not in (" +
//            "        select id from flow_instance f " +
//            "         where f.flow_status != 1" +
//            ")")
    @Query("from FlowTask")
    List<FlowTask> findAlreadyFlow(String flowOperator);

    //    @Query(nativeQuery = true, name = "select t.id, t.flow_instance_id, t.started_time, t.flow_deploy_model_id from flow_node_process t " +
//            " where t.flow_operator =: flowOperator " +
//            "   and t.flow_node_status = 2" +
//            "   and t.flow_instance_id not in (" +
//            "        select id from flow_instance f " +
//            "         where f.flow_status = 1" +
//            ")")
    @Query("from FlowTask")
    List<FlowTask> findEndFlow(String flowOperator);

}
