package useCases;

import java.util.Scanner;

import custom.ConsoleColors;
import dao.EngineerDao;
import dao.EngineerDaoImpl;
import exception.EngineerException;

public class ChangeYourPasswordEngineerUseCase {

	public void changePasswordEngineer() {
		Scanner sc = new Scanner(System.in);

		System.out.println(ConsoleColors.ORANGE+"Enter your username(Email): "+ConsoleColors.RESET);
		String empUsername = sc.next();

		System.out.println(ConsoleColors.ORANGE+"Enter your new password: "+ConsoleColors.RESET);
		String newPassword = sc.next();

		try {
			EngineerDao dao = new EngineerDaoImpl();
			String msg = dao.changeYourPasswordEngineer(empUsername, newPassword);
			System.out.println(ConsoleColors.GREEN_BACKGROUND+ msg+ConsoleColors.RESET);
			System.out.println();
		} catch (EngineerException e) {
			e.printStackTrace();
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
		}

	}

}
