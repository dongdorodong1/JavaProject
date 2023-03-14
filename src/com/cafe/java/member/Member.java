package com.cafe.java.member;

/**
 * 회원인 고객의 정보를 담은 클래스입니다. <br>
 * ex) 고객번호 / 아이디 / 비밀번호 / 이름 / 성별 / 생년월일 / 전화번호 / 누적포인트
 */
public class Member {

	// 1■kn19v6xe■dykxixha■유재헌■M■1997-05-11■010-9445-2764■990
	// 고객번호 / 아이디 / 비밀번호 / 이름 / 성별 / 생년월일 / 전화번호 / 누적포인트

	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private String userGen;
	private String userBirth;
	private String userTel;
	private int userPoint;

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

	public String getUserGen() {
		return userGen;
	}

	public void setUserGen(String userGen) {
		this.userGen = userGen;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public int getUserPoint() {
		return userPoint;
	}

	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}

}
