package com.cafe.java.member;

/**
 * 비회원 고객이 구매한 구매내역 정보입니다.<br>
 * ex) 상품번호, 구매수량, 구매일자, 온도, 사이즈
 *
 */
public class NonMemberPurchase { // 비회원 구매목록

	// 7■1■2022-06-06■ICE■M
	// 상품번호, 구매수량, 구매일자, 온도, 사이즈

	private int productNo;
	private int purchaseNum;
	private String purchaseDate;
	private String temOption;
	private String sizeOption;

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getPurchaseNum() {
		return purchaseNum;
	}

	public void setPurchaseNum(int purchaseNum) {
		this.purchaseNum = purchaseNum;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getTemOption() {
		return temOption;
	}

	public void setTemOption(String temOption) {
		this.temOption = temOption;
	}

	public String getSizeOption() {
		return sizeOption;
	}

	public void setSizeOption(String sizeOption) {

		this.sizeOption = sizeOption;
	}

}
