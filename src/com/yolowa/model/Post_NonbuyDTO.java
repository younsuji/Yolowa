package com.yolowa.model;

public class Post_NonbuyDTO {

	PostDTO post_dto;
	NonbuyDTO nonbuy_dto;
	
	public Post_NonbuyDTO(PostDTO post_dto, NonbuyDTO nonbuy_dto) {
		super();
		this.post_dto = post_dto;
		this.nonbuy_dto = nonbuy_dto;
	}
	public Post_NonbuyDTO() {
		super();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Post_NonbuyDTO [post_dto=").append(post_dto).append(", nonbuy_dto=").append(nonbuy_dto)
				.append("]");
		return builder.toString();
	}
	
	
	public PostDTO getPost_dto() {
		return post_dto;
	}
	public void setPost_dto(PostDTO post_dto) {
		this.post_dto = post_dto;
	}
	public NonbuyDTO getNonbuy_dto() {
		return nonbuy_dto;
	}
	public void setNonbuy_dto(NonbuyDTO nonbuy_dto) {
		this.nonbuy_dto = nonbuy_dto;
	}
	
	
	
}
