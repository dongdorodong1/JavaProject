package com.cafe.java.member;

/**
 * 회원고객의 구매내역 정보를 담은 클래스입니다.
 */
public class MemberPurchase {

	// 199■32■2■350■2022-03-21■ICE■M
	// 회원번호, 상품번호, 구매수량, 적립 포인트, 구매날짜, 온도, 사이즈

	private int userNo;
	private int productNo;
	private int purchaseNum;
	private int savePoint;
	private String purchaseDate;
	private String temOption;
	private String sizeOption;

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

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

	public int getSavePoint() {
		return savePoint;
	}

	public void setSavePoint(int savePoint) {
		this.savePoint = savePoint;
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

	@Override
	public String toString() { // 혜린님

		return String.format("%d", this.productNo);
	}

}
