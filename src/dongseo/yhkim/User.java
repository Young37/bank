package dongseo.yhkim;

import java.util.ArrayList;

public class User implements Comparable<User>{
	private String id;// 유일

	private String password;
	private String name;
	private int phone;
	private ArrayList<Integer> accountNumberList = new ArrayList<Integer>();// null pointer방지

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public ArrayList<Integer> getAccountNumberList() {
		return accountNumberList;
	}

	public void setAccountNumberList(ArrayList<Integer> accountNumberList) {
		this.accountNumberList = accountNumberList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int compareTo(User user) {
			return this.id.compareTo(user.getId());
	}
}
