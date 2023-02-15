package dongseo.yhkim;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountFunction {
	Scanner scanner = new Scanner(System.in);

	public void deposit(Account currentAccount) {//�Ա�
		int select;
		System.out.print("�Աݾ� : ");
		try {
			select = scanner.nextInt();
			scanner.nextLine();
		} catch (java.util.InputMismatchException e) {
			scanner.nextLine();
			return;
		}
		if (select > 0) {
			currentAccount.setBalance(currentAccount.getBalance() + select);
			System.out.println("�Ա� �Ϸ�");
		} else
			System.out.println("���� �ʰ�");
	}

	public void withdraw(Account currentAccount) {//���
		if (!passwordCheck(currentAccount))
			return;
		int select;
		System.out.print("��ݾ� : ");
		try {
			select = scanner.nextInt();
			scanner.nextLine();
		} catch (java.util.InputMismatchException e) {
			scanner.nextLine();
			return;
		}
		if (select < 0 || select > currentAccount.getBalance())
			System.out.println("���� �ʰ�");
		else
			currentAccount.setBalance(currentAccount.getBalance() - select);
	}

	public void remit(ArrayList<Account> accountList,Account currentAccount) {//��ü
		if (!passwordCheck(currentAccount))
			return;
		int select;
		System.out.print("��ü ��� ���� : ");
		try {
			select = scanner.nextInt();
			scanner.nextLine();
		} catch (java.util.InputMismatchException e) {
			scanner.nextLine();
			return;
		}
		for (Account targetAccount : accountList) {
			if (targetAccount.getAccountNumber() == select) {
				System.out.print("��ݾ� : ");
				try {
					select = scanner.nextInt();
					scanner.nextLine();
				} catch (java.util.InputMismatchException e) {
					scanner.nextLine();
					return;
				}
				if (select < 0 || select > currentAccount.getBalance())
					System.out.println("���� �ʰ�");
				else {
					currentAccount.setBalance(currentAccount.getBalance() - select);
					targetAccount.setBalance(targetAccount.getBalance() + select);
					System.out.println("��ü �Ϸ�");
					return;
				}
			}
		}
		System.out.println("��ġ�ϴ� ���� ����");
	}

	public boolean deleteAccount(ArrayList<Account> accountList,Account currentAccount,User currentUser) {//���»���
		System.out.println(
				String.format("���¹�ȣ %d �ܰ� %d", currentAccount.getAccountNumber(), currentAccount.getBalance()));
		System.out.print("���� �����մϱ�? (Y/N)");
		String ans = scanner.nextLine();
		if ("Y".equals(ans) || "y".equals(ans)) {
			if (!passwordCheck(currentAccount))
				return false;
			for (int i = 0; i < accountList.size(); i++) {
				Account compareAccount = accountList.get(i);
				if (compareAccount.getAccountNumber() == currentAccount.getAccountNumber()) {
					accountList.remove(i);
					currentUser.getAccountNumberList().remove(currentUser.getAccountNumberList().indexOf(currentAccount.getAccountNumber()));
					System.out.println("���� ���� �Ϸ�");
					return true;
				}
			}
		}
		return false;
	}

	private boolean passwordCheck(Account currentAccount) {
		System.out.print("���� ��й�ȣ �Է� : ");
		String ans = scanner.nextLine();
		if (!currentAccount.getPassword().equals(ans)) {
			System.out.println("��й�ȣ ����ġ");
			return false;
		} else {
			System.out.println("��й�ȣ ��ġ");
			return true;
		}
	}
}
