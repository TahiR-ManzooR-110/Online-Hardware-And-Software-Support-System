package useCases;

import java.util.List;

import custom.ConsoleColors;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import exception.ComplaintException;
import model.Complaints;

public class GetHistoryOfAllComplaintsUseCase {
	
	public void complaintHistory(int empId) {
		EmployeeDao dao = new EmployeeDaoImpl();
		try {
			List<Complaints> complaints = dao.getHistoryOfAllComplaints(empId);
			complaints.forEach(c -> {
				System.out.println(ConsoleColors.BLACK_BOLD_BRIGHT+"=========================================================="+ConsoleColors.RESET);
				System.out.println(ConsoleColors.ORANGE+"Complaint ID: "+ConsoleColors.RESET+c.getComplaintId());
				System.out.println(ConsoleColors.ORANGE+"Complaint Type: "+ConsoleColors.RESET+c.getComplaintType());
				System.out.println(ConsoleColors.ORANGE+"Complaint Status: "+ConsoleColors.RESET+c.getComplaintStatus());
				System.out.println(ConsoleColors.ORANGE+"Complaint Raised On: "+ConsoleColors.RESET+c.getComplaintRaisedDate());
				System.out.println(ConsoleColors.ORANGE+"Complaint Resolved On: "+ConsoleColors.RESET+c.getComplaintResolutionDate());
				System.out.println(ConsoleColors.ORANGE+"Your Employee ID: "+ConsoleColors.RESET+c.getEmpId());
				System.out.println(ConsoleColors.ORANGE+"Complaint Assigned To An Engineer with ID: "+ConsoleColors.RESET+c.getEngId());
				System.out.println(ConsoleColors.BLACK_BOLD_BRIGHT+"=========================================================="+ConsoleColors.RESET);
			});
		} catch (ComplaintException e) {
			e.printStackTrace();
			System.out.println(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
			System.out.println();
		}
	}

}
