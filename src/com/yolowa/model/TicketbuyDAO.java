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

	// 대분류로 DTO찾아서 list return
	public List<TicketbuyDTO> selectByBigcat(String bigcat) {
		List<TicketbuyDTO> ticketbuy_list = new ArrayList<>();
		String sql = "select * from ticketbuy where bigcat = " + bigcat;
		conn = DBUtil.getConnect();

		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next())
				;
			{
				TicketbuyDTO ticketbuy_dto = makeTicketbuy_DTO(rs);
				ticketbuy_list.add(ticketbuy_dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
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

	// 전체보기
	public List<TicketbuyDTO> selectAllticketbuy() {
		List<TicketbuyDTO> ticketbuy_list = new ArrayList<>();
		String sql = "select * from ticketbuy";
		conn = DBUtil.getConnect();

		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				TicketbuyDTO ticketbuy_dto = makeTicketbuy_DTO(rs);
				ticketbuy_list.add(ticketbuy_dto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return ticketbuy_list;
	}
	//전체보기 끝

	//추가
	public int addticketbuy(TicketbuyDTO ticketbuy_dto) {
		String sql = "insert into ticketbuy values (?,?,?,?)";
		conn = DBUtil.getConnect();

		try {
			st = conn.prepareStatement(sql);

			st.setString(1, ticketbuy_dto.getBigcat());
			st.setString(2, ticketbuy_dto.getSmallcat());
			st.setInt(3, ticketbuy_dto.getT_min());
			st.setInt(4, ticketbuy_dto.getT_price());

			count = st.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return count;
	}
	//추가 끝
}
