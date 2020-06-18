package intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class DistinctExample {
	public static void main(String[] args) {
		IntStream is = IntStream.of(1, 2, 2, 3, 3, 5, 6, 5); 
		int sum = 0; 
		sum = is.distinct().peek(System.out::println).sum();// 최종처리 메소드 없으면 실행 안됨 중간처리 안됨 
		System.out.println("sum: "+sum);
		
		List<Student> list = Arrays.asList(
				new Student ("Hong", 33), 
				new Student("Kim", 35), 
				new Student("Park",95), 
				new Student ("Hong", 33)
				);
		list.stream().distinct().forEach(s -> System.out.println(s));//distinct가 있지만 hong의 객체 두개 다 출력됨. 그래서 같은 객체라고 Student에 정의 해줘야 함(해시코드, equals를 재정의)
	}
}
