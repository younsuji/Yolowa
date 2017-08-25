package com.yolowa.controller;

import java.util.List;
import java.util.Scanner;

import com.yolowa.model.NonbuyDAO;
import com.yolowa.model.NonbuyDTO;
import com.yolowa.model.TicketbuyDAO;
import com.yolowa.model.TicketbuyDTO;

public class ManageController {

	public static void NonbuyMain() {

		System.out.println("1.nonbuy 전체보기");
		System.out.println("2.nonbuy 추가");
		System.out.println("3.nonbuy 업데이트");
		System.out.println("4.nonbuy 삭제");
		System.out.println("5.ticketbuy 전체보기");
		System.out.println("6.ticketbuy 추가");
		System.out.println("7.ticketbuy 업데이트");
		System.out.println("8.ticketbuy 삭제");

		NonbuyDAO nonbuy_dao = new NonbuyDAO();
		List<NonbuyDTO> nonbuy_list = null;
		NonbuyDTO nonbuy_dto = null;
		int result = 0;

		TicketbuyDAO ticketbuy_dao = new TicketbuyDAO();
		List<TicketbuyDTO> ticketbuy_list = null;
		TicketbuyDTO ticketbuy_dto = null;

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("작업선택");
			int select = sc.nextInt();

			switch (select) {
			case 1: { // nonbuy 전체보기
				nonbuy_list = nonbuy_dao.selectAllnonbuy();
				break;
			}
			case 2: { // nonbuy 추가
				System.out.println("bigcat 입력");
				String bigcat = sc.next();
				System.out.println("smallcat 입력");
				String smallcat = sc.next();
				System.out.println("장소 입력");
				String n_place = sc.next();
				System.out.println("시간 입력");
				String n_time = sc.next();
				System.out.println("보증금 입력");
				int n_deposit = sc.nextInt();

				nonbuy_dto = new NonbuyDTO(bigcat, smallcat, n_place, n_time, n_deposit);

				result = nonbuy_dao.addnonbuy(nonbuy_dto);
				if (result > 0)
					System.out.println("입력완료");
				else
					System.out.println("입력실패");
				break;
			}
			case 3: { // nonbuy 업데이트
				System.out.println("업데이트할 bigcat 검색 ");
				String bigcat = sc.next();
				System.out.println("업데이트할 smallcat 검색 ");
				String smallcat = sc.next();

				nonbuy_dto = nonbuy_dao.selectByCat(bigcat, smallcat);
				System.out.println("n_place입력");
				String n_place = sc.next();
				System.out.println("n_time입력");
				String n_time = sc.next();
				System.out.println("n_deposit입력");
				int n_deposit = sc.nextInt();

				nonbuy_dto = new NonbuyDTO(bigcat, smallcat, n_place, n_time, n_deposit);

				result = nonbuy_dao.updateNonbuy(nonbuy_dto);
				if (result > 0)
					System.out.println("업데이트 완료");
				else
					System.out.println("업데이트 실패");
				break;
			}
			case 4: { // nonbuy 삭제
				System.out.println("삭제할 bigcat 검색 ");
				String bigcat = sc.next();
				System.out.println("삭제할 smallcat 검색 ");
				String smallcat = sc.next();

				nonbuy_dto = nonbuy_dao.selectByCat(bigcat, smallcat);
				result = nonbuy_dao.deleteNonbuy(nonbuy_dto);
				if (result > 0)
					System.out.println("삭제 완료");
				else
					System.out.println("삭제 실패");
				break;
			}
			case 5: { // ticketbuy 전체보기
				ticketbuy_list = ticketbuy_dao.selectAllticketbuy();
				break;
			}
			case 6: { // ticketbuy 추가
				System.out.println("bigcat 입력");
				String bigcat = sc.next();
				System.out.println("smallcat 입력");
				String smallcat = sc.next();
				System.out.println("t_min 입력");
				int t_min = sc.nextInt();
				System.out.println("t_price 입력");
				int t_price = sc.nextInt();

				ticketbuy_dto = new TicketbuyDTO(bigcat, smallcat, t_min, t_price);

				result = ticketbuy_dao.addticketbuy(ticketbuy_dto);

				if (result > 0)
					System.out.println("입력완료");
				else
					System.out.println("입력실패");
				break;
			}

			case 7: { // ticketbuy 업데이트

			}
			case 8: { // ticketbuy 삭제

			}
			}// switch 끝

		} // while 끝

	}// NonbuyMain 끝
}
