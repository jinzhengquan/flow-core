package cn.flow.query.mapper;

import cn.flow.engine.model.FlowTask;
import cn.flow.query.view.FlowTaskBriefView;
import org.springframework.stereotype.Component;

@Component
public class FlowTaskMapper {

    public FlowTaskBriefView createFlowTaskBriefView(FlowTask flowTask) {
        return new FlowTaskBriefView(flowTask.getId());
    }
}
