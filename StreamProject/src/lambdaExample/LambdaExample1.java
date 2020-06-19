package lambdaExample;

import java.util.function.ToIntFunction;

public class LambdaExample1 {
	private static Student[] students = { new Student("Hong", 90, 96), new Student("Shin", 95, 93) };

	// avg() 메소드 작성
	
	//1.ToIntFunction 인터페이스 이용
	public static double avg(ToIntFunction<Student> function) {
		int sum = 0;
		for (Student student : students) {
			sum += function.applyAsInt(student);
		}
		double avg = (double) sum / students.length;

		return avg;
	}
	
	
	//2.일반 메소드 이용
	public static double avgMath() {
		int sum = 0;
		for (Student student : students) {
			sum += student.getMathScore();
		}
		double avg = (double) sum / students.length;
		return avg;
	}

	public static double avgEnglish() {
		int sum = 0;
		for (Student student : students) {
			sum += student.getEnglishScore();
		}
		double avg = (double) sum / students.length;
		return avg;
	}

	public static double avgTotal() {
		int sum = 0;
		for (Student student : students) {
			sum += student.getEnglishScore() + student.getMathScore();
		}
		double avg = (double) sum / students.length;
		return avg;
	}


	
	public static void main(String[] args) {

		//1.ToIntFunction 인터페이스로 구현
		//영어평균
		
//		double englishAvg = avg(s->s.getEnglishScore());
		double englishAvg = avg(new ToIntFunction<Student>() {

			@Override
			public int applyAsInt(Student value) {
				return value.getEnglishScore();
			}
			
		});
		
		System.out.println("영어 점수 평균 : " + englishAvg);
		
//		double mathAvg = avg(s->s.getMathScore());
		
		
		//수학평균
		
		double mathAvg = avg(new ToIntFunction<Student>() {

			@Override
			public int applyAsInt(Student value) {
				return value.getMathScore();
			}
			
		});
		System.out.println("수학 점수 평균 : " + mathAvg);
		
		
		//전체 평균
		
		double totalAvg = avg(value->value.getEnglishScore()+value.getMathScore());
//		double totalAvg = avg(new ToIntFunction<Student>() {
//
//			@Override
//			public int applyAsInt(Student value) {
//				return value.getEnglishScore()+value.getMathScore();
//			}
//			
//		});
		System.out.println("전체 점수 평균: " + totalAvg);
		
		
		//2. 일반 메소드 선언해서 구현
		
		System.out.println("수학평균: " + avgMath());
		System.out.println("영어평균: " + avgEnglish());
		System.out.println("전체평균: " + avgTotal());

	}
}
