package com.cafe.java.product;

import java.util.Calendar;

public class NonBuyProduct { // TODO 장바구니에 넣을 상품클래스
	private int productNo;
	private String productName;
	private int productPrice;
	private int productNum;
	private String buyTime;
	private String tempOp;
	private String sizeOp;
	private int onePrice;

	public int getOnePrice() {
		return onePrice;
	}

	public void setOnePrice(int onePrice) {
		this.onePrice = onePrice;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
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

}
