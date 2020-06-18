package basic;

import java.util.Random;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class FromIntRangeExample {
	public static void main(String[] args) {
		IntStream stream = IntStream.range(11, 20);
		stream.forEach(s -> System.out.print(s+" "));// 11<=range<20
		System.out.println();
		
		IntStream stream1 = IntStream.rangeClosed(11, 20);
		stream1.forEach(s -> System.out.print(s+" "));// 11<=rangeClosed<=20
		System.out.println();
		
		IntPredicate predicate = new IntPredicate() {

			@Override
			public boolean test(int value) {
				return value % 2 == 1;
			}

		};
		IntStream stream2 = IntStream.rangeClosed(11, 20);
		stream2.filter(predicate).forEach(s -> System.out.print(s+" "));
		System.out.println();
		
		
		Random random = new Random();
		IntStream intStream = random.ints(10, 11, 100); //11부터 100사이의 숫자 10개를 랜덤으로 가져 오는 것
		intStream.forEach(s -> System.out.print(s+" "));
		System.out.println();
		Random random1 = new Random();
		IntStream intStream1 = random1.ints(20, 11, 100);
		intStream1.filter(t->t>=50&&t<60)/*filter(t-> t>=50).filter(t-> t<60)*/.forEach(s1 -> System.out.print(s1+" "));
	}
}
