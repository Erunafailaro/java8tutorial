package java8tutorial.lambda.search;

import java.util.List;

import java8tutorial.lambda.search.criteria.CheckPersonEligibleForSelectiveService;
import java8tutorial.lambda.search.criteria.Consumer;
import java8tutorial.lambda.search.criteria.Function;
import java8tutorial.lambda.search.criteria.PersonCriteria;
import java8tutorial.lambda.search.criteria.Predicate;
import java8tutorial.lambda.search.datageneration.Person;
import java8tutorial.lambda.search.datageneration.PersonGenerator;

public class PersonSearch {

	public static void main(String[] args) {

		System.out.println("1 - Ansatz einfach:");
		printPersonsWithinAgeRange(PersonGenerator.getPersons(), 50, 100);

		System.out.println("\n\n2 - Ansatz \"Architekt\":");
		printPersonsWithinAgeRange(PersonGenerator.getPersons(),
				new CheckPersonEligibleForSelectiveService());

		System.out.println("\n\n3 - Ansatz \"Anonymer Kryptologe\":");
		printPersonsWithinAgeRange(PersonGenerator.getPersons(),
				new PersonCriteria() {
					public boolean test(Person p) {
						return p.getAge() >= 50 && p.getAge() <= 100;
					}

				});

		/*
		 * Warum funktioniert das? PersonCriteria ist ein funktionales
		 * Interface. Es besitzt nur genau eine abstrakte Methode.
		 * 
		 * Der Lambda-Ausdruck funktioniert hier ähnlich wie eine anonyme
		 * Klasse. Es gibt einen typisierten Parameter (Person p). Der darauf
		 * folgende Ausdruck ist ein boolean, passend zum Rückgabewert der
		 * Methode test() aus dem Inteface.
		 */
		System.out.println("\n\n4 - Ansatz Lambda, einfach:");
		printPersonsWithinAgeRange(
				PersonGenerator.getPersons(),
				/* fehlender Methodenname */(Person p) -> p.getAge() >= 50
						&& p.getAge() <= 100); // <- Lambda-Ausdruck !!!

		System.out.println("\n\n5 - Ansatz Lambda, mit Generics:");
		printPersonsWithPredicate(PersonGenerator.getPersons(),
		/* kein (Person p) */p -> p.getAge() >= 50 && p.getAge() <= 100);

		System.out.println("\n\n6 - Ansatz Lambda, mit zwei Generics:");
		processPersons(PersonGenerator.getPersons(),
				p -> p.getAge() >= 50 && p.getAge() <= 100, p -> p.print());

		System.out.println("\n\n7 - Ansatz Lambda, mit drei Generics:");
		processPersonsWithFunction(
				PersonGenerator.getPersons(),
				p -> p.getAge() >= 50 && p.getAge() <= 100, //
				p -> p.getHeightInMeters().toString(),
				heightInMeters -> System.out.println("Person ist "
						+ heightInMeters + "m groß."));
	}

	/**
	 * Klassischer Ansatz, um eine Collection zu durchsuchen.
	 * 
	 * @param roster
	 * @param low
	 * @param high
	 */
	public static void printPersonsWithinAgeRange(List<Person> roster, int low,
			int high) {
		for (Person p : roster) {
			if (low <= p.getAge() && p.getAge() < high) {
				System.out.println(p);
			}
		}
	}

	/**
	 * Einsatz eines Interfaces, um eine Collection zu durchsuchen.
	 * 
	 * @param roster
	 * @param criteria
	 */
	public static void printPersonsWithinAgeRange(List<Person> roster,
			PersonCriteria criteria) {
		for (Person p : roster) {
			if (criteria.test(p)) {
				System.out.println(p);
			}
		}
	}

	/**
	 * Einsatz eines generischen Interfaces, um eine Collection zu durchsuchen.
	 * 
	 * @param roster
	 * @param tester
	 */
	public static void printPersonsWithPredicate(List<Person> roster,
			Predicate<Person> tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				System.out.println(p);
			}
		}
	}

	/**
	 * Einsatz eines weiteren generischen Interfaces, um einen zweiten
	 * Lambda-Ausdruck zu verwenden.
	 * 
	 * @param roster
	 * @param tester
	 * @param block
	 */
	public static void processPersons(List<Person> roster,
			Predicate<Person> tester, Consumer<Person> block) {
		for (Person p : roster) {
			if (tester.test(p)) {
				block.accept(p);
			}
		}
	}

	/**
	 * Einsatz eines weiteren generischen Interfaces, um einen dritten
	 * Lambda-Ausdruck zu verwenden.
	 * 
	 * @param roster
	 * @param tester
	 * @param mapper
	 * @param block
	 */
	public static void processPersonsWithFunction(List<Person> roster,
			Predicate<Person> tester, Function<Person, String> mapper,
			Consumer<String> block) {
		for (Person p : roster) {
			if (tester.test(p)) {
				String data = mapper.apply(p);
				block.accept(data);
			}
		}
	}

}
