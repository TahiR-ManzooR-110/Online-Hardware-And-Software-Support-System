package useCases;

import java.util.List;

import custom.ConsoleColors;
import dao.HodDao;
import dao.HodDaoImpl;
import exception.ComplaintException;
import model.Complaints;

public class GetListOfAllComplaintsUseCase {
	
	public void listOfComplaints() {
		HodDao dao = new HodDaoImpl();
		List<Complaints> complaints;
		try {
			complaints = dao.getListOfAllComplaints();
			complaints.forEach(c -> {
				System.out.println(ConsoleColors.BLACK_BOLD_BRIGHT+"=========================================================="+ConsoleColors.RESET);
				System.out.println(ConsoleColors.ORANGE+"Complaint ID: "+ConsoleColors.RESET+c.getComplaintId());
				System.out.println(ConsoleColors.ORANGE+"Complaint Type: "+ConsoleColors.RESET+c.getComplaintType());
				System.out.println(ConsoleColors.ORANGE+"Complaint Status: "+ConsoleColors.RESET+c.getComplaintStatus());
				System.out.println(ConsoleColors.ORANGE+"Complaint Raised On: "+ConsoleColors.RESET+c.getComplaintRaiseDate());
				System.out.println(ConsoleColors.ORANGE+"Complaint Resolved On: "+ConsoleColors.RESET+c.getComplaintResolutionDate());
				System.out.println(ConsoleColors.ORANGE+"Complaint Raised By Employee With ID: "+ConsoleColors.RESET+c.getEmpId());
				System.out.println(ConsoleColors.ORANGE+"Complaint Assigned To An Engineer with ID: "+ConsoleColors.RESET+c.getEngId());
				System.out.println(ConsoleColors.BLACK_BOLD_BRIGHT+"=========================================================="+ConsoleColors.RESET);
			});
		} catch (ComplaintException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
			System.out.println();
		}
	
	}

}
