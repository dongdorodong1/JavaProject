package com.cafe.java.manager;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.cafe.java.data.Data;
import com.cafe.java.product.Menu;

/**
 * 관리자의 메뉴관리 클래스 입니다. <br>
 * : 메뉴를 조회, 추가, 삭제 할 수 있습니다.
 * 
 * @author 손지연
 * @see #managerMenuManage
 */
public class ManagerMenuManage {

	public static ArrayList<Menu> menuList;
	private static final boolean result = false;
	private static final String ProductNo = "";
	private static final String ProductName = "";
	private static final String OneTimeSup = "";
	private static final String Kcal = "";
	private static final String Sugar = "";
	private static final String Price = "";

	public void menuManage() {
		boolean loop = true;
		System.out.println();

		Scanner scan = new Scanner(System.in);

		while (loop) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("               [메뉴 관리]");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("1. 메뉴 조회");
			System.out.println();
			System.out.println("2. 메뉴 추가");
			System.out.println();
			System.out.println("3. 메뉴 삭제");
			System.out.println();
			System.out.println("0. 이전 메뉴로 돌아가기");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.print("▶ 입력: ");

			String se4 = scan.nextLine();

			if (se4.equals("1")) {

				// 조회
				menuInquiry();

			} else if (se4.equals("2")) {
				// 메뉴 추가
				menuAdd();

			} else if (se4.equals("3")) {

				// 메뉴 삭제
				menuDelete();

			} else {
				loop = false;
			}

		}
	}

	/**
	 * 메뉴를 삭제 할 수 있는 메소드입니다. 상품번호를 입력받아 삭제가 가능합니다. 삭제는 1번, 취소,돌아가기는 2번을 입력해 실행합니다.
	 * 
	 * @author 손지연
	 * @see #menuDelete
	 */
	public static void menuDelete() {

		System.out.println();

		Scanner scan = new Scanner(System.in);

		System.out.println("            [메뉴 삭제]");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println();

		// 1■아메리카노■600■14■0■2,000
		// 상품번호, 상품명, 1회제공량, 칼로리, 당류, 가격
		System.out.print("삭제하고자 하는 상품 번호: ");
		int productNo = scan.nextInt();

		// 1번 입력 시 삭제
		System.out.println("1 삭제 ");

		// 2번 입력 시 취소, 뒤로가기
		System.out.println("2 취소");

		// 1, 2번 중 해당 번호 선택
		System.out.print("선택: ");
		int sel = scan.nextInt();

		if (sel == 1) {
			Data.deleteMenu(productNo);

		} else if (sel == 2) {

		}

		Data.pause();

	}

	/**
	 * 메뉴를 추가 할 수 있는 메소드입니다. 상품번호, 상품명, 제공량, 칼로리, 당류, 가격을 입력하여 수정할 수 있습니다.
	 * 
	 * @author 손지연
	 * @see #menuAdd
	 */
	private void menuAdd() {

		Scanner scan1 = new Scanner(System.in);

		System.out.println();

		// 1■아메리카노■600■14■0■2,000
		// 상품번호, 상품명, 1회제공량, 칼로리, 당류, 가격

		System.out.println("             [메뉴 추가]");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("추가하고자 하는 메뉴 정보를 입력하세요.");
		System.out.println();
		System.out.println("[상품명, 제공량, 칼로리, 당류, 가격]");
		System.out.println();
		int productNo = Data.createMenuNo();

		System.out.print("1. 상품명: ");
		String productName = scan1.nextLine();

		System.out.print("2. 제공량: ");
		String oneTimeSup = scan1.nextLine();

		System.out.print("3. 칼로리: ");
		String kcal = scan1.nextLine();

		System.out.print("4. 당류: ");
		String sugar = scan1.nextLine();

		System.out.print("5. 가격: ");
		int price = scan1.nextInt();

		Menu menu = new Menu();

		menu.setProductNo(productNo);
		menu.setProductName(productName);
		menu.setOneTimeSup(oneTimeSup);
		menu.setKcal(kcal);
		menu.setSugar(sugar);
		menu.setPrice(price);

		Data.menuList.add(menu);

		System.out.println("상품 정보가 추가되었습니다.");
		System.out.println(menu.getProductName());

		Data.pause();

	}

	/**
	 * 메뉴를 조회 할 수 있는 메소드입니다.
	 * 
	 * @author 손지연
	 * @see #menuInquiry
	 */
	private void menuInquiry() {

		System.out.println();
		Scanner scan = new Scanner(System.in);

		// 1■아메리카노■600■14■0■2,000
		// 상품번호, 상품명, 1회제공량, 칼로리, 당류, 가격

		System.out.println("                                       [메뉴 조회]");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("[상품번호]      [상품명]            [제공량]        [칼로리]   [당류]              [가격]");
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");

		for (Menu mu : Data.menuList) {

			System.out.printf("%5d\t%10s\t\t%4s\t\t%4s\t%4s\t\t%8d\n", mu.getProductNo(), mu.getProductName(),
					mu.getOneTimeSup(), mu.getKcal(), mu.getSugar(), mu.getPrice());

		}
		System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
		System.out.println("이전 메뉴로 돌아가기(0번)");
		scan.nextLine();
		return;
	}

}
