package com.cafe.java.member;

import java.util.Scanner;

import com.cafe.java.data.Data;
import com.cafe.java.member.*;

/**
 * 고객(회원) 로그인 하는 클래스입니다.
 * 
 *
 * @author 강혜린
 * @author 김현준
 * @author 유동환
 * @author 손지연
 * @author 조혜은
 * 
 */
public class MemberLogin {

	public static String paymetName = ""; // 로그인한 회원정보
	public static int paymentPoint = 0; // 포인트

	public void mbLogin() {

		boolean loop = true;
		boolean flag = true;
		Scanner scan = new Scanner(System.in);

		Loop1: while (loop) {

			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("          ▶ 고객(회원) 로그인 ◀");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println();
			System.out.print("    🍮 회원 아이디 : ");
			String id = scan.nextLine();
			System.out.print("    🍮 회원 비밀번호 : ");
			String pw = scan.nextLine();

			// 2om2v3fj■qwt6kczs
			for (Member mb : Data.member) {

				if (mb.getUserId().equals(id) && mb.getUserPw().equals(pw)) {
					System.out.println();
					System.out.println("    로그인에 성공하셨습니다.");
					scan.nextLine();
					MemberService mbs = new MemberService();
					paymetName = mb.getUserName();
					paymentPoint = mb.getUserPoint();

					mbs.memberBegin(mb);

					break Loop1;

				}

				if (mb.getUserId().equals(id) && !mb.getUserPw().equals(pw)) {
					
					System.out.println();
					System.out.println("비밀번호가 일치하지 않습니다.\n다시 입력해주세요");

					flag = false;

				}

			}

			if (loop && flag) {
				System.out.print("일치하는 아이디가 없습니다.\n다시 입력하시겠습니까(y/n)?");
				String ans = scan.nextLine();
				if (ans.equals("y")) {

				} else {

				}
			}
		}
	}

}
