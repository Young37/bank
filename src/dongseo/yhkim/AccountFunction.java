package dongseo.yhkim;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountFunction {
	Scanner scanner = new Scanner(System.in);

	public void deposit(Account currentAccount) {//입금
		int select;
		System.out.print("입금액 : ");
		try {
			select = scanner.nextInt();
			scanner.nextLine();
		} catch (java.util.InputMismatchException e) {
			scanner.nextLine();
			return;
		}
		if (select > 0) {
			currentAccount.setBalance(currentAccount.getBalance() + select);
			System.out.println("입금 완료");
		} else
			System.out.println("범위 초과");
	}

	public void withdraw(Account currentAccount) {//출금
		if (!passwordCheck(currentAccount))
			return;
		int select;
		System.out.print("출금액 : ");
		try {
			select = scanner.nextInt();
			scanner.nextLine();
		} catch (java.util.InputMismatchException e) {
			scanner.nextLine();
			return;
		}
		if (select < 0 || select > currentAccount.getBalance())
			System.out.println("범위 초과");
		else
			currentAccount.setBalance(currentAccount.getBalance() - select);
	}

	public void remit(ArrayList<Account> accountList,Account currentAccount) {//이체
		if (!passwordCheck(currentAccount))
			return;
		int select;
		System.out.print("이체 대상 계좌 : ");
		try {
			select = scanner.nextInt();
			scanner.nextLine();
		} catch (java.util.InputMismatchException e) {
			scanner.nextLine();
			return;
		}
		for (Account targetAccount : accountList) {
			if (targetAccount.getAccountNumber() == select) {
				System.out.print("출금액 : ");
				try {
					select = scanner.nextInt();
					scanner.nextLine();
				} catch (java.util.InputMismatchException e) {
					scanner.nextLine();
					return;
				}
				if (select < 0 || select > currentAccount.getBalance())
					System.out.println("범위 초과");
				else {
					currentAccount.setBalance(currentAccount.getBalance() - select);
					targetAccount.setBalance(targetAccount.getBalance() + select);
					System.out.println("이체 완료");
					return;
				}
			}
		}
		System.out.println("일치하는 계좌 없음");
	}

	public boolean deleteAccount(ArrayList<Account> accountList,Account currentAccount,User currentUser) {//계좌삭제
		System.out.println(
				String.format("계좌번호 %d 잔고 %d", currentAccount.getAccountNumber(), currentAccount.getBalance()));
		System.out.print("정말 삭제합니까? (Y/N)");
		String ans = scanner.nextLine();
		if ("Y".equals(ans) || "y".equals(ans)) {
			if (!passwordCheck(currentAccount))
				return false;
			for (int i = 0; i < accountList.size(); i++) {
				Account compareAccount = accountList.get(i);
				if (compareAccount.getAccountNumber() == currentAccount.getAccountNumber()) {
					accountList.remove(i);
					currentUser.getAccountNumberList().remove(currentUser.getAccountNumberList().indexOf(currentAccount.getAccountNumber()));
					System.out.println("계좌 삭제 완료");
					return true;
				}
			}
		}
		return false;
	}

	private boolean passwordCheck(Account currentAccount) {
		System.out.print("계좌 비밀번호 입력 : ");
		String ans = scanner.nextLine();
		if (!currentAccount.getPassword().equals(ans)) {
			System.out.println("비밀번호 불일치");
			return false;
		} else {
			System.out.println("비밀번호 일치");
			return true;
		}
	}
}
