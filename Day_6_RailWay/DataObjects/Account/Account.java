package Account;

import Common.Utilities;

public class Account {
	private String Email;
	private String Password;
	private String ConfirmPwd;
	private String PID;

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getConfirmPwd() {
		return ConfirmPwd;
	}

	public void setConfirmPwd(String confirmPwd) {
		ConfirmPwd = confirmPwd;
	}

	public String getPID() {
		return PID;
	}

	public void setPID(String pID) {
		PID = pID;
	}
	
	public void InitUserData() {
		Utilities ult = new Utilities();
		String currentPass = ult.randomPassword(9);
		this.setEmail(ult.randomEmail());
		this.setPassword(currentPass);
		this.setConfirmPwd(currentPass);
		this.setPID(ult.randomPID(9));
	}
	
	public void InitUserDataWrongEmail() {
		Utilities ult = new Utilities();
		String currentPass = ult.randomPassword(9);
		this.setEmail("seltrain2015@gmail.com");
		this.setPassword(currentPass);
		this.setConfirmPwd(currentPass);
		this.setPID(ult.randomPID(9));
	}
	
	public void InitUserDataEmptyPwdAndPid() {
		Utilities ult = new Utilities();
		String currentPass = ult.randomPassword(9);
		this.setEmail(ult.randomEmail());
		this.setPassword("");
		this.setConfirmPwd(currentPass);
		this.setPID("");
	}
}
