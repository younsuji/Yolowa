package com.yolowa.controller;

import java.util.List;
import java.util.Scanner;
import com.yolowa.model.CustomerDAO;
import com.yolowa.model.CustomerDTO;
import com.yolowa.view.CustomerView;

public class CustomerController {

	public static void CustomerMain() {

		CustomerDAO customer_dao = new CustomerDAO();
		CustomerDTO customer_dto = null;
		List<CustomerDTO> customer_list = null;
		int result;
		String msg;
		Scanner sc = new Scanner(System.in);

		Cus: while (true) {
			System.out.println("1. 회원정보수정");
			System.out.println("2. 회원탈퇴");
			System.out.println("0. 뒤로가기");
			int s = sc.nextInt();
			switch (s) {
			case 0: {
				break Cus;
			}
			case 1: {
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
			case 2: {
				System.out.println("회원정보수정");
				
				System.out.print("수정할 password >> ");
				String c_password = sc.nextLine();
				if ("".equals(c_password) || c_password == null) {
					System.out.println(c_password);
					c_password = customer_dto.getC_password();
				}
				System.out.print("수정할 phone >> ");
				String c_phone = sc.nextLine();
				if ("".equals(c_phone) || c_phone == null) {
					System.out.println(c_phone);
					c_phone = customer_dto.getC_phone();
				}
				customer_dto = new CustomerDTO(customer_dto.getC_num(), customer_dto.getC_id(), c_password,
						customer_dto.getC_name(), c_phone, customer_dto.getC_point());
				result = customer_dao.updateCustomer(customer_dto);
				if (result > 0) {
					msg = "수정성공";
				} else {
					msg = "수정실패";
				}
				CustomerView.print(msg);
				CustomerView.print(customer_dto);
				break;
			}
			case 3: {
				System.out.println("회원탈퇴");
				CustomerView.print(customer_dto);
				System.out.print("탈퇴하시겠습니까? (탈퇴는 1, 취소는 0) >> ");
				int i = sc.nextInt();
				switch(i){
				case 0:
					
				}

				break;
			}
			}

		}
	}
}
