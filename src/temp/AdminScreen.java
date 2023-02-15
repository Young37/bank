package temp;

import java.util.ArrayList;
import java.util.Scanner;

import dongseo.yhkim.Account;
import dongseo.yhkim.User;

public class AdminScreen {
	Scanner scanner = new Scanner(System.in);

	AdminScreen(ArrayList<User> userList, ArrayList<Account> accountList) {
		AdminFunction adminFunction = new AdminFunction(userList, accountList);
		int select;

		System.out.println("|관리자 화면|");
		while (true) {
			System.out.println("1.출력 작업 2.검색 작업 3.삭제 작업 4.관리자 암호 변경 5.로그아웃");
			try {
				select = scanner.nextInt();
				scanner.nextLine();
			} catch (java.util.InputMismatchException e) {
				scanner.nextLine();
				continue;
			}
			switch (select) {
			case 1:
				adminFunction.print();
				break;
			case 2:
				adminFunction.search();
				break;
			case 3:
				adminFunction.delete();
				break;
			case 4:
				adminFunction.changePassword();
				break;
			case 5:
				return;
			}
		}
	}
}
