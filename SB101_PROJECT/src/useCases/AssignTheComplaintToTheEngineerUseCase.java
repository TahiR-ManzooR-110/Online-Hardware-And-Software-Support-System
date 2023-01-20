package useCases;

import java.util.Scanner;

import custom.ConsoleColors;
import dao.HodDao;
import dao.HodDaoImpl;
import exception.EngineerException;

public class AssignTheComplaintToTheEngineerUseCase {
	
	public void assignComplaint() {
		Scanner sc = new Scanner(System.in);
	
		System.out.println(ConsoleColors.ORANGE+"Enter Complaint ID: "+ConsoleColors.RESET);
		int complaintId = sc.nextInt();
		
		System.out.println(ConsoleColors.ORANGE+"Enter Engineer ID: "+ConsoleColors.RESET);
		int engId = sc.nextInt();
		
		try {
			HodDao dao = new HodDaoImpl();
			String msg = dao.assignTheComplaintToTheEngineer(complaintId, engId);
			System.out.println(ConsoleColors.GREEN_BACKGROUND+msg+ConsoleColors.RESET);
		} catch (EngineerException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
			System.out.println();
		}
	}

}
