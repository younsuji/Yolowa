package com.yolowa.view;

import java.util.List;
import com.yolowa.model.ReviewDTO;

public class ReviewView {
	public static void print(List<ReviewDTO> review_list) {
		for (ReviewDTO review_dto : review_list) {
			System.out.println(review_dto);
		}
	}

	public static void print(ReviewDTO review_dto) {
		System.out.println(review_dto);
	}

	public static void print(String msg) {
		System.out.println(msg);
	}
}
