package com.cafe.java.manager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.cafe.java.data.Data;
import com.cafe.java.member.MemberPurchase;
import com.cafe.java.member.NonMemberPurchase;
import com.cafe.java.product.Menu;

/**
 * SalesMonth클래스 입니다. <br>
 * 입력받은 월별 매출현황, 고객 수 기능이 있는 클래스입니다. 관리자로부터 매출현황을 알고 싶은 날짜(YYYY-MM)을 입력받습니다.
 * <br>
 * 입력받은 날짜와 일치하는 해당 월 의 고객수(회원 + 비회원)와 총 매출액(회원 + 비회원)을 알려줍니다. <br>
 * 
 * @see #month()
 *
 * @author 강혜린
 */
public class SalesMonth {

	public void month() {
		// 2. 월별 고객수 & 매출액

		Scanner scan = new Scanner(System.in);

		int year = 0;
		int month = 0;
		int sel = 0;

		boolean loop = true;
		while (loop) {

			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("\t\t\t[ 月 별 고객수 & 매출액 ]");
			System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
			System.out.println("매출 현황을 알고 싶으신 날짜를 입력해주세요.");
			System.out.print("연도(YYYY) : ");
			year = scan.nextInt();
			System.out.print("월(MM) : ");
			month = scan.nextInt();
			System.out.printf("입력하신 날짜는 %d년 %02d월 입니다.\n", year, month);
			System.out.println("▶ 맞으면 1, 다시 입력을 원하시면 2을 입력해주세요");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.print("▶ 입력 : ");
			sel = scan.nextInt();
			System.out.println();

			if (sel == 1) {

				// 고객수
				int count = 0;
				// Calendar calendar = Calendar.getInstance();
				// calendar.set(year, month);

				String input = String.format("%d-%02d", year, month);

				for (MemberPurchase mp1 : Data.memberPurchase) {

					if (mp1.getPurchaseDate().substring(0, 7).equals(input)) {
						count++; // 고객 수 카운트

					}
				}

				for (NonMemberPurchase nmp1 : Data.nonMemberPurchase) {
					if (nmp1.getPurchaseDate().substring(0, 7).equals(input)) {
						count++; // 비회원고객 수 카운트

					}
				}

				// 매출액
				ArrayList<MemberPurchase> inputNo = Data.getProductNoMon(input); // 일치하는 날짜의 상품번호 가져오기

				int sum = 0;

				for (int i = 0; i < inputNo.size(); i++) {

					String inputno = String.format("%s", inputNo.get(i));
					ArrayList<Menu> inputPrice = Data.getProductPrice(inputno);
					sum += inputPrice.get(0).getPrice();

				}

				ArrayList<NonMemberPurchase> inputNonon = Data.getProductNononMon(input); // 일치하는 날짜의 상품번호 가져오기

				for (int i = 0; i < inputNo.size(); i++) {

					String inputno = String.format("%s", inputNo.get(i));
					ArrayList<Menu> inputPrice = Data.getProductPrice(inputno);
					sum += inputPrice.get(0).getPrice();

				}

				System.out.printf(input + "월의 고객수 : %,d명\n", count);
				System.out.printf(input + "월의 매출액 : %,d원\n", sum);

				Data.pause();
				loop = false;

			} else if (sel == 2) {

				System.out.println("다시");
				loop = false;

			}

		}

	}

}
