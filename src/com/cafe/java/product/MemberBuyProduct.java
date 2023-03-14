package com.cafe.java.product;

/**
 * 회원 고객이 구매한 상품의 정보를 담은 클래스입니다.
 *
 */
public class MemberBuyProduct {
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private int userPoint;
	private int productNo;
	private int purchaseNum;
	private int savePoint;
	private String productName;
	private int productPrice;
	private int productNum;
	private String buyTime;
	private String tempOp;
	private String sizeOp;
	private int onePrice;

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserPoint() {
		return userPoint;
	}

	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public String getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}

	public String getTempOp() {
		return tempOp;
	}

	public void setTempOp(String tempOp) {
		this.tempOp = tempOp;
	}

	public String getSizeOp() {
		return sizeOp;
	}

	public void setSizeOp(String sizeOp) {
		this.sizeOp = sizeOp;
	}

	public int getOnePrice() {
		return onePrice;
	}

	public void setOnePrice(int onePrice) {
		this.onePrice = onePrice;
	}

}
