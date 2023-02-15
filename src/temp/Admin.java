package temp;

public final class Admin {
	private static final String id = "admin";
	private static String password = "1111";
	
	public static String getId() {
		return Admin.id;
	}
	
	public static void changePassword(String password, String newPassword) {
		if(Admin.password.equals(password)) {
			Admin.password = newPassword;
		}
	}
	
	public static boolean checkPassword(String password) {
		if(Admin.password.equals(password)) {
			return true;
			}else {
				return false;
			}
	}
	
	
}
