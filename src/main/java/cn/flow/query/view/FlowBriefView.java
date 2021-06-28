package cn.flow.query.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户能启动哪些流程
 */
@Data
@AllArgsConstructor
public class FlowBriefView {
    private String flowCategoryName;
    private List<FlowDeployInfo> flowDeployInfos = new ArrayList<>();

    @Data
    @AllArgsConstructor
    @RequiredArgsConstructor
    private class FlowDeployInfo {
        private String id;
        private String Name;
    }

    public FlowBriefView(String flowCategoryName, String flowModelId, String flowModelName) {
        FlowDeployInfo flowDeployInfo = new FlowDeployInfo(flowModelId, flowModelName);
        this.flowCategoryName = flowCategoryName;
        flowDeployInfos.add(flowDeployInfo);
    }
}
