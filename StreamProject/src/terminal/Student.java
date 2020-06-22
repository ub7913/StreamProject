package terminal;

public class Student {
	public enum Sex { //Student 클래스 안에 열거형 타입으로 선언, 중첩 클래스임
		MALE, FEMALE;
	}
	
	public enum City {
		Seoul, Pusan;
	}
	
	private String name;
	private int score;
	private Sex sex;//위에 Sex와 City 클래스를 만들어 놨으므로 필드값을 선언할 수 있다.
	private City city;
	
	public Student(String name, int score, Sex sex) {
		super();
		this.name = name;
		this.score = score;
		this.sex = sex;
	}
	
	public Student(String name, int score, Sex sex, City city) {
		super();
		this.name = name;
		this.score = score;
		this.sex = sex;
		this.city = city;
	}
	
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	public Sex getSex() {
		return sex;
	}
	public City getCity() {
		return city;
	}
	
	
	
}
