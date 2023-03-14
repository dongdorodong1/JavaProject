package com.cafe.java.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.cafe.java.manager.Manager;
import com.cafe.java.member.Member;
import com.cafe.java.member.MemberLogin;
import com.cafe.java.member.MemberPurchase;
import com.cafe.java.member.NonMemberPurchase;
import com.cafe.java.product.Menu;
import com.cafe.java.product.StockList;

/**
 * 프로그램 시작시 미리 만들어둔 더미데이터를 기반으로 <br>
 * 작업시 필요한 데이터들을 txt파일로부터 컬렉션으로 옮겨놓는 load() 메소드와 <br>
 * 프로그램 종료시 새롭게 입력 / 수정된 컬렉션으로부터 다시 txt파일로 옮기는 save() 메소드가 있습니다. <br>
 * 추가로 작업시 공통으로 필요한 메소드들의 집합입니다.
 * 
 * 
 * @
 * 
 *   @see #load()
 * @see #save()
 * @see #pause()
 * @see #getProduct(int)
 * @see #getProductNo(String)
 * @see #getUserNo(String)
 * @see #deleteUser(int)
 * @see #createManagerNo()
 * @see #createMemberNo()
 * @see #getProductNo2(String)
 * @see #getProductNonon(String)
 * @see #getProductNononMon(String)
 * @see #getProductNononMon(String)
 * @see #getProductPrice(String)
 * @see #memberNonmemberCheck()
 * @see #deleteMenu(int)
 * 
 * @author 강혜린
 * @author 김현준
 * @author 유동환
 * @author 손지연
 * @author 조혜은
 */
public class Data {
	public static boolean flag;
	private final static String MANAGER;
	private final static String MEMBER;
	private final static String MENULIST;
	private final static String STOCKLIST;
	private final static String MEMBERPURCHASE;
	private final static String NONMEMBERPURCHASE;
	private static int waitNo = 1;

	public static ArrayList<Manager> manager; // Student.txt -> 학생정보를 어레이리스트에 다 넣음
	public static ArrayList<Member> member;
	public static ArrayList<Menu> menuList;
	public static ArrayList<StockList> stockList;
	public static ArrayList<MemberPurchase> memberPurchase;
	public static ArrayList<NonMemberPurchase> nonMemberPurchase;
	static {
		flag = true;
		MANAGER = ".\\dat\\Manager.txt";
		MEMBER = ".\\dat\\Member.txt";
		MENULIST = ".\\dat\\Menu.txt";
		STOCKLIST = ".\\dat\\StockList.txt";
		MEMBERPURCHASE = ".\\dat\\MemberPurchase.txt";
		NONMEMBERPURCHASE = ".\\dat\\NonMemberPurchase.txt";

		manager = new ArrayList<Manager>();
		member = new ArrayList<Member>();
		menuList = new ArrayList<Menu>();
		stockList = new ArrayList<StockList>();
		memberPurchase = new ArrayList<MemberPurchase>();
		nonMemberPurchase = new ArrayList<NonMemberPurchase>();
	}

	/**
	 * 텍스트 파일 > 컬렉션 <br/>
	 * <br/>
	 * 기존 생성했던 더미데이터를 컬렉션에 옮겨주는 메소드입니다.
	 * 
	 */
	public static void load() {

		// 텍스트 파일 > 컬렉션

		try {
			// 매니저 데이터
			BufferedReader reader = new BufferedReader(new FileReader(MANAGER));

			String line = null;

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split("■");

				Manager mg = new Manager();

				mg.setManagerNo(Integer.parseInt(temp[0]));
				mg.setManagerId(temp[1]);
				mg.setManagerPw(temp[2]);
				mg.setManagerName(temp[3]);
				mg.setManagerTel(temp[4]);

				manager.add(mg);

			}

			reader.close();

			// 회원정보 데이터
			reader = new BufferedReader(new FileReader(MEMBER));

			line = null;

			while ((line = reader.readLine()) != null) {

				// 1■kn19v6xe■dykxixha■유재헌■M■1997-05-11■010-9445-2764■990
				// 고객번호 / 아이디 / 비밀번호 / 이름 / 성별 / 생년월일 / 전화번호 / 누적포인트
				String[] temp = line.split("■");

				Member mb = new Member();
				mb.setUserNo(Integer.parseInt(temp[0]));
				mb.setUserId(temp[1]);
				mb.setUserPw(temp[2]);
				mb.setUserName(temp[3]);
				mb.setUserGen(temp[4]);
				mb.setUserBirth(temp[5]);
				mb.setUserTel(temp[6]);
				mb.setUserPoint(Integer.parseInt(temp[7]));

				member.add(mb);

			}

			reader.close();

			reader = new BufferedReader(new FileReader(MENULIST));

			line = null;

			while ((line = reader.readLine()) != null) {

				// 1■아메리카노■600■14■0■2,000
				// 상품번호, 상품명, 1회제공량, 칼로리, 당류, 가격

				String[] temp = line.split("■");

				Menu menu = new Menu();

				menu.setProductNo(Integer.parseInt(temp[0]));
				menu.setProductName(temp[1]);
				menu.setOneTimeSup(temp[2]);
				menu.setKcal(temp[3]);
				menu.setSugar(temp[4]);
				menu.setPrice(Integer.parseInt(temp[5]));

				menuList.add(menu);

			}

			reader.close();

			// 재고량 데이터
			reader = new BufferedReader(new FileReader(STOCKLIST));

			line = null;

			while ((line = reader.readLine()) != null) {

				// 1■아메리카노■120■2,000■2022-09-27
				// 상품번호, 상품명, 재고량, 가격, 입고일

				String[] temp = line.split("■");

				StockList stock = new StockList();

				stock.setProductNo(Integer.parseInt(temp[0]));
				stock.setProductName(temp[1]);
				stock.setStockNum(Integer.parseInt(temp[2]));
				stock.setPrice(Integer.parseInt(temp[3]));
				stock.setRecDate(temp[4]);

				stockList.add(stock);

			}

			reader.close();

			reader = new BufferedReader(new FileReader(MEMBERPURCHASE));

			line = null;

			while ((line = reader.readLine()) != null) {

				// 199■32■2■350■2022-03-21■ICE■M
				// 회원번호, 상품번호, 구매수량, 적립 포인트, 구매날짜, 온도, 사이즈

				String[] temp = line.split("■");

				MemberPurchase mbp = new MemberPurchase();

				mbp.setUserNo(Integer.parseInt(temp[0]));
				mbp.setProductNo(Integer.parseInt(temp[1]));
				mbp.setPurchaseNum(Integer.parseInt(temp[2]));
				mbp.setSavePoint(Integer.parseInt(temp[3]));
				mbp.setPurchaseDate(temp[4]);
				mbp.setTemOption(temp[5]);
				mbp.setSizeOption(temp[6]);

				memberPurchase.add(mbp);

			}

			reader.close();

			// 비회원 구매 정보
			reader = new BufferedReader(new FileReader(NONMEMBERPURCHASE));

			line = null;

			while ((line = reader.readLine()) != null) {

				// 7■1■2022-06-06■ICE■M
				// 상품번호, 구매수량, 구매일자, 온도, 사이즈

				String[] temp = line.split("■");

				NonMemberPurchase nmbp = new NonMemberPurchase();

				nmbp.setProductNo(Integer.parseInt(temp[0]));
				nmbp.setPurchaseNum(Integer.parseInt(temp[1]));
				nmbp.setPurchaseDate(temp[2]);
				nmbp.setTemOption(temp[3]);
				nmbp.setSizeOption(temp[4]);

				nonMemberPurchase.add(nmbp);

			}

			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}// load

	/**
	 * 컬렉션 > 텍스트 파일 <br/>
	 * <br/>
	 * 프로그램이 종료될때 실행되며 실행중 발생한 컬렉션의 수정사항을 텍스트파일로 옮기는 메소드입니다.
	 */
	public static void save() {

		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(MANAGER));

			// 1001■abc1234■1234■홍길동■010-1234-5678
			for (Manager mg : manager) {

				String data = String.format("%d■%s■%s■%s■%s", mg.getManagerNo(), mg.getManagerId(), mg.getManagerPw(),
						mg.getManagerName(), mg.getManagerTel());

				writer.write(data + "\r\n");

			}

			writer.close();

			// 1■6adutw9r■k73zeyag■최현효■F■1968-05-11■010-2932-9889■120
			writer = new BufferedWriter(new FileWriter(MEMBER));

			for (Member mb : member) {

				String data = String.format("%d■%s■%s■%s■%s■%s■%s■%d", mb.getUserNo(), mb.getUserId(), mb.getUserPw(),
						mb.getUserName(), mb.getUserGen(), mb.getUserBirth(), mb.getUserTel(), mb.getUserPoint());

				writer.write(data + "\r\n");

			}

			writer.close();

			// 1■아메리카노■600■14■0■2000
			writer = new BufferedWriter(new FileWriter(MENULIST));

			for (Menu menu : menuList) {

				String data = String.format("%d■%s■%s■%s■%s■%d", menu.getProductNo(), menu.getProductName(),
						menu.getOneTimeSup(), menu.getKcal(), menu.getSugar(), menu.getPrice());

				writer.write(data + "\r\n");

			}

			writer.close();

			// 1■아메리카노■120■2000■2022-09-27
			writer = new BufferedWriter(new FileWriter(STOCKLIST));

			for (StockList stock : stockList) {

				String data = String.format("%d■%s■%d■%d■%s", stock.getProductNo(), stock.getProductName(),
						stock.getStockNum(), stock.getPrice(), stock.getRecDate());

				writer.write(data + "\r\n");

			}

			writer.close();

			// 74■44■3■270■2022-07-17■X■X
			writer = new BufferedWriter(new FileWriter(MEMBERPURCHASE));

			for (MemberPurchase mbp : memberPurchase) {

				String data = String.format("%d■%d■%d■%d■%s■%s■%s", mbp.getUserNo(), mbp.getProductNo(),
						mbp.getPurchaseNum(), mbp.getSavePoint(), mbp.getPurchaseDate(), mbp.getTemOption(),
						mbp.getSizeOption());

				writer.write(data + "\r\n");

			}

			writer.close();

			// 18■5■2022-07-14■ICE■M
			writer = new BufferedWriter(new FileWriter(NONMEMBERPURCHASE));

			for (NonMemberPurchase nmbp : nonMemberPurchase) {

				String data = String.format("%d■%d■%s■%s■%s", nmbp.getProductNo(), nmbp.getPurchaseNum(),
						nmbp.getPurchaseDate(), nmbp.getTemOption(), nmbp.getSizeOption());

				writer.write(data + "\r\n");

			}

			writer.close();

		} catch (Exception e) {
			System.out.println("Data.save");
			e.printStackTrace();
		} // sava

	}

	/**
	 * 엔터를 눌러 다음화면으로 넘어가는 하는 메소드
	 */
	public static void pause() {

		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("다음화면으로 이동하려면 엔터를 입력하세요.");
		scan.nextLine();
		System.out.println();

	}

	/**
	 * 상품번호를 인자로 받아 해당번호의 Menu객체를 반환합니다.
	 * 
	 * @author 유동환
	 * @param productNo <br/>
	 *                  : 메뉴데이터에 있는 상품번호
	 * @return Menu
	 */
	public static Menu getProduct(int productNo) {

		for (Menu m : menuList) {

			if (m.getProductNo() == productNo) {

				return m;
			}

		}
		return null;
	}

	/**
	 * 상품명을 인자로 받아 해당상품의 번호를 반환합니다.
	 * 
	 * @author 유동환
	 * @param productNo   <br/>
	 *                    : 메뉴데이터에 있는 상품번호
	 * @param productName <br/>
	 *                    : 메뉴데이터에 있는 상품이름
	 * @return Menu
	 * 
	 */
	public static int getProductNo(String productName) {

		for (Menu m : menuList) {

			if (m.getProductName() == productName) {

				return m.getProductNo();
			}
		}
		return 0;
	}

	/**
	 * 고객 정보 조회에서 특정 고객 찾아오기
	 * 
	 * @author 조혜은
	 * @see #getUserNo(String)
	 */
	public static Member getUserNo(String userNo) {

		for (Member ml : member) {

			if (ml.getUserName().equals(userNo)) {

				return ml;
			}

		}
		return null;
	}

	/**
	 * 고객 정보 삭제하기
	 * 
	 * @author 조혜은
	 * @see #deleteUser(int)
	 */
	public static boolean deleteUser(int userNo) {

		for (Member s : member) {

			if (s.getUserNo() == userNo) {

				return member.remove(s);
			}

		}

		return false;
	}

	/**
	 * 관리자 추가하였을 때 관리자 번호 자동증가
	 * 
	 * @author 조혜은
	 * @see #createMgNo()
	 */
	public static int createMgNo() { // 혜은님

		int max = 0;

		for (Manager m : manager) {

			if (m.getManagerNo() > max) {
				max = m.getManagerNo();
			}

		}

		return max + 1;

	}

	/**
	 * 마지막 회원번호에 1을 더하여 새로운 회원번호를 반환하는 메소드입니다.
	 * 
	 * @author 김현준
	 * @param getUserNo <br/>
	 *                  : 저장되어있는 회원번호
	 * @return MemberShip
	 */
	public static int createMemberNo() { // 현준님

		// studen.txt > 가장 번호가 큰 학생의 번호

		int max = 0;

		for (Member mb : member) {

			if (mb.getUserNo() > max) {

				max = mb.getUserNo();
			}
		}
		return max + 1;

	}

	/**
	 *
	 * 마지막 메뉴번호에 1을 더하여 새로운 메뉴번호를 반환합니다.
	 * 
	 */
	public static int createMenuNo() { //
		int max = 0;

		for (Menu m : menuList) {
			if (m.getProductNo() > max) {
				max = m.getProductNo();
			}
		}
		return max + 1;
	}

	/**
	 * 회원정보를 탐색하여 회원, 비회원을 구분하는 메소드입니다.
	 * 
	 * @author 김현준
	 * @param getUserName             <br/>
	 *                                : 회원정보에 있는 회원 이름
	 * @param MemberLogin.paymentName <br/>
	 *                                : 현재 로그인 회원 이름
	 * @return MemberShip
	 */
	public static boolean memberNonmemberCheck() {

		for (Member m : member) {

			if (m.getUserName().equals(MemberLogin.paymetName)) {
				return true; // 회원결제로 이동
			}
		}

		return false;

	}

	/**
	 * getProductNo2()메소드입니다. <br>
	 * 날짜(YYYY-MM-DD)를 인자로 받아 고객(회원)구매데이터에서 해당 날짜와 일치하는 상품의 리스트를 반환합니다. <br>
	 * 
	 * @author 강혜린
	 * 
	 * @Param PurchaseDate : 고객(회원) 고객구매데이터에 있는 구매날짜 <br>
	 * @Param getproductno2 : 구매날짜(YYYY-MM-DD)와 일치하는 상품의 데이터를 넣은 리스트 <br>
	 * 
	 * @return getproductno2
	 */
	public static ArrayList<MemberPurchase> getProductNo2(String purchaseDate) { // 혜린님 TODO구매 날짜를 넣으면 상품의 고유 번호를 가져오는
																					// 메소드(일별-회원)

		ArrayList<MemberPurchase> getproductno2 = new ArrayList<MemberPurchase>();

		for (MemberPurchase m : memberPurchase) {

			if (m.getPurchaseDate().equals(purchaseDate)) {

				getproductno2.add(m);
			}
		}
		return getproductno2;
	}

	/**
	 * getProductNonon()메소드입니다. <br>
	 * 날짜(YYYY-MM-DD)를 인자로 받아 고객(비회원)구매데이터에서 해당 날짜와 일치하는 상품의 리스트를 반환 합니다. <br>
	 * 
	 * @author 강혜린
	 * 
	 * @Param PurchaseDate : 고객(비회원) 고객구매데이터에 있는 구매날짜 <br>
	 * @Param getproductno2 : 구매날짜(YYYY-MM-DD)와 일치하는 상품의 데이터를 넣은 리스트 <br>
	 * 
	 * @return getproductno2
	 */
	public static ArrayList<NonMemberPurchase> getProductNonon(String purchaseDate) { // 혜린님 TODO구매 날짜를 넣으면 상품의 고유 번호를
																						// 가져오는 메소드(일별-비회원)

		ArrayList<NonMemberPurchase> getproductno2 = new ArrayList<NonMemberPurchase>();

		for (NonMemberPurchase m : nonMemberPurchase) {

			if (m.getPurchaseDate().equals(purchaseDate)) {

				getproductno2.add(m);
			}
		}
		return getproductno2;
	}

	/**
	 * getProductNoMon()메소드입니다. <br>
	 * 날짜(YYYY-MM)를 인자로 받아 고객(회원)구매데이터에서 해당 날짜와 일치하는 상품의 리스트를 반환합니다. <br>
	 * 
	 * @author 강혜린
	 * 
	 * @Param PurchaseDate : 고객(회원) 고객구매데이터에 있는 구매날짜 <br>
	 * @Param getproductno2 : 구매날짜(YYYY-MM)와 일치하는 상품의 데이터를 넣은 리스트 <br>
	 * 
	 * @return getproductno2
	 */
	public static ArrayList<MemberPurchase> getProductNoMon(String purchaseDate) { // 혜린님 TODO구매 날짜를 넣으면 상품의 고유 번호를 가져오는
																					// 메소드(월별-회원)

		ArrayList<MemberPurchase> getproductno2 = new ArrayList<MemberPurchase>();

		for (MemberPurchase m : memberPurchase) {

			if (m.getPurchaseDate().substring(0, 7).equals(purchaseDate)) {

				getproductno2.add(m);
			}
		}
		return getproductno2;
	}

	/**
	 * getProductNononMon()메소드입니다. <br>
	 * 날짜(YYYY-MM)를 인자로 받아 고객(비회원)구매데이터에서 해당 날짜와 일치하는 상품의 리스트를 반환 합니다. <br>
	 * 
	 * @author 강혜린
	 * 
	 * @Param PurchaseDate : 고객(비회원) 고객구매데이터에 있는 구매날짜 <br>
	 * @Param getproductno2 : 구매날짜(YYYY-MM)와 일치하는 상품의 데이터를 넣은 리스트 <br>
	 * 
	 * @return getproductno2
	 */
	public static ArrayList<NonMemberPurchase> getProductNononMon(String purchaseDate) { // 혜린님 TODO구매 날짜를 넣으면 상품의 고유
																							// 번호를 가져오는 메소드(월별-비회원)
		ArrayList<NonMemberPurchase> getproductno2 = new ArrayList<NonMemberPurchase>();

		for (NonMemberPurchase m : nonMemberPurchase) {

			if (m.getPurchaseDate().substring(0, 7).equals(purchaseDate)) {

				getproductno2.add(m);
			}
		}
		return getproductno2;
	}

	/**
	 * getProductPrice()메소드입니다. <br>
	 * 상품번호를 인자로 받아 메뉴 데이터에서 해당 상품번호와 일치하는 메뉴 리스트를 반환 합니다. <br>
	 * 
	 * @author 강혜린
	 * 
	 * @Param ProductNo : 메뉴 데이터에 있는 상품번호 <br>
	 * @Param getProductPrice : 상품번호와 일치하는 상품의 데이터 넣은 리스트 <br>
	 * 
	 * @return getProductPrice
	 */
	public static ArrayList<Menu> getProductPrice(String memberPurchase2) { // 혜린님 TODO상품 번호를 넣으면 넣으면 상품의 가격를 가져오는 메소드

		ArrayList<Menu> getProductPrice = new ArrayList<Menu>();

		for (Menu m : menuList) {

			int a = Integer.parseInt(memberPurchase2);

			if (m.getProductNo() == a) {

				getProductPrice.add(m);
			}
		}
		return getProductPrice;
	}

	/**
	 * 대기번호를 부여하는 메소드입니다.<br>
	 * 결제가 완료되면 +!이 되고 프로그램이 종료되면 초기화됩니다.
	 * 
	 * @author 유동환
	 * @return int
	 */
	public static int getWaitNo() {
		return waitNo;
	}

	public static void setWaitNo(int waitNo) {
		Data.waitNo = waitNo;
	}

	/**
	 * 메뉴를 삭제 할 수 있는 메소드
	 * 
	 * @author 손지연 menu.getProductName
	 */

	public static boolean deleteMenu(int productNo) {

		for (Menu m : menuList) {
			if (m.getProductNo() == productNo) {
				return menuList.remove(m);
			}
		}

		return false;
	}

}
