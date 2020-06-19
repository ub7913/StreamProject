package intermediate;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

public class LoopingExample {
	public static void main(String[] args) {
		int[] intArr = {1,2,3,4,5};
		
		
		System.out.println("[peek()를 마지막에 호출한 경우]");
		Arrays.stream(intArr)
			.filter(new IntPredicate() {

				@Override
				public boolean test(int value) {
					return value%2==0;
				}
				
			})
			.peek(new IntConsumer() {

				@Override
				public void accept(int value) {
					System.out.println(value);
				}
				
			}); //동작하지 않음
		
		
		System.out.println("[최종처리 메소드를 마지막에 호출한 경우]");
		int total = Arrays.stream(intArr)
				.filter(a -> a%2 == 0)
				.peek(n -> System.out.println(n))
				.sum();
			System.out.println("총합 : " + total);
			
		
			
		System.out.println("[forEach()를 마지막에 호출한 경우]");
		Arrays.stream(intArr)
			.filter(a -> a%2==0)
			.forEach(n->System.out.println(n));
	}
}
