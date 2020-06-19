package terminal;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.ToIntFunction;

import intermediate.Student;

public class AggregateExample2 {
	public static void main(String[] args) {
		
		//sum()써보기
		List<Student> students = Arrays.asList(new Student("Hong", 55), new Student("Park", 88), new Student("Hwang", 67));
		int result = students.stream().mapToInt(new ToIntFunction<Student>()	{

			@Override
			public int applyAsInt(Student value) {
				return value.getScore();
			}
			
		}).sum();
		System.out.println("집계결과1 : " + result);
		
		
		
		//reduce()써보기
		result = students
				.stream()/* .filter(n->n.getScore()>100) */
				.mapToInt(s -> s.getScore())
				.reduce(new IntBinaryOperator() {

					@Override
					public int applyAsInt(int left, int right) {
						System.out.println("left : " + left + ", right : " + right);
						return left + right; // 집계처리 방식을 정함
					}
					
				}).getAsInt();
		System.out.println("집계결과2 : " + result);
		
		
		result = students.stream().filter(n->n.getScore()>100)
						 .mapToInt(s -> s.getScore())
						 .reduce(0, new IntBinaryOperator() { //리턴되는 getScore()의 타입이 인트 타입이라서 0,getAsInt()가 필요 없다

							@Override
							public int applyAsInt(int left, int right) {
								return left+right;
							}
							 
						 });
		System.out.println("집계결과3 : " + result);//필터에 걸러지는 요소가 없어서 reduce에 예외처리로 나올 int타입 0을 설정 해 놓았다.
		
	}//end of main
}
