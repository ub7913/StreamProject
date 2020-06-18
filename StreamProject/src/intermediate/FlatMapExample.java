package intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlatMapExample {
	public static void main(String[] args) {
		List<String> inputList1 = Arrays.asList("java8 lambda", "stream mapping");
		inputList1.stream().flatMap(new Function<String, Stream<String>>() {

			@Override
			public Stream<String> apply(String data) {
				return Arrays.stream(data.split(" ")); //.stream() ()안에 어떤 타입이 오느냐에 따라 그 타입에 맞는 스트림을 리턴하는 구문이다. if int타입이 들어 오면 IntStream이 리턴, String타입이면 Stream<String>이 리턴된다.
			}
			
		}).forEach(new Consumer<String>() {

			@Override
			public void accept(String word) {
				System.out.println(word);
				
			}
		});
		
		System.out.println();
		
		
		//Stream<String> 타입을 IntStream으로 바꿔서 출력
		List<String> inputList2 = Arrays.asList("10, 20, 30", "40, 50, 60");
		inputList2.stream()//String 타입으로 Stream에 담았다.
			.flatMapToInt(new Function<String, IntStream>() { //String으로 담긴 Stream을 IntStream으로 변환해서 리턴 할 것이다. flatMapToInt가 아닌 flatMap으로 하고 싶으면 new Function<String, Stream<String>>()으로 바꾸면 된다.

				@Override
				public IntStream apply(String data) {
					String[] strArr = data.split(","); // split을 통해  쉼표들이 잘리면서 "10","20","30","40","50","60" 이 되고 srtArr 배열에 담긴다.
					int[] intArr = new int[strArr.length];//strArr의 크기(6)만큼의 intArr배열 인스턴스를 하나 생성한다.
					for(int i = 0; i<strArr.length; i++) { // intArr각 인덱스 마다 값을 하나씩 담는 for문을 쓴다.
						intArr[i] = Integer.parseInt(strArr[i].trim()); //문자였던 것을 인트로 변환해서 intArr배열에 담는데.. trim은 언제쓰는거?
					}
					return Arrays.stream(intArr);
				}
				
			}).forEach(number -> System.out.println(number));
				
		
	}
}
