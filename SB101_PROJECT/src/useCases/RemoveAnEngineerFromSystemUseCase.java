package useCases;

import java.util.Scanner;

import custom.ConsoleColors;
import dao.HodDao;
import dao.HodDaoImpl;
import exception.EngineerException;

public class RemoveAnEngineerFromSystemUseCase {
	
	public void engineerRemove() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(ConsoleColors.ORANGE+"Enter Engineer's ID: "+ConsoleColors.RESET);
		int engId = sc.nextInt();
		
		try {
			HodDao dao = new HodDaoImpl();
			String msg = dao.removeAnEngineerFromSystem(engId);
			System.out.println(ConsoleColors.GREEN_BACKGROUND+msg+ConsoleColors.RESET);
			System.out.println();
		} catch (EngineerException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
			System.out.println();
			engineerRemove();
		}
	}
}
