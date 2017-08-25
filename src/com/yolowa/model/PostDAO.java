package com.yolowa.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class PostDAO {

	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int count;

	// 포스트 제목만 보기
	public List<String> selectPostTitle() {
		List<String> string_list = new ArrayList<>();
		String sql = "select p_title from post";
		conn = DBUtil.getConnect();

		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				String s = rs.getString(1);
				string_list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return string_list;
	}// 포스트 제목만 보기

	// 포스트 전체보기
	public List<PostDTO> selectAllPost() {
		List<PostDTO> post_list = new ArrayList<>();
		String sql = "select * from post order by p_date ";
		conn = DBUtil.getConnect();

		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				PostDTO post_dto = makePostDTO(rs);
				post_list.add(post_dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}

		return post_list;
	}// 포스트 전체보기

	
	// postDTO 만들기
	public PostDTO makePostDTO(ResultSet rs2) throws SQLException {
		int p_num = rs2.getInt(1);
		String p_title = rs2.getString(2);
		Date p_date = rs2.getDate(3);
		int p_max = rs2.getInt(4);
		String p_comment = rs2.getString(5);
		String bigcat = rs2.getString(6);
		String smallcat = rs2.getString(7);

		return new PostDTO(p_num, p_title, p_date, p_max, p_comment, bigcat, smallcat);
	}

}
