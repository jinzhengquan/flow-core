package cn.flow.engine.factory;

import cn.flow.engine.model.FlowModel;
import cn.flow.engine.model.FlowNode;
import cn.flow.engine.model.FlowNodeLinked;
import org.springframework.stereotype.Component;

@Component
public class FlowNodeLinkedFactory {

    public FlowNodeLinked createFlowNodeLinked(FlowNode startFlowNode,
                                               FlowNode endFlowNode,
                                               FlowModel flowModel,
                                               String createdBy) {
        return new FlowNodeLinked(startFlowNode,
                endFlowNode,
                flowModel,
                createdBy);
    }
}
