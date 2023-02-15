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

		System.out.println("|������ ȭ��|");
		while (true) {
			System.out.println("1.��� �۾� 2.�˻� �۾� 3.���� �۾� 4.������ ��ȣ ���� 5.�α׾ƿ�");
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
