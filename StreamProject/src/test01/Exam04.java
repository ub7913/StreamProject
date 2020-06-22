package test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;



public class Exam04 {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		Connection conn = getConnect();
		try {
			String sql = "select * from employees";
			ResultSet rs = conn.prepareStatement(sql).executeQuery();
			while (rs.next()) {
				employees.add(new Employee(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						 rs.getString(6),  rs.getString(7), rs.getInt(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		employees.stream().filter(t->t.getFirstName()
						  .startsWith("S"))
						  .sorted((o1,o2)->o1.getFirstName().compareTo(o2.getFirstName()))
						  .forEach(s->System.out.println(s.getFirstName()));
		
		long result = employees.stream().filter(t->t.getFirstName()
				  .startsWith("S"))
				  .sorted((o1,o2)->o1.getFirstName().compareTo(o2.getFirstName())).count();
		
		System.out.println("총 합은: " + result);
		
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

class Employee {
	private int empId;
	private String firstName;
	private String lastName;
	private String eMail;
	private String phone;
	private String hireDate;
	private String jobId;
	private int salary;
	private int commissionPct;
	private int magId;
	private int deptId;

	public Employee(int empId, String firstName, String lastName, String eMail, String phone,
			 String hireDate,  String jobId,
			int salary, int commissionPct, int magId, int deptId) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.phone = phone;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.magId = magId;
		this.deptId = deptId;
	}

	public int getEmpId() {
		return empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String geteMail() {
		return eMail;
	}

	public String getPhone() {
		return phone;
	}

	public String getHireDate() {
		return hireDate;
	}

	public String getJobId() {
		return jobId;
	}

	public int getSalary() {
		return salary;
	}

	public int getCommissionPct() {
		return commissionPct;
	}

	public int getMagId() {
		return magId;
	}

	public int getDeptId() {
		return deptId;
	}

	

}