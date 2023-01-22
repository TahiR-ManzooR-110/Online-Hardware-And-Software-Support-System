package model;

import java.util.Date;

public class Complaints {
	
	private int complaintId;
    private String complaintType;
    private String complaintStatus;
    private Date complaintRaisedDate;
    private Date complaintResolutionDate;
    private int empId;
    private int engId;
    
    public Complaints() {}

	public Complaints(int complaintId, String complaintType, String complaintStatus, Date complaintRaisedDate,
			Date complaintResolutionDate, int empId, int engId) {
		super();
		this.complaintId = complaintId;
		this.complaintType = complaintType;
		this.complaintStatus = complaintStatus;
		this.complaintRaisedDate = complaintRaisedDate;
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

	public Date getComplaintRaisedDate() {
		return complaintRaisedDate;
	}

	public void setComplaintRaisedDate(Date complaintRaisedDate) {
		this.complaintRaisedDate = complaintRaisedDate;
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
				+ complaintStatus + ", complaintRaisedDate=" + complaintRaisedDate + ", complaintResolutionDate="
				+ complaintResolutionDate + ", empId=" + empId + ", engId=" + engId + "]";
	}
    
}
