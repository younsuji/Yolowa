package com.yolowa.controller;

import java.util.Scanner;

import com.yolowa.model.PostDAO;
import com.yolowa.model.Post_NonbuyDAO;
import com.yolowa.model.Post_TicketbuyDAO;

public class PostController {

	public static void PostMain() {

		PostDAO post_dao = new PostDAO();
		Post_NonbuyDAO post_nonbuy_dao = new Post_NonbuyDAO();
		Post_TicketbuyDAO post_ticket_dao = new Post_TicketbuyDAO();
		
		Scanner sc = new Scanner(System.in);

		Post_While: while (true) {
			System.out.println("전체 제목만 보기- ");
			System.out.println("전체 포스트 보기");
			System.out.println("특정 포스트 보기-1.nonbuy");
			System.out.println("특정 포스트 보기-2.ticketbuy");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("");

			int select = sc.nextInt();

			switch (select) {
			case 1: {
				post_dao.selectPostTitle();
				break;
			}
			case 2: {
				post_dao.selectAllPost();
				break;
			}
			case 3: {
				post_nonbuy_dao.
				break;
			}
			case 4: {
				break;
			}
			case 5: {
				break;
			}default:
				break;
			}

		}

	}
}
