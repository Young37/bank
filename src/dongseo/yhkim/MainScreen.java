package dongseo.yhkim;

import java.util.Scanner;

public class MainScreen {

	public static void main(String[] args) {
		UserManager userManager = new UserManager();//���� ������ ��������
		LoginManager loginManager = new LoginManager();//���� ���ÿ��� + ���õ� ������ ���� ��� �������̽� ����

		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			int select;
			System.out.println("|��� ����|");
			System.out.println("|1:�α��� 2:ȸ������ 3:����|");

			try {//�Է�
				select = scanner.nextInt();
				scanner.nextLine();
			} catch (java.util.InputMismatchException e) {
				scanner.nextLine();
				continue;
			}

			if (select == 3) {//���
				System.out.println("����");
				scanner.close();
				return;
			} else if (select == 1) {
				User currentUser = loginManager.signIn(userManager.getUserList());// �α��� �õ�
				while(loginManager.userScreen(currentUser))                       //  ������ -> ���� ��ũ��
					if(userManager.deleteUser(currentUser))break;                 //         ����������� ���� �� -> ������ ��� break
			} else if (select == 2) {
				userManager.signUp();// ȸ�� �߰�
			} else {
				System.out.println("�߸��� �Է�");
			}
		}
	}

}
