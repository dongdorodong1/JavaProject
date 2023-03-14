package com.cafe.java;

import java.util.Scanner;

import com.cafe.java.data.Data;
import com.cafe.java.manager.ManagerLogin;
import com.cafe.java.member.MemberLogin;
import com.cafe.java.member.MemberShip;
import com.cafe.java.member.NonMemPayment;
import com.cafe.java.product.MenuService;
import com.cafe.java.product.RecommendProduct;

/**
 * 메인클래스입니다. <br>
 * 관리자, 고객(회원) 로그인이 가능하고 고객계정이 없다면 비회원 모드로 이용이 가능합니다. <br>
 * 또한 회원가입이 가능합니다.
 * 
 * @see #nonMemberIn()
 *
 * @author 강혜린
 * @author 김현준
 * @author 유동환
 * @author 손지연
 * @author 조혜은
 * 
 *
 */
public class MainClass {

	// 1. 데이터 로드
	// 2. 주메뉴 > 선택
	// 3. 선택 > 기능 호출
	// 4. 데이터 저장
	public static void main(String[] args) {

		Data.load();
		
		boolean loop = true;

		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println();
		System.out.println(

				"           ██╗ █████╗ ██╗   ██╗ █████╗ \r\n" + "           ██║██╔══██╗██║   ██║██╔══██╗\r\n"
						+ "           ██║███████║██║   ██║███████║\r\n"
						+ "      ██   ██║██╔══██║╚██╗ ██╔╝██╔══██║\r\n"
						+ "      ╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║\r\n"
						+ "       ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝\r\n" + "\r\n"
						+ "       ██████╗ █████╗ ███████╗███████╗\r\n"
						+ "      ██╔════╝██╔══██╗██╔════╝██╔════╝\r\n"
						+ "      ██║     ███████║█████╗  █████╗  \r\n"
						+ "      ██║     ██╔══██║██╔══╝  ██╔══╝  \r\n"
						+ "      ╚██████╗██║  ██║██║     ███████╗\r\n" + "       ╚═════╝╚═╝  ╚═╝╚═╝     ╚══════╝");

		System.out.println();
		System.out.println();
		System.out.println("           주문하시려면 엔터를 눌러주세요");
		scan.nextLine();
		System.out.println();
		System.out.println();
		System.out.println();
		
		while (loop) {


			System.out.println("\t\t (\\______(\\\r\n" + "\t\t ( „• ֊ •„ )\r\n" + "\t\t   O  ☕️  O");
			Data.flag = true;
			System.out.println();
			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓 𝕁𝔸𝕍𝔸 ℂ𝔸𝔽𝔼 〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println();
			System.out.println("    1. 관리자 기능\t\t2. 회원 로그인");
			System.out.println();
			System.out.println("    3. 비회원 주문\t\t4. 회원가입");
			System.out.println();
			System.out.println("    5. 프로그램 종료");
			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.print("▶ 입력: ");

			String sel = scan.nextLine();

			if (sel.equals("1")) {

				ManagerLogin managerLogin = new ManagerLogin();
				managerLogin.mgLogin();

			} else if (sel.equals("2")) {

				MemberLogin memberLogin = new MemberLogin();
				memberLogin.mbLogin();

			} else if (sel.equals("3")) {

				nonMemberIn(); // 비회원 화면 띄우기 - 동환

			} else if (sel.equals("4")) {

				MemberShip membership = new MemberShip();
				membership.begin();
			}

			else if (sel.equals("5")) {
				loop = false;
			} else {
			}

		}

		System.out.println("프로그램을 종료합니다.");

		Data.save();
		System.exit(0);
	}

	/**
	 * 고객(비회원)으로 들어온 화면입니다.<br>
	 * 추천메뉴보기에서는 월,일별 추천메뉴가 출력되어있으며, 번호를 입력하여 해당상품을 즉시구매할수도 있습니다.<br>
	 * 메뉴선택으로 들어가면 전체메뉴를 보고 메뉴를 선택할수 있습니다.
	 * 
	 * 
	 * @author 유동환
	 */
	private static void nonMemberIn() {

		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("              고객(비회원) 주문");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println();
		System.out.println("\t     1. 추천메뉴보기");
		System.out.println();
		System.out.println("\t     2. 메뉴선택(전체메뉴)");
		System.out.println();
		System.out.println("\t     0. 이전 화면으로 돌아가기");
		System.out.println();
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.print("▶ 입력 : ");
		String sel = scan.nextLine();

		if (sel.equals("1")) {
			// 기간별 추천메뉴
			RecommendProduct rp = new RecommendProduct();
			rp.recommend();

		} else if (sel.equals("2")) {
			MenuService ms = new MenuService();
			ms.seeMenu();
		} else {
			// 이전화면으로 돌아가기
			return;
		}

	}

}
