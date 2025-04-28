package lab02.filters;

public interface Filter<T> {
    boolean matches(T t);
}
