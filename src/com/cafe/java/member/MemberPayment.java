package com.cafe.java.member;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.cafe.java.data.Data;
import com.cafe.java.product.MemberBuyProduct;
import com.cafe.java.product.MemberMenuService;
import com.cafe.java.product.NonBuyProduct;
import com.cafe.java.product.ShopBasket;

/**
 * 멤버들이 구매한 장바구니를 가지고 결제 및 영수증을 출력하는 클래스입니다.
 * 
 * @author 김현준
 * @author 유동환 결제수단을 선택할 수 있는 memberPaymentChoice메소드를 기반으로 <br/>
 *         카드 결제, 현금 결제, 포인트 결제를 선택할 수 있습니다. <br/>
 *         회원 영수증을 출력하는 메소드로 receiptPrintPoint
 *
 */
public class MemberPayment extends MemberLogin {
	private static String name = "";
	private static int point = 0;
	String paymentCheck = ""; // 결제수단 구분
	Scanner scan = new Scanner(System.in);

	/**
	 * 결제 수단을 선택할 수 있는 메소드입니다.
	 * 
	 * @author 김현준
	 * @author 유동환
	 * 
	 * @param member         -> 회원정보
	 * @param memberProdList -> 장바구니에 담긴 상품 정보
	 * @param money          -> 결제 금액
	 */
	public void memberPaymentChoice(Member member, ArrayList<MemberBuyProduct> memberProdList, int money) { // 장바구니에서 합계
																											// 금액을 받아옴

		boolean loop = true;

		while (loop && Data.flag) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("               [ 결제수단 선택 ]");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println();
			System.out.print("\t\t1. 카드 결제");
			System.out.println();
			System.out.print("\t\t2. 현금 결제");
			System.out.println();
			System.out.print("\t\t3. 포인트 조회 / 사용");
			System.out.println();
			System.out.println("\t\t0. 이전화면으로 돌아가기");
			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.print("▶ 입력: ");

			String sel = scan.nextLine();

			if (sel.equals("1")) {
				// 카드 결제
				paymentCheck = "카드 결제";
				memberCardPayment(member, memberProdList, money);
				loop = false;

			} else if (sel.equals("2")) {
				// 현금 결제
				paymentCheck = "현금 결제";
				memberCashPayment(member, memberProdList, money);
				loop = false;

			} else if (sel.equals("3")) {
				// 포인트 조회/확인
				paymentCheck = "포인트 결제";
				memberPointPayment(member, memberProdList, money);

			} else {
				loop = false;
			}

		}
	}

	/**
	 * 카드 결제를 진행해주는 메소드입니다.
	 * 
	 * @author 김현준
	 * @author 유동환
	 * 
	 * @param member         -> 회원정보
	 * @param memberProdList -> 장바구니에 담긴 상품 정보
	 * @param money          -> 결제금액
	 */
	public void memberCardPayment(Member member, ArrayList<MemberBuyProduct> memberProdList, int money) {

		Calendar buyDate = Calendar.getInstance();

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("              고객(회원) 카드 결제");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("카드를 단말기에 꽂아주세요.");
		System.out.println();
		System.out.printf("결제 금액: %,d\n", money);
		System.out.println();
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.print("결제를 완료하시겠습니까(y/n)?");
		String sel = scan.nextLine();

		if (sel.equals("y")) {
			System.out.println("엔터를 누르면 영수증을 출력합니다.");
			scan.nextLine();
			receiptPrintCardAndCash(member, money, memberProdList); //
			for (MemberBuyProduct mbp : memberProdList) { // 상품 > 컬렉션

				// 74■44■3■270■2022-07-17■X■X
				// 고객번호/상품번호/구매수량/포인트/데이트/온도옵션/사이즈옵션
				MemberPurchase mp = new MemberPurchase();

				mp.setUserNo(member.getUserNo());
				mp.setProductNo(mbp.getProductNo());
				mp.setPurchaseDate(String.format("%tF", buyDate));
				mp.setPurchaseNum(mbp.getProductNum());
				mp.setSavePoint(mbp.getProductPrice() / 20);
				mp.setTemOption(mbp.getTempOp());
				mp.setSizeOption(mbp.getSizeOp());
				Data.memberPurchase.add(mp);
			}
			memberProdList.clear();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			/* */} else if (sel.equals("n")) {
			// n을 선택한 경우
		}
	}

	/**
	 * 
	 * 회원 고객이 구매한 상품을 현금으로 결제하는 메소드입니다.
	 * 
	 * @author 김현준
	 * @author 유동환
	 * @param input          -> 고객이 지불할 금액
	 * @param money          -> 상품의 총금액
	 * @param memberProdList -> 회원고객이 장바구니에 담은 상품목록
	 */
	public void memberCashPayment(Member member, ArrayList<MemberBuyProduct> memberProdList, int money) {
		Calendar BuyDate = Calendar.getInstance();
		Boolean loop = true;

		while (loop) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("              고객(회원) 현금 결제");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.printf("결제 금액: %,d\n", money);
			System.out.println();
			System.out.print("지불할 금액: ");
			int cash = scan.nextInt();
			System.out.print("결제를 진행하시겠습니까(y/n)? : ");
			String sel = scan.next();
			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");

			if (sel.equals("y")) {
				// 금액 유효성 검사
				if (cash >= money) {

					int balance = cash - money;
					System.out.println("정상적으로 결제가 완료되었습니다.");
					System.out.println("거스름돈: " + balance + "원");
					System.out.println("엔터를 누르면 영수증을 출력합니다.");
					scan.nextLine();
					for (MemberBuyProduct mbp : memberProdList) { // 상품 > 컬렉션

						// 74■44■3■270■2022-07-17■X■X
						// 고객번호/상품번호/구매수량/포인트/데이트/온도옵션/사이즈옵션
						MemberPurchase mp = new MemberPurchase();

						mp.setUserNo(member.getUserNo());
						mp.setProductNo(mbp.getProductNo());
						mp.setPurchaseDate(String.format("%tF", BuyDate));
						mp.setPurchaseNum(mbp.getProductNum());
						mp.setSavePoint(mbp.getProductPrice() / 20);
						mp.setTemOption(mbp.getTempOp());
						mp.setSizeOption(mbp.getSizeOp());
						Data.memberPurchase.add(mp);
					}

					scan.nextLine();
					receiptPrintCardAndCash(member, money, memberProdList);
					memberProdList.clear();
					loop = false;

				} else {
					// 금액이 부족한 경우
					System.out.println("투입 금액이 부족합니다.");
					System.out.println("금액을 다시 넣어주세요.");
					scan.nextLine();
					continue;

				}

			} else if (sel.equals("n")) {

				System.out.println("n을 선택하셨습니다.\n엔터를 누르면 결제 선택화면으로 돌아갑니다.");
				loop = false;
				Data.pause();

			}

		}
	}

	/**
	 * 
	 * 회원 고객이 본인의 포인트를 조회 / 사용 할수 있는 메소드입니다.
	 * 
	 * @author 김현준
	 * 
	 * 
	 * @param money          -> 결제 금액
	 * @param memberProdList -> 장바구니에 담긴 상품 정보
	 */
	public void memberPointPayment(Member member, ArrayList<MemberBuyProduct> memberProdList, int money) {

		Boolean loop = true;

		while (loop) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("              포인트 조회 및 사용 ");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println();
			System.out.print("1. 포인트 조회");
			System.out.println();
			System.out.print("2. 포인트 사용");
			System.out.println();
			System.out.print("3. 다른 결제 방식 선택");
			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.print("▶ 입력: ");

			String sel = scan.nextLine();

			if (sel.equals("1")) {
				// 포인트 조회
				pointVeiw(money, memberProdList);

			} else if (sel.equals("2")) {
				// 포인트 사용
				usingPoint(member, money, memberProdList);
				loop = false;

			} else if (sel.equals("3")) {
				// 결제 수단 선택 화면
				loop = false;
			} else {

				Data.pause();

			}

		}
	}

	/**
	 * 
	 * 회원의 현재까지 누적 포인트를 확인할 수 있는 메소드입니다.
	 * 
	 * @author 김현준
	 * 
	 * @param money          -> 결제 금액
	 * @param memberProdList -> 장바구니에 담긴 상품 정보
	 *
	 */
	public void pointVeiw(int money, ArrayList<MemberBuyProduct> memberProdList) {
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("                 포인트 조회 ");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.printf("현재 [%s]님의 포인트 잔액은 [%,d]원입니다\n", MemberLogin.paymetName, MemberLogin.paymentPoint);
		System.out.println();
		System.out.println("이전화면으로 돌아가기: 0");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.print("▶ 입력: ");
		String sel = scan.nextLine();

		if (sel.equals("0")) {

		}
	}

	/**
	 * 회원의 누적 포인트를 사용할 수 있는 메소드입니다.
	 * 
	 * @author 김현준
	 * @author 유동환
	 * 
	 * @param member         -> 회원 정보
	 * @param money          -> 결제 금액
	 * @param memberProdList -> 장바구니에 담긴 상품 리스트
	 */
	private void usingPoint(Member member, int money, ArrayList<MemberBuyProduct> memberProdList) {

		boolean loop = true;
		Calendar BuyDate = Calendar.getInstance();
		Scanner scan = new Scanner(System.in);

		while (loop) {
			
			
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("                  포인트 사용");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.printf("[%s]님의 누적 포인트: [%,d]\n", MemberLogin.paymetName, MemberLogin.paymentPoint);
			System.out.println();
			System.out.printf("결제금액: %,d\n", money);
			System.out.println();
			System.out.println("결제 수단 선택");
			System.out.println("―――――――――――――――――――――――――――――――――――――――――――――");
			System.out.println("1. 포인트 결제");
			System.out.println();
			System.out.println("2. 다른 결제 방식 선택");
			System.out.println("―――――――――――――――――――――――――――――――――――――――――――――");
			System.out.print("▶ 입력: ");
			String sel = scan.nextLine();

			if (sel.equals("1")) {

				if (MemberLogin.paymentPoint >= money) {

					System.out.println("포인트 결제가 완료되었습니다.");

					for (MemberBuyProduct mbp : memberProdList) { // 상품 > 컬렉션

						// 74■44■3■270■2022-07-17■X■X
						// 고객번호/상품번호/구매수량/포인트/데이트/온도옵션/사이즈옵션
						MemberPurchase mp = new MemberPurchase();

						mp.setUserNo(member.getUserNo());
						mp.setProductNo(mbp.getProductNo());
						mp.setPurchaseDate(String.format("%tF", BuyDate));
						mp.setPurchaseNum(mbp.getProductNum());
						mp.setSavePoint(mbp.getProductPrice() / 20);
						mp.setTemOption(mbp.getTempOp());
						mp.setSizeOption(mbp.getSizeOp());
						Data.memberPurchase.add(mp);
					}
					System.out.println();
					System.out.println("엔터를 누르면 영수증을 출력합니다.");
					scan.nextLine();
					receiptPrintPoint(member, money, memberProdList);

					memberProdList.clear(); // 결제 완료후 장바구니 지우기
					loop = false;

				} else {
					System.out.println("포인트 잔액이 부족합니다.\n다른결제 방식을 선택하시려면 엔터를 입력하세요");
					scan.nextLine();
				}
			} else {
				loop = false;
			}
		}

	}

	/**
	 * 
	 * 회원 고객들이 카드와 현금 결제 완료시 영수증을 출력하는 메소드입니다.
	 * 
	 * @author 김현준
	 * 
	 * 
	 * @param memberProdList <br\>: 회원고격들이 구매한 상품목록
	 * @param money          <br\>: 회원고객들이 구매한 상품의 총금액
	 */
	public void receiptPrintCardAndCash(Member member, int money, ArrayList<MemberBuyProduct> memberProdList) {

		int addPoint = 0;
		String exit = "";

		Scanner scan = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("                     JAVA CAFE");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("강남역1호점                 T:02-302-3111");
		System.out.println("서울 강남구 강남대로 392 ");
		System.out.println("대표:1team                 200-11-11022");
		System.out.printf("매장#3779            %tF %tT\n", cal, cal);
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println();
		System.out.printf("대기번호: %d\n", Data.getWaitNo());
		System.out.println();
		System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("[메뉴명]\t\t\t[수량]\t\t\t[금액]");
		System.out.println("┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉");
		for (MemberBuyProduct memberBuyProd : memberProdList) {
			System.out.printf("%s(%s)(%s)\t\t%s개\t\t%,d원\n", memberBuyProd.getProductName(),
					memberBuyProd.getTempOp() == null ? "X" : memberBuyProd.getTempOp(),
					memberBuyProd.getSizeOp() == null ? "X" : memberBuyProd.getSizeOp(), memberBuyProd.getProductNum(),
					memberBuyProd.getOnePrice());
		}
		System.out.println("┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉");
		System.out.printf("결제 수단 : %s\n", paymentCheck);
		System.out.printf("상품 가격: %,d\n", money);
		System.out.println();
		System.out.printf("적립 전 포인트: %,d\n", member.getUserPoint());
		System.out.printf("포인트 적립 내역: %,d\n", money / 20);

		addPoint = member.getUserPoint() + money / 20;
		member.setUserPoint(addPoint);

		System.out.printf("%s 님의 적립 포인트: %,d\n", member.getUserName(), addPoint);
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("감사합니다 안녕히 가세요.");
		memberProdList.clear();
		System.out.println();
		Data.setWaitNo(Data.getWaitNo() + 1);
		System.out.printf("가게나가기(exit입력): ");
		String out = scan.nextLine();

		if (out.equals("exit")) {
			ShopBasket.memberSum = 0;
			Data.flag = false;
			return;
		}

	}

	/**
	 * 
	 * 회원 고객들이 포인트를 이용해 결제를 진행한 경우 영수증을 출력해주는 메소드입니다.
	 * 
	 * @author 김현준
	 * 
	 * @param member         -> 회원정보
	 * @param money          -> 누적 금액
	 * @param memberProdList -> 장바구니에 담긴 상품 정보
	 */

	public void receiptPrintPoint(Member member, int money, ArrayList<MemberBuyProduct> memberProdList) {
		int subPoint = 0;
		int point = 0;
		String exit = "";

		Scanner scan = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();

		point = member.getUserPoint(); // 회원이 원래있던 포인트
		subPoint = member.getUserPoint() - money; // 포인트에서 결제금액 차감
		member.setUserPoint(subPoint); // 차감후 남은 포인트로 저장

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("                      JAVA CAFE");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("강남역1호점                 T:02-302-3111");
		System.out.println("서울 강남구 강남대로 392 ");
		System.out.println("대표:1team                 200-11-11022");
		System.out.printf("매장#3779            %tF %tT\n", cal, cal);
		System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println("[메뉴명]\t\t\t[수량]\t\t\t[금액]");
		System.out.println("┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉");
		for (MemberBuyProduct memberBuyProd : memberProdList) {
			System.out.printf("%s(%s)(%s)\t\t%s개\t\t%,d원\n", memberBuyProd.getProductName(),
					memberBuyProd.getTempOp() == null ? "X" : memberBuyProd.getTempOp(),
					memberBuyProd.getSizeOp() == null ? "X" : memberBuyProd.getSizeOp(), memberBuyProd.getProductNum(),
					memberBuyProd.getOnePrice());
		}
		System.out.println("┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉┉");
		System.out.println();
		System.out.printf("대기번호: %d\n", Data.getWaitNo());
		System.out.println();
		System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.printf("결제 수단 : %s\n", paymentCheck);
		System.out.println();
		System.out.printf("현재 포인트: %,d \n", point);
		System.out.printf("결제 금액: %,d\n", money);
		System.out.printf("잔여 포인트: %,d\n", subPoint);
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.print("프로그램 종료(exit입력) : ");

		String sel = scan.nextLine();
		Data.setWaitNo(Data.getWaitNo() + 1);
		if (sel.equals("exit")) {
			Data.flag = false;
			ShopBasket.memberSum = 0;
			return;

		}
	}
}