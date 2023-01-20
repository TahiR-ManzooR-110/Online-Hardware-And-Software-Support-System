package dao;

import java.util.List;

import exception.ComplaintException;
import exception.EngineerException;
import exception.HodException;
import model.Complaints;
import model.Engineer;
import model.Hod;

public interface HodDao {

	public Hod hodLogin(String hodUsername, String hodPassword) throws HodException;
	public String registerANewEngineer(String engName, String engUsername, String engPassword, String deptName) throws EngineerException;
	public List<Engineer> getListOfAllEngineers() throws EngineerException;
	public String removeAnEngineerFromSystem(int engId) throws EngineerException;
	public List<Complaints> getListOfAllComplaints() throws ComplaintException;
	public String assignTheComplaintToTheEngineer(int complaintId, int engId) throws EngineerException; 

}
