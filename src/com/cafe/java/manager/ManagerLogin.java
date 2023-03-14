package com.cafe.java.manager;

import java.util.ArrayList;
import java.util.Scanner;

import com.cafe.java.data.Data;
import com.cafe.java.member.Member;

/**
 * 
 * 관리자 로그인 화면 클래스입니다.
 * 
 * 
 */
public class ManagerLogin {

	public void mgLogin() {

		boolean loop = true;
		boolean flag = true;
		Scanner scan = new Scanner(System.in);

		Loop1: while (loop) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("              ▶ 관리자 로그인 ◀ ");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.print("    🍮 관리자 아이디 : ");
			String id = scan.nextLine();
			System.out.print("    🍮 관리자 비밀번호 : ");
			String pw = scan.nextLine();
			System.out.println();

			for (Manager mg : Data.manager) {
				if (mg.getManagerId().equals(id) && mg.getManagerPw().equals(pw)) {
					System.out.println("로그인에 성공하셨습니다.");
					scan.nextLine();

					ManagerService mgs = new ManagerService();
					mgs.managerBegin();

					break Loop1;

				} else if (mg.getManagerId().equals(id) && !mg.getManagerPw().equals(pw)) {

					System.out.println("비밀번호가 일치하지 않습니다.\n다시 입력해주세요");

					flag = false;

				}

			}

			if (loop && flag) {

				System.out.print("일치하는 아이디가 없습니다.\n다시 입력하시겠습니까(y/n)?");
				String ans = scan.nextLine();
				if (ans.equals("y")) {
				} else {
					loop = false;
				}
			}
		}
	}
}
