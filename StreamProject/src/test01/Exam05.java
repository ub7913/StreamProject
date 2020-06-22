package test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Exam05 {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		Connection conn = getConnect();
		try {
			String sql = "select * from employees";
			ResultSet rs = conn.prepareStatement(sql).executeQuery();
			while (rs.next()) {
				employees.add(new Employee(rs.getInt("employee_id"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("email"), rs.getString("phone_number"),
						 rs.getString("hire_date"),  rs.getString("job_id"), rs.getInt("salary"),
						rs.getInt("commission_pct"), rs.getInt("manager_id"), rs.getInt("department_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		employees.stream().filter(t->t.getSalary()<5000).sorted((o1, o2) -> o1.getSalary() - o2.getSalary())
						  .forEach(s->System.out.println(s.getFirstName()+", "+s.getSalary()));
		
		int result = employees.stream().filter(t->t.getSalary()<5000)
		  .reduce(0, new BiFunction<Integer, Employee, Integer>(){

			@Override
			public Integer apply(Integer t, Employee u) {
//				System.out.println("t: "+t+", u: "+u.getSalary());
				return t+u.getSalary();
			}
			  
		  }, new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				return t+u;
			}
			  
		  });
		System.out.println();
		System.out.println("합계: "+result);
		}
	
		
	
	
	public static Connection getConnect() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "hr", "hr");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}

