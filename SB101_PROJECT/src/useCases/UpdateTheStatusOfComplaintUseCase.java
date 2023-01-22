package useCases;

import java.util.Scanner;

import custom.ConsoleColors;
import dao.EngineerDao;
import dao.EngineerDaoImpl;
import exception.ComplaintException;

public class UpdateTheStatusOfComplaintUseCase {
	
	public void updateStatus() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(ConsoleColors.ORANGE+"Enter Complaint ID: "+ConsoleColors.RESET);
		int complaintId = sc.nextInt();
		
		System.out.println(ConsoleColors.PURPLE+"+-----------------+" +"\n"
		                  +"| 1. In Progress. |" +"\n"
		                  +"| 2. Resolved.    |" +"\n"
		                  +"+-----------------+" + ConsoleColors.RESET);
		String complaintStatus = "";
		
		EngineerDao dao = new EngineerDaoImpl();
		
		int choice = sc.nextInt();
		
		if(choice == 1) {
			complaintStatus = "In Progress";
			try {
				String msg = dao.updateTheStatusOfComplaint(complaintId, complaintStatus);
				System.out.println(ConsoleColors.GREEN_BACKGROUND+msg+ConsoleColors.RESET);
			} catch (ComplaintException e) {
				System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
			}
		}else if(choice == 2) {
			complaintStatus = "Resolved";
			try {
				String msg = dao.updateTheStatusOfComplaint(complaintId, complaintStatus);
				System.out.println(ConsoleColors.GREEN_BACKGROUND+msg+ConsoleColors.RESET);
			} catch (ComplaintException e) {
				System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
			}
		}else {
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+"Invalid choice, please enter the correct choice."+ConsoleColors.RESET);
		}
	}

}
