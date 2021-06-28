package cn.flow.core.specification;

import java.util.function.Function;

public class SpecificationBuilder<T> {

    private Specification<T> spec;

    private SpecificationBuilder(Specification<T> spec) {
        this.spec = spec;
    }

    public static <T> SpecificationBuilder<T> create(Specification<? super T> spec) {
        return new SpecificationBuilder<>(spec::isSatisfiedBy);
    }

    public static <S, T> SpecificationBuilder<T> create(Function<? super T, ? extends S> transfer, Specification<? super S> spec) {
        return new SpecificationBuilder<>(object -> spec.isSatisfiedBy(transfer.apply(object)));
    }

    public SpecificationBuilder<T> or(Specification<? super T> otherSpec) {
        Specification<T> thisSpec = this.spec;
        this.spec = object -> thisSpec.isSatisfiedBy(object) || otherSpec.isSatisfiedBy(object);
        return this;
    }

    public <S> SpecificationBuilder<T> or(Function<? super T, ? extends S> transfer, Specification<S> otherSpec) {
        Specification<T> thisSpec = this.spec;
        this.spec = object -> thisSpec.isSatisfiedBy(object) || otherSpec.isSatisfiedBy(transfer.apply(object));
        return this;
    }

    public SpecificationBuilder<T> and(Specification<? super T> otherSpec) {
        Specification<T> thisSpec = this.spec;
        this.spec = object -> thisSpec.isSatisfiedBy(object) && otherSpec.isSatisfiedBy(object);
        return this;
    }

    public <S> SpecificationBuilder<T> and(Function<? super T, ? extends S> transfer, Specification<S> otherSpec) {
        Specification<T> thisSpec = this.spec;
        this.spec = object -> thisSpec.isSatisfiedBy(object) && otherSpec.isSatisfiedBy(transfer.apply(object));
        return this;
    }

    public SpecificationBuilder<T> not() {
        Specification<T> thisSpec = this.spec;
        this.spec = object -> !thisSpec.isSatisfiedBy(object);
        return this;
    }

    public Specification<T> build() {
        return this.spec;
    }

    public <E extends RuntimeException> ThrowableSpecification<T, E> buildWithThrowable(Function<? super T, ? extends E> exceptionBuilder) {
        Specification<T> thisSpec = this.spec;
        return new ThrowableSpecification() {
            @Override
            protected RuntimeException buildException(Object object) {
                return null;
            }

            @Override
            public boolean isSatisfiedBy(Object object) {
                return false;
            }
        };
    }
}
