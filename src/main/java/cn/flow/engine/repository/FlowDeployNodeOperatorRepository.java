package cn.flow.engine.repository;

import cn.flow.engine.model.FlowDeployNodeOperator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowDeployNodeOperatorRepository extends CrudRepository<FlowDeployNodeOperator, String> {


    List<FlowDeployNodeOperator> findFlowDeployNodeOperatorByOperatorContainingOrRoleContaining(String operator, String role);
}
