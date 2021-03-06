package java8tutorial.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java8tutorial.lambda.search.datageneration.Person;
import java8tutorial.lambda.search.datageneration.PersonGenerator;

public class StreamProcessing
{

    public static void main(String[] args)
    {
        List<Person> persons = PersonGenerator.getPersons();
        List<String> collect = persons.stream() //
                .filter((Person p) -> p.getHeightInMeters().doubleValue() < 1.79d) //
                .sorted(Comparator.comparing(Person::getAge)) // Person::getAge
                                                              // method
                                                              // reference
                .map(Person::getFirstname) //
                .collect(Collectors.toList());
        System.out.println(collect);
    }

}
