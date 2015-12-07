package java8tutorial.lambda.comparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java8tutorial.lambda.search.datageneration.Person;
import java8tutorial.lambda.search.datageneration.PersonGenerator;

public class LambdaComparator
{

    public static void main(String[] args)
    {

        sortWithClassicComparator();

    }

    public static void sortWithClassicComparator()
    {
        List<Person> persons = PersonGenerator.getPersons();
        Collections.sort(persons, new Comparator<Person>()
        {

            @Override
            public int compare(Person o1, Person o2)
            {
                return o1.getFirstname().compareToIgnoreCase(o2.getFirstname());
            }

        });
        System.out.println(persons);
    }

    public static void sortWithLambda()
    {
        List<Person> persons = PersonGenerator.getPersons();
        Collections.sort(persons, (Person o1, Person o2) -> o1.getFirstname().compareToIgnoreCase(o2.getFirstname()));

    }

}
