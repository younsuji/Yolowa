package com.yolowa.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class TicketbuyDAO {

	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int count;
	String sql;
	
	public List<TicketbuyDTO> selectByBigcat(String bigcat){
		List<TicketbuyDTO> ticketbuy_list = new ArrayList<>();
		String sql = "select * from ticketbuy where bigcat = "+bigcat;
		conn = DBUtil.getConnect();
		
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next());{
				TicketbuyDTO ticketbuy_dto = makeTicketbuy_DTO(rs);
				ticketbuy_list.add(ticketbuy_dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ticketbuy_list;
		
		
	}

	private TicketbuyDTO makeTicketbuy_DTO(ResultSet rs2) throws SQLException {
		String bigcat = rs2.getString(1);
		String smallcat = rs2.getString(2);
		int t_min = rs2.getInt(3);
		int t_price = rs2.getInt(4);
		return new TicketbuyDTO(bigcat, smallcat, t_min, t_price);
	}
	
	
	
	
}
