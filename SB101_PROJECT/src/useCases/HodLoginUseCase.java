package useCases;

import java.util.Scanner;

import custom.ConsoleColors;
import dao.HodDao;
import dao.HodDaoImpl;
import exception.HodException;
import model.Hod;

public class HodLoginUseCase {
	
	public void loginHod() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println(ConsoleColors.ORANGE+ "Enter Username(Email): " + ConsoleColors.RESET);
		String hodUsername = sc.next();
		
		System.out.println(ConsoleColors.ORANGE+ "Enter Password: " + ConsoleColors.RESET);
		String hodPassword = sc.next();
		
		try {
			HodDao dao = new HodDaoImpl();
			Hod hod = dao.hodLogin(hodUsername, hodPassword);
			System.out.println(ConsoleColors.GREEN_BACKGROUND + "Login Successfull!" + ConsoleColors.RESET);
			System.out.println();
			System.out.println(ConsoleColors.BLUE_BOLD + "Welcome "+hod.getHodName()+ConsoleColors.RESET);
		} catch (HodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
			System.out.println();
			loginHod();
		}
		
	}

}
