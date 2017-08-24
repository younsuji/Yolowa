package com.yolowa.model;

public class TicketbuyDTO {
	private String bigcat;
	private String smallcat;
	private int t_min;
	private int t_price;

	public TicketbuyDTO() {
		super();
	}

	public TicketbuyDTO(String bigcat, String smallcat, int t_min, int t_price) {
		super();
		this.bigcat = bigcat;
		this.smallcat = smallcat;
		this.t_min = t_min;
		this.t_price = t_price;
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

	public int getT_min() {
		return t_min;
	}

	public void setT_min(int t_min) {
		this.t_min = t_min;
	}

	public int getT_price() {
		return t_price;
	}

	public void setT_price(int t_price) {
		this.t_price = t_price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TicketbuyDTO [bigcat=").append(bigcat).append(", smallcat=").append(smallcat).append(", t_min=")
				.append(t_min).append(", t_price=").append(t_price).append("]");
		return builder.toString();
	}
}
