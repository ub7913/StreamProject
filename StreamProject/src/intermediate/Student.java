package intermediate;

public class Student {
	private String name;
	private int score;
	public Student (String name, int score) {
		super();
		this.name=name;
		this.score=score;
	}
	
	public int hashCode() {
		return this.name.hashCode() + this.score;
	}
	
	public boolean equals(Object obj) {
		Student std = (Student) obj;
		boolean stdBool = this.name.equals(std.name);
		boolean scoreBool = this.score == std.score;
		return stdBool && scoreBool;
	}
	
	@Override
	public String toString() {
		String str = String.format("%s %s", name, score);
		return str;
	}
	
}
