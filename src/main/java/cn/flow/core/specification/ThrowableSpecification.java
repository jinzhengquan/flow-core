package cn.flow.core.specification;

public abstract class ThrowableSpecification<T, E extends RuntimeException> implements Specification<T> {

    protected abstract E buildException(T object);

    public final void verify(T object) {
        if (!isSatisfiedBy(object)) {
            throw buildException(object);
        }
    }
}
