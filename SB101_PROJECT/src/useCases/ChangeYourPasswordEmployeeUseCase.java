package useCases;

import java.util.Scanner;

import custom.ConsoleColors;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import exception.EmployeeException;

public class ChangeYourPasswordEmployeeUseCase {
	
	public void changePasswordEmployee() {
		Scanner sc = new Scanner(System.in);

		System.out.println(ConsoleColors.ORANGE+"Enter your username(Email): "+ConsoleColors.RESET);
		String empUsername = sc.next();

		System.out.println(ConsoleColors.ORANGE+"Enter new password: "+ConsoleColors.RESET);
		String newPassword = sc.next();

		try {
			EmployeeDao dao = new EmployeeDaoImpl();
			String msg = dao.changeYourPasswordEmployee(empUsername, newPassword);
			System.out.println(ConsoleColors.GREEN_BACKGROUND+ msg+ConsoleColors.RESET);
			System.out.println();
		} catch (EmployeeException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
		}
	}

}
