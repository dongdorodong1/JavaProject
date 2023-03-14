package com.cafe.java.member;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.cafe.java.data.Data;

/**
 * 회원가입을 기능을 구현한 클래스입니다. begin메소드에서 memberAdd메소드를 호출합니다. memberAdd메소드에서 유효성 검사를
 * 진행한 뒤 ArrayList에 입력한 정보를 추가합니다.
 * 
 * @author 김현준
 * 
 * @see begin()
 * @see memberAdd()
 * 
 * @
 */
public class MemberShip { // 회원가입 클래스

	String name = "";
	String id = "";
	String pw = "";
	String birth = "";
	String gender = "";
	String tel = "";

	boolean loop = true;

	/**
	 * 회원가입 창을 보여주는 메소드입니다.
	 * 
	 * @author 김현준
	 * @param name   -> 이름(한글2~5자)
	 * @param id     -> 아이디(영소문자, 숫자 8~16자리)
	 * @param pw     -> 비밀번호(영문자, 숫자 8~16자리)
	 * @param birth  -> 생년월일(YYYY-MM-DD)
	 * @param gender -> 성별(M:남자 / F:여자)
	 * @param tel    -> 전화번호(000-0000-0000)
	 * 
	 */
	public void begin() {

		Scanner scan = new Scanner(System.in);

		while (loop) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("              [ 회원가입 ]");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println();
			System.out.println("  [정보입력]");
			System.out.print("  ✐ 이름(한글2~5자):");
			name = scan.nextLine();
			System.out.print("  ✐ ID(8~16자) :");
			id = scan.nextLine();
			System.out.print("  ✐ PW(8~16자) :");
			pw = scan.nextLine();
			System.out.print("  ✐ 생년월일(YYYY-MM-DD):");
			birth = scan.nextLine();
			System.out.print("  ✐ 성별(M/F) :");
			gender = scan.nextLine();
			System.out.print("  ✐ 연락처(000-0000-0000): ");
			tel = scan.nextLine();
			System.out.println();
			System.out.println("  1. 작성완료 ");
			System.out.println("  2. 회원가입 취소");
			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.print("▶ 입력: ");

			String sel = scan.nextLine();

			if (sel.equals("1")) {

				memberAdd(); // 회원정보 유효성 검사 및 추가

			} else if (sel.equals("2")) {

				loop = false;

			}
		}
	}

	/**
	 * 회원가입을 위해 작성된 정보에 대한 유효성 검사 및 ArrayList에 추가하는 작업을 진행하는 메소드입니다.
	 * 
	 * @author 김현준
	 * @param name   -> 이름(한글2~5자)
	 * @param id     -> 아이디(영소문자, 숫자 8~16자리)
	 * @param pw     -> 비밀번호(영문자, 숫자 8~16자리)
	 * @param birth  -> 생년월일(YYYY-MM-DD)
	 * @param gender -> 성별(M:남자 / F:여자)
	 * @param tel    -> 전화번호(000-0000-0000)
	 * 
	 */
	public void memberAdd() {

		// 회원정보 예시 -> 1■abc1111■1234■정기연■M■1981-11-02■010-2000-5587■6440

		Boolean idCheck = Pattern.matches("^[0-9a-zA-Z]*$", id);
		Boolean pwCheck = Pattern.matches("^[0-9a-zA-Z]*$", pw);
		Boolean telCheck = Pattern.matches("^\\d{3}-\\d{3,4}-\\d{4}", tel);
		Boolean birthCheck = Pattern.matches("^\\d{4}-d{2}-\\d{2}", birth);
		Boolean nameCheck = Pattern.matches("^[가-힣]{2,5}", name);
		Boolean idLenthCheck = Pattern.matches("^[A-Za-z_][A-Za-z0-9]{7,15}$", id);

		int number = Data.createMemberNo();
		int count = 0; // 유효성 검사에 제한되는 항목 갯수

		if (!nameCheck) { // 한글 2~5자 유효성 검사

			System.out.println("- 이름은 한글 2~5자로 입력해야 합니다. ");
			System.out.println();
			count++;
		}

		// 중복 id 유효성 검사
		for (Member mb : Data.member) {
			if (mb.getUserId().equals(id)) {
				System.out.println("- 중복된 아이디입니다.");
				System.out.println();
				count++;
			}
		}

		// id,pw 영문자,숫자 유효성 검사
		if ((!idCheck) || (!pwCheck)) {

			System.out.println("- id와 pw는 영문자, 숫자로만 구성되어야 합니다.");
			System.out.println();
			count++;

		}

		// 누락된 정보가 있는지 유효성 검사
		if (id.equals(null) || pw.equals(null) || name.equals(null) || tel.equals(null) || gender.equals(null)
				|| birth.equals(null)) { //

			System.out.println("- 회원가입 모든 항목은 필수 입력 정보입니다.");
			System.out.println("  입력하지 않은 정보를 입력해 주세요.");
			System.out.println();
			count++;
		}

		// id의 시작 글자 및 id와 pw의 길이 유효성 검사
		if (!idLenthCheck) {

			System.out.println("- id는 숫자로 시작할 수 없습니다.\n");
			System.out.println("  id는 8~16자리 영문자, 숫자로 구성되어야 합니다.");
			System.out.println();
			count++;

		}

		// 생년월일 정보 유효성 검사
		if (!(birth.indexOf('-') == 4 || birth.indexOf('-') == 7)) {

			System.out.println("- 생년월일은 XXXX-XX-XX 형식으로 작성해야합니다.");
			System.out.println();
			count++;

		}

		// 성별 정보 유효성 검사
		if (!(gender.equals("M") || gender.equals("F"))) {

			System.out.println("- 성별은 M/N으로만 작성해야합니다. (남자:M / 여자:F)");
			System.out.println();
			count++;

		}
		Scanner scan = new Scanner(System.in);
		// 전화번호 정보 유효성 검사
		if (!telCheck) {

			System.out.println("- 전화번호는 OOO-OOOO-OOOO / OOO-OOO-OOOO 형식으로 작성해야합니다.");
			System.out.println();
			count++;

		}

		if (count == 0) {

			Member mb = new Member();

			// 회원정보 추가
			mb.setUserNo(number);
			mb.setUserId(id);
			mb.setUserPw(pw);
			mb.setUserName(name);
			mb.setUserGen(gender);
			mb.setUserBirth(birth);
			mb.setUserTel(tel);
			mb.setUserPoint(0);

			Data.member.add(mb);

			System.out.println();
			System.out.println("회원가입이 완료되었습니다.");
			Data.pause();

			loop = false;

		} else {

			System.out.printf("  %d개의 항목이 회원가입 형식과 일치하지 않습니다.\n", count);
			System.out.println("  회원가입에 실패했습니다.");
			System.out.println();
			System.out.println("  회원가입을 취소하려면 0번을 누르세요");
			System.out.print("  ▶ 입력: ");
			int num = scan.nextInt();

			if (num == 0) {
				loop = false;
			}

		}
	}
}