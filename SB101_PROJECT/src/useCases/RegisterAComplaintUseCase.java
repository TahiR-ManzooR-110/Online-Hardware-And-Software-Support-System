package useCases;

import java.util.Scanner;

import custom.ConsoleColors;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import exception.ComplaintException;

public class RegisterAComplaintUseCase {
	
	public void complaintRegister(int empId) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(ConsoleColors.PURPLE +"+----------------------------------+" + "\n"
		                  						+"| 1. Complaint regarding Hardware. |" + "\n"
		                                        +"| 2. Complaint regarding Software. |" + "\n"
		                                        +"+----------------------------------+" + "\n"+ConsoleColors.RESET);
		int choice = sc.nextInt();
		
		String complaintType="NA";
		
		if(choice == 1) {
			complaintType = "Hardware";
		}else if(choice == 2) {
			complaintType = "Software";
		}else {
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+"Invalid Choice, please try again..."+ConsoleColors.RESET);
			System.out.println();
			complaintRegister(empId);
		}
		
		try {
			EmployeeDao dao = new EmployeeDaoImpl();
			dao.registerAComplaint(empId, complaintType);
			System.out.println();
		} catch (ComplaintException e) {
			e.printStackTrace();
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
		}
	}

}
