package java8tutorial.lambda.search.datageneration;

public class PersonFactory {

	public static Person createPerson(String firstname, String lastname, int age,
			String heightInMeters) {
		Person p = new Person();
		p.setFirstname(firstname);
		p.setLastname(lastname);
		p.setAge(age);
		p.setHeightInMeters(heightInMeters);

		return p;
	}
}
