package dao;

import java.util.List;

import exception.ComplaintException;
import exception.EmployeeException;
import model.Complaints;
import model.Eng_CompDTO;

public interface EmployeeDao {

	public String employeeRegistration(String empName, String empUsername, String empPassword, int deptId) throws EmployeeException;
	public String employeeLogin(String empUsername, String empPassword) throws EmployeeException;
	public int registerAComplaint(int empId, String complaintType) throws ComplaintException;
	public Eng_CompDTO getStatusOfYourComplaint(int complaintId) throws ComplaintException;
	public List<Complaints> getHistoryOfAllComplaints(int empId) throws ComplaintException;
	public String changeYourPasswordEmployee(String empUsername, String empPassword) throws EmployeeException;

}
