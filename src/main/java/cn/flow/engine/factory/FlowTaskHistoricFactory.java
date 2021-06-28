package cn.flow.engine.factory;

import cn.flow.engine.model.FlowTask;
import cn.flow.engine.model.FlowTaskHistoric;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowTaskHistoricFactory {

    private final FlowTask flowTask;

    public FlowTaskHistoric createFlowNodeProcessHis() {
        return new FlowTaskHistoric(flowTask.getFlowInstanceId(),
                flowTask.getFlowDeployModelId(),
                flowTask.getFlowNodeId(),
                flowTask.getFlowOperator(),
                flowTask.getFlowNodeStatus(),
                flowTask.getStartedTime(),
                flowTask.getEndTime());
    }

}
