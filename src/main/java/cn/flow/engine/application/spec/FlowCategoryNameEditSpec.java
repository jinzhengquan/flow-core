package cn.flow.engine.application.spec;

import cn.flow.core.specification.Pair;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import cn.flow.core.specification.ThrowableSpecification;
import cn.flow.engine.exception.DuplicatedFlowCategoryNameException;
import cn.flow.engine.repository.FlowCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowCategoryNameEditSpec extends ThrowableSpecification<Pair<String, String>, DuplicatedFlowCategoryNameException> {
    private final FlowCategoryRepository flowCategoryRepository;

    @Override
    public boolean isSatisfiedBy(Pair<String, String> command) {
        return !(!StringUtils.equals(command.first, command.second)
                && flowCategoryRepository.existsByCategoryName(command.second));
    }

    @Override
    protected DuplicatedFlowCategoryNameException buildException(Pair<String, String> command) {
        return new DuplicatedFlowCategoryNameException(command.second);
    }
}
