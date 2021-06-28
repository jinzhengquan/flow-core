package cn.flow.engine.application.spec;

import lombok.RequiredArgsConstructor;
import cn.flow.core.specification.ThrowableSpecification;
import cn.flow.engine.exception.DuplicatedFlowModelNameException;
import cn.flow.engine.repository.FlowModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowModelNameCreateSpec extends ThrowableSpecification<String, DuplicatedFlowModelNameException> {
    private final FlowModelRepository flowModelRepository;

    @Override
    public boolean isSatisfiedBy(String flowModelName) {
        return !flowModelRepository.existsByFlowModelName(flowModelName);
    }

    @Override
    protected DuplicatedFlowModelNameException buildException(String flowModelName) {
        return new DuplicatedFlowModelNameException(flowModelName);
    }
}
