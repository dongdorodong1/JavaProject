package com.cafe.java.member;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import com.cafe.java.MainClass;
import com.cafe.java.data.Data;
import com.cafe.java.product.NonBuyProduct;
import com.cafe.java.product.ShopBasket;

/**
 * 비회원고객들이 구매한 상품들을 결제하는 클래스입니다.
 * 
 * @see #pay(List, int)
 * @see #cardPay(int, List)
 * @see #cashPay(int, List)
 * @see #receipt(List, int)
 * 
 * @author 유동환
 *
 */
public class NonMemPayment {

	/**
	 * 비회원 고객의 상품을 결제하기 전, 결제 수단 선택을 출력하는 메소드입니다.
	 * 
	 * @param nbpList <br>
	 *                : 상품들을 모아놓은 메뉴리스트
	 * @param money   <br>
	 *                : 메뉴의 총금액
	 * @author 유동환
	 */
	public static void pay(List<NonBuyProduct> nbpList, int money) {

		boolean loop = true;
		Scanner scan = new Scanner(System.in);
		String sel = "";
		while (loop && Data.flag) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("               [고객(비회원) 결제]");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println();
			System.out.println("\t   1. 카드 결제");
			System.out.println();
			System.out.println("\t   2. 현금 결제");
			System.out.println();
			System.out.println("\t   0. 결제취소");
			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.print("▶ 입력 :");
			sel = scan.nextLine();

			if (sel.equals("1")) {
				cardPay(money, nbpList);
			} else if (sel.equals("2")) {
				cashPay(money, nbpList);
			} else {
				return;
			}

		}

	}

	/**
	 * 비회원 고객들이 구매한 상품을 현금으로 결제하는 메소드입니다.
	 * 
	 * @param input   : 고객이 지불할 금액
	 * @param money   : 상품의 총금액
	 * @param nbpList : 비회원고객이 장바구니에 담은 상품목록
	 * @author 유동환
	 */
	private static void cashPay(int money, List<NonBuyProduct> nbpList) {

		Calendar buyDate = Calendar.getInstance();
		Scanner scan = new Scanner(System.in);
		String payway = "현금";

		String sel = "";
		int input = 0;
		int change = 0; // 잔돈
		boolean loop = true;

		while (loop) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("            [고객(비회원) 현금 결제]");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.printf("결제금액: %,d \n", money);
			System.out.print("돈을 넣으세요(금액입력): ");
			input = scan.nextInt();
			scan.nextLine();

			change = input - money;

			System.out.print("결제를 완료하시겠습니까(y/n)? :");
			sel = scan.nextLine();
			if (change < 0) {
				System.out.println();
				System.out.println("금액이 부족합니다.\n\n엔터를 입력하여 다시 넣어주세요.");
				scan.nextLine();
				continue;

			}
			System.out.println();
			System.out.println();
			System.out.println("정상적으로 결제가 완료되었습니다. ");
			System.out.println();
			System.out.printf("거스름돈 :%,d원\n", change);
			System.out.println();
			System.out.println("엔터를 누르면 영수증이 출력됩니다.");
			scan.nextLine();
			NonMemberreceipt(nbpList, money, payway);
			for (NonBuyProduct nbp : nbpList) { // 상품 > 컬렉션

				NonMemberPurchase nmp = new NonMemberPurchase();

				nmp.setProductNo(nbp.getProductNo());
				nmp.setPurchaseDate(String.format("%tF", buyDate));
				nmp.setPurchaseNum(nbp.getProductNum());
				nmp.setSizeOption(nbp.getSizeOp());
				nmp.setTemOption(nbp.getTempOp());
				Data.nonMemberPurchase.add(nmp);
			}
			nbpList.clear();
			loop = false;
		}
	}

	/**
	 * 비회원 고객들이 구매한 상품을 카드로 결제하는 메소드입니다.
	 * 
	 * @author 유동환
	 * @param input   : 고객이 지불할 금액
	 * @param money   : 상품의 총금액
	 * @param nbpList : 비회원고객이 장바구니에 담은 상품목록
	 */
	private static void cardPay(int money, List<NonBuyProduct> nbpList) {

		Scanner scan = new Scanner(System.in);
		String sel = "";
		Calendar buyDate = Calendar.getInstance();
		String payway = "카드";

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("             [고객(비회원) 카드 결제]");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("");
		System.out.println("카드를 단말기에 꽂아주세요.");
		System.out.println("――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println();
		System.out.printf("결제금액: %,d \n", money);
		System.out.println();
		System.out.println("――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println();
		System.out.print("결제를 완료하시겠습니까(y/n)?");
		sel = scan.nextLine();
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");

		if (sel.equals("y")) {

			for (NonBuyProduct nbp : nbpList) { // 상품 > 컬렉션

				NonMemberPurchase nmp = new NonMemberPurchase();

				nmp.setProductNo(nbp.getProductNo());
				nmp.setPurchaseDate(String.format("%tF", buyDate));
				nmp.setPurchaseNum(nbp.getProductNum());
				nmp.setSizeOption(nbp.getSizeOp());
				nmp.setTemOption(nbp.getTempOp());
				Data.nonMemberPurchase.add(nmp);

			} // 향상for문

			System.out.println();
			System.out.println("결제가 완료되었습니다.\n\n카드를 제거해주세요.");
			System.out.println();
			System.out.println("엔터를 누르면 영수증이 출력됩니다.");
			scan.nextLine();
			NonMemberreceipt(nbpList, money, payway);
			nbpList.clear(); // 결제와 동시에 담아왔던 장바구니 초기화

		} else {

		}
	}

	/**
	 * 비회원 고객들이 결제완료시 영수증을 출력하는 메소드입니다. <br\>
	 * 
	 * @author 유동환
	 * @param nbpList <br\>: 비회원고격들이 구매한 상품목록
	 * @param money   <br\>: 비회원고객들이 구매한 상품의 총금액
	 */

	private static void NonMemberreceipt(List<NonBuyProduct> nbpList, int money, String payway) {

		String sel = "";
		Scanner scan = new Scanner(System.in);
		boolean exit = false;
		Calendar cal = Calendar.getInstance();

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("                     JAVA CAFE");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("강남역1호점                 T:02-302-3111");
		System.out.println("서울 강남구 강남대로 392 ");
		System.out.println("대표:1team                 200-11-11022");
		System.out.printf("매장#3779           %tF %tT\n", cal, cal);
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println();
		System.out.printf("대기번호: %d\n", Data.getWaitNo());
		System.out.println();
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("[메뉴명]\t\t\t[수량]\t\t\t[금액]");
		System.out.println("┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉");
		for (NonBuyProduct nbp : nbpList) {
			System.out.printf("%s(%s)(%s)\t\t%s개\t\t%,d원\n", nbp.getProductName(),
					nbp.getTempOp() == null ? "X" : nbp.getTempOp(), nbp.getSizeOp() == null ? "X" : nbp.getSizeOp(),
					nbp.getProductNum(), nbp.getOnePrice());

		}
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println();
		System.out.printf("결제 수단: %s\n", payway);
		System.out.printf("결제 금액 : %,d\n", money);
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println();
		System.out.print("▶가게 나가기(exit입력):");
		sel = scan.nextLine();
		Data.setWaitNo(Data.getWaitNo() + 1); // wait No ++
		if (sel.equals("exit")) {
			ShopBasket.NonSum = 0;
			Data.flag = false;
			return;
		}

	}

}