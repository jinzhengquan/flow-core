package cn.flow.engine.interceptor;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CommandParam {
    private String flowDeployModelId;
    private String flowOperator;
    private String flowTaskId;
    private String flowInstanceId;

    public CommandParam(String flowTaskId, String flowDeployModelId, String flowOperator) {
        this.flowTaskId = flowTaskId;
        this.flowDeployModelId = flowDeployModelId;
        this.flowOperator = flowOperator;
    }

}
