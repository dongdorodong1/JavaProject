package com.cafe.java.manager;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cafe.java.data.Data;

/**
 * 관리자 기능 화면을 보여주는 클래스 입니다.
 * 
 * @see #ManagerService()
 */
public class ManagerService {

	/**
	 * 관리자 기능 화면 메소드 입니다,
	 * 
	 * @see #managerBegin()
	 */
	public void managerBegin() {

		boolean loop = true;

		Scanner scan = new Scanner(System.in);

		while (loop) {
			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("                 관리자 화면");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println();
			System.out.print("\t\t1. 관리자 추가");
			System.out.println();
			System.out.println();
			System.out.print("\t\t2. 재고관리");
			System.out.println();
			System.out.println();
			System.out.print("\t\t3. 고객관리");
			System.out.println();
			System.out.println();
			System.out.print("\t\t4. 매출관리");
			System.out.println();
			System.out.println();
			System.out.print("\t\t5. 메뉴관리");
			System.out.println();
			System.out.println();
			System.out.print("\t    0. 이전화면으로 돌아가기");
			System.out.println();
			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.print("▶ 입력: ");

			String sel = scan.nextLine();

			if (sel.equals("1")) {

				// 1. 관리자 추가하기
				add();

			} else if (sel.equals("2")) {

				// 2. 재고 관리
				ManagerStockList stockList = new ManagerStockList();
				stockList.stlist();

			} else if (sel.equals("3")) {

				// 3. 고객 관리
				ManagerMemberList memberList = new ManagerMemberList();
				memberList.memlist();

			} else if (sel.equals("4")) {

				// 4. 매출 관리
				SalesManagement smg = new SalesManagement();
				smg.sellshow();

			} else if (sel.equals("5")) {

				// 5. 메뉴 관리
				// 5. 메뉴 관리
				ManagerMenuManage menuManage = new ManagerMenuManage();
				menuManage.menuManage();
			}

			else {

				// 0. 초기화면으로 돌아가기
				loop = false;

			} // if

		} // while

//	Data.save();

	} // begin

	/**
	 * 관리자를 추가할 수 있는 메소드입니다.
	 * 
	 * @author 조혜은
	 * @see #add()
	 */
	private void add() {

		String regex = "";
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("               [관리자 추가]");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");

		System.out.print("▶ 관리자를 추가하시겠습니까?(y/n입력): ");
		String manager = scan.nextLine();
		System.out.println();

		if (manager.equals("y")) {

			int managerNo = Data.createMgNo(); // 관리자번호

			System.out.print("아이디: ");
			String managerId = scan.nextLine();
			System.out.println();

			System.out.print("비밀번호: ");
			String managerPw = scan.nextLine();
			System.out.println();

			System.out.print("이름: ");
			String managerName = scan.nextLine();
			System.out.println();

			System.out.print("전화번호('-'필수작성): ");
			String managerTel = scan.nextLine();
			System.out.println();

			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");

			if (isValid(managerId, managerPw, managerName, managerTel)) {

				Manager mg = new Manager();

				mg.setManagerNo(managerNo);
				mg.setManagerId(managerId);
				mg.setManagerPw(managerPw);
				mg.setManagerName(managerName);
				mg.setManagerTel(managerTel);

				Data.manager.add(mg);

				System.out.println();
				System.out.println("관리자를 추가하였습니다.");
			} else {
				System.out.println("가입실패, 입력하신 정보를 확인해주세요.");
			}

			// 입력 받은 정보 > ArrayList<Manager>

			// 데이터 집합에 새로운 관리자 추가

		}

		Data.pause();

	}// add

	/**
	 * 관리자 회원가입 유효성 검사
	 * 
	 * @param managerId
	 * @param managerPw
	 * @param managerName
	 * @param managerTel
	 * @return
	 */
	private static boolean isValid(String managerId, String managerPw, String managerName, String managerTel) {

		String regex = " "; // 정규식(문자열)
		Pattern pattern = null; // 정규식 객체
		Matcher matcher = null; // 검사 결과 객체

		// regex = "\\w{4,12};
		// 크롤링 > 데이터 수집 > 정규화(다듬기) + 정규표현식
		regex = "^[A-Za-z][A-Za-z0-9_]{3,11}$"; // 사용자가 입력한 값이 2~3자리 숫자냐
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(managerId);

		if (!matcher.find()) {

			System.out.println("아이디는 영어+숫자+_조합, 숫자 시작불가능 4~12자리로 입력해주세요");
			return false;
		}

		// 비밀번호
		regex = "^[A-Za-z0-9\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)]{4,14}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(managerPw);

		if (!matcher.find()) {

			System.out.println("비밀번호는 영어+숫자+특수문자, 4~12자리로 입력해주세요");
			return false;
		}

		// 이름
		regex = "^[가-힣]{2,5}$"; // 한글로 시작해야되고 한글로 끝나야된다. //2~5길이검사까지
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(managerName); // 이름: 홍길동

		// 홍길동Hong

		// 유효성검사는 잘못되었을때를 찾아라!
		if (!matcher.find()) {

			System.out.println("이름을 필수, 한글, 2~5자 이내로 입력하세요.");

			return false;

		}

		// 연락처
		regex = "^(01[017])?-[0-9]{3,4}-[0-9]{4}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(managerTel);

		if (!matcher.find()) {

			System.out.println("연락처는 '-'를 포함하여 형식에 맞게 작성해주세요.");
			return false;
		}

		return true; // 올바른 이름
	}
}
