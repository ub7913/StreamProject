package intermediate;

import java.util.List;
import java.util.function.Predicate;

public class FilterExample {
	public static void main(String[] args) {
		List<Employee> employees = Employee.persons(); // Employee 클래스에 만들어 놓은 persons()메소드가 호출 되면서 인스턴스 6개 만들어 질것임
		employees.stream() //
		  .filter(new Predicate<Employee>() {

			@Override
			public boolean test(Employee t) {
				return t.getIncome() > 4000;
			} // 람다식 안쓰고 필터 씀

		})
		  .filter(t -> t.isFemail())// 람다식으로 필터표현
		  .peek(System.out::println)//중간처리 과정에서 출력을 해보기 위한 것
		  .forEach(s -> s.setIncome(s.getIncome() * 1.1)/*System.out.println(s.toString()*/); // toString()도 Employee에 오버라이딩 해놧기 때문에 오버라이딩 한대로 출력된다.
		System.out.println("성과급 지급 후");
		employees.stream().forEach(System.out::println);//
	}
}
