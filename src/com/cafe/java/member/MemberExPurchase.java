package com.cafe.java.member;

import java.util.Scanner;

import com.cafe.java.data.Data;
import com.cafe.java.product.MemberMenuService;
import com.cafe.java.product.Menu;

/**
 * MemberExPurchase클래스 입니다.<br>
 * 고객(회원)의 과거 구매내역을 보여주는 기능입니다. <br>
 * 화면에 표시된 구매내역중 상품번호를 입력하면 선택한 상품을 구매할 수 있는 구매화면으로 넘어간다. <br>
 *
 * @see #exPurchase()
 * 
 * @author 강혜린
 */
public class MemberExPurchase extends MemberLogin {

	public static void exPurchase(Member m) {
		Scanner scan = new Scanner(System.in);

		boolean loop = true;
		int no = 0;

		while (loop) {

			System.out.println();
			System.out.printf("\t\t\t【 %s 】님의 구매내역\n", m.getUserName());
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("[번호]\t[일자]\t\t[상품명]\t\t[수량]\t[가격]");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");

			for (MemberPurchase mp : Data.memberPurchase) {

				if (mp.getUserNo() == m.getUserNo()) {
					if (mp.getSizeOption().equals("M")) {
						Data.getProduct(mp.getProductNo())
								.setPrice(Data.getProduct(mp.getProductNo()).getPrice() + 500);

					} else if (mp.getSizeOption().equals("L")) {
						Data.getProduct(mp.getProductNo())
								.setPrice(Data.getProduct(mp.getProductNo()).getPrice() + 1000);
					}

					// 고객이 구매한리스트txt에서 제품번호를 가져온 후, 메뉴txt에서 제품번호와 일치하는 메뉴 명과 가격을 가져오기 위함

					System.out.printf("%d\t%s\t%s%s(%s)\t   %d\t%,d\n", mp.getProductNo(), mp.getPurchaseDate(),
							mp.getTemOption(), Data.getProduct(mp.getProductNo()).getProductName(), mp.getSizeOption(),
							mp.getPurchaseNum(), mp.getPurchaseNum() * Data.getProduct(mp.getProductNo()).getPrice());
				}

			}

			System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
			System.out.println("0. 이전화면으로 돌아가기");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("번호를 입력하시면 동일한 제품을 구매할 수 있습니다.");
			System.out.print("▶ 입력: ");
			String sel = scan.nextLine();

			for (Menu prod : Data.menuList) {

				if (sel.equals(String.valueOf(prod.getProductNo()))) {
					MemberMenuService.option(m, Data.menuList.get(prod.getProductNo() - 1));
				}

			}

			if (sel.equals("0")) {

				return;
			} else {
				// 선택한 메뉴 구매 화면으로 넘어가기
			}
		}

	}

}
