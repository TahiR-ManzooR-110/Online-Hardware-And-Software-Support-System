package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.ComplaintException;
import exception.EngineerException;
import exception.HodException;
import model.Complaints;
import model.Engineer;
import model.Hod;
import utility.DBUtil;

public class HodDaoImpl implements HodDao{

	@Override
	public Hod hodLogin(String hodUsername, String hodPassword) throws HodException {
		Hod hod = new Hod();

		try(Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("select * from hod where hodUsername = ? and hodPassword = ?");
			ps.setString(1, hodUsername);
			ps.setString(2, hodPassword);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				hod.setHodName(rs.getString("hodName"));
				hod.setHodUsername(rs.getString("hodUsername"));
				hod.setHodPassword(rs.getString("hodPassword"));
			}else {
				throw new HodException("Invalid Username or Password.");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new HodException(e.getMessage());
		}
		return hod;
	}

	@Override
	public String registerANewEngineer(String engName, String engUsername, String engPassword, String deptName)
			throws EngineerException {
		String msg="Registration Failed! Invalid credentials, please try again...";
		
		try(Connection conn=DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into Engineer(engName,engUsername,engPassword,deptName) values(?,?,?,?)");
			
			ps.setString(1, engName);
			ps.setString(2, engUsername);
			ps.setString(3, engPassword);
			ps.setString(4, deptName);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				msg="Engineer Registered Successfully!";
			}else {
				throw new EngineerException("Registration Failed! Invalid credentials, please try again...");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EngineerException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public List<Engineer> getListOfAllEngineers() throws EngineerException {
		List<Engineer> engList = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from Engineer");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Engineer engineer=new Engineer();
				
				engineer.setEngId(rs.getInt("engId"));
				engineer.setEngName(rs.getString("engName"));
				engineer.setEngUsername(rs.getString("engUsername"));
				engineer.setEngPassword(rs.getString("engPassword"));
				engineer.setDeptName(rs.getString("deptName"));
				
				engList.add(engineer);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new EngineerException(e.getMessage());
		}
		
		return engList;
	}

	@Override
	public String removeAnEngineerFromSystem(int engId) throws EngineerException {
		String msg="Engineer with ID "+engId+" not found, please try again...";
		
		try (Connection conn=DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("delete from Engineer where engId = ?");
			
			ps.setInt(1, engId);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				msg="Engineer with ID "+engId+" has been deleted successfully!";
			}else {
				throw new EngineerException("Engineer with ID "+engId+" not found, please try again...");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new EngineerException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public List<Complaints> getListOfAllComplaints() throws ComplaintException {
		List<Complaints> complaintList = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from Complaints where complaintStatus='Raised'");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Complaints com = new Complaints();
				
				com.setComplaintId(rs.getInt("complaintId"));
				com.setComplaintType(rs.getString("complaintType"));
				com.setComplaintStatus(rs.getString("complaintStatus"));
				com.setComplaintRaiseDate(rs.getDate("complaintRaiseDate"));
				com.setComplaintResolutionDate(rs.getDate("complaintResolutionDate"));
				com.setEmpId(rs.getInt("empId"));
				com.setEngId(rs.getInt("engId"));
				
				complaintList.add(com);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ComplaintException(e.getMessage());
		}
		
		return complaintList;
	}

	@Override
	public String assignTheComplaintToTheEngineer(int complaintId, int engId) throws EngineerException {
		String msg="Complaint with ID "+complaintId+" not found, please try again.";
		
		try (Connection conn=DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update Complaints set engId = ?, complaintStatus = 'Assigned' where complaintId = ?");
			
			ps.setInt(1, engId);
			ps.setInt(2, complaintId);
			
			int x=ps.executeUpdate();
			
			if(x>0) {
				msg="Complaint with complaintID "+complaintId+" assigned to the Engineer with ID "+engId+" Successfully!";
			}else {
				throw new EngineerException("Engineer with ID "+engId+" not found, please enter correct ID.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EngineerException(e.getMessage());
		}
		
		return msg;
	}

}
