package dongseo.yhkim;

import java.util.Scanner;

public class MainScreen {

	public static void main(String[] args) {
		UserManager userManager = new UserManager();//유저 생성과 삭제역할
		LoginManager loginManager = new LoginManager();//유저 선택역할 + 선택된 유저에 대한 기능 인터페이스 역할

		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			int select;
			System.out.println("|기능 선택|");
			System.out.println("|1:로그인 2:회원가입 3:종료|");

			try {//입력
				select = scanner.nextInt();
				scanner.nextLine();
			} catch (java.util.InputMismatchException e) {
				scanner.nextLine();
				continue;
			}

			if (select == 3) {//기능
				System.out.println("종료");
				scanner.close();
				return;
			} else if (select == 1) {
				User currentUser = loginManager.signIn(userManager.getUserList());// 로그인 시도
				while(loginManager.userScreen(currentUser))                       //  성공시 -> 유저 스크린
					if(userManager.deleteUser(currentUser))break;                 //         유저삭제기능 선택 시 -> 성공할 경우 break
			} else if (select == 2) {
				userManager.signUp();// 회원 추가
			} else {
				System.out.println("잘못된 입력");
			}
		}
	}

}
