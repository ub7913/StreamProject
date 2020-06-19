package intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortExample {
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(//
				new Student("Hong", 30), //
				new Student("Hwang", 25), //
				new Student("Park", 27) //
		);
		students.stream().sorted().forEach(s -> System.out.println(s));// 에러나는데 Student클래스가 소트 될수 없는 클래스이기 때문이다.
																		// Student에 Comparable 할 수 있는 기능을 추가 해야 한다.
																		// implements Comparable<Student> 하기
		System.out.println("Hong".compareTo("Park"));
		System.out.println("Hong".compareTo("Hark"));

		List<Person> persons = Arrays.asList( // Person클래스는 comparable을 구현하는 클래스가 아님 , 이럴때는 어떻게?
				new Person("Ahn", 30), 
				new Person("Park", 25), //
				new Person("Hwang", 27));
		persons.stream().sorted(new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.name.compareTo(o2.name); //이름을 정렬
				//return o1.age - o2.age; //점수를 정렬
			}
		}).forEach(System.out::println);
	}
}
