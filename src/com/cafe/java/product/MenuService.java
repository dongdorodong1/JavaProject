package com.cafe.java.product;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import com.cafe.java.data.Data;
import com.cafe.java.member.NonMemPayment;
import com.cafe.java.member.NonMemberPurchase;

/**
 * 비회원 고객에게 보여지는 메뉴목록 클래스입니다.
 * 
 * @author 유동환
 * @see #coffee()
 * @see #adeJuice()
 * @see #smoothie()
 * @see #tea()
 * @see #cookie()
 * @see #cake()
 * @see #sandwich()
 */
public class MenuService { // TODO 수정

	public static List<NonBuyProduct> nbpList = new ArrayList<>(); // 비회원 멤버가 산 상품을 모아둔 장바구니

	/**
	 * 메뉴를 카테고리별로 확인할 수 있습니다.
	 */
	public static void seeMenu() {

		Scanner scan = new Scanner(System.in);

		String sel = "";
		boolean loop = true;

		while (loop && Data.flag) {

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("╔════════════════ °• ♔ •° ════════════════╗\r\n");
			System.out.println("\t\t [ 메뉴 ]");
			System.out.println("");
			System.out.println("\t\t▶ 음료");
			System.out.println("\t\t1. 커피");
			System.out.println("\t\t2. 스무디");
			System.out.println("\t\t3. 에이드 & 주스");
			System.out.println("\t\t4. 티");
			System.out.println();
			System.out.println("\t\t▶ 디저트");
			System.out.println("\t\t5. 케이크");
			System.out.println("\t\t6. 쿠키");
			System.out.println("\t\t7. 샌드위치");
			System.out.println();
			System.out.println("\t   0. 이전화면으로 돌아가기");
			System.out.println();
			System.out.println("╚════════════════ °• ♔ •° ═════════════════╝");
			System.out.print("▶ 입력 : ");
			sel = scan.nextLine();

			// 결제까지 마치고 나와야만 loop를 탈출할 수 있는 방법?
			if (sel.equals("1")) {
				coffee();

			} else if (sel.equals("2")) {
				smoothie();
			} else if (sel.equals("3")) {
				adeJuice();
			} else if (sel.equals("4")) {
				tea();
			} else if (sel.equals("5")) {
				cake();
			} else if (sel.equals("6")) {
				cookie();
			} else if (sel.equals("7")) {
				sandwich();
			} else {
				loop = false;
				Data.flag = false;
			}
		}
	}

	/**
	 * 샌드위치 메뉴를 볼수있습니다.
	 */
	private static void sandwich() {

		Scanner scan = new Scanner(System.in);
		String sel = "";

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("╔════════════════ °• ♔ •° ════════════════╗\r\n");
		System.out.println("\t\t [ 샌드위치 ]");
		System.out.println();
		System.out.println("        1. 햄 앤 치즈 샌드위치\t5,900원");
		System.out.println();
		System.out.println("        2. 바질 토마토 파니니\t\t6,000원");
		System.out.println();
		System.out.println("        3. 에그 샌드위치\t\t4,000원");
		System.out.println();
		System.out.println("        4. 베이컨 치즈 스페셜\t\t5,000원");
		System.out.println();
		System.out.println("        5. 잠봉뵈르 샌드위치\t\t6,500원");
		System.out.println();
		System.out.println("0. 이전화면으로 돌아가기");
		System.out.println();
		System.out.println("╚════════════════ °• ♔ •° ═════════════════╝");
		System.out.print("▶ 입력 : ");
		sel = scan.nextLine();

		if (sel.equals("1")) {
			option(Data.menuList.get(42));
		} else if (sel.equals("2")) {
			option(Data.menuList.get(43));
		} else if (sel.equals("3")) {
			option(Data.menuList.get(44));
		} else if (sel.equals("4")) {
			option(Data.menuList.get(45));
		} else if (sel.equals("5")) {
			option(Data.menuList.get(46));
		} else {

		}

	}

	/**
	 * 쿠키 메뉴를 볼수있습니다.
	 */
	private static void cookie() {

		Scanner scan = new Scanner(System.in);
		String sel = "";

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("╔════════════════ °• ♔ •° ════════════════╗\r\n");
		System.out.println("\t\t  [쿠키]");
		System.out.println();
		System.out.println();
		System.out.println("\t1. 마카롱\t\t  1,500원");
		System.out.println();
		System.out.println("\t2. 바질 치즈 쿠키\t  2,500원");
		System.out.println();
		System.out.println("\t3. 레몬 마들렌\t  3,000원");
		System.out.println();
		System.out.println("\t4. 리얼 초코칩 쿠키\t  2,500원");
		System.out.println();
		System.out.println("\t5. 휘낭시에 쿠키\t  3,400원");
		System.out.println();
		System.out.println("\t 0. 이전화면으로 돌아가기");
		System.out.println();
		System.out.println("╚════════════════ °• ♔ •° ═════════════════╝");
		System.out.print("▶ 입력 : ");
		sel = scan.nextLine();

		if (sel.equals("1")) {
			option(Data.menuList.get(37));
		} else if (sel.equals("2")) {
			option(Data.menuList.get(38));
		} else if (sel.equals("3")) {
			option(Data.menuList.get(39));
		} else if (sel.equals("4")) {
			option(Data.menuList.get(40));
		} else if (sel.equals("5")) {
			option(Data.menuList.get(41));
		} else {

		}
	}

	/**
	 * 케이크 메뉴를 볼수있습니다.
	 */
	private static void cake() {

		Scanner scan = new Scanner(System.in);
		String sel = "";

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("╔════════════════ °• ♔ •° ════════════════╗\r\n");
		System.out.println("\t\t  [케이크]");
		System.out.println();
		System.out.println();
		System.out.println("\t1. 티라미수\t\t5,500원");
		System.out.println();
		System.out.println("\t2. 레드벨벳 케이크\t\t6,500원");
		System.out.println();
		System.out.println("\t3. 치즈 케이크\t\t4,500원");
		System.out.println();
		System.out.println("\t4. 딸기 생크림 케이크\t\t5,000원");
		System.out.println();
		System.out.println("\t5. 자색 고구마 케이크\t\t5,500원");
		System.out.println();
		System.out.println("\t0. 이전화면으로 돌아가기");
		System.out.println();
		System.out.println("╚════════════════ °• ♔ •° ═════════════════╝");
		System.out.print("▶ 입력 : ");
		sel = scan.nextLine();

		if (sel.equals("1")) {
			option(Data.menuList.get(32));
		} else if (sel.equals("2")) {
			option(Data.menuList.get(33));
		} else if (sel.equals("3")) {
			option(Data.menuList.get(34));
		} else if (sel.equals("4")) {
			option(Data.menuList.get(35));
		} else if (sel.equals("5")) {
			option(Data.menuList.get(36));
		} else {

		}

	}

	/**
	 * 티 메뉴를 볼수있습니다.
	 */
	private static void tea() {

		Scanner scan = new Scanner(System.in);
		String sel = "";

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("╔════════════════ °• ♔ •° ════════════════╗\r\n");
		System.out.println("\t\t   [티]");

		System.out.println();
		System.out.println("\t  1. 캐모마일\t\t2,500원");
		System.out.println();
		System.out.println("\t  2. 사과 유자차\t\t3,500원");
		System.out.println();
		System.out.println("\t  3. 레몬차\t\t3,000원");
		System.out.println();
		System.out.println("\t  4. 유자차\t\t3,000원");
		System.out.println();
		System.out.println("\t  5. 녹차\t\t\t2,500원");
		System.out.println();
		System.out.println("\t  6. 보이차\t\t2,500원");
		System.out.println();
		System.out.println("\t  0. 이전화면으로 돌아가기");
		System.out.println();
		System.out.println("╚════════════════ °• ♔ •° ═════════════════╝");
		System.out.print("▶ 입력 : ");
		sel = scan.nextLine();

		if (sel.equals("1")) {
			option(Data.menuList.get(26));
		} else if (sel.equals("2")) {
			option(Data.menuList.get(27));
		} else if (sel.equals("3")) {
			option(Data.menuList.get(28));
		} else if (sel.equals("4")) {
			option(Data.menuList.get(29));
		} else if (sel.equals("5")) {
			option(Data.menuList.get(30));
		} else if (sel.equals("6")) {
			option(Data.menuList.get(31));
		} else {

		}

	}

	/**
	 * 에이드와 주스 메뉴를 볼수있습니다.
	 */
	private static void adeJuice() {

		Scanner scan = new Scanner(System.in);
		String sel = "";

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("╔════════════════ °• ♔ •° ════════════════╗\r\n");
		System.out.println("\t\t  [에이드 & 주스]");
		System.out.println();
		System.out.println("\t1. 레몬 에이드\t\t3,500원");
		System.out.println();
		System.out.println("\t2. 자몽 에이드\t\t3,500원");
		System.out.println();
		System.out.println("\t3. 청포도 에이드\t\t3,500원");
		System.out.println();
		System.out.println("\t4. 토마토 바질 에이드\t4,900원");
		System.out.println();
		System.out.println("\t5. 패션 후르츠 에이드\t5,000원");
		System.out.println();
		System.out.println("\t6. 라임 에이드\t\t3,900원");
		System.out.println();
		System.out.println("\t7. 블루레몬 에이드\t\t3,800원");
		System.out.println();
		System.out.println("\t8. 딸기 주스\t\t3,800원");
		System.out.println();
		System.out.println("\t9. 초코 바나나\t\t3,800원");
		System.out.println();
		System.out.println("\t10. 오렌지 주스\t\t3,500원");
		System.out.println();
		System.out.println("\t0. 이전화면으로 돌아가기");
		System.out.println();
		System.out.println("╚════════════════ °• ♔ •° ═════════════════╝");
		System.out.print("▶ 입력 : ");
		sel = scan.nextLine();

		if (sel.equals("1")) {
			option(Data.menuList.get(16));
		} else if (sel.equals("2")) {
			option(Data.menuList.get(17));
		} else if (sel.equals("3")) {
			option(Data.menuList.get(18));
		} else if (sel.equals("4")) {
			option(Data.menuList.get(19));
		} else if (sel.equals("5")) {
			option(Data.menuList.get(20));
		} else if (sel.equals("6")) {
			option(Data.menuList.get(21));
		} else if (sel.equals("7")) {
			option(Data.menuList.get(22));
		} else if (sel.equals("8")) {
			option(Data.menuList.get(23));
		} else if (sel.equals("9")) {
			option(Data.menuList.get(24));
		} else if (sel.equals("10")) {
			option(Data.menuList.get(25));
		} else {
		}

	}

	/**
	 * 스무디 메뉴를 볼수있습니다.
	 */
	private static void smoothie() {

		Scanner scan = new Scanner(System.in);
		String sel = "";

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("╔════════════════ °• ♔ •° ════════════════╗\r\n");
		System.out.println("\t\t  [ 스무디 ]");
		System.out.println();
		System.out.println("\t1. 녹차프라페\t\t3,900원");
		System.out.println();
		System.out.println("\t2. 쿠키프라페\t\t3,900원");
		System.out.println();
		System.out.println("\t3. 플레인 요거트 스무디\t3,900원");
		System.out.println();
		System.out.println("\t4. 딸기 요거트 스무\t\t3,900원");
		System.out.println();
		System.out.println("\t5. 망고 요거트 스무디\t3,900원");
		System.out.println();
		System.out.println("\t6. 죠리퐁 스무디\t\t3,900원");
		System.out.println();
		System.out.println("\t7. 초코 스무디\t\t3,800원");
		System.out.println();
		System.out.println("\t8. JAVA 초코칩 프라페\t3,900원");
		System.out.println();
		System.out.println("\t0. 이전화면으로 돌아가기");
		System.out.println();
		System.out.println("╚════════════════ °• ♔ •° ═════════════════╝");
		System.out.print("▶ 입력 : ");
		sel = scan.nextLine();

		if (sel.equals("1")) {
			option(Data.menuList.get(8));
		} else if (sel.equals("2")) {
			option(Data.menuList.get(9));
		} else if (sel.equals("3")) {
			option(Data.menuList.get(10));
		} else if (sel.equals("4")) {
			option(Data.menuList.get(11));
		} else if (sel.equals("5")) {
			option(Data.menuList.get(12));
		} else if (sel.equals("6")) {
			option(Data.menuList.get(13));
		} else if (sel.equals("7")) {
			option(Data.menuList.get(14));
		} else if (sel.equals("8")) {
			option(Data.menuList.get(15));
		}
	}

	/**
	 * 커피 메뉴를 볼수있습니다.
	 */
	private static void coffee() {

		Scanner scan = new Scanner(System.in);
		String sel = "";

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("╔════════════════ °• ♔ •° ════════════════╗\r\n");
		System.out.println("\t\t  [ 커피 ]");
		System.out.println();
		System.out.println("\t1. 아메리카노\t\t2,000원");
		System.out.println();
		System.out.println("\t2. 카페라떼\t\t2,500원");
		System.out.println();
		System.out.println("\t3. 바닐라 라떼\t\t3,200원");
		System.out.println();
		System.out.println("\t4. 돌체 콜드브루\t\t6,000원");
		System.out.println();
		System.out.println("\t5. 카푸치노\t\t3,000원");
		System.out.println();
		System.out.println("\t6. 아인슈페너\t\t4,000원");
		System.out.println();
		System.out.println("\t7. 카라멜마끼아또\t\t3,500원");
		System.out.println();
		System.out.println("\t8. 카페모카\t\t3,000원");
		System.out.println();
		System.out.println("\t0. 이전화면으로 돌아가기");
		System.out.println();
		System.out.println("╚════════════════ °• ♔ •° ═════════════════╝");
		System.out.print("▶ 입력 : ");
		sel = scan.nextLine();

		if (sel.equals("1")) {
			option(Data.menuList.get(0));
		} else if (sel.equals("2")) {
			option(Data.menuList.get(1));
		} else if (sel.equals("3")) {
			option(Data.menuList.get(2));
		} else if (sel.equals("4")) {
			option(Data.menuList.get(3));
		} else if (sel.equals("5")) {
			option(Data.menuList.get(4));
		} else if (sel.equals("6")) {
			option(Data.menuList.get(5));
		} else if (sel.equals("7")) {
			option(Data.menuList.get(6));
		} else if (sel.equals("8")) {
			option(Data.menuList.get(7));
		} else {

		}
	}

	/**
	 * 선택한 메뉴에 대해 옵션을 선택할 수 있습니다. <br>
	 * HOT / ICE <br?SIZE
	 * 
	 * @author 유동환
	 */
	public static void option(Menu m) { // TODO 옵션선택

		Scanner scan = new Scanner(System.in);
		Calendar buyTime = Calendar.getInstance();

		String sel = "";
		int amount = 0;
		String opTemp = "";
		String opSize = "";

		NonBuyProduct nbp = new NonBuyProduct(); // 비회원 멤버가 산 상품

		nbp.setOnePrice(m.getPrice());

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.printf("               [%s]\n", m.getProductName());
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		// 상품번호, 구매수량, 구매일자, 온도, 사이즈
		if (m.getProductNo() < 31) {

			if (m.getProductNo() < 9 || m.getProductNo() > 25) {// ICE/HOT이 필요한 경우
				System.out.println("★ 옵션(ICE/HOT) ★");
				System.out.println("1. HOT\t\t(0원)");
				System.out.println("2. ICE\t\t(0원)");
				System.out.println("――――――――――――――――――――――――――――――――――――");
				System.out.println("★ 옵션(SIZE) ★");
				System.out.println("1. S\t\t(0원)");
				System.out.println("2. M\t\t(+500원)");
				System.out.println("3. L\t\t(+1,000원)");
				System.out.println("―――――――――――――――――――――――――――――――――――");
				System.out.println("0. 메뉴 화면으로 돌아가기");
				System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");

				System.out.print("▶ ICE / HOT 선택 : ");
				opTemp = scan.nextLine();

				System.out.print("▶ 사이즈 선택 :");
				opSize = scan.nextLine();

				if (opTemp.equals("1")) {
					nbp.setTempOp("HOT");
				} else {
					nbp.setTempOp("ICE");
				}

				if (opSize.equals("1")) {
					nbp.setSizeOp("S");

				} else if (opSize.equals("2")) {
					nbp.setSizeOp("M");
					nbp.setProductPrice(m.getPrice() + 500); // 기존 가격에 + 500
					nbp.setOnePrice(m.getPrice() + 500);
				} else if (opSize.equals("3")) {
					nbp.setSizeOp("L");
					nbp.setProductPrice(m.getPrice() + 1000); // 기존 가격에 + 1000
					nbp.setOnePrice(m.getPrice() + 1000);
				} // ICE/HOT이 필요한 경우

			} else { // 에이드 & 주스류일때
				System.out.println("★ 옵션(SIZE) ★");
				System.out.println();
				System.out.println("1. S\t\t(0원)");
				System.out.println("2. M\t\t(+500원)");
				System.out.println("3. L\t\t(+1,000원)");
				System.out.println("0. 메뉴 화면으로 돌아가기");
				System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
				System.out.println();
				System.out.println();
				System.out.print("▶ 사이즈 선택 :");
				opSize = scan.nextLine();

				if (opSize.equals("1")) {

					nbp.setSizeOp("S");

				} else if (opSize.equals("2")) {

					nbp.setSizeOp("M");
					nbp.setProductPrice(m.getPrice() + 500); // 기존 가격에 + 500
					nbp.setOnePrice(m.getPrice() + 500);

				} else if (opSize.equals("3")) {

					nbp.setSizeOp("L");
					nbp.setProductPrice(m.getPrice() + 1000); // 기존 가격에 + 1000
					nbp.setOnePrice(m.getPrice() + 1000);
				}
			} // else 에이드 & 주스류일때
		}

		System.out.print("▶ 수량:");
		amount = scan.nextInt();
		scan.nextLine();
		System.out.println();
		System.out.print("장바구니에 담으시겠습니까?(y/n): ");
		sel = scan.nextLine();

		nbp.setProductNum(amount);

		nbp.setProductPrice(amount * nbp.getOnePrice()); // 가격 * 상품하나의 가격
		nbp.setProductNo(m.getProductNo());
		nbp.setProductName(m.getProductName());
		nbp.setBuyTime(String.format("%tF", buyTime));

		if (sel.equals("y")) {
			System.out.println();
			nbpList.add(nbp);
			System.out.print("더 담으시겠습니까?(y/n): ");
			sel = scan.nextLine();

			if (sel.equals("n")) {

				ShopBasket sb = new ShopBasket();
				sb.shop(nbpList);

			} else {

			}
		} else {

		}

	}
}
