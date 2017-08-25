package com.yolowa.model;

public class NonbuyDTO {
	private String bigcat;
	private String smallcat;
	private String n_place;
	private String n_time;
	private int n_deposit;

	public NonbuyDTO() {
		super();
	}

	public NonbuyDTO(String bigcat, String smallcat, String n_place, String n_time, int n_deposit) {
		super();
		this.bigcat = bigcat;
		this.smallcat = smallcat;
		this.n_place = n_place;
		this.n_time = n_time;
		this.n_deposit = n_deposit;
	}

	public String getBigcat() {
		return bigcat;
	}

	public void setBigcat(String bigcat) {
		this.bigcat = bigcat;
	}

	public String getSmallcat() {
		return smallcat;
	}

	public void setSmallcat(String smallcat) {
		this.smallcat = smallcat;
	}

	public String getN_place() {
		return n_place;
	}

	public void setN_place(String n_place) {
		this.n_place = n_place;
	}

	public String getN_time() {
		return n_time;
	}

	public void setN_time(String n_time) {
		this.n_time = n_time;
	}

	public int getN_deposit() {
		return n_deposit;
	}

	public void setN_deposit(int n_deposit) {
		this.n_deposit = n_deposit;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NonbuyDTO [bigcat=").append(bigcat).append(", smallcat=").append(smallcat).append(", n_place=")
				.append(n_place).append(", n_time=").append(n_time).append(", n_deposit=").append(n_deposit)
				.append("]");
		return builder.toString();
	}
}