package cn.flow.core.specification;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SpecificationInvoker extends AbstractSpecificationInterceptor {

    @Override
    public void execute(ThrowableSpecification specification) {

    }

    @Override
    public SpecificationInterceptor getNext() {
        return null;
    }

    @Override
    public void setNext(SpecificationInterceptor next) {
        throw new UnsupportedOperationException("SpecificationInvoker must be the last interceptor in the chain");
    }
}
