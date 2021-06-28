package cn.flow.query.view;

import cn.flow.core.enums.FlowNodeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class FlowNodeBriefView {
    private String flowNodeId;

    private String nodeName;

    private FlowNodeType nodeType;

    private String flowDeployModelId;
}
