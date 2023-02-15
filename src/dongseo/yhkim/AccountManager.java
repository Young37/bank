package dongseo.yhkim;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager {
	private ArrayList<Account> accountList = new ArrayList<Account>();;
	Scanner scanner = new Scanner(System.in);

	public Account selectAccount(User currentUser) {// '������ ���� ���'���� ���� �� ���·� selectedFunction�� �۵���Ű�� ���� �������� �޼ҵ�
		int select;
		if (currentUser.getAccountNumberList().isEmpty()) {
			System.out.println("���°� �������� ����");
			return null;
		}
		System.out.println("|���� ���|");
		for (Integer currentAccountNumber : currentUser.getAccountNumberList()) {// ���� ���
			System.out.println(
					String.format("%d�� ���� : %d", currentUser.getAccountNumberList().indexOf(currentAccountNumber) + 1,
							currentAccountNumber.intValue()));
		}
		System.out.println("|���� ����|");
			try {
			select = scanner.nextInt();
			scanner.nextLine();
		} catch (java.util.InputMismatchException e) {
			scanner.nextLine();
			return null;
		}
		select -= 1;
		try {
			for (Account account : accountList) {
				if (account.getAccountNumber() == currentUser.getAccountNumberList().get(select)) {
					return account;
				}
			}
		} catch (java.lang.IndexOutOfBoundsException e) {
			return null;
		}
		return null;
	}

	public void createAccount(User currentUser) {// ������ ��ȣ�� ������ ���¹�ȣ���߰�|���� ��ü�� ���¸���Ʈ�� �߰�
		int validAccountNumber = createAccountNumber(currentUser);
		if (validAccountNumber == -1) {
			System.out.println("���� ���� ���� �� �ʰ�");
			return;
		}
		currentUser.getAccountNumberList().add(validAccountNumber);
		Account newAccount = new Account();
		newAccount.setAccountNumber(validAccountNumber);
		newAccount.setUser(currentUser.getId());
		System.out.println(String.format("���¹�ȣ : %d", validAccountNumber));
		System.out.println("���� ��й�ȣ �Է�");
		newAccount.setPassword(scanner.nextLine());
		accountList.add(newAccount);
	}

	private int createAccountNumber(User currentUser) {// accountList�� ���� 9�ڸ� ���� ����
		if (accountList.size() == 1000000000)
			return -1;
		while (true) {
			boolean duplicate = false;
			int newAccountNumber = createRandomNumber();
			for (Account comparison : accountList) {
				if (newAccountNumber == comparison.getAccountNumber())
					duplicate = true;
			}
			if (duplicate)
				continue;
			return newAccountNumber;
		}
	}

	private int createRandomNumber() {// ������ 9�ڸ� ���� ����
		int numbers[] = new int[9];
		for (int i = 0; i < 9; i++)
			numbers[i] = (int) (Math.random() * 10);
		int result = Integer.parseInt(String.format("%d%d%d%d%d%d%d%d%d", numbers[0], numbers[1], numbers[2],
				numbers[3], numbers[4], numbers[5], numbers[6], numbers[7], numbers[8]));
		return result;
//		else {
//			Random random = new Random();
//			int result = random.nextInt(10);
//			if(result==10000) {System.out.println("����");}
//			System.out.println(result);
//			return result;
//		}
	}

	public ArrayList<Account> getAccountList() {
		return accountList;
	}

}
