package model;

import java.util.Date;

public class Eng_CompDTO {
	
	private int engId;
	private String engName;
	private String engUsername;
	private String engPassword;
	private String deptName;
	private int complaintId;
    private String complaintType;
    private String complaintStatus;
    private Date complaintRaiseDate;
    private Date complaintResolutionDate;
    private int empId;
    
    public Eng_CompDTO() {}

	public Eng_CompDTO(int engId, String engName, String engUsername, String engPassword, String deptName,
			int complaintId, String complaintType, String complaintStatus, Date complaintRaiseDate,
			Date complaintResolutionDate, int empId) {
		super();
		this.engId = engId;
		this.engName = engName;
		this.engUsername = engUsername;
		this.engPassword = engPassword;
		this.deptName = deptName;
		this.complaintId = complaintId;
		this.complaintType = complaintType;
		this.complaintStatus = complaintStatus;
		this.complaintRaiseDate = complaintRaiseDate;
		this.complaintResolutionDate = complaintResolutionDate;
		this.empId = empId;
	}

	public int getEngId() {
		return engId;
	}

	public void setEngId(int engId) {
		this.engId = engId;
	}

	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	public String getEngUsername() {
		return engUsername;
	}

	public void setEngUsername(String engUsername) {
		this.engUsername = engUsername;
	}

	public String getEngPassword() {
		return engPassword;
	}

	public void setEngPassword(String engPassword) {
		this.engPassword = engPassword;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public String getComplaintType() {
		return complaintType;
	}

	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}

	public String getComplaintStatus() {
		return complaintStatus;
	}

	public void setComplaintStatus(String complaintStatus) {
		this.complaintStatus = complaintStatus;
	}

	public Date getComplaintRaiseDate() {
		return complaintRaiseDate;
	}

	public void setComplaintRaiseDate(Date complaintRaiseDate) {
		this.complaintRaiseDate = complaintRaiseDate;
	}

	public Date getComplaintResolutionDate() {
		return complaintResolutionDate;
	}

	public void setComplaintResolutionDate(Date complaintResolutionDate) {
		this.complaintResolutionDate = complaintResolutionDate;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Eng_CompDTO [engId=" + engId + ", engName=" + engName + ", engUsername=" + engUsername
				+ ", engPassword=" + engPassword + ", deptName=" + deptName + ", complaintId=" + complaintId
				+ ", complaintType=" + complaintType + ", complaintStatus=" + complaintStatus + ", complaintRaiseDate="
				+ complaintRaiseDate + ", complaintResolutionDate=" + complaintResolutionDate + ", empId=" + empId
				+ "]";
	}
}
