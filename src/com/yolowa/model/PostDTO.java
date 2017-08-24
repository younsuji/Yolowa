package com.yolowa.model;

import java.sql.Date;

public class PostDTO {
	private int p_num;
	private String p_title;
	private Date p_date;
	private int p_max;
	private String p_comment;
	private String bigcat;
	private String smallcat;

	public PostDTO() {
		super();
	}

	public PostDTO(int p_num, String p_title, Date p_date, int p_max, String p_comment, String bigcat,
			String smallcat) {
		super();
		this.p_num = p_num;
		this.p_title = p_title;
		this.p_date = p_date;
		this.p_max = p_max;
		this.p_comment = p_comment;
		this.bigcat = bigcat;
		this.smallcat = smallcat;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public String getP_title() {
		return p_title;
	}

	public void setP_title(String p_title) {
		this.p_title = p_title;
	}

	public Date getP_date() {
		return p_date;
	}

	public void setP_date(Date p_date) {
		this.p_date = p_date;
	}

	public int getP_max() {
		return p_max;
	}

	public void setP_max(int p_max) {
		this.p_max = p_max;
	}

	public String getP_comment() {
		return p_comment;
	}

	public void setP_comment(String p_comment) {
		this.p_comment = p_comment;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PostDTO [p_num=").append(p_num).append(", p_title=").append(p_title).append(", p_date=")
				.append(p_date).append(", p_max=").append(p_max).append(", p_comment=").append(p_comment)
				.append(", bigcat=").append(bigcat).append(", smallcat=").append(smallcat).append("]");
		return builder.toString();
	}
}