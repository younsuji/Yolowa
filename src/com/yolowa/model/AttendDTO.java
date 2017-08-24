package com.yolowa.model;

public class AttendDTO {
	private int p_num;
	private int c_num;
	private int a_deposit;
	private char a_check;

	public AttendDTO() {
		super();
	}

	public AttendDTO(int p_num, int c_num, int a_deposit, char a_check) {
		super();
		this.p_num = p_num;
		this.c_num = c_num;
		this.a_deposit = a_deposit;
		this.a_check = a_check;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public int getC_num() {
		return c_num;
	}

	public void setC_num(int c_num) {
		this.c_num = c_num;
	}

	public int getA_deposit() {
		return a_deposit;
	}

	public void setA_deposit(int a_deposit) {
		this.a_deposit = a_deposit;
	}

	public char getA_check() {
		return a_check;
	}

	public void setA_check(char a_check) {
		this.a_check = a_check;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AttendDTO [p_num=").append(p_num).append(", c_num=").append(c_num).append(", a_deposit=")
				.append(a_deposit).append(", a_check=").append(a_check).append("]");
		return builder.toString();
	}
}