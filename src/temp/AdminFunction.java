package temp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import dongseo.yhkim.Account;
import dongseo.yhkim.User;

public class AdminFunction {
	ArrayList<User> userList;
	ArrayList<Account> accountList;
	Scanner scanner = new Scanner(System.in);
	int select;

	AdminFunction(ArrayList<User> userList, ArrayList<Account> accountList) {
		this.userList = userList;
		this.accountList = accountList;
	}

	public void print() {
		while (true) {
			System.out.println("1.����� ��� 2.���� ��� 3.�ڷ�");
			try {
				select = Integer.parseInt(scanner.nextLine());
			} catch (java.lang.NumberFormatException e) {
				continue;
			}
			if (select == 1) {
				printUser();
			} else if (select == 2) {
				printAccount();
			} else if (select == 3) {
				return;
			}
		}
	}

	public void printUser() {
		while (true) {
			System.out.println("1.���� �� ��� 2.id�������� ��� 3.�ڷ�");
			try {
				select = Integer.parseInt(scanner.nextLine());
			} catch (java.lang.NumberFormatException e) {
				continue;
			}
			if (select == 1 || select == 2) {
				ArrayList<User> list = userList;//��¸� �Ѵ�, ���� �Ǵ� userList���� ��ü�� ���� ������ ���� �ǵ帮���� �ʰ� list�ȿ����� ���ĸ� �ٲٴϱ� �������.
				if (select == 2) {
					Collections.sort(list);//list�� id������������ ����� �ڵ� 
				}
				for (User currentUser : list) {
					System.out.println(String.format("id:%s/password:%s/phone:%d", currentUser.getId(),
							currentUser.getPassword(), currentUser.getPhone()));
					if (currentUser.getAccountNumberList().isEmpty()) {
						System.out.println("���� ����");
						continue;
					}
					System.out.println("���� ���");
					for (int currentAccount : currentUser.getAccountNumberList())
						System.out.println(currentAccount);
				}
			} else if (select == 3)
				return;
		}
	}

	public void printAccount() {
		while (true) {
			System.out.println("1.�ܾ� �� ��� 2.�������� ��� 3.�ڷ�");System.out.println("�̱���");
			try {
				select = Integer.parseInt(scanner.nextLine());
			} catch (java.lang.NumberFormatException e) {
				continue;
			}
			if (select == 1 || select == 2) {
				ArrayList<Account> list = accountList;
				if(select == 1) {
					Collections.sort(list);
				}else if(select == 2) {
					
				}
				for(Account currentAccount:list) {
					System.out.println(String.format("���¹�ȣ:%d/�ܰ�:%d/������:%s/���º�й�ȣ:%s",currentAccount.getAccountNumber(),currentAccount.getBalance(),currentAccount.getUser(),currentAccount.getPassword()));
				}
			} else if (select == 3) {
				return;
			}
		}
	}

	public void search() {
		while (true) {
			System.out.println("1. 2. 3.�ڷ�");
			try {
				select = Integer.parseInt(scanner.nextLine());
			} catch (java.lang.NumberFormatException e) {
				continue;
			}
			if (select == 1) {
				
			} else if (select == 2) {
				
			} else if (select == 3) {
				return;
			}
		}
	}

	public void delete() {
		while (true) {
			System.out.println("1.����� ���� 2. ���� ���� 3.�ڷ�");System.out.println("�̱���");
			try {
				select = Integer.parseInt(scanner.nextLine());
			} catch (java.lang.NumberFormatException e) {
				continue;
			}
			if (select == 1) {
				
			} else if (select == 2) {
				
			} else if (select == 3) {
				return;
			}
		}
	}

	public void changePassword() {
		System.out.println("���� ��ȣ �Է�");
		String password = scanner.nextLine();
		if (!Admin.checkPassword(password)) {
			System.out.println("Ʋ�� ��ȣ");
			return;
		}
		System.out.println("���ο� ��ȣ �Է�");
		String newPassword = scanner.nextLine();
		Admin.changePassword(password, newPassword);
		System.out.println("���� �Ϸ�");
	}
}
