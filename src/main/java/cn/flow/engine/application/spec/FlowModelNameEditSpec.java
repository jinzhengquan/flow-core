package cn.flow.engine.application.spec;

import cn.flow.core.specification.Pair;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import cn.flow.core.specification.ThrowableSpecification;
import cn.flow.engine.exception.DuplicatedFlowModelNameException;
import cn.flow.engine.repository.FlowModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowModelNameEditSpec extends ThrowableSpecification<Pair<String, String>, DuplicatedFlowModelNameException> {
    private final FlowModelRepository flowModelRepository;

    @Override
    public boolean isSatisfiedBy(Pair<String, String> command) {
        return !(!StringUtils.equals(command.first, command.second)
                && flowModelRepository.existsByFlowModelName(command.second));
    }

    @Override
    protected DuplicatedFlowModelNameException buildException(Pair<String, String> command) {
        return new DuplicatedFlowModelNameException(command.second);
    }
}
