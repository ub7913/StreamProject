package lambdaExample;

import java.util.function.IntBinaryOperator;

public class OperratorExample {
	
	private static int[] scores = { 92, 95, 87 };
	
	public static int maxOrMin(IntBinaryOperator operator) {
		int result = scores[0];
		for (int score:scores) {
			result = operator.applyAsInt(result, score);
		}
		return result;
	}
	
	public static void main(String[] args) {
		//최대값 얻기
		int max = maxOrMin (new IntBinaryOperator() {

			@Override
			public int applyAsInt(int left, int right) {
				if(left>=right) 
					return left;
				else 
					return right;
			}
			
		});
		
//		int max = maxOrMin((a,b) -> {
//			if(a>=b) return a;
//			else return b;
//		});
		System.out.println("최대값: "+max);
		
		int min = maxOrMin((a,b) -> {
			if(a<=b) return a;
			else return b;
		});
		System.out.println("최소값: "+min);
	}
}
