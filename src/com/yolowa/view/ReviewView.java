package com.yolowa.view;

import java.util.List;
import com.yolowa.model.ReviewDTO;

public class ReviewView {
	public static void print(List<ReviewDTO> rlist) {
		for (ReviewDTO bdto : rlist) {
			System.out.println(bdto);
		}
	}

	public static void print(ReviewDTO rdto) {
		System.out.println(rdto);
	}

	public static void print(String msg) {
		System.out.println(msg);
	}
}
