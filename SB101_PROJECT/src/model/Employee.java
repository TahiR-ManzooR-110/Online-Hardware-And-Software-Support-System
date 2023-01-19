package model;

public class Employee {
	
	private int empId;
	private String empName;
	private String empUsername;
	private String empPassword;
	private int deptId;
	
	public Employee() {}

	public Employee(int empId, String empName, String empUsername, String empPassword, int deptId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empUsername = empUsername;
		this.empPassword = empPassword;
		this.deptId = deptId;
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

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empUsername=" + empUsername + ", empPassword="
				+ empPassword + ", deptId=" + deptId + "]";
	}

}
