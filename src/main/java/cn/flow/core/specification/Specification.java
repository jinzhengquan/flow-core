package cn.flow.core.specification;

@FunctionalInterface
public interface Specification<T> {

    boolean isSatisfiedBy(T object);
}
