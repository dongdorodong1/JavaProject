package com.cafe.java.product;

/**
 * 메뉴정보를 담은 클래스입니다.
 *
 */
public class Menu {

	// 1■아메리카노■600■14■0■2,000
	// 상품번호, 상품명, 1회제공량, 칼로리, 당류, 가격

	private int productNo;
	private String productName;
	private String oneTimeSup;
	private String kcal;
	private String sugar;
	private int price;

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

	public String getOneTimeSup() {
		return oneTimeSup;
	}

	public void setOneTimeSup(String oneTimeSup) {
		this.oneTimeSup = oneTimeSup;
	}

	public String getKcal() {
		return kcal;
	}

	public void setKcal(String kcal) {
		this.kcal = kcal;
	}

	public String getSugar() {
		return sugar;
	}

	public void setSugar(String sugar) {
		this.sugar = sugar;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override // 혜린님
	public String toString() {

		return String.format("%d", this.getPrice());

	}

}
