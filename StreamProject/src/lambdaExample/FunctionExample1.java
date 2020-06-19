package lambdaExample;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionExample1 {

	private static List<Student> list = Arrays.asList(new Student("Hong", 90, 96), new Student("Shin", 95, 93));

	public static void printString(Function<Student, String> function) {
		for (Student student : list) {
			System.out.println(function.apply(student) + " ");

		}
		System.out.println();
	}

	public static void printInt(ToIntFunction<Student> function) {
		for (Student student : list) {
			System.out.println(function.applyAsInt(student) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println("학생이름");
		//printString(t->t.getName());
		printString(new Function<Student, String>(){

			@Override
			public String apply(Student t) {
				return t.getName();
			}
			
		});
		
		
		System.out.println("영어 점수");	
		printInt((t)->t.getEnglishScore());
		
		System.out.println("수학 점수");
		printInt(t->t.getMathScore());
	}
}
