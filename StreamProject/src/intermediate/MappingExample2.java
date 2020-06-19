package intermediate;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MappingExample2 {
	public static void main(String[] args) {

		// map()
		List<Employee> employees = Employee.persons();
		employees.stream().map(new Function<Employee, String>() {

			@Override
			public String apply(Employee t) {
				return t.getName();
			}

		}).filter(new Predicate<String>() {

			@Override
			public boolean test(String t) {
				return t.startsWith("H");// H로 시작하는 값을 리턴하도록
			}

		}).forEach(s -> System.out.println(s));
		System.out.println();

		// mapToObj
		// List<Employee> employees = Employee.persons();
		employees.stream().map(new Function<Employee, String>() {

			@Override
			public String apply(Employee t) {
				return t.getName();
			}

		}).flatMap(new Function<String, Stream<Character>>() {

			@Override
			public Stream<Character> apply(String t) {// 요소 하나하나를 0~t.length()만큼 잘라서 mapToObj()(내가 원하는 오브젝트(아무)타입으로
														// 바꿔주는것) 캐릭터타입의 String으로 바꿔준다는 의미
				return IntStream.range(0, t.length()).mapToObj(new IntFunction<Character>() {// IntFunction<Character>
																								// 인트타입으로 받아서 캐릭터 타입으로
																								// 반환

					@Override
					public Character apply(int value) {
						return t.charAt(value);// charAt(): 해당되는 위치의 인덱스 값을 하나씩 받는다. character타입으로 반환하는것
					}

				});
			}

		}).forEach(s -> System.out.println(s));
		
		
		
		//위의 복잡한 식을 람다식으로 줄이면 아래와 같이 된다.
		
		employees.stream().map(t-> t.getName())
				 .flatMap(t-> IntStream.range(0, t.length())
									   .mapToObj(value -> t.charAt(value)))
			     .forEach(s->System.out.println(s));
	}
}
