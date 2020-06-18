package intermediate;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class Employee {
	public static enum Gender { //열거형 타입을 만들기 위해 메소드를 하나 만듬
		MALE, FEMALE;
	}
	
	private long id;
	private String name;
	private Gender gender;
	private LocalDate dateOfBirth;
	private double income;
	
	public Employee(long id, String name, Gender gender, LocalDate dateOfBirth, double income) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.income = income;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}
	
	public boolean isMale() {
		return this.gender == Gender.MALE;//this.gender 이것이 열거형 타입 MALE인지 아닌지 확인하는 메소드
	}
	
	public boolean isFemail() {
		return this.gender == Gender.FEMALE;
	}

	@Override
	public String toString() {
		String str = String.format("%s %s %s %s %.2f", id, name, gender, dateOfBirth, income);
		return str;
	}
	
	public static List<Employee> persons() { //List타입의 persons 메소드를 하나 만들어 줌, 이 메소드 안에는 생성자가 담겨 있고 생성자를 리턴 하며 인스턴스를 만들도록 하게끔 하는 것이다.
		Employee e1 = new Employee(1, "Hong", Gender.MALE, LocalDate.of(1991, Month.JANUARY, 3), 2343.0);
		Employee e2 = new Employee(2, "Hwang", Gender.MALE, LocalDate.of(1993, Month.APRIL, 23), 3322.0);
		Employee e3 = new Employee(3, "Choi", Gender.FEMALE, LocalDate.of(1989, Month.JUNE, 1), 4343.0);
		Employee e4 = new Employee(4, "Park", Gender.MALE, LocalDate.of(1988, Month.JULY, 21), 7900.0);
		Employee e5 = new Employee(5, "Kim", Gender.FEMALE, LocalDate.of(1994, Month.MAY, 13), 3293.0);
		Employee e6 = new Employee(6, "Ryu", Gender.MALE, LocalDate.of(1992, Month.OCTOBER, 31), 4400.0);
		
		return Arrays.asList(e1, e2, e3, e4, e5, e6);
	}
}
