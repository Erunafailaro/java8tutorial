package java8tutorial.lambda.search.criteria;

import java8tutorial.lambda.search.datageneration.Person;

@FunctionalInterface
public interface PersonCriteria
{

    boolean test(Person p);

}
