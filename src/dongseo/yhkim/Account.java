package dongseo.yhkim;

public class Account implements Comparable<Account>{
	private int accountNumber;//¿Ø¿œ
	
	private int balance;
	private String user;
	private String password;
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int compareTo(Account account) {
		System.out.println(this.balance - account.getBalance());
		return this.balance - account.getBalance();
	}
	
}
