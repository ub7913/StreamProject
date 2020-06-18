package intermediate;

import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MappingExample {
	public static void main(String[] args) {
		Stream.of(1,2,3)/*.flatMap(new Function<Integer, Stream<Integer>>() {

			@Override
			public Stream<Integer> apply(Integer t) {				
				return Stream.of(t, t * 2, t*t); // 각각요소들에게 영향을 미치도록 하는 메소드, 해당되는 요소들이 여러가지 와도됨
			}
			
		})*/
		.flatMap(t->Stream.of(t, t * 2, t*t));
		//.forEach(s -> System.out.println(s));
		
		Stream.of(1,2,3).flatMapToInt(new Function<Integer, IntStream>() { // flatMapToInt는 매핑을 IntStream으로 리턴해주는 중간처리메소드이다.

			@Override
			public IntStream apply(Integer t) {
				return IntStream.of(t*2);
			}
			
		});
		
		Double sum = Employee.persons().stream().flatMapToDouble(new Function<Employee, DoubleStream>(){ //flatMapToDouble는 매핑을 DoubleStream으로 반환해주는 중간처리메소드이다.
				//Double 타입으로 반환이 됐기 때문에 Double 타입의 sum에 값을 집어 넣을 수 있다.
			@Override
			public DoubleStream apply(Employee t) {
				return DoubleStream.of(t.getIncome());
			}
			
		}).sum();
		
		System.out.println("sum: "+ sum);
		/*.forEach(s -> System.out.println(s));*/
	}
}
