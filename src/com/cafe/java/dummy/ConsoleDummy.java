package com.cafe.java.dummy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * 작업을 위해 사전에 데이터정보를 만드는 클래스입니다.
 * 
 * @see #memberDummy()
 * @see #purchse()
 * @see #nonMember()
 * 
 * @author 강혜린
 * @author 김현준
 * @author 유동환
 * @author 손지연
 * @author 조혜은
 * 
 */
public class ConsoleDummy {

	// 고유번호 ■ID ■PW ■이름 ■성별 ■생년월일 ■전화번호 ■적립 포인트

	public static void main(String[] args) {

		try {

//			memberDummy(); // 회원 정보 Dummy
//			purchase(); // 회원 구매 내역 Dummy
//			nonMember(); // 비회원 구매 내역 Dummy

		} catch (Exception e) {
			System.out.println("memberDummy");
			e.printStackTrace();
		}
	}

	/**
	 * 회원정보를 만드는 메소드입니다.<br>
	 * ex) 고유번호 ■ID ■PW ■이름 ■성별 ■생년월일 ■전화번호 ■적립 포인트
	 * 
	 * @throws IOException
	 * @author 강혜린
	 * @author 김현준
	 * @author 유동환
	 * @author 손지연
	 * @author 조혜은
	 * 
	 */
	private static void memberDummy() throws IOException {

		Random rnd = new Random();

		String[] name1 = { "김", "이", "박", "정", "최", "손", "유" };
		String[] name2 = { "신", "석", "효", "정", "진", "현", "재", "형", "민", "기", "동", "헌", "석", "수", "나", "연" };

		String[] id = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
				"t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

		String[] pw = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
				"t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

		String[] gender = { "M", "F" };

		// 서울시 강남구

		int no = 1; // 학생번호로 사용할 고유번호

		// 파일 기록
		FileWriter writer = new FileWriter(".\\dat\\Member.txt");

		// 고유번호 ■ID ■PW ■이름 ■성별 ■생년월일 ■전화번호 ■적립 포인트

		for (int i = 1; i <= 200; i++) {

			String data = String.format("%d■%s■%s■%s■%s■%s■%s■%s"

					, no

					,
					id[rnd.nextInt(id.length)] + id[rnd.nextInt(id.length)] + id[rnd.nextInt(id.length)]
							+ id[rnd.nextInt(id.length)] + id[rnd.nextInt(id.length)] + id[rnd.nextInt(id.length)]
							+ id[rnd.nextInt(id.length)] + id[rnd.nextInt(id.length)]

					,
					pw[rnd.nextInt(pw.length)] + pw[rnd.nextInt(pw.length)] + pw[rnd.nextInt(pw.length)]
							+ pw[rnd.nextInt(pw.length)] + pw[rnd.nextInt(pw.length)] + pw[rnd.nextInt(pw.length)]
							+ pw[rnd.nextInt(pw.length)] + pw[rnd.nextInt(pw.length)]

					, name1[rnd.nextInt(name1.length)] + name2[rnd.nextInt(name2.length)]
							+ name2[rnd.nextInt(name2.length)]

					, gender[rnd.nextInt(gender.length)]

					, String.format("%d-%02d-%02d", rnd.nextInt(70) + 1950, rnd.nextInt(12) + 1, rnd.nextInt(30) + 1)

					, String.format("010-%d-%d", rnd.nextInt(9000) + 1000, rnd.nextInt(9000) + 1000)

					, String.format("%d", rnd.nextInt(1000) * 10));

			System.out.println(data);
			writer.write(data + "\r\n");
			no++;

		}
		writer.close();

	}

	/**
	 * 고객(회원) 구매내역을 만드는 메소드입니다.<br>
	 * ex) 회원번호■상품번호■구매수량■구매날짜■적립 받은 포인트■옵션정보
	 * 
	 * @throws IOException
	 * @author 강혜린
	 * @author 김현준
	 * @author 유동환
	 * @author 손지연
	 * @author 조혜은
	 * 
	 */
	private static void purchase() throws IOException {

		Random rnd = new Random();

		String data2 = "";
		String op1 = "";
		String op2 = "";

		String[] option1 = { "HOT", "ICE" };
		String[] option2 = { "S", "M", "L" };

		int no = 0;
		int productNo = 0;
		int consumNo = 0;

		// 파일 기록
		FileWriter writer = new FileWriter(".\\dat\\MemberPurchase.txt");

		// 회원번호■상품번호■구매수량■구매날짜■적립 받은 포인트■옵션정보
		for (int i = 1; i <= 2000; i++) {

			int month = rnd.nextInt(10) + 1;

			String data = String.format("%d■%d■%d■%s■%s"

			// 회원번호
					, no = rnd.nextInt(100) + 1

					// 상품번호
					, productNo = rnd.nextInt(45) + 1

					// 상품 구매 개수
					, consumNo = rnd.nextInt(5) + 1

					// 포인트 적립
					, String.format("%d", rnd.nextInt(50) * 10)

					// 날짜 출력
					, String
							.format("2022-%02d-%02d", month,
									(month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8)
											|| (month == 10) || (month == 12) ? rnd.nextInt(31) + 1
													: rnd.nextInt(30) + 1));

			// 커피,티, 카페류 옵션 선택
			if (productNo <= 32) {
				op1 = option1[rnd.nextInt(option1.length)];
				op2 = option2[rnd.nextInt(option2.length)];
			} else {
				op1 = "X";
				op2 = "X";
			}

			System.out.println(data + "■" + op1 + "■" + op2);
			writer.write(data + "■" + op1 + "■" + op2 + "\r\n");

		}
		writer.close();
	}

	/**
	 * 고객(비회원회원) 구매내역을 만드는 메소드입니다.<br>
	 * ex) 상품번호■구매수량■구매날짜■적립 받은 포인트■옵션정보
	 * 
	 * @throws IOException
	 * @author 강혜린
	 * @author 김현준
	 * @author 유동환
	 * @author 손지연
	 * @author 조혜은
	 * 
	 */
	private static void nonMember() throws IOException {

		Random rnd = new Random();

		String data2 = "";
		String op1 = "";
		String op2 = "";

		String[] option1 = { "HOT", "ICE" };
		String[] option2 = { "S", "M", "L" };

		int no = 0;
		int productNo = 0;
		int consumNo = 0;

		// 파일 기록
		FileWriter writer = new FileWriter(".\\dat\\NonMemberPurchase.txt");

		// ■상품번호■구매수량■구매날짜■적립 받은 포인트■옵션정보

		for (int i = 1; i <= 1000; i++) {

			int month = rnd.nextInt(9) + 1;

			String data = String.format("%d■%d■%s"

			// 상품번호
					, productNo = rnd.nextInt(45) + 1

					// 상품 구매 개수
					, consumNo = rnd.nextInt(5) + 1

					, String
							.format("2022-%02d-%02d", month,
									(month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8)
											|| (month == 10) || (month == 12) ? rnd.nextInt(31) + 1
													: rnd.nextInt(30) + 1));

			if (productNo <= 32) {
				op1 = option1[rnd.nextInt(option1.length)];
				op2 = option2[rnd.nextInt(option2.length)];
			} else {
				op1 = "X";
				op2 = "X";
			}

			System.out.println(data + "■" + op1 + "■" + op2);
			writer.write(data + "■" + op1 + "■" + op2 + "\r\n");

		}

		// 커피,티, 카페류 옵션 선택

		writer.close();

	}// NonMember

}
