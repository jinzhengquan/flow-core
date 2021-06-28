package cn.flow.engine.application.spec;

import cn.flow.core.specification.Pair;
import lombok.RequiredArgsConstructor;
import cn.flow.core.specification.ThrowableSpecification;
import cn.flow.engine.exception.DuplicatedFlowNodeNameException;
import cn.flow.engine.repository.FlowNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowNodeNameCreateSpec extends ThrowableSpecification<Pair<String, String>, DuplicatedFlowNodeNameException> {
    private final FlowNodeRepository flowNodeRepository;

    @Override
    public boolean isSatisfiedBy(Pair<String, String> param) {
        return !flowNodeRepository.existsByNodeNameAndFlowModel_Id(param.second, param.first);
    }

    @Override
    protected DuplicatedFlowNodeNameException buildException(Pair<String, String> param) {
        return new DuplicatedFlowNodeNameException(param.second);
    }
}
