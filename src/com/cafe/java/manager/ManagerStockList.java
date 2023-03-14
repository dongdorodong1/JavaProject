package com.cafe.java.manager;

import java.util.ArrayList;

import java.util.Scanner;

import com.cafe.java.data.Data;
import com.cafe.java.product.StockList;

/**
 * 관리자의 재고관리 기능 클래스 입니다.
 * 
 * @see #ManagerStockList()
 * @author 조혜은
 */
public class ManagerStockList {

	private int stockNum;
	private String productName;

	/**
	 * 재고확인과 주문관리를 확인할 수 있는 화면 메소드입니다.
	 * 
	 * @see #stlist()
	 * @author 조혜은
	 */
	public void stlist() {

		// 2. 재고 관리
		boolean loop = true;

		Scanner scan = new Scanner(System.in);

		while (loop) {

			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("                 [재고관리]");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println();
			System.out.println("\t1. 재고확인");
			System.out.println();
			System.out.println("\t2. 주문관리");
			System.out.println();
			System.out.println("\t0. 관리자 화면으로 돌아가기");
			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.print("▶ 입력: ");

			String sel = scan.nextLine();

			if (sel.equals("1")) {

				// 1. 재고확인
				stockCheck();

			} else if (sel.equals("2")) {

				// 2. 주문관리
				orderList();

			} else {

				// 0. 이전 화면으로 돌아가기
				loop = false;
			}

		}

	}// stlist

	/**
	 * 주문관리 화면입니다.<br>
	 * 주문관리 화면에서는 재고가 10개 이하인 상품목록을 볼 수 있습니다.<br>
	 * 또한 10개 이하인 상품들 중에서 재고를 주문할 수 있습니다.<br>
	 * 재고주문을 완료하게 되면 주문한 상품명과 재고량을 보여줍니다.
	 * 
	 * @author 조혜은
	 * @see #orderList()
	 */
	private void orderList() {

		int numCheck = 0; // 10개 이하 재고수량

		Scanner scan = new Scanner(System.in);

		// 1■아메리카노■120■2000■2022-09-27
		System.out.println();

		System.out.println("                               [주문관리]");
		System.out.println("▶ 재고수량이 10개 이하인 상품");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println(" [상품번호]      [상품명]\t\t[가격]\t\t[재고수량]\t[입고일]");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");

		// 재고수량 10개이하 내역
		for (StockList ms : Data.stockList) {

			if (ms.getStockNum() <= 10) {

				numCheck = ms.getStockNum();

				System.out.printf("%5d\t%10s\t\t%4d\t\t%5d\t\t%10s\n", ms.getProductNo(), ms.getProductName(),
						ms.getPrice(), numCheck, ms.getRecDate());

			}
		}

		System.out.println();
		System.out.print("▶ 상품을 주문하시겠습니까?(y/n입력): ");
		String product = scan.nextLine();
		System.out.println();

		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("▶ 상품 주문하기");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println();

		if (product.equals("y")) {

			System.out.print("상품명: ");
			String productName = scan.nextLine();

			System.out.print("구매 수량: ");
			int stockNum = scan.nextInt();

			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");

			// 구매수량은 입력한 상품명의 구매수량을 올려주고 주문했다는 문구 띄우기
			// 주문 재고 수량 넣기
			ArrayList<StockList> stlist = Data.stockList;

			int sum = 0; // 원래 재고수량과 주문한 수량 합계

			for (StockList s : stlist) {

				if (s.getProductName().equals(productName)) {

					sum = s.getStockNum() + stockNum; // 기존 재고수량 + 입력한 수량y

					s.setStockNum(sum);
				}

				// StockList에 합친 재고수량 넣기

			}

			System.out.printf("▶ 구매한 상품명: %s\n구매한 수량: %d개\n", productName, stockNum);
			System.out.println();
			System.out.printf("▶ %s현재 재고수량: %d개\n", productName, sum);
			System.out.println();
			System.out.println("재고주문을 완료했습니다.");

		} else {

		}

		// 일시 정지
		Data.pause();

	}

	/**
	 * 재고량이 10개 이하인 메뉴를 가져오는 메소드입니다.
	 * 
	 * @author 조혜은
	 * @return
	 */
	private int stockNumCheck() {

		for (StockList ms : Data.stockList) {

			if (ms.getStockNum() <= 10) {
				return ms.getStockNum();
			}
		}
		return stockNum;
	}

	/**
	 * 재고확인 화면입니다.<br>
	 * 재고확인 화면에서는 현재 가지고 있는 재고정보를 조회 및 상품검색이 가능합니다.
	 * 
	 * @see #stockCheck();
	 * 
	 * @author 조혜은
	 * @author 유동환 - 상품검색
	 */
	private void stockCheck() {

		// 1■아메리카노■120■2000■2022-09-27
		System.out.println();

		System.out.println("                               [재고확인]");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println(" [상품번호]     [상품명]\t\t[가격]\t\t[재고수량]\t\t  [입고일]");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");

		for (StockList ms : Data.stockList) {

			System.out.printf("%5d\t%10s\t\t%4d\t\t%5d\t\t%10s\n", ms.getProductNo(), ms.getProductName(),
					ms.getPrice(), ms.getStockNum(), ms.getRecDate());

		}

		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		Scanner scan = new Scanner(System.in);
		System.out.print("▶상품명으로 검색:");
		String productName = scan.nextLine();
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		for (StockList ms : Data.stockList) {
			if (productName.equals(ms.getProductName())) {
				System.out.printf("%5d\t%12s\t\t%,5d\t\t%5d\t\t%10s\n", ms.getProductNo(), ms.getProductName(),
						ms.getPrice(), ms.getStockNum(), ms.getRecDate());
			}

		}
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		// 일시정지
		Data.pause();

	} // stockCheck

}
