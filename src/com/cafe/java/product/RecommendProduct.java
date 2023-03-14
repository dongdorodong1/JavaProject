package com.cafe.java.product;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.cafe.java.data.Data;
import com.cafe.java.member.MemberPurchase;
import com.cafe.java.member.NonMemberPurchase;

/**
 * 비회원 고객에게 추천상품을 제공하는 클래스입니다. <br\>캘린더 클래스를 이용하여 이번달과 전달의 월을 구하고 <br\>
 * HashMap안에 월에 해당하는 상품을 key로 하고, 상품의 갯수를 누적하는 방식으로 value로 하였습니다.<br\> 맵을 정렬하기위해
 * LIST<MAP.ENTRY> 클래스로 boxing하여 갯수(value)를 오름차순 정렬을 하였습니다.<br\> 따라서 오늘의 추천메뉴에는
 * 이번달에 많이 팔린 메뉴를 1~4위로 추출하여 출력하였고<br\> 이번달의 추천메뉴는 바로 전달에 많이 팔린 메뉴를 1~4위로 추출하여
 * 출력하였습니다. <br\>
 * 
 * @author 유동환
 *
 */

public class RecommendProduct {

	public static void recommend() {

		String sel = "";
		String year = "";
		String month = "";
		String date = "";

		Scanner scan = new Scanner(System.in);

		Calendar cal = Calendar.getInstance();

		String calMonth = String.format("%02d", cal.get(Calendar.MONTH) + 1); // 이번달
		String beforeMonth = String.format("%02d", cal.get(Calendar.MONTH)); // 전달
		// 15■4■2022-08-09■HOT■M

		HashMap<String, Integer> pbmap = new HashMap<String, Integer>();
		HashMap<String, Integer> beforePbmap = new HashMap<String, Integer>(); // 전달 메뉴 Map

		for (NonMemberPurchase nmbp : Data.nonMemberPurchase) {

			String[] temp = nmbp.getPurchaseDate().split("-");
			year = temp[0];
			month = temp[1];
			date = temp[2];

			if (month.equals(calMonth)) {

				if (!pbmap.containsKey(Data.getProduct(nmbp.getProductNo()).getProductName())) {
					pbmap.put(Data.getProduct(nmbp.getProductNo()).getProductName(), 1);
				} else {
					pbmap.put(Data.getProduct(nmbp.getProductNo()).getProductName(),
							pbmap.get(Data.getProduct(nmbp.getProductNo()).getProductName()) + 1);
				}

			} // 현재 달의 인기메뉴

			if (month.equals(beforeMonth)) {

				if (!beforePbmap.containsKey(Data.getProduct(nmbp.getProductNo()).getProductName())) {
					beforePbmap.put(Data.getProduct(nmbp.getProductNo()).getProductName(), 1);
				} else {
					beforePbmap.put(Data.getProduct(nmbp.getProductNo()).getProductName(),
							beforePbmap.get(Data.getProduct(nmbp.getProductNo()).getProductName()) + 1);
				}

			} // 전 달의 인기메뉴
		} // 비회원 구매내역

		for (MemberPurchase mbp : Data.memberPurchase) {

			String[] temp = mbp.getPurchaseDate().split("-");
			year = temp[0];
			month = temp[1];
			date = temp[2];

			if (month.equals(calMonth)) {

				if (!pbmap.containsKey(Data.getProduct(mbp.getProductNo()).getProductName())) {
					pbmap.put(Data.getProduct(mbp.getProductNo()).getProductName(), 1);
				} else {
					pbmap.put(Data.getProduct(mbp.getProductNo()).getProductName(),
							pbmap.get(Data.getProduct(mbp.getProductNo()).getProductName()) + 1);
				}

			} // 현재 달의 인기메뉴

			if (month.equals(beforeMonth)) {

				if (!beforePbmap.containsKey(Data.getProduct(mbp.getProductNo()).getProductName())) {
					beforePbmap.put(Data.getProduct(mbp.getProductNo()).getProductName(), 1);
				} else {
					beforePbmap.put(Data.getProduct(mbp.getProductNo()).getProductName(),
							beforePbmap.get(Data.getProduct(mbp.getProductNo()).getProductName()) + 1);
				}

			}
		} // 회원 구매내역

		List<Map.Entry<String, Integer>> oderList = new ArrayList<>(pbmap.entrySet());
		oderList.sort(new Comparator<Map.Entry<String, Integer>>() {
			@Override

			public int compare(Map.Entry<String, Integer> p1, Map.Entry<String, Integer> p2) {
				return p2.getValue() - p1.getValue();
			}
		});// 현재 달의 메뉴정렬

		List<Map.Entry<String, Integer>> BeforeOderList = new ArrayList<>(beforePbmap.entrySet());
		BeforeOderList.sort(new Comparator<Map.Entry<String, Integer>>() {
			@Override

			public int compare(Map.Entry<String, Integer> p1, Map.Entry<String, Integer> p2) {
				return p2.getValue() - p1.getValue();
			}
		});// 이전 달의 메뉴정렬

		boolean loop = true;

		// 이달의 추천상품 > 전달의 가장 많이 팔린메뉴 1,2,3,4위
		// 오늘의 추천상품 > 이번달에 가장 많이 팔린 메뉴 1,2,3,4위
		while (loop) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("                  [추천메뉴]");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println();
			System.out.println("\t  <★오늘의 Best Menu★>");
			System.out.println();
			System.out.printf("\t  1. %s, [판매개수: %s]\n", oderList.get(0).getKey(), oderList.get(0).getValue());
			System.out.println();
			System.out.printf("\t  2. %s, [판매개수: %s]\n", oderList.get(1).getKey(), oderList.get(1).getValue());
			System.out.println();
			System.out.printf("\t  3. %s, [판매개수: %s]\n", oderList.get(2).getKey(), oderList.get(2).getValue());
			System.out.println();
			System.out.printf("\t  4. %s, [판매개수: %s]\n", oderList.get(3).getKey(), oderList.get(3).getValue());
			System.out.println();
			System.out.println("――――――――――――――――――――――――――――――――――――――――");
			System.out.println();
			System.out.println("         <★이달의 Best Menu★>");
			System.out.println();
			System.out.printf("\t  5. %s, [판매개수: %s]\n", BeforeOderList.get(0).getKey(),
					BeforeOderList.get(0).getValue());
			System.out.println();
			System.out.printf("\t  6. %s, [판매개수: %s]\n", BeforeOderList.get(1).getKey(),
					BeforeOderList.get(1).getValue());
			System.out.println();
			System.out.printf("\t  7. %s, [판매개수: %s]\n", BeforeOderList.get(2).getKey(),
					BeforeOderList.get(2).getValue());
			System.out.println();
			System.out.printf("\t  8. %s, [판매개수: %s]\n", BeforeOderList.get(3).getKey(),
					BeforeOderList.get(3).getValue());
			System.out.println();
			System.out.println("\t  0. 이전화면으로 돌아가기");
			System.out.println();
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.print("▶입력: ");
			sel = scan.nextLine();

			if (sel.equals("1")) {
				// 1번메뉴가 장바구니로
				MenuService.option(Data.getProduct(Data.getProductNo(oderList.get(0).getKey())));
			} else if (sel.equals("2")) {
				// 2번메뉴가 장바구니로
				MenuService.option(Data.getProduct(Data.getProductNo(oderList.get(1).getKey())));
			} else if (sel.equals("3")) {
				// 3번메뉴가 장바구니로
				MenuService.option(Data.getProduct(Data.getProductNo(oderList.get(2).getKey())));
			} else if (sel.equals("4")) {
				// 4번메뉴가 장바구니로
				MenuService.option(Data.getProduct(Data.getProductNo(oderList.get(3).getKey())));
			} else if (sel.equals("5")) {
				// 5번메뉴가 장바구니로
				MenuService.option(Data.getProduct(Data.getProductNo(BeforeOderList.get(0).getKey())));
			} else if (sel.equals("6")) {
				// 6번메뉴가 장바구니로
				MenuService.option(Data.getProduct(Data.getProductNo(BeforeOderList.get(1).getKey())));
			} else if (sel.equals("7")) {
				// 7번메뉴가 장바구니로
				MenuService.option(Data.getProduct(Data.getProductNo(BeforeOderList.get(2).getKey())));
			} else if (sel.equals("8")) {
				// 8번메뉴가 장바구니로
				MenuService.option(Data.getProduct(Data.getProductNo(BeforeOderList.get(3).getKey())));
			} else {
				loop = false;
			}
		}
	}

}
