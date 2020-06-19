package lambdaExample;

import java.util.function.UnaryOperator;

public class LambdaExample3 {
	public static void main(String[] args) {
		
		UnaryOperator<String> uo = new UnaryOperator<String>() {

			@Override
			public String apply(String t) {
				//return t.substring(t.length() - 5);//10-3=7 7번째 자리 다음부터 잘라내서 리턴
				return t.toLowerCase();//소문자로 리턴 해줌
			}
			
		};
		
		System.out.println(uo.apply("HelloWorldNice")); 
		
	}
}
