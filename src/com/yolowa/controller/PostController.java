package com.yolowa.controller;

import java.util.Scanner;

import com.yolowa.model.PostDAO;
import com.yolowa.model.Post_NonbuyDAO;
import com.yolowa.model.Post_TicketbuyDAO;

public class PostController {

	public static void PostMain() {

		PostDAO post_dao = new PostDAO();
		Post_NonbuyDAO post_nonbuy_dao = new Post_NonbuyDAO();
		Post_TicketbuyDAO post_ticketbuy_dao = new Post_TicketbuyDAO();
		int p_num = 0; 
		Scanner sc = new Scanner(System.in);

		Post_While: while (true) {
			System.out.println("전체 포스트 제목만 보기 "); //로그인전 방 리스트 보기
			System.out.println("전체 포스트 보기"); // 방 리스트 보기 
			System.out.println("특정 포스트 보기-1.nonbuy"); // 방 클릭하면 보일 내용
			System.out.println("특정 포스트 보기-2.ticketbuy"); //방 클릭하면 보일 내용
			System.out.println("포스트 작성하기");
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
				// 키워드 서치해서 p_num 가져오기 
				post_nonbuy_dao.selectPost_Nonbuy(p_num);
				break;
			}
			case 4: {
				//키워드 서치해서 p_num 가져오기
				post_ticketbuy_dao.selectPost_Ticketbuy(p_num);
				break;
			}
			case 5: {
				System.out.println("bigcat 입력");
				String bigcat = sc.next();
				System.out.println("smallcat 입력");
				String smallcat = sc.next();
				// nonbuy 나 ticketbuy 에서 찾아서 post 에 대분류 소분류 넣기.
				
				
				
				break;
			}default:
				break;
			}

		}

	}
}
