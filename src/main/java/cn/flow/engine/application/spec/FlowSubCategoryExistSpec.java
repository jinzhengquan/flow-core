package cn.flow.engine.application.spec;

import lombok.RequiredArgsConstructor;
import cn.flow.core.specification.ThrowableSpecification;
import cn.flow.engine.exception.FlowSubCategoryExistNotDeleteException;
import cn.flow.engine.model.FlowCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowSubCategoryExistSpec extends ThrowableSpecification<FlowCategory, FlowSubCategoryExistNotDeleteException> {

    @Override
    public boolean isSatisfiedBy(FlowCategory flowCategory) {
        return !(flowCategory.getFlowCategories().size() > 0);
    }

    @Override
    protected FlowSubCategoryExistNotDeleteException buildException(FlowCategory object) {
        return new FlowSubCategoryExistNotDeleteException();
    }
}
