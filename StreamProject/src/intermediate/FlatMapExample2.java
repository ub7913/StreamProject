package intermediate;

import java.util.List;
import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlatMapExample2 {
	public static void main(String[] args) {
		
		//그냥 Stream과 flatMap 
		Stream<Integer> stream = Stream.of(1, 2, 3);
		stream.flatMap(new Function<Integer, Stream<Integer>>() {

			@Override
			public Stream<Integer> apply(Integer t) {
				return Stream.of(t*2);
			}
			
		}).filter(value -> value>3)
		  .forEach(s -> System.out.println(s));
		
		
		//IntStream과 flatMapToInt
		stream = Stream.of(1, 2, 3);//스트림은 한번 소진되면 다시 선언해줘야 한다.
		int sum = stream.flatMapToInt(new Function<Integer, IntStream>(){

			@Override
			public IntStream apply(Integer t) {
//				return Stream.of(t*2);//Stream<Integer>이렇게 리턴하겠다는 의미
				return IntStream.of(t*2);
			}
			
		}).sum();
		System.out.println("sum" + sum);
		
		
		//Stream과 flatMapToDouble
		List<Employee> employees = Employee.persons();
		employees.stream()
				 .flatMapToDouble(t->DoubleStream.of(t.getIncome()))
				 .forEach(s->System.out.println(s));
	}
}
