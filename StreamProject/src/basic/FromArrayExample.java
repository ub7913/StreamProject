package basic;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class FromArrayExample {
	public static void main(String[] args) {
		String[] strAry = {"Hong", "Hwang", "Park"};
		Stream<String> stream = Arrays.stream(strAry); // 스트림 얻어오기
		stream.peek(new Consumer<String>() {

			@Override
			public void accept(String t) {//accep자체는 의미 없지만 매개값이 중요
				System.out.println("peek: "+t.toString());//중간처리
			}
			
		}).forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println("forEach: " + t.toString());//최종처리
			}
		}) ;
	}
}
//중간처리 최종처리를 한번씩 한번씩 한다.
