package cn.flow.core.specification;

public interface SpecificationInterceptor {

    void execute(ThrowableSpecification specification);

    SpecificationInterceptor getNext();

    void setNext(SpecificationInterceptor next);

}
