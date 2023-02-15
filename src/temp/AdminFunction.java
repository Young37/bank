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
			System.out.println("1.사용자 출력 2.계좌 출력 3.뒤로");
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
			System.out.println("1.가입 순 출력 2.id오름차순 출력 3.뒤로");
			try {
				select = Integer.parseInt(scanner.nextLine());
			} catch (java.lang.NumberFormatException e) {
				continue;
			}
			if (select == 1 || select == 2) {
				ArrayList<User> list = userList;//출력만 한다, 복사 되는 userList안의 객체가 같긴 하지만 값을 건드리지는 않고 list안에서의 정렬만 바꾸니까 상관없다.
				if (select == 2) {
					Collections.sort(list);//list를 id오름차순으로 만드는 코드 
				}
				for (User currentUser : list) {
					System.out.println(String.format("id:%s/password:%s/phone:%d", currentUser.getId(),
							currentUser.getPassword(), currentUser.getPhone()));
					if (currentUser.getAccountNumberList().isEmpty()) {
						System.out.println("계좌 없음");
						continue;
					}
					System.out.println("계좌 목록");
					for (int currentAccount : currentUser.getAccountNumberList())
						System.out.println(currentAccount);
				}
			} else if (select == 3)
				return;
		}
	}

	public void printAccount() {
		while (true) {
			System.out.println("1.잔액 순 출력 2.오름차순 출력 3.뒤로");System.out.println("미구현");
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
					System.out.println(String.format("계좌번호:%d/잔고:%d/소유자:%s/계좌비밀번호:%s",currentAccount.getAccountNumber(),currentAccount.getBalance(),currentAccount.getUser(),currentAccount.getPassword()));
				}
			} else if (select == 3) {
				return;
			}
		}
	}

	public void search() {
		while (true) {
			System.out.println("1. 2. 3.뒤로");
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
			System.out.println("1.사용자 삭제 2. 계좌 삭제 3.뒤로");System.out.println("미구현");
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
		System.out.println("현재 암호 입력");
		String password = scanner.nextLine();
		if (!Admin.checkPassword(password)) {
			System.out.println("틀린 암호");
			return;
		}
		System.out.println("새로운 암호 입력");
		String newPassword = scanner.nextLine();
		Admin.changePassword(password, newPassword);
		System.out.println("변경 완료");
	}
}
