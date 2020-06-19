package intermediate;

public class Student implements Comparable<Student> {
	private String name;
	private int score;
	public Student (String name, int score) {
		super();
		this.name=name;
		this.score=score;
	}
	
	
	
	public int getScore() {
		return score;
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

	@Override
	public int compareTo(Student o) { 
		//-1(음수) 오름차순
		//1(양수) 내림차순
		//0
		//return this.score - o.score;//this.score는 비교를 당하는 , o.score는 비교를 할 대상(매개값), 점수기준으로 정렬하기 위한 재정의 메소드
		return this.name.compareTo(o.name); //이름을 기준으로 정렬하기 위한 메소드
	}
	
}
