package dongseo.yhkim;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class UserManager {
	private ArrayList<User> userList = new ArrayList<User>();
	Scanner scanner = new Scanner(System.in);

	public void signUp() {// ���� ����
		User newUser = new User();
		//
		System.out.print("���̵� : ");
		String id = scanner.nextLine();
		if (id.equals("admin")) {
			System.out.println("|������ ���̵� ��� �Ұ���|");
			return;
		}
		for (User duplicationCheck : userList)
			if (id.equals(duplicationCheck.getId())) {
				System.out.println("|���̵� �ߺ�|");
				return;
			}
		newUser.setId(id);
		//
		System.out.print("��й�ȣ : ");
		newUser.setPassword(scanner.nextLine());
		//
		try {
			System.out.print("��ȭ��ȣ : ");
			newUser.setPhone(scanner.nextInt());
		} catch (InputMismatchException e) {
			System.out.println("|�ùٸ��� ���� ��ȣ�Դϴ�.|");
			return;
		}
		//
		System.out.print("�̸� : ");
		scanner.nextLine();
		newUser.setName(scanner.nextLine());
		//
		userList.add(newUser);
	}

	public boolean deleteUser(User currentUser) {// ���� ����
		if (currentUser.getAccountNumberList().isEmpty()) {
			System.out.print("|���� Ż���մϱ�?(Y/N)|");
			String ans = scanner.nextLine();
			if ("y".equals(ans) || "Y".equals(ans)) {
				System.out.println("|��й�ȣ�� �Է��ϼ���|");
				ans = scanner.nextLine();
				if (ans.equals(currentUser.getPassword())) {
					userList.remove(currentUser);
					System.out.println("|Ż�� �Ϸ�|");
					return true;
				}
			}
		} else {
			System.out.println("|���� ���|");
			for (Integer currentAccountNumber : currentUser.getAccountNumberList()) {// ���� ���
				System.out.println(String.format("%d�� ���� : %d",
						currentUser.getAccountNumberList().indexOf(currentAccountNumber) + 1,
						currentAccountNumber.intValue()));
			}
			System.out.println("|���¸� ���� ��� �����ϼ���|");
			return false;
		}
		System.out.println("����");
		return false;
	}

	public ArrayList<User> getUserList(){
		return userList;
	}
	
	
}