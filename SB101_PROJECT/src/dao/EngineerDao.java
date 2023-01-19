package dao;

import java.util.List;

import exception.ComplaintException;
import exception.EngineerException;
import model.Complaints;

public interface EngineerDao {

	public String engineerLogin(String engUsername, String engPassword) throws EngineerException;
	public List<Complaints> getAllAssignedComplaintsByHod(int engId) throws ComplaintException;
	public String updateTheStatusOfComplaint(int complaintId, String complaintStatus) throws ComplaintException;
	public List<Complaints> getListOfAttendedComplaints(int engId) throws ComplaintException;
	public String changeYourPasswordEngineer(String engUsername, String engPassword) throws EngineerException;

}
