package cn.flow.engine.repository;

import cn.flow.engine.model.FlowTaskHistoric;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowTaskHistoricRepository extends CrudRepository<FlowTaskHistoric, String> {

}
