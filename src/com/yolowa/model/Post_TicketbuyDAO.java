package com.yolowa.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;

public class Post_TicketbuyDAO {

	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int count;
	
	public Post_TicketbuyDTO selectPost_Ticketbuy(int p_num){
		Post_TicketbuyDTO post_ticketbuy_dto = null;
		
		String sql = "select * from post join ticketbuy using (bigcat, smallcat) where p_num = " + p_num;
		conn = DBUtil.getConnect();
		
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				post_ticketbuy_dto = makePostTicketbuyDTO(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.dbClose(conn, st, rs);
		}
		
		return post_ticketbuy_dto;
	}

	public Post_TicketbuyDTO makePostTicketbuyDTO(ResultSet rs2) throws SQLException {
		PostDTO post_dto = new PostDTO(rs2.getInt(1), rs2.getString(2), rs2.getDate(3), rs2.getInt(4), rs2.getString(5), rs2.getString(6), rs2.getString(7));
		TicketbuyDTO ticketbuy_dto = new TicketbuyDTO(rs2.getString(1), rs2.getString(2), rs2.getInt(3), rs2.getInt(4));
		
		return new Post_TicketbuyDTO(post_dto, ticketbuy_dto);
	}
}
