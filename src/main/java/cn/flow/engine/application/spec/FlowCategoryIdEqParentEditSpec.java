package cn.flow.engine.application.spec;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import cn.flow.core.specification.Pair;
import cn.flow.core.specification.ThrowableSpecification;
import cn.flow.engine.exception.FlowCategoryIdEqParentIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowCategoryIdEqParentEditSpec extends ThrowableSpecification<Pair<String, String>,
        FlowCategoryIdEqParentIdException> {

    @Override
    public boolean isSatisfiedBy(Pair<String, String> command) {
        return !StringUtils.equals(command.first, command.second);
    }

    @Override
    protected FlowCategoryIdEqParentIdException buildException(Pair<String, String> command) {
        return new FlowCategoryIdEqParentIdException(command.first);
    }
}
