package com.yolowa.model;


public class Post_TicketbuyDTO {

	PostDTO post_dto;
	TicketbuyDTO ticketbuy_dto;
	
	public Post_TicketbuyDTO(PostDTO post_dto, TicketbuyDTO ticketbuy_dto) {
		super();
		this.post_dto = post_dto;
		this.ticketbuy_dto = ticketbuy_dto;
	}
	
	public Post_TicketbuyDTO() {
		super();
	}
	
	public PostDTO getPost_dto() {
		return post_dto;
	}
	public void setPost_dto(PostDTO post_dto) {
		this.post_dto = post_dto;
	}
	public TicketbuyDTO getTicketbuy_dto() {
		return ticketbuy_dto;
	}
	public void setTicketbuy_dto(TicketbuyDTO ticketbuy_dto) {
		this.ticketbuy_dto = ticketbuy_dto;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Post_TicketbuyDTO [post_dto=").append(post_dto).append(", ticketbuy_dto=").append(ticketbuy_dto)
				.append("]");
		return builder.toString();
	}
	
	
	
}
