package useCases;

import java.util.Scanner;

import custom.ConsoleColors;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import exception.EmployeeException;
import model.Employee;

public class EmployeeLoginUseCase {
	
	public int loginAsEmployee() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(ConsoleColors.ORANGE+"Enter your username(Email): "+ConsoleColors.RESET);
		String engUsername = sc.next();
		
		System.out.println(ConsoleColors.ORANGE+"Enter your password: "+ConsoleColors.RESET);
		String engPassword = sc.next();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		int empId = 0;
		
		try {
			Employee employee = dao.employeeLogin(engUsername, engPassword);
			System.out.println(ConsoleColors.GREEN_BACKGROUND+"Login successfull!"+ConsoleColors.RESET);
			System.out.println();
			System.out.println(ConsoleColors.BLUE_BOLD+"Welcome " + employee.getEmpName()+" (Employee)"+ConsoleColors.RESET);
			empId=employee.getEmpId();
		} catch (EmployeeException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
			System.out.println();
			loginAsEmployee();
		}
		return empId;
	}

}
