package com.yolowa.model;

public class CustomerDTO {
	private int c_num;
	private String c_id;
	private String c_password;
	private String c_name;
	private String c_phone;
	private int c_point;

	public CustomerDTO() {
		super();
	}

	public CustomerDTO(int c_num, String c_id, String c_password, String c_name, String c_phone, int c_point) {
		super();
		this.c_num = c_num;
		this.c_id = c_id;
		this.c_password = c_password;
		this.c_name = c_name;
		this.c_phone = c_phone;
		this.c_point = c_point;
	}

	public CustomerDTO(String c_id, String c_password, String c_name, String c_phone, int c_point) {
		super();
		this.c_id = c_id;
		this.c_password = c_password;
		this.c_name = c_name;
		this.c_phone = c_phone;
		this.c_point = c_point;
	}

	public int getC_num() {
		return c_num;
	}

	public void setC_num(int c_num) {
		this.c_num = c_num;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getC_password() {
		return c_password;
	}

	public void setC_password(String c_password) {
		this.c_password = c_password;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_phone() {
		return c_phone;
	}

	public void setC_phone(String c_phone) {
		this.c_phone = c_phone;
	}

	public int getC_point() {
		return c_point;
	}

	public void setC_point(int c_point) {
		this.c_point = c_point;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerDTO [c_num=").append(c_num).append(", c_id=").append(c_id).append(", c_password=")
				.append(c_password).append(", c_name=").append(c_name).append(", c_phone=").append(c_phone)
				.append(", c_point=").append(c_point).append("]");
		return builder.toString();
	}
}
