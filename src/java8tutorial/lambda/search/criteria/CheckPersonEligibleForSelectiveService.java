package java8tutorial.lambda.search.criteria;

import java8tutorial.lambda.search.datageneration.Person;

public class CheckPersonEligibleForSelectiveService implements PersonCriteria{
	public boolean test(Person p) {
        return 
            p.getAge() >= 50 &&
            p.getAge() <= 100;
    }
}
