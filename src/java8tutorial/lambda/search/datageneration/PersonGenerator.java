package java8tutorial.lambda.search.datageneration;

import java.util.ArrayList;
import java.util.List;

public class PersonGenerator {

	public static List<Person> getPersons(){
		List<Person> persons = new ArrayList<Person>();
		persons.add(PersonFactory.createPerson("Max", "Muster", 50, "1.69"));
		persons.add(PersonFactory.createPerson("Hannes", "Muster", 27, "1.78"));
		persons.add(PersonFactory.createPerson("Frauke", "Muster", 48, "1.99"));
		persons.add(PersonFactory.createPerson("Karl-Gustav", "Muster", 99, "1.83"));
		
		return persons;
	}
}
