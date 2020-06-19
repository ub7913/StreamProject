package terminal;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.function.DoubleConsumer;
import java.util.stream.IntStream;

public class AggregateExample {
	public static void main(String[] args) {
		int[] intAry = { 1, 2, 3, 4, 5 };
		IntStream iStream = Arrays.stream(intAry);// IntStream을 굳이 해준이유는 stream에 int타입이 들어 가있음을 보여주기 위해서
		OptionalDouble od = iStream.filter(n -> n > 5).average();
		double result;
		
		
		//방법3
		od.ifPresent(new DoubleConsumer() { //필터에 걸러지는 해당하는 값이 있으면 ~

			@Override
			public void accept(double value) {
				System.out.println("결과는 : " + value);
			}
			
		});
		
		
		//방법2
//		result = od.orElse(0.0);//필터에 걸러져 해당하는 결과 값이 값이 없으면 0.0을 내겠다는 의미
//		System.out.println(result);
		
		
		//방법1
//		if (od.isPresent()) { //필터에 걸러져 해당하는 값이 있으면 result
//			result = od.getAsDouble();
//			System.out.println(result);
//		} else {
//			System.out.println("값이 없습니다.");
//		}
	}
}
