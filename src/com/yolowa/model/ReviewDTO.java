package com.yolowa.model;

public class ReviewDTO {
	private int p_num;
	private int c_num;
	private int r_good;
	private String r_review;

	public ReviewDTO() {
		super();
	}

	public ReviewDTO(int p_num, int c_num, int r_good, String r_review) {
		super();
		this.p_num = p_num;
		this.c_num = c_num;
		this.r_good = r_good;
		this.r_review = r_review;
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

	public int getR_good() {
		return r_good;
	}

	public void setR_good(int r_good) {
		this.r_good = r_good;
	}

	public String getR_review() {
		return r_review;
	}

	public void setR_review(String r_review) {
		this.r_review = r_review;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReviewDTO [p_num=").append(p_num).append(", c_num=").append(c_num).append(", r_good=")
				.append(r_good).append(", r_review=").append(r_review).append("]");
		return builder.toString();
	}
}
