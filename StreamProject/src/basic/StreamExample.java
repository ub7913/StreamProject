package basic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamExample {
	static int sum =0;
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		
		//1,3,5의 제곱값의 합
		for(int n : numbers) {
			if (n%2 == 1) {//filter
				int square = n*n;//map
				sum+= square;
			}
		}
		System.out.println("결과 : " + sum);
		
		numbers.stream().forEach(s -> System.out.println(s)); //numbers의 각각 요소들에 forEach구문 작동
		
//		Predicate<Integer> predicate = (t) ->  t%2 ==1;
//		Function<Integer, Integer> function = new Function<Integer, Integer>() {
//
//			@Override
//			public Integer apply(Integer t) {
//				return t * t;
//			}
//			
//		};
		
		numbers.stream().filter(/* predicate */(t) -> t % 2 == 1)
						.map(/* function */t -> t * t)
						.forEach(s -> sum += s);//predicate인터테이스를 구현하는 추상 메소드는 test이고 이 메소드 타입은 boolean타입 ,조건에 참인지 아닌지 리턴해주는것
		System.out.println("결과: "+sum); 
	}
}
