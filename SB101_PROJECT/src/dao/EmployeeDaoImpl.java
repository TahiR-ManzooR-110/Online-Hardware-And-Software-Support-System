package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import custom.ConsoleColors;
import exception.ComplaintException;
import exception.EmployeeException;
import model.Complaints;
import model.Employee;
import utility.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public String employeeRegistration(String empName, String empUsername, String empPassword, int deptId)
			throws EmployeeException {
		String msg = "Registration Failed, please try again...";

		try(Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("insert into Employee (empName,empUsername,empPassword,deptId)"
					+ "values(?,?,?,?)");
			ps.setString(1, empName);
			ps.setString(2, empUsername);
			ps.setString(3, empPassword);
			ps.setInt(4, deptId);

			int x = ps.executeUpdate();
			
			if(x>0) {
				msg = "Registration Successfull!";
			}else {
				throw new EmployeeException("Registration Failed, please enter your details correctly.");
			}


		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}

		return msg;
	}

	@Override
	public Employee employeeLogin(String empUsername, String empPassword) throws EmployeeException {
		Employee employee = new Employee();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from employee where empUsername = ?"
					+ "and empPassword = ?");
			
			ps.setString(1, empUsername);
			ps.setString(2, empPassword);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				employee.setEmpId(rs.getInt("empId"));
				employee.setEmpName(rs.getString("empName"));
				employee.setEmpUsername(rs.getString("empUsername"));
				employee.setEmpPassword(rs.getString("empPassword"));
				employee.setDeptId(rs.getInt("deptId"));
			}else {
				throw new EmployeeException("Invalid Username or Password, please try again...");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} 
		
		return employee;
	}

	@Override
	public int registerAComplaint(int empId, String complaintType) throws ComplaintException {
		int complaintId = 0;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into complaints (complaintId, complaintType, complaintStatus, complaintRaisedDate, empId) values(?,?,?,?,?)");
			
			complaintId = (int) (Math.random()*100000000);
			LocalDate complaintRaiseDate = LocalDate.now();
			
			ps.setInt(1, complaintId);
			ps.setString(2, complaintType);
			ps.setString(3, "Raised");
			ps.setDate(4, java.sql.Date.valueOf(complaintRaiseDate));
			ps.setInt(5, empId);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				System.out.println(ConsoleColors.GREEN_BACKGROUND+"Your Complaint has been registered successfully with complaint ID "+complaintId+ConsoleColors.RESET);
			}else {
				throw new ComplaintException(ConsoleColors.RED_BACKGROUND_BRIGHT+"Something went wrong!, Please try again..."+ConsoleColors.RESET);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ComplaintException(e.getMessage());
		}
		
		return complaintId;
	}

	@Override
	public Complaints getStatusOfYourComplaint(int complaintId, int empId) throws ComplaintException {
		Complaints check = new Complaints();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from complaints where complaintId = ? AND empId = ?");
			ps.setInt(1, complaintId);
			ps.setInt(2, empId);
			ResultSet rs = ps.executeQuery();
			
			 if(rs.next()) {
				check.setComplaintId(rs.getInt("complaintId"));
				check.setComplaintType(rs.getString("complaintType"));
				check.setComplaintStatus(rs.getString("complaintStatus"));
				check.setComplaintRaisedDate(rs.getDate("complaintRaisedDate"));
				check.setComplaintResolutionDate(rs.getDate("complaintResolutionDate"));
				check.setEmpId(rs.getInt("empId"));
				check.setEngId(rs.getInt("engId"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
		}
		
		
		return check;
	}

	@Override
	public List<Complaints> getHistoryOfAllComplaints(int empId) throws ComplaintException {
		List<Complaints> complaints = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from complaints where empId = ?");
			ps.setInt(1, empId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Complaints com = new Complaints();
				
				com.setComplaintId(rs.getInt("complaintId"));
				com.setComplaintType(rs.getString("complaintType"));
				com.setComplaintStatus(rs.getString("complaintStatus"));
				com.setComplaintRaisedDate(rs.getDate("ComplaintRaisedDate"));
				com.setComplaintResolutionDate(rs.getDate("ComplaintResolutionDate"));
				com.setEmpId(rs.getInt("empId"));
				com.setEngId(rs.getInt("engId"));
				
				complaints.add(com);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ComplaintException(e.getMessage());
		}
		
		return complaints;
	}

	@Override
	public String changeYourPasswordEmployee(String empUsername, String empPassword) throws EmployeeException {
		String msg = "Something went wrong!, please try again...";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update employee set empPassword = ? where empUsername = ?");
			
			ps.setString(1, empPassword);
			ps.setString(2, empUsername);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				msg = "Your password has been changed successfully!";
			}else {
				throw new EmployeeException("Something went wrong!, please check your username.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		
		return msg;
	}

}
