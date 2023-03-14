package com.cafe.java.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cafe.java.member.Member;
import com.cafe.java.member.MemberPayment;
import com.cafe.java.member.NonMemPayment;

/**
 * 고객이 담아온 상품목록을 출력하고 결제진행 의사를 묻는 클래스입니다.
 * 
 * @see #shop(List)
 * @see #memberShop(Member, ArrayList)
 * @author 유동환
 *
 */
public class ShopBasket { // 장바구니
	public static int NonSum; // 비회원 총금액
	public static int memberSum; // 회원 총금액

	static {
		NonSum = 0;
		memberSum = 0;

	}

	/**
	 * 비회원 고객이 담아온 상품목록을 출력하고 결제진행 의사를 묻는 메소드
	 * 
	 * @param nbpList <br>
	 *                : 비회원 고객이 담아온 상품리스트
	 * 
	 * @author 유동환
	 */
	public static void shop(List<NonBuyProduct> nbpList) {

		Scanner scan = new Scanner(System.in);

		String sel = "";

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("╔═══════════════════════════════════════════════════════════════╗");
		System.out.println("                         ▶ 장바구니");
		System.out.println("╚═══════════════════════════════════════════════════════════════╝");
		System.out.println(" ═══════════════════════════════════════════════════════════════ ");
		System.out.println(" [상품번호]\t    [상품명]\t[가격]\t[추가옵션]\t       [담긴수량]   ");
		System.out.println();
		System.out.println(" ═══════════════════════════════════════════════════════════════ ");

		nbpList.stream().map(n -> n.getProductPrice()).forEach(p -> {

			NonSum += p;
		});
		nbpList.stream()
				.forEach(n -> System.out.printf("%4d\t%9s\t%,5d %6s/%s     %8d\n", n.getProductNo(), n.getProductName(),
						n.getOnePrice(), n.getTempOp() == null ? "X" : n.getTempOp(),
						n.getSizeOp() == null ? "X" : n.getSizeOp(), n.getProductNum()));
		System.out.println(" ═══════════════════════════════════════════════════════════════ ");
		System.out.println();
		System.out.printf("금액합계: %,d", NonSum);
		System.out.println();
		System.out.println(" ═══════════════════════════════════════════════════════════════ ");
		System.out.println();
		System.out.print("결제를 진행하시겠습니까(y/n)?");
		sel = scan.nextLine();

		if (sel.equals("y")) {
			NonMemPayment nmp = new NonMemPayment();// TODO 비회원 회원결제 조건
			nmp.pay(nbpList, NonSum);

		} else {
			NonSum = 0;
		}

	}

	/**
	 * 
	 * @param member     <br>
	 *                   : 메뉴를 담아온 회원 고객에 대한 정보입니다.
	 * @param memberProd <br>
	 *                   : 회원 고객이 담아온 메뉴목록 리스트
	 * 
	 * @author 유동환
	 */
	public static void memberShop(Member member, ArrayList<MemberBuyProduct> memberProd) {

		Scanner scan = new Scanner(System.in);

		String sel = "";
		int priceSum = 0;

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("╔═══════════════════════════════════════════════════════════════╗");
		System.out.println("                         ▶ 장바구니");
		System.out.println("╚═══════════════════════════════════════════════════════════════╝");
		System.out.println(" ═══════════════════════════════════════════════════════════════ ");
		System.out.println("[상품번호]\t    [상품명]\t[가격]\t[추가옵션]\t       [담긴수량]    ");
		System.out.println(" ═══════════════════════════════════════════════════════════════ ");

		memberProd.stream().map(n -> n.getProductPrice()).forEach(p -> {

			memberSum += p;
		});
		memberProd.stream()
				.forEach(n -> System.out.printf("%4d\t%9s\t%,5d %6s/%s     %8d\n", n.getProductNo(), n.getProductName(),
						n.getOnePrice(), n.getTempOp() == null ? "X" : n.getTempOp(),
						n.getSizeOp() == null ? "X" : n.getSizeOp(), n.getProductNum()));
		System.out.println(" ═══════════════════════════════════════════════════════════════ ");
		System.out.println();
		System.out.printf("  금액합계: %,d", memberSum);
		System.out.println();
		System.out.println(" ═══════════════════════════════════════════════════════════════ ");
		System.out.println();
		System.out.print("결제를 진행하시겠습니까(y/n)? ");
		sel = scan.nextLine();

		if (sel.equals("y")) {
			MemberPayment mp = new MemberPayment();
			mp.memberPaymentChoice(member, memberProd, memberSum);
		} else {

			memberSum = 0;
		}

	}

}
