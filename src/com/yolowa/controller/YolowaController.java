package com.yolowa.controller;

import java.util.Scanner;
import com.yolowa.model.CustomerDAO;
import com.yolowa.model.CustomerDTO;
import com.yolowa.view.CustomerView;

public class YolowaController {

	public static void main(String[] args) {
		CustomerDAO customer_dao = new CustomerDAO();
		CustomerDTO customer_dto = null;
		int result;
		String msg;
		Scanner sc = new Scanner(System.in);
		Yolowa: while (true) {
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. id 찾기");
			System.out.println("4. password 찾기");
			System.out.println("0. 끝");
			int i = sc.nextInt();
			switch (i) {
			case 0: {
				break Yolowa;
			}
			case 1: {
				System.out.println("id >> ");
				String c_id = sc.nextLine();
				System.out.println("password >> ");
				String c_password = sc.nextLine();
				customer_dto = customer_dao.selectByC_idpass(c_id, c_password);
				if (customer_dto == null) {
					System.out.println("저장된 정보가 없습니다.");
				}
				break;
			}
			case 2: {
				System.out.println("회원가입");
				System.out.print("id >> ");
				String c_id = sc.nextLine();
				System.out.print("password >> ");
				String c_password = sc.nextLine();
				System.out.print("이름 >> ");
				String c_name = sc.nextLine();
				System.out.print("전화번호 >> ");
				String c_phone = sc.nextLine();
				int c_point = 100000;
				customer_dto = new CustomerDTO(c_id, c_password, c_name, c_phone, c_point);
				result = customer_dao.insertCustomer(customer_dto);
				if (result > 0) {
					msg = "가입완료";
				} else {
					msg = "가입실패";
				}
				customer_dto.setC_num(customer_dao.selectC_num(customer_dto));
				CustomerView.print(msg);
				CustomerView.print(customer_dto);
				break;
			}
			case 3: {
				System.out.println("id 찾기");
				System.out.print("이름 >> ");
				String c_name = sc.nextLine();
				System.out.print("전화번호 >> ");
				String c_phone = sc.nextLine();
				customer_dto = customer_dao.selectByC_namephone(c_name, c_phone);
				if (customer_dto == null) {
					System.out.println("저장된 정보가 없습니다.");
				}
				System.out.println("id >> " + customer_dto.getC_id());
				break;
			}
			case 4: {
				System.out.println("password 찾기");
				System.out.print("id >> ");
				String c_id = sc.nextLine();
				System.out.print("이름 >> ");
				String c_name = sc.nextLine();
				System.out.print("전화번호 >> ");
				String c_phone = sc.nextLine();
				customer_dto = customer_dao.selectByC_idnamephone(c_id, c_name, c_phone);
				if (customer_dto == null) {
					System.out.println("저장된 정보가 없습니다.");
				}
				System.out.println("password >> " + customer_dto.getC_password());
				break;
			}
			}
		}
	}
}
