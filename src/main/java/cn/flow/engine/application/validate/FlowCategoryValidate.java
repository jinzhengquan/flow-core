package cn.flow.engine.application.validate;

import cn.flow.core.specification.Pair;
import cn.flow.engine.application.command.FlowCategoryEditCmd;
import cn.flow.engine.application.spec.*;
import lombok.RequiredArgsConstructor;
import cn.flow.engine.application.command.FlowCategoryCreateCmd;
import org.flow.engine.application.spec.*;
import test.flow.engine.application.spec.*;
import cn.flow.engine.model.FlowCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowCategoryValidate {

    private final FlowCategoryNameCreateSpec flowCategoryNameCreateSpec;
    private final FlowCategoryNameEditSpec flowCategoryNameEditSpec;
    private final FlowCategoryParentIdNotExistSpec flowCategoryParentIdNotExistSpec;
    private final FlowSubCategoryExistSpec flowSubCategoryExistSpec;
    private final FlowCategoryIdEqParentEditSpec flowCategoryIdEqParentEditSpec;

    public void validCreateCommand(FlowCategoryCreateCmd command) {
        flowCategoryNameCreateSpec.verify(command.getCategoryName());
        flowCategoryParentIdNotExistSpec.verify(command.getParentId());
    }

    public void validDeleteCommand(FlowCategory flowCategory) {
        //存在子类不能删
        flowSubCategoryExistSpec.verify(flowCategory);
        //todo 关联了流程不能删
    }

    public void validEditCommand(String categoryName, FlowCategoryEditCmd command) {
        flowCategoryIdEqParentEditSpec.verify(Pair.of(command.getId(), command.getParentId()));
        flowCategoryParentIdNotExistSpec.verify(command.getParentId());
        flowCategoryNameEditSpec.verify(Pair.of(categoryName, command.getCategoryName()));
    }
}
