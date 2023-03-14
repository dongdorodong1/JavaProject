package com.cafe.java.manager;

import java.util.ArrayList;
import java.util.Scanner;

import com.cafe.java.data.Data;
import com.cafe.java.member.Member;

/**
 * 관리자의 고객관리 기능 화면 클래스 입니다.
 * 
 * @see #ManagerMemberList()
 * 
 * @author 조혜은
 */
public class ManagerMemberList {

	/**
	 * 고객의 정보를 조회, 수정, 삭제할 수 있는 화면 메소드입니다.
	 * 
	 * @see #memlist()
	 * 
	 * @author 사용자 조혜은
	 */
	public void memlist() {

		// 3. 고객 관리
		boolean loop = true;

		Scanner scan = new Scanner(System.in);

		while (loop) {

			System.out.println();
			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("                 [고객관리]");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println();
			System.out.println("\t      1. 고객 정보 조회");
			System.out.println();
			System.out.println("\t      2. 고객 정보 수정");
			System.out.println();
			System.out.println("\t      3. 고객 정보 삭제");
			System.out.println();
			System.out.println("\t    0. 이전화면으로 돌아가기");
			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.print("▶ 입력: ");

			String sel = scan.nextLine();

			if (sel.equals("1")) {

				// 1. 고객 정보 조회
				memberCheck();

			} else if (sel.equals("2")) {

				// 2. 고객 정보 수정
				memberEdit();

			} else if (sel.equals("3")) {

				// 3. 고객 정보 삭제
				memberDelete();

			} else {

				// 0. 이전 화면으로 돌아가기
				loop = false;

			}

		}

	}// memlist

	/**
	 * 고객 정보를 삭제하는 메소드 입니다.
	 * 
	 * @see #memberDelete()
	 * 
	 * @author 조혜은
	 */
	private void memberDelete() {
		// 3. 고객 삭제

		System.out.println();

		Scanner scan = new Scanner(System.in);

		System.out.println("[고객 정보 삭제]");

		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.print("▶ 고객 정보를 정말 삭제하시겠습니까?(y/n입력): ");
		String delete = scan.nextLine();
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");

		if (delete.equals("y")) {

			System.out.println();
			System.out.print("삭제하시는 고객님 번호: ");
			int userNo = scan.nextInt();
			scan.nextLine(); // 엔터 버리기

			boolean result = Data.deleteUser(userNo);

			if (result) {
				System.out.println();
				System.out.println("입력하신 고객 정보가 삭제 되었습니다.");
			} else {
				System.out.println("문제가 발생했습니다. 다시 시도하거나 관리자에게 연락주세요.");
			}

			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");

		} else {

		}

		Data.pause();

	}// memberDelete

	/**
	 * 고객 정보를 수정하는 메소드 입니다.<br>
	 * 고객의 정보를 전체 수정할 수 있고 특정 정보를 수정할 수 있습니다.
	 * 
	 * @see #memberEdit()
	 * 
	 * @author 조혜은
	 */
	private void memberEdit() {

		// 2. 고객 정보 수정

		System.out.println();

		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("           [고객 정보 수정]");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.print("수정하고자 하는 고객 이름: ");
		String userNo = scan.nextLine();
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println();

//		String userName1 = Data.Member(int userNo);
		Member ml = Data.getUserNo(userNo);

		System.out.println("▶ 회원정보 수정하기 > 기존 정보 유지(엔터)");

		System.out.print("1. 아이디: ");
		String userId = scan.nextLine();

		System.out.print("2. 비밀번호:");
		String userPw = scan.nextLine();

		System.out.print("3. 이름:");
		String userName = scan.nextLine(); // userName

		System.out.print("4. 성별:");
		String userGen = scan.nextLine();

		System.out.print("5. 생년월일:");
		String userBirth = scan.nextLine();

		System.out.print("6. 전화번호:");
		String userTel = scan.nextLine();
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");

		if (!userId.equals("")) {
			ml.setUserId(userId); // 아이디 수정
		}

		if (!userPw.equals("")) {
			ml.setUserPw(userPw);
		}

		if (!userName.equals("")) {
			ml.setUserName(userName);
		}

		if (!userGen.equals("")) {
			ml.setUserGen(userGen);
		}

		if (!userBirth.equals("")) {
			ml.setUserBirth(userBirth);
		}

		if (!userTel.equals("")) {
			ml.setUserTel(userTel);
		}

		System.out.println();
		System.out.println("고객 정보를 수정했습니다.");

		Data.pause();

	}// memberEdit

	/**
	 * 고객 정보를 조회하는 메소드 입니다.<br>
	 * 고객 정보목록을 나열하여 고객 이름을 검색하여 정보를 조회할 수 있습니다.
	 * 
	 * @see #memberCheck()
	 * 
	 * @author 조혜은
	 */
	private void memberCheck() {

		// 1. 고객 정보 조회

		Scanner scan = new Scanner(System.in);

		System.out.println();

		System.out.println("                                           [고객 정보 조회]");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("   [고객번호]      [아이디]\t\t[비밀번호]\t[이름]\t[성별]\t  [생년월일]\t[전화번호]\t[포인트]");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");

		for (Member ml : Data.member) {

			// 1■6n24jp8n■4gbhbyvc■최형효■M■2018-02-05■010-9223-5739■3530
			System.out.printf("   %3d\t\t%8s\t%8s\t%3s\t%2s\t%10s\t%13s\t%4d\n", ml.getUserNo(), ml.getUserId(),
					ml.getUserPw(), ml.getUserName(), ml.getUserGen(), ml.getUserBirth(), ml.getUserTel(),
					ml.getUserPoint());
		}
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");

		System.out.println();
		System.out.println("▶ 조회하고자 하는 고객 이름, 엔터(나가기):");

		String userNo = scan.nextLine(); // 고유번호
		System.out.println();

		if (!userNo.equals("")) { // 빈문자가 아닐 때

			// 특정 고객 조회를 할 거냐
			Member ml = Data.getUserNo(userNo); // 찾아왔고

			System.out.println("                                           [고객 정보 조회]");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println(" [고객번호]  [아이디]\t[비밀번호]\t[이름]\t  [성별]\t  [생년월일]\t [전화번호]\t[포인트]");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("   " + ml.getUserNo() + "    " + ml.getUserId() + "\t" + ml.getUserPw() + "        "
					+ ml.getUserName() + "       " + ml.getUserGen() + "    " + ml.getUserBirth() + "\t"
					+ ml.getUserTel() + "\t " + ml.getUserPoint() + "원");
			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println();

		}

		// 일시 정지
		Data.pause();

	}// memberCheck

}
