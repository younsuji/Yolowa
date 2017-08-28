package com.yolowa.controller;

import java.util.Scanner;
import com.yolowa.model.CustomerDAO;
import com.yolowa.model.CustomerDTO;
import com.yolowa.view.CustomerView;

public class CustomerController {

	public static void CustomerMain() {

		CustomerDAO customer_dao = new CustomerDAO();
		CustomerDTO customer_dto = null;
		int result;
		String msg;
		Scanner sc = new Scanner(System.in);

		Cus: while (true) {
			System.out.println("1. 본인정보보기");
			System.out.println("2. 회원정보수정");
			System.out.println("3. 회원탈퇴");
			System.out.println("0. 뒤로가기");
			int s = sc.nextInt();
			switch (s) {
			case 0: {
				break Cus;
			}
			case 1: {
				System.out.println("본인정보보기");
				CustomerView.print(customer_dto);
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
				System.out.println("삭제하시겠습니까? 삭제는 1번, 아니면 0번을 누르세요.");
				int i = sc.nextInt();
				switch (i) {
				case 0:
					System.out.println("취소되었습니다.");
					break;
				case 1:
					customer_dao.deleteCustomer(customer_dto.getC_id(), customer_dto.getC_password());
					System.out.println("삭제되었습니다.");
					break;
				default:
					System.out.println("번호를 확인하세요.");
					break;
				}
			}
			default:
				System.out.println("번호를 확인하세요.");
				break;
			}
		}
	}
}
