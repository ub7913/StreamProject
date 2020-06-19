package intermediate;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class MatchExample {
	public static void main(String[] args) {
		int[] intAry = { 2, 4, 6 };
		Integer[] integerAry={2,4,6};
		//String[] strAry = {"s","d","f"};
		
		
		boolean result = Arrays.stream(intAry).allMatch(new IntPredicate() {

			@Override
			public boolean test(int value) {
				return value%2==0;
			}
			
		});
		System.out.println("모두 2의 배수인가? " + result);
		System.out.println();
		
		result = Arrays.stream(integerAry).allMatch(new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				return t%2==1;
			}
			
		});
		System.out.println("모두 홀수인가? " + result);
		System.out.println("int와 Integer는 다른 것이다");
		System.out.println();
		
		
		result = Arrays.stream(intAry).anyMatch(new IntPredicate() {

			@Override
			public boolean test(int value) {
				return value%3==0;
			}
			
		});
		System.out.println("하나라도 3의 배수가 있는가? " + result);
		
		
		result = Arrays.stream(intAry).noneMatch(new IntPredicate() {

			@Override
			public boolean test(int value) {
				return value%3==0;
			}
			
		});
		System.out.println("3의배수가 없는가? " + result);
		
		

	}
}
