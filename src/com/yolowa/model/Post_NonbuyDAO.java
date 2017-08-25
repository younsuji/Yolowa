package com.yolowa.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;

public class Post_NonbuyDAO {
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int count;
	
	public Post_NonbuyDTO selectPost_Nonbuy(int p_num){
		Post_NonbuyDTO post_nonbuy_dto = null;
		String sql = "select * from post join nonbuy using (bigcat, smallcat) where p_num = " + p_num;
		conn = DBUtil.getConnect();
		
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				post_nonbuy_dto = makePostNonbuyDTO(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.dbClose(conn, st, rs);
		}
		return post_nonbuy_dto;
	}

	public Post_NonbuyDTO makePostNonbuyDTO(ResultSet rs2) {
		PostDTO post_dto = new PostDTO(rs2.getInt(1), rs2.getString(2), rs2.getDate(3), rs2.getInt(4), rs2.getString(5), rs2.getString(6), rs2.getString(7));
		NonbuyDTO nonbuy_dto = new NonbuyDTO(rs2.getString(1), rs2.getString(2), rs2.getString(3), rs2.getString(4), rs2.getInt(5));
		return new Post_NonbuyDTO(post_dto, nonbuy_dto);
	}
}
