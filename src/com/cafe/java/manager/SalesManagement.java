package com.cafe.java.manager;

import java.util.Scanner;

/**
 * SalesManagement클래스 입니다.<br>
 * 매출액과 고객수를 일별과 월별을 선택하는 클래스입니다. 관리자가 일별 매출과 월별 매출을 확인할 수 있는 기능입니다. <br>
 * 번호를 입력하여 일별을 확인할지 월별을 확인할지 선택할 수 있습니다. <br>
 *
 * @see #sellshow()
 *
 * @author 강혜린
 */
public class SalesManagement {

	public void sellshow() {

		Scanner scan = new Scanner(System.in);

		boolean loop = true;
		while (loop) {

			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("\t\t[매출현황]");
			System.out.println("――――――――――――――――――――――――――――――――――――");
			System.out.println();
			System.out.println("\t1. 일별 고객수 & 매출액");
			System.out.println("\t2. 월별 고객수 & 매출액");
			System.out.println();
			System.out.println("0. 이전메뉴로 돌아가기");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.print("▶ 입력 : ");
			String sel = scan.nextLine();

			if (sel.equals("1")) {
				// 1. 일별 고객수 & 매출액
				SalesDay salesDay = new SalesDay();
				salesDay.day();

			} else if (sel.equals("2")) {
				// 2. 월별 고객수 & 매출액
				SalesMonth salesMonth = new SalesMonth();
				salesMonth.month();

			} else if (sel.equals("0")) {
				loop = false;

			} else {
				System.out.println("잘못입력하셨습니다.");
			}

		}

	}// sellshow

}// class
