package cn.flow.engine.application.spec;

import cn.flow.core.specification.ThrowableSpecification;
import cn.flow.engine.exception.DuplicatedFlowCategoryNameException;
import cn.flow.engine.repository.FlowCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowCategoryNameCreateSpec extends ThrowableSpecification<String, DuplicatedFlowCategoryNameException> {
    private final FlowCategoryRepository flowCategoryRepository;

    @Override
    public boolean isSatisfiedBy(String categoryName) {
        return !flowCategoryRepository.existsByCategoryName(categoryName);
    }

    @Override
    protected DuplicatedFlowCategoryNameException buildException(String categoryName) {
        return new DuplicatedFlowCategoryNameException(categoryName);
    }
}
