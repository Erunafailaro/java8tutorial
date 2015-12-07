package java8tutorial.lambda.search.datageneration;

import java.math.BigDecimal;

public class Person {
	public Person() {
		// do nothing
	}

	public Person(int age, String lastname, String firstname,
			String heightInMeters) {
		super();
		this.age = age;
		this.lastname = lastname;
		this.firstname = firstname;
		this.setHeightInMeters(heightInMeters);
		;
	}

	private int age;
	private String lastname;
	private String firstname;
	private BigDecimal heightInMeters;

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the heightInMeters
	 */
	public BigDecimal getHeightInMeters() {
		return heightInMeters;
	}

	/**
	 * @param heightInMeters
	 *            the heightInMeters to set
	 */
	public void setHeightInMeters(BigDecimal heightInMeters) {
		this.heightInMeters = heightInMeters;
	}

	/**
	 * @param heightInMeters
	 *            the heightInMeters to set
	 */
	public void setHeightInMeters(String heightInMeters) {
		this.heightInMeters = new BigDecimal(heightInMeters);
	}

	public String toString() {
		return "- " + firstname + " " + lastname + ", Alter: " + age
				+ ", Größe: " + heightInMeters.toString() + "m";
	}

	public void print(){
		System.out.println(toString());
	}
}
