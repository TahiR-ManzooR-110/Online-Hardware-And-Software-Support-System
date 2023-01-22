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
import exception.EngineerException;
import model.Complaints;
import model.Engineer;
import utility.DBUtil;

public class EngineerDaoImpl implements EngineerDao{

	@Override
	public Engineer engineerLogin(String engUsername, String engPassword) throws EngineerException {
		Engineer engineer = new Engineer();

		try(Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from engineer where engUsername = ? and engPassword = ?");

			ps.setString(1, engUsername);
			ps.setString(2, engPassword);

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				engineer.setEngId(rs.getInt("engId"));
				engineer.setEngName(rs.getString("engName"));
				engineer.setEngUsername(rs.getString("engUsername"));
				engineer.setEngPassword(rs.getString("engPassword"));
				engineer.setDeptName(rs.getString("deptName"));
			} else {
				throw new EngineerException("Invalid username or password, please try again...");
			}

		} catch (SQLException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
		}
		return engineer;
	}

	@Override
	public List<Complaints> getAllAssignedComplaintsByHod(int engId) throws ComplaintException {
		List<Complaints> complaints = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from complaints where engId=? and complaintStatus='Assigned'");
			
			ps.setInt(1, engId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Complaints com = new Complaints();
				
				com.setComplaintId(rs.getInt("complaintId"));
				com.setComplaintType(rs.getString("complaintType"));
				com.setComplaintStatus(rs.getString("complaintStatus"));
				com.setComplaintRaisedDate(rs.getDate("complaintRaisedDate"));
				com.setComplaintResolutionDate(rs.getDate("complaintResolutionDate"));
				com.setEmpId(rs.getInt("empId"));
				com.setEngId(rs.getInt("engId"));
						
				complaints.add(com);
			}
			
			
		} catch (SQLException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
		}
		
		return complaints;
	}

	@Override
	public String updateTheStatusOfComplaint(int complaintId, String complaintStatus) throws ComplaintException {
		String msg = "Complaint ID not found, please enter the correct complaint ID.";
		try (Connection conn = DBUtil.provideConnection()){
			int x = 0;
			if(complaintStatus.equals("Resolved")) {
				PreparedStatement ps = conn.prepareStatement("update complaints set complaintStatus = ?, complaintResolutionDate = ? where complaintId = ?");
				LocalDate resolutionDate = LocalDate.now();
				ps.setString(1, complaintStatus);
				ps.setDate(2, java.sql.Date.valueOf(resolutionDate));
				ps.setInt(3, complaintId);
				x = ps.executeUpdate();
				
			}else {
				PreparedStatement ps = conn.prepareStatement("update complaints set complaintStatus = ?, complaintResolutionDate = null where complaintId = ?");
				
				ps.setString(1, complaintStatus);
				ps.setInt(2, complaintId);
				x = ps.executeUpdate();
			}
			if(x>0) {
				msg = "Complaint status with Complaint ID "+complaintId+" updated successfully!";
			}else {
				throw new ComplaintException("Complaint with ID "+complaintId+" not found, please enter the correct complaint ID.");
			}
			
		} catch (SQLException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
		}
		
		return msg;
	}

	@Override
	public List<Complaints> getListOfAttendedComplaints(int engId) throws ComplaintException {
		List<Complaints> complaints = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from complaints where engId = ? AND complaintStatus='Resolved'");	
			ps.setInt(1, engId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Complaints com = new Complaints();
				
				com.setComplaintId(rs.getInt("complaintId"));
				com.setComplaintType(rs.getString("complaintType"));
				com.setComplaintStatus(rs.getString("complaintStatus"));
				com.setComplaintRaisedDate(rs.getDate("complaintRaisedDate"));
				com.setComplaintResolutionDate(rs.getDate("complaintResolutionDate"));
				com.setEmpId(rs.getInt("empId"));
				com.setEngId(rs.getInt("engId"));
				
				complaints.add(com);
			}
			
		} catch (SQLException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
		}
		
		return complaints;
	}

	@Override
	public String changeYourPasswordEngineer(String engUsername, String engPassword) throws EngineerException {
		String msg = "Wrong username or password.";
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("update engineer set engPassword = ? where engUsername = ?");
			ps.setString(1, engPassword);
			ps.setString(2, engUsername);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				msg = "Password changed successfully!";
			}else {
				throw new EngineerException("Wrong username or password.");
			}
		} catch (SQLException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
		}
		
		return ConsoleColors.GREEN_BACKGROUND+msg+ConsoleColors.RESET;
	}
}
