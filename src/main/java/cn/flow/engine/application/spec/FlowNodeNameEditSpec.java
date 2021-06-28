package cn.flow.engine.application.spec;

import cn.flow.core.specification.Pair;
import lombok.RequiredArgsConstructor;
import cn.flow.core.specification.ThrowableSpecification;
import cn.flow.engine.exception.DuplicatedFlowNodeNameException;
import cn.flow.engine.model.FlowNode;
import cn.flow.engine.repository.FlowNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlowNodeNameEditSpec extends ThrowableSpecification<Pair<FlowNode, String>, DuplicatedFlowNodeNameException> {
    private final FlowNodeRepository flowNodeRepository;

    @Override
    public boolean isSatisfiedBy(Pair<FlowNode, String> param) {
        return !(!Objects.equals(param.first.getNodeName(), param.second)
                && flowNodeRepository.existsByNodeNameAndFlowModel_Id(
                param.second, param.first.getFlowModel().getId()));
    }

    @Override
    protected DuplicatedFlowNodeNameException buildException(Pair<FlowNode, String> param) {
        return new DuplicatedFlowNodeNameException(param.second);
    }
}
