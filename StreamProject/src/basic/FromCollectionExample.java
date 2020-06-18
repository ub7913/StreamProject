package basic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Student {
	private String name;
	private int score;
	
	public Student(String name, int score) {
		this.name=name;
		this.score=score;
	}
	public String getName() { return this.name; }
	public int getScore() { return this.score; }
	
}

public class FromCollectionExample {
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(//forEach 각 요소들에 대해 하나씩 접근해서  어떠한 처리를 하겠다는 것
				new Student("Hong", 35), 
				new Student("Hwang", 55),
				new Student("Park", 60)
		);
		
//		Stream<Student> stream = students.stream(); 아래 forEach해서 한거랑 똑같은것
		Predicate<Student> predicate = new Predicate<Student>() {

			@Override
			public boolean test(Student t) {
				return t.getScore() > 50;
			}
			
		};
		students.stream().filter(predicate/* t -> t.getScore() > 50 */) //한번에 쓸수 있는 것을 너무 나눠썼다.
		.forEach((t) ->  System.out.println(t.getName() + ", " + t.getScore()));
	} //리스트에 스트림을 할건데 필터하고 각각을 불러와서 출력 하겠다는 문장
}
