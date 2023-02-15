package dongseo.yhkim;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginManager {
	private AccountManager accountManager = new AccountManager();
	Scanner scanner = new Scanner(System.in);

	public User signIn(ArrayList<User> userList){// 로그인 시도
		if (userList.isEmpty()) {
			System.out.println("사용자 존재하지 않음");
			return null;
		}
		System.out.println("|로그인|");
		System.out.println("아이디 : ");
		String idInput = scanner.nextLine();
		for (User currentUser : userList) {
			if (currentUser.getId().equals(idInput)) {
				for (int i = 0; i < 5; i++) {
					System.out.println(String.format("|기회%d번 남음|", 5 - i));
					System.out.println("비밀번호 :");
					String passwordInput = scanner.nextLine();
					if (currentUser.getPassword().equals(passwordInput)) {
						System.out.println("|로그인 완료|");
						return currentUser;
					}
				}
				System.out.println("|5회 오류|");
				return null;
			}
		}
		System.out.println("|일치하는 아이디 없음|");
		return null;
	}

	public boolean userScreen(User currentUser) {// 로그인 성공
		if (currentUser == null)
			return false;
		while (true) {
			int select;
			System.out.println("|1.계좌선택 2.계좌생성 3.로그아웃 4.회원 탈퇴 |");
			try {// 입력
				select = scanner.nextInt();
				scanner.nextLine();
			} catch (InputMismatchException e) {
				scanner.nextLine();
				continue;
			}
			if (select == 1) {// 계좌기능
				Account currentAccount = accountManager.selectAccount(currentUser);//계좌 선택
				if (currentAccount != null) {
					AccountFunction accountFunction = new AccountFunction();
					while (true) {
						System.out.println(String.format("잔고 %d원", currentAccount.getBalance()));
						System.out.println("|기능 선택|");
						System.out.println("1.입금 2.출금 3.이체 4.뒤로가기 5.계좌 삭제");
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
							accountFunction.deposit(currentAccount);// 입금
						} else if (select == 2) {
							accountFunction.withdraw(currentAccount);// 출금
						} else if (select == 3) {
							accountFunction.remit(accountManager.getAccountList(), currentAccount);// 이체
						} else if (select == 5) {
							if(accountFunction.deleteAccount(accountManager.getAccountList(), currentAccount,
									currentUser))break;// 계좌 삭제
						}
					}
				}
			} else if (select == 2) {// 계좌생성
				accountManager.createAccount(currentUser);
			} else if (select == 3) {// 로그아웃
				return false;
			} else if (select == 4) {// 회원탈퇴시도
				return true;
			} else {
				System.out.println("|잘못된 입력|");
			}
		}
	}
}