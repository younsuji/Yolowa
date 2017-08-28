package com.yolowa.view;

import java.util.List;
import com.yolowa.model.PostDTO;

public class PostView {
	public static void print(List<PostDTO> post_list) {
		for (PostDTO post_dto : post_list) {
			System.out.println(post_dto);
		}
	}

	public static void print(PostDTO post_dto) {
		System.out.println(post_dto);
	}

	public static void print(String msg) {
		System.out.println(msg);
	}
}
