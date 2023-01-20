package useCases;

import java.util.Scanner;

import custom.ConsoleColors;
import dao.HodDao;
import dao.HodDaoImpl;
import exception.EngineerException;

public class RegisterANewEngineerUseCase {
	
	public void engineerRegistrationByHod() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(ConsoleColors.ORANGE+"Enter your name: "+ ConsoleColors.RESET);
		String engName = sc.next();
		
		System.out.println(ConsoleColors.ORANGE+"Enter your username(Email)"+ ConsoleColors.RESET);
		String engUsername = sc.next();
		
		System.out.println(ConsoleColors.ORANGE+"Enter your password"+ ConsoleColors.RESET);
		String engPassword = sc.next();
		
		System.out.println(ConsoleColors.ORANGE+"Enter your department(Hardware or Software)"+ ConsoleColors.RESET);
		String deptName = sc.next();
		
		try {
			HodDao dao = new HodDaoImpl();
			String msg = dao.registerANewEngineer(engName, engUsername, engPassword, deptName);
			System.out.println(ConsoleColors.GREEN_BACKGROUND+msg+ConsoleColors.RESET);
			System.out.println();
		} catch (EngineerException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
			System.out.println();
			engineerRegistrationByHod();
		}
		
	}

}
