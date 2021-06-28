package cn.flow.core.specification;

public abstract class AbstractSpecificationInterceptor implements SpecificationInterceptor {

    protected SpecificationInterceptor next;

    @Override
    public SpecificationInterceptor getNext() {
        return next;
    }

    @Override
    public void setNext(SpecificationInterceptor next) {
        this.next = next;
    }
}

