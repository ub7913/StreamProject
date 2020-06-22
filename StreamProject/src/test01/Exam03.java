package test01;

import java.util.stream.IntStream;

public class Exam03 {
	public static void main(String[] args) {
		IntStream stream = IntStream.rangeClosed(1, 20);
		int result = stream.filter(t -> t%2==0).peek(s->System.out.print(s+" ")).sum();
		System.out.println();
		System.out.println("결과: "+ result);
	}
}
