package com.yolowa.view;

import java.util.List;
import com.yolowa.model.PostDTO;

public class PostView {
	public static void print(List<PostDTO> plist) {
		for (PostDTO bdto : plist) {
			System.out.println(bdto);
		}
	}

	public static void print(PostDTO pdto) {
		System.out.println(pdto);
	}

	public static void print(String msg) {
		System.out.println(msg);
	}
}
