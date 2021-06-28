package cn.flow.engine.factory;

import cn.flow.engine.model.FlowCategory;
import cn.flow.engine.repository.FlowCategoryRepository;
import lombok.RequiredArgsConstructor;
import cn.flow.engine.application.command.FlowCategoryCreateCmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowCategoryFactory {
    private final FlowCategoryRepository flowCategoryRepository;

    public FlowCategory createFlowCategory(FlowCategoryCreateCmd command) {
        FlowCategory parentFlowCategory = flowCategoryRepository.findParentId(command.getParentId());
        return new FlowCategory(command.getCategoryName(),
                parentFlowCategory,
                command.getCreatedBy());
    }

}
