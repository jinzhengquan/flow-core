package cn.flow.engine.application.spec;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import cn.flow.core.specification.ThrowableSpecification;
import cn.flow.engine.exception.FlowCategoryParentIdNotExistException;
import cn.flow.engine.repository.FlowCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowCategoryParentIdNotExistSpec extends ThrowableSpecification<String, FlowCategoryParentIdNotExistException> {
    private final FlowCategoryRepository flowCategoryRepository;

    @Override
    public boolean isSatisfiedBy(String id) {
        if(StringUtils.isBlank(id)) {
            return true;
        }
        return flowCategoryRepository.existsById(id);
    }

    @Override
    protected FlowCategoryParentIdNotExistException buildException(String id) {
        return new FlowCategoryParentIdNotExistException(id);
    }
}
