package dongseo.yhkim;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager {
	private ArrayList<Account> accountList = new ArrayList<Account>();;
	Scanner scanner = new Scanner(System.in);

	public Account selectAccount(User currentUser) {// '유저의 계좌 목록'에서 고르면 그 계좌로 selectedFunction을 작동시키기 위한 지나가는 메소드
		int select;
		if (currentUser.getAccountNumberList().isEmpty()) {
			System.out.println("계좌가 존재하지 않음");
			return null;
		}
		System.out.println("|계좌 목록|");
		for (Integer currentAccountNumber : currentUser.getAccountNumberList()) {// 계좌 출력
			System.out.println(
					String.format("%d번 계좌 : %d", currentUser.getAccountNumberList().indexOf(currentAccountNumber) + 1,
							currentAccountNumber.intValue()));
		}
		System.out.println("|계좌 선택|");
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

	public void createAccount(User currentUser) {// 계좌의 번호만 유저의 계좌번호에추가|계좌 객체를 계좌리스트에 추가
		int validAccountNumber = createAccountNumber(currentUser);
		if (validAccountNumber == -1) {
			System.out.println("계좌 생성 가능 수 초과");
			return;
		}
		currentUser.getAccountNumberList().add(validAccountNumber);
		Account newAccount = new Account();
		newAccount.setAccountNumber(validAccountNumber);
		newAccount.setUser(currentUser.getId());
		System.out.println(String.format("계좌번호 : %d", validAccountNumber));
		System.out.println("계좌 비밀번호 입력");
		newAccount.setPassword(scanner.nextLine());
		accountList.add(newAccount);
	}

	private int createAccountNumber(User currentUser) {// accountList에 없는 9자리 정수 리턴
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

	private int createRandomNumber() {// 랜덤한 9자리 정수 리턴
		int numbers[] = new int[9];
		for (int i = 0; i < 9; i++)
			numbers[i] = (int) (Math.random() * 10);
		int result = Integer.parseInt(String.format("%d%d%d%d%d%d%d%d%d", numbers[0], numbers[1], numbers[2],
				numbers[3], numbers[4], numbers[5], numbers[6], numbers[7], numbers[8]));
		return result;
//		else {
//			Random random = new Random();
//			int result = random.nextInt(10);
//			if(result==10000) {System.out.println("정답");}
//			System.out.println(result);
//			return result;
//		}
	}

	public ArrayList<Account> getAccountList() {
		return accountList;
	}

}
