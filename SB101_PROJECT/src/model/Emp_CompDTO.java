package model;

import java.util.Date;

public class Emp_CompDTO {
	
	private int empId;
	private String empName;
	private String empUsername;
	private String empPassword;
	private int deptId;
	private int complaintId;
    private String complaintType;
    private String complaintStatus;
    private Date complaintRaiseDate;
    private Date complaintResolutionDate;
    private int engId;
    
    public Emp_CompDTO() {}

	public Emp_CompDTO(int empId, String empName, String empUsername, String empPassword, int deptId, int complaintId,
			String complaintType, String complaintStatus, Date complaintRaiseDate, Date complaintResolutionDate,
			int engId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empUsername = empUsername;
		this.empPassword = empPassword;
		this.deptId = deptId;
		this.complaintId = complaintId;
		this.complaintType = complaintType;
		this.complaintStatus = complaintStatus;
		this.complaintRaiseDate = complaintRaiseDate;
		this.complaintResolutionDate = complaintResolutionDate;
		this.engId = engId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpUsername() {
		return empUsername;
	}

	public void setEmpUsername(String empUsername) {
		this.empUsername = empUsername;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
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

	public int getEngId() {
		return engId;
	}

	public void setEngId(int engId) {
		this.engId = engId;
	}

	@Override
	public String toString() {
		return "Emp_CompDTO [empId=" + empId + ", empName=" + empName + ", empUsername=" + empUsername
				+ ", empPassword=" + empPassword + ", deptId=" + deptId + ", complaintId=" + complaintId
				+ ", complaintType=" + complaintType + ", complaintStatus=" + complaintStatus + ", complaintRaiseDate="
				+ complaintRaiseDate + ", complaintResolutionDate=" + complaintResolutionDate + ", engId=" + engId
				+ "]";
	}
}
