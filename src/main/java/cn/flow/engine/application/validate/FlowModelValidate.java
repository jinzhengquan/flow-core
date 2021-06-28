package cn.flow.engine.application.validate;

import cn.flow.core.specification.Pair;
import cn.flow.engine.application.spec.FlowModelNameEditSpec;
import lombok.RequiredArgsConstructor;
import cn.flow.engine.application.command.FlowModelCreateCmd;
import cn.flow.engine.application.command.FlowModelEditCmd;
import cn.flow.engine.application.spec.FlowModelNameCreateSpec;
import cn.flow.engine.model.FlowModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowModelValidate {
    private final FlowModelNameCreateSpec flowModelNameCreateSpec;
    private final FlowModelNameEditSpec flowModelNameEditSpec;

    public void validateCreateCommand(FlowModelCreateCmd command) {
        flowModelNameCreateSpec.verify(command.getFlowModelName());
    }

    public void validateEditCommand(String flowName, FlowModelEditCmd command) {
        flowModelNameEditSpec.verify(Pair.of(flowName, command.getFlowModelName()));
    }

    public void validateDeleteCommand(FlowModel flowModel) {
        //todo 存在未归档的流程实例不能删
    }
}
