package dongseo.yhkim;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class UserManager {
	private ArrayList<User> userList = new ArrayList<User>();
	Scanner scanner = new Scanner(System.in);

	public void signUp() {// 유저 생성
		User newUser = new User();
		//
		System.out.print("아이디 : ");
		String id = scanner.nextLine();
		if (id.equals("admin")) {
			System.out.println("|관리자 아이디 사용 불가능|");
			return;
		}
		for (User duplicationCheck : userList)
			if (id.equals(duplicationCheck.getId())) {
				System.out.println("|아이디 중복|");
				return;
			}
		newUser.setId(id);
		//
		System.out.print("비밀번호 : ");
		newUser.setPassword(scanner.nextLine());
		//
		try {
			System.out.print("전화번호 : ");
			newUser.setPhone(scanner.nextInt());
		} catch (InputMismatchException e) {
			System.out.println("|올바르지 않은 번호입니다.|");
			return;
		}
		//
		System.out.print("이름 : ");
		scanner.nextLine();
		newUser.setName(scanner.nextLine());
		//
		userList.add(newUser);
	}

	public boolean deleteUser(User currentUser) {// 유저 삭제
		if (currentUser.getAccountNumberList().isEmpty()) {
			System.out.print("|정말 탈퇴합니까?(Y/N)|");
			String ans = scanner.nextLine();
			if ("y".equals(ans) || "Y".equals(ans)) {
				System.out.println("|비밀번호를 입력하세요|");
				ans = scanner.nextLine();
				if (ans.equals(currentUser.getPassword())) {
					userList.remove(currentUser);
					System.out.println("|탈퇴 완료|");
					return true;
				}
			}
		} else {
			System.out.println("|계좌 목록|");
			for (Integer currentAccountNumber : currentUser.getAccountNumberList()) {// 계좌 출력
				System.out.println(String.format("%d번 계좌 : %d",
						currentUser.getAccountNumberList().indexOf(currentAccountNumber) + 1,
						currentAccountNumber.intValue()));
			}
			System.out.println("|계좌를 먼저 모두 삭제하세요|");
			return false;
		}
		System.out.println("실패");
		return false;
	}

	public ArrayList<User> getUserList(){
		return userList;
	}
	
	
}