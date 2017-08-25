package com.yolowa.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class NonbuyDAO {
	
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int count;
	String sql;
	
	public List<NonbuyDTO> selectByBigcat(String bigcat){
		List<NonbuyDTO> nonbuy_list = new ArrayList<>();
		String sql = "select * from nonbuy where bigcat = "+bigcat;
		conn = DBUtil.getConnect();
		
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				NonbuyDTO nonbuy_dto = makeNonbuy_DTO(rs);
				nonbuy_list.add(nonbuy_dto);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nonbuy_list;
	}

	private NonbuyDTO makeNonbuy_DTO(ResultSet rs2) throws SQLException {
		String bigcat = rs2.getString(1);
		String smallcat =rs2.getString(2);
		String n_place = rs2.getString(3);
		Date n_time = rs2.getDate(4);
		int n_deposit = rs2.getInt(5);
		return new NonbuyDTO(bigcat, smallcat, n_place, n_time, n_deposit);
	}
}
