package terminal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectExample {
	public static void main(String[] args) {
		List<String> strList = Arrays.asList("Abby", "Charlie", "Choi");
		
		List<String> filterList = strList.stream().filter(new Predicate<String>() {

			@Override
			public boolean test(String t) {
				return t.startsWith("C");
			}
			
		}).collect(Collectors.toList());//toList()를 쓰면 List타입으로 반환, toMap()을쓰면 Map 타입으로 반환(키 밸류로 반환) 등등.. 어떤 컬렉터를 쓰냐에 따라 반환타입이 달라진다.
		filterList.stream().forEach(s->System.out.println(s));
		System.out.println();
	
		List<Student> students = Arrays.asList(
				new Student("Hong", 34, Student.Sex.MALE),
				new Student("Hwang", 22, Student.Sex.FEMALE),
				new Student("Park", 33, Student.Sex.MALE),
				new Student("Choi", 44, Student.Sex.FEMALE)
		);
		List<Student> maleStudent = students.stream().filter(new Predicate<Student>() {

			@Override
			public boolean test(Student t) {
				return t.getSex() == Student.Sex.MALE;
			}
			
		}).collect(Collectors.toList());
		long cnt = maleStudent.stream()
							   .peek(s->System.out.println(s.getName()))//해당되는 스트림을 출력해보는 것
							   .count();
		System.out.println("총" + cnt + "명");
		
		HashSet<Student> femaleSet = students.stream()
				.filter(s -> s.getSex() == Student.Sex.FEMALE)
				.peek(s->System.out.println(s.getSex()))
				.collect(Collectors.toCollection(new Supplier<HashSet<Student>>() {

					@Override
					public HashSet<Student> get() {
						return new HashSet<Student>();
					}
					
				}));
		int result = femaleSet.stream().map(new Function<Student, Integer>() {

			@Override
			public Integer apply(Student t) {
				return t.getScore();
			}
			
		}).reduce(0, new BinaryOperator<Integer>() {//집계

			@Override
			public Integer apply(Integer t, Integer u) {
				System.out.println(t+", "+u);
				return t+u;
			}
			
		}

		);
		System.out.println("합은 : "+result);
	}
}
