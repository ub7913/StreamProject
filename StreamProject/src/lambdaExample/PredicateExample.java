package lambdaExample;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
	private static List<Student1> list = Arrays.asList(new Student1 ("Hong", "Male", 90),
														new Student1 ("Kim", "Female", 90),
														new Student1 ("Gam", "Male", 95),
														new Student1 ("Park", "Female", 92));
	
	public static double avg(Predicate<Student1> predicate) {
		int count =0, sum= 0;
		for(Student1 student : list) {
			if (predicate.test(student)) {
				count++;
				sum += student.getScore();
			}
		}
		return (double) sum/count;
	}
	
	public static void main(String[] args) {
		double maleAvg = avg(t-> t.getSex().equals("Male"));
		System.out.println("남자 평균 점수: " + maleAvg);
		
		double femaleAvg = avg(t->t.getSex().equals("Female"));
		System.out.println("여자 평균 점수: " + femaleAvg);
	}
}
