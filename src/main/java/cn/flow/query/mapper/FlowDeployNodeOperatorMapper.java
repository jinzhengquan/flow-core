package cn.flow.query.mapper;

import cn.flow.engine.model.FlowDeployModel;
import cn.flow.query.view.FlowBriefView;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlowDeployNodeOperatorMapper {

    public List<FlowBriefView> flowNodeOperatorToBriefView(Collection<FlowDeployModel> flowModels) {
        return flowModels.stream().map(this::flowModelToBriefView).collect(Collectors.toList());
    }

    private FlowBriefView flowModelToBriefView(FlowDeployModel flowModel) {
        return new FlowBriefView(flowModel.getFlowCategory().getCategoryName(),
                flowModel.getId(),
                flowModel.getFlowModelName());
    }
}
