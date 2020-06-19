package lambdaExample;

import java.util.function.IntBinaryOperator;

class GetMax implements IntBinaryOperator {

	@Override
	public int applyAsInt(int left, int right) {
		return left > right ? left : right;// left가 크면 left를 리턴 아니면 right를 리턴
	}

}

class GetMin implements IntBinaryOperator {

	@Override
	public int applyAsInt(int left, int right) {
		return left < right ? left : right;
	}

}

public class LambdaExample {
	private static int[] scores = { 10, 50, 3 };

	public static int maxOrMin(IntBinaryOperator operator) {
		int result = scores[0]; // 맥스값 필요 할때는 0, 미니멈 값 필요 할때는 알수없는 큰숫자 (ex 100000000같은) 필요, 그러면 메소두가 두개나 필요,
								// 메소드를 줄이기 위해서 기준 값을 scores[0]을 주면 된다.
		for (int score : scores) {
			result = operator.applyAsInt(result, score);
		}
		return result;
	}

	public static void main(String[] args) {
		// 최대값 얻기
		int result = maxOrMin(new GetMax());
		System.out.println("최대값은  " + result);

		// 최소값 얻기
		int result1 = maxOrMin(new GetMin());
		System.out.println("최소값은  " + result1);

//		int max = maxOrMin((a, b) -> {
//			if (a >= b)
//				return a;
//			else
//				return b;
//		});
//		
//		System.out.println("최대값 : " + max);
//		
//		int min = maxOrMin((a, b) -> {
//			if (a <= b)
//				return a;
//			else
//				return b;
//		});
//		
//		System.out.println("최소값: " + min);
//	}
	}
}
