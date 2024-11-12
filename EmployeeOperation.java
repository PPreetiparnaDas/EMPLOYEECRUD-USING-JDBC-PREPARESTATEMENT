package EmployeeOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class EmployeeOperation {
	private static Connection con=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	private static String sql=null;

	public static Connection getCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bcet","root","preeti");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static int addEmployee(Employee emp) {
		int status=0;
		try {
			con=getCon();
			String query="insert into employee(empid,empName,empEmail,empPass)values(?,?,?,?)";

			ps=con.prepareStatement(query);
			ps.setInt(1, emp.getEmpId());
			ps.setString(2,emp.getEmpName());
			ps.setString(3,emp.getEmpEmail());
			ps.setString(4,emp.getEmpPass());
			status=ps.executeUpdate();
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;

	}
	public static void viewEmployee() {

		try {
			con=getCon();
			String query="Select empId,empName,empEmail,empPass from bcet.employee";
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("EmployeeId :"+rs.getInt(1));
				System.out.println("Employee  :"+rs.getString(2));
				System.out.println("EmployeeId :"+rs.getString(3));
				System.out.println("EmployeeId :"+rs.getString(4));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void viewEmployeebyId(int empId) {
		try {
			con=getCon();
			String query="Select empId,empName,empEmail,empPass from employee where empid=?";
			ps=con.prepareStatement(query);
			ps.setInt(1, empId);
			rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("Employee Id :"+rs.getInt(1));
				System.out.println("Employee Name :"+rs.getString(2));
				System.out.println("Employee Email :"+rs.getString(3));
				System.out.println("Employee Pass :"+rs.getString(4));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static int updateEmployee(Employee uemp) {
		int status=0;
		try {
			con=getCon();
			String query="update employee set empName=?,empEmail=?,empPass=? where empId=?";
			ps=con.prepareStatement(query);
			ps.setString(1,uemp.getEmpName());
			ps.setString(2,uemp.getEmpEmail());
			ps.setString(3,uemp.getEmpPass());
			ps.setInt(4, uemp.getEmpId());
			status=ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}
	public static int deleteEmployee(int empId) {
	    int status = 0;
	    try {
	        con = getCon();
	        
	        String query = "DELETE FROM employee WHERE empId = ?";
	        ps = con.prepareStatement(query);
	        
	        ps.setInt(1, empId);
	        
	        status = ps.executeUpdate();
	        
	        ps.close();
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return status;
	}

}
