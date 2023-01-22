package useCases;

import java.util.Scanner;

import custom.ConsoleColors;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import exception.ComplaintException;
import model.Complaints;

public class GetStatusOfYourComplaintUseCase {
	public void complaint_Status(int empId) {
		Scanner sc = new Scanner(System.in);
		System.out.println(ConsoleColors.ORANGE+"Enter your complaint ID: "+ConsoleColors.RESET);
		
		int complaintId = sc.nextInt();
	
		try {
			EmployeeDao dao = new EmployeeDaoImpl();
			Complaints details =  dao.getStatusOfYourComplaint(complaintId,empId);
		
			if(details.getComplaintId() != 0) {
			System.out.println(ConsoleColors.ORANGE+"Complaint ID: "+ConsoleColors.RESET+details.getComplaintId());
			System.out.println(ConsoleColors.ORANGE+"Complaint Type: "+ConsoleColors.RESET+details.getComplaintType());
			System.out.println(ConsoleColors.ORANGE+"Complaint Status: "+ConsoleColors.RESET+details.getComplaintStatus());
			System.out.println(ConsoleColors.ORANGE+"Complaint Raised On: "+ConsoleColors.RESET+details.getComplaintRaisedDate());
			System.out.println(ConsoleColors.ORANGE+"Complaint Resolved On: "+ConsoleColors.RESET+details.getComplaintResolutionDate());
			System.out.println(ConsoleColors.ORANGE+"Employee's ID: "+ConsoleColors.RESET+details.getEmpId());
			System.out.println(ConsoleColors.ORANGE+"Engineer's ID: "+ConsoleColors.RESET+details.getEngId());
			}else {
				System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+" Invalid Complaint ID "+ConsoleColors.RESET);
			}
			
		} catch (ComplaintException e) {
			e.printStackTrace();
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ e.getMessage()+ConsoleColors.RESET);
		}
	}

}
