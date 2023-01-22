package useCases;

import java.util.Scanner;

import custom.ConsoleColors;
import dao.EngineerDao;
import dao.EngineerDaoImpl;
import exception.EngineerException;
import model.Engineer;

public class EngineerLoginUseCase {
	
	public int loginAsEngineer() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(ConsoleColors.ORANGE+"Enter your username(Email): "+ConsoleColors.RESET);
		String engUsername = sc.next();
		
		System.out.println(ConsoleColors.ORANGE+"Enter your password: "+ConsoleColors.RESET);
		String engPassword = sc.next();
		
		EngineerDao dao = new EngineerDaoImpl();
		int engId = 0;
		try {
			Engineer engineer = dao.engineerLogin(engUsername, engPassword);
			System.out.println(ConsoleColors.GREEN_BACKGROUND+"Login successfull!"+ConsoleColors.RESET);
			System.out.println();
			System.out.println(ConsoleColors.BLUE_BOLD+"Welcome " + engineer.getEngName()+" (Engineer)"+ConsoleColors.RESET);
			engId=engineer.getEngId();
		} catch (EngineerException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
			System.out.println();
			loginAsEngineer();
		}
		return engId;
	}

}
