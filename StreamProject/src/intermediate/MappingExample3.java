package intermediate;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MappingExample3 {
	public static void main(String[] args) {
		int[] intAry = { 1, 2, 3, 4, 5 };
		double[] doubleAry = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		
		IntStream intStream = Arrays.stream(intAry);//IntStream
		DoubleStream doubleStream = Arrays.stream(doubleAry);//DoubleStream임 , 매개값으로 들오 온 배열이 어떤 타입이냐에 따라 스트림의 타입이 정해진다.
	
		doubleStream = intStream.asDoubleStream();
		doubleStream.forEach(s->System.out.println(s));
		
		intStream = Arrays.stream(intAry);
		intStream.asLongStream().forEach(System.out::println);//asLongStream() : int타입을 long타입으로
		
		intStream = Arrays.stream(intAry);
		Stream<Integer> iStream = intStream.boxed();//boxed() int를 Integer로 박싱해서 Stream생성
		iStream.forEach(s->System.out.println(s));
	}
}
