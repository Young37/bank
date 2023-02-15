package dongseo.yhkim;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginManager {
	private AccountManager accountManager = new AccountManager();
	Scanner scanner = new Scanner(System.in);

	public User signIn(ArrayList<User> userList){// �α��� �õ�
		if (userList.isEmpty()) {
			System.out.println("����� �������� ����");
			return null;
		}
		System.out.println("|�α���|");
		System.out.println("���̵� : ");
		String idInput = scanner.nextLine();
		for (User currentUser : userList) {
			if (currentUser.getId().equals(idInput)) {
				for (int i = 0; i < 5; i++) {
					System.out.println(String.format("|��ȸ%d�� ����|", 5 - i));
					System.out.println("��й�ȣ :");
					String passwordInput = scanner.nextLine();
					if (currentUser.getPassword().equals(passwordInput)) {
						System.out.println("|�α��� �Ϸ�|");
						return currentUser;
					}
				}
				System.out.println("|5ȸ ����|");
				return null;
			}
		}
		System.out.println("|��ġ�ϴ� ���̵� ����|");
		return null;
	}

	public boolean userScreen(User currentUser) {// �α��� ����
		if (currentUser == null)
			return false;
		while (true) {
			int select;
			System.out.println("|1.���¼��� 2.���»��� 3.�α׾ƿ� 4.ȸ�� Ż�� |");
			try {// �Է�
				select = scanner.nextInt();
				scanner.nextLine();
			} catch (InputMismatchException e) {
				scanner.nextLine();
				continue;
			}
			if (select == 1) {// ���±��
				Account currentAccount = accountManager.selectAccount(currentUser);//���� ����
				if (currentAccount != null) {
					AccountFunction accountFunction = new AccountFunction();
					while (true) {
						System.out.println(String.format("�ܰ� %d��", currentAccount.getBalance()));
						System.out.println("|��� ����|");
						System.out.println("1.�Ա� 2.��� 3.��ü 4.�ڷΰ��� 5.���� ����");
						try {
							select = scanner.nextInt();
							scanner.nextLine();
						} catch (java.util.InputMismatchException e) {
							scanner.nextLine();
							break;
						}
						if (select == 4) {
							break;
						} else if (select == 1) {
							accountFunction.deposit(currentAccount);// �Ա�
						} else if (select == 2) {
							accountFunction.withdraw(currentAccount);// ���
						} else if (select == 3) {
							accountFunction.remit(accountManager.getAccountList(), currentAccount);// ��ü
						} else if (select == 5) {
							if(accountFunction.deleteAccount(accountManager.getAccountList(), currentAccount,
									currentUser))break;// ���� ����
						}
					}
				}
			} else if (select == 2) {// ���»���
				accountManager.createAccount(currentUser);
			} else if (select == 3) {// �α׾ƿ�
				return false;
			} else if (select == 4) {// ȸ��Ż��õ�
				return true;
			} else {
				System.out.println("|�߸��� �Է�|");
			}
		}
	}
}