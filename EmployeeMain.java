package EmployeeOperation;

import java.util.Scanner;

public class EmployeeMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean running =true;

		while(running) {
			System.out.println("\nEmployee CRUD Operations:");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employees");
			System.out.println("3.View employee by id :");
			System.out.println("4. Update Employee");
			System.out.println("5. Delete Employee");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				//add employee
				System.out.print("Enter Employee ID: ");
				int id = sc.nextInt();
				System.out.print("Enter Employee Name: ");
				String name = sc.next();
				System.out.print("Enter Email: ");
				String email = sc.next();
				System.out.print("Enter pass : ");
				String pass = sc.next();
				
				Employee emp = new Employee();
               // emp.setEmpId(id);
                emp.setEmpName(name);
                emp.setEmpEmail(email);
                emp.setEmpPass(pass);
				
                int status = EmployeeOperation.addEmployee(emp);
                if (status > 0) {
                    System.out.println("Employee added successfully!");
                } else {
                    System.out.println("Failed to add employee.");
                }
				break;
			case 2:
				//view employee
				EmployeeOperation.viewEmployee();
				
				break;
			case 3:
				//View employee by id
				System.out.println("Enter EmployeeId :");
				int empId=sc.nextInt();
				EmployeeOperation.viewEmployeebyId(empId);
				break;
			case 4:
				//Update Employee
				System.out.print("Enter Employee ID: ");
				int uid = sc.nextInt();
				System.out.print("Enter Employee Name: ");
				String uname = sc.next();
				System.out.print("Enter Email: ");
				String uemail = sc.next();
				System.out.print("Enter pass : ");
				String upass = sc.next();
				
				
				Employee uemp=new Employee();
				uemp.setEmpId(uid);
				uemp.setEmpName(uname);
				uemp.setEmpEmail(uemail);
				uemp.setEmpPass(upass);
				int status1 = EmployeeOperation.updateEmployee(uemp);
                if (status1 > 0) {
                    System.out.println(" successfull!");
                } else {
                    System.out.println(" not successfull");
                }
				break;
			case 5:
				//Delete Employee
				System.out.print("Enter Employee ID: ");
				int uid2 = sc.nextInt();
				int status2 = EmployeeOperation.deleteEmployee(uid2);
                if (status2 > 0) {
                    System.out.println(" successfull!");
                } else {
                    System.out.println(" not successfull");
                }
				break;
			case 6:
				//Exit
				break;
			
			}
		}
	}
}
