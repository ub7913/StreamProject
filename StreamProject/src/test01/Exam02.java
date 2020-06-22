package test01;

import java.util.Arrays;
import java.util.List;

import intermediate.Student;

public class Exam02 {
	public static void main(String[] args) {
//		int[] intAry = new int[] {3,2,5,7,1};
//		Arrays.sort(intAry, 0, intAry.length);
//		for (int i:intAry) {
//			System.out.println(i + " ");
//		}
//	}
		
		int[] intAry = new int[] {3,2,5,7,1};
		
//		List<Integer> intAry = Arrays.asList(3,2,5,7,1);
		
		Arrays.stream(intAry).sorted().forEach(s->System.out.println(s));
		
		
	}
}
