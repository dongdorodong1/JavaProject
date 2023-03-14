package com.cafe.java.member;

import java.util.Scanner;

import com.cafe.java.data.Data;
import com.cafe.java.product.MemberMenuService;
import com.cafe.java.product.MemberRecommendProduct;
import com.cafe.java.product.RecommendProduct;

/**
 * 로그인 성공한 고객(회원)의 서비스메뉴를 보여주는 클래스 입니다.
 * 
 * @see #memberBegin
 * 
 * @author 강혜린
 *
 */
public class MemberService {

	public void memberBegin(Member m) {

		Scanner scan = new Scanner(System.in);

		boolean loop = true;
		while (loop && Data.flag) {
			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.printf("                ▶ %s님 ◀ \n", m.getUserName());
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println();
			System.out.println("\t   1. 추천 메뉴");
			System.out.println();
			System.out.printf("\t   2. %s님의 구매내역\n", m.getUserName());
			System.out.println();
			System.out.println("\t   3. 메뉴 선택(전체 메뉴)");
			System.out.println();
			System.out.println("\t   0. 초기화면으로 돌아가기");
			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.print("▶ 입력: ");

			String sel = scan.nextLine();

			if (sel.equals("1")) {

				MemberRecommendProduct.recommend(m);

			} else if (sel.equals("2")) {
				// 2. %s님의 구매내역\n"
				MemberExPurchase.exPurchase(m);

			} else if (sel.equals("3")) {
				// 3. 메뉴 선택(전체 메뉴)
				MemberMenuService.seeMenu(m);
			} else {
				// 0. 초기화면으로 돌아가기
				loop = false;
			}
		}

	}

}
