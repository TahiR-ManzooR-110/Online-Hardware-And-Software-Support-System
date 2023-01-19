package model;

import java.util.Date;

public class Complaints {
	
	private int complaintId;
    private String complaintType;
    private String complaintStatus;
    private Date complaintRaiseDate;
    private Date complaintResolutionDate;
    private int empId;
    private int engId;
    
    public Complaints() {}

	public Complaints(int complaintId, String complaintType, String complaintStatus, Date complaintRaiseDate,
			Date complaintResolutionDate, int empId, int engId) {
		super();
		this.complaintId = complaintId;
		this.complaintType = complaintType;
		this.complaintStatus = complaintStatus;
		this.complaintRaiseDate = complaintRaiseDate;
		this.complaintResolutionDate = complaintResolutionDate;
		this.empId = empId;
		this.engId = engId;
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

	public int getEngId() {
		return engId;
	}

	public void setEngId(int engId) {
		this.engId = engId;
	}

	@Override
	public String toString() {
		return "Complaints [complaintId=" + complaintId + ", complaintType=" + complaintType + ", complaintStatus="
				+ complaintStatus + ", complaintRaiseDate=" + complaintRaiseDate + ", complaintResolutionDate="
				+ complaintResolutionDate + ", empId=" + empId + ", engId=" + engId + "]";
	}
    
}
