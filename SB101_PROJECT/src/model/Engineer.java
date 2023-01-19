package model;

public class Engineer {
	
	private int engId;
	private String engName;
	private String engUsername;
	private String engPassword;
	private String deptName;

	public Engineer() {}

	public Engineer(int engId, String engName, String engUsername, String engPassword, String deptName) {
		super();
		this.engId = engId;
		this.engName = engName;
		this.engUsername = engUsername;
		this.engPassword = engPassword;
		this.deptName = deptName;
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

	@Override
	public String toString() {
		return "Engineer [engId=" + engId + ", engName=" + engName + ", engUsername=" + engUsername + ", engPassword="
				+ engPassword + ", deptName=" + deptName + "]";
	}

}
