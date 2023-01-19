package model;

public class Hod {
	
	private String hodName;
	private String hodUsername;
	private String hodPassword;
	
	public Hod() {}

	public Hod(String hodName, String hodUsername, String hodPassword) {
		super();
		this.hodName = hodName;
		this.hodUsername = hodUsername;
		this.hodPassword = hodPassword;
	}

	public String getHodName() {
		return hodName;
	}

	public void setHodName(String hodName) {
		this.hodName = hodName;
	}

	public String getHodUsername() {
		return hodUsername;
	}

	public void setHodUsername(String hodUsername) {
		this.hodUsername = hodUsername;
	}

	public String getHodPassword() {
		return hodPassword;
	}

	public void setHodPassword(String hodPassword) {
		this.hodPassword = hodPassword;
	}

	@Override
	public String toString() {
		return "Hod [hodName=" + hodName + ", hodUsername=" + hodUsername + ", hodPassword=" + hodPassword + "]";
	}

}
