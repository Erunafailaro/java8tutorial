package java8tutorial.lambda.search.criteria;

public interface Predicate<T> {
	boolean test(T t);
}