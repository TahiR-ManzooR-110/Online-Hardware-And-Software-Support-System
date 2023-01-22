package useCases;

import java.util.Scanner;

import custom.ConsoleColors;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import exception.EmployeeException;

public class EmployeeRegistrationUseCase {

	public void empRegister() {
		Scanner sc = new Scanner(System.in);

		System.out.println(ConsoleColors.ORANGE+"Enter your name: "+ConsoleColors.RESET);
		String engName = sc.next();

		System.out.println(ConsoleColors.ORANGE+"Enter your username(Email): "+ConsoleColors.RESET);
		String empUsername = sc.next();

		System.out.println(ConsoleColors.ORANGE+"Enter your password: "+ConsoleColors.RESET);
		String empPassword = sc.next();

		System.out.println(ConsoleColors.ORANGE+"Enter Department ID: "+ConsoleColors.RESET);
		int deptId = sc.nextInt();

		try {
			EmployeeDao dao = new EmployeeDaoImpl();
			String msg = dao.employeeRegistration(engName, empUsername, empPassword, deptId);
			System.out.println(ConsoleColors.GREEN_BACKGROUND+msg+ConsoleColors.RESET);
		} catch (EmployeeException e) {
			e.printStackTrace();
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
		}
	}
}
