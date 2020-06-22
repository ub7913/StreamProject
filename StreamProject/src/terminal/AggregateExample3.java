package terminal;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import intermediate.Employee;

public class AggregateExample3 {
	public static void main(String[] args) {
		// 1)
		double result = Employee.persons().stream()
				.map(new Function<Employee, Double>() {

					@Override
					public Double apply(Employee t) {
						return t.getIncome();
					}
					
				}).reduce(0.0, new BinaryOperator<Double>() {

					@Override
					public Double apply(Double t, Double u) {
						System.out.println("1111=> "+t+", "+u);
						return t+u;
					}
					
				});
		System.out.println("결과값: "+result);
		System.out.println();
		
		//2)
		double result1 = Employee.persons().parallelStream()
				.reduce(0.0, 
						new BiFunction<Double, Employee, Double>(){//map 대신에 들어 가는 것, map이 없어서 어떤 항목을 집계하겠다는 내용이 없음

							@Override
							public Double apply(Double t, Employee u) {
								System.out.println("t : "+ t + ", u : " + u.getIncome());
								return t + u.getIncome();//t는 처음에 seed값 0 
							}
						},
						new BinaryOperator<Double>(){

							@Override
							public Double apply(Double t, Double u) {
								System.out.println("t는 "+t+", u는 "+u);
								return t + u;
							}
						}
				);
		System.out.println("결과값: "+result1);
	}
}
