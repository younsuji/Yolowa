package com.yolowa.model;

import java.sql.Connection;
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

	// 대분류로 DTO찾아서 list return
	public List<NonbuyDTO> selectByBigcat(String bigcat) {
		List<NonbuyDTO> nonbuy_list = new ArrayList<>();
		String sql = "select * from nonbuy where bigcat = " + bigcat;
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				NonbuyDTO nonbuy_dto = makeNonbuy_DTO(rs);
				nonbuy_list.add(nonbuy_dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return nonbuy_list;
	}

	// 전체보기
	public List<NonbuyDTO> selectAllnonbuy() {
		List<NonbuyDTO> nonbuy_list = new ArrayList<>();
		String sql = "select * from nonbuy ";
		conn = DBUtil.getConnect();

		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				NonbuyDTO nonbuy_dto = makeNonbuy_DTO(rs);
				nonbuy_list.add(nonbuy_dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return nonbuy_list;
	}
	// 전체보기 끝

	// 카테고리로 검색(update,delete)
	public NonbuyDTO selectByCat(String bigcat, String smallcat) {
		NonbuyDTO nonbuy_dto = null;
		String sql = "select * from nonbuy where bigcat = ? and smallcat = ?";
		conn = DBUtil.getConnect();

		try {
			st = conn.prepareStatement(sql);
			st.setString(1, bigcat);
			st.setString(2, smallcat);
			rs = st.executeQuery();

			while (rs.next()) {
				nonbuy_dto = makeNonbuy_DTO(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return nonbuy_dto;
	}
	// 카테고리보기 끝

	// nonbuy 추가
	public int addnonbuy(NonbuyDTO nonbuy_dto) {
		String sql = "insert into nonbuy values (?, ?, ?, ?, ?)";
		conn = DBUtil.getConnect();

		try {
			st = conn.prepareStatement(sql);
			st.setString(1, nonbuy_dto.getBigcat());
			st.setString(2, nonbuy_dto.getSmallcat());
			st.setString(3, nonbuy_dto.getN_place());
			st.setString(4, nonbuy_dto.getN_time());
			st.setInt(5, nonbuy_dto.getN_deposit());

			count = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return count;
	}
	// nonbuy 추가 끝

	// nonbuy 업데이트
	public int updateNonbuy(NonbuyDTO nonbuy_dto) {
		String sql = "update nonbuy set " + " n_place = ?,n_time =?, n_deposit =?"
				+ " where bigcat =? and smallcat = ?";
		conn = DBUtil.getConnect();

		try {
			st = conn.prepareStatement(sql);
			st.setString(4, nonbuy_dto.getBigcat());
			st.setString(5, nonbuy_dto.getSmallcat());
			st.setString(1, nonbuy_dto.getN_place());
			st.setString(2, nonbuy_dto.getN_time());
			st.setInt(3, nonbuy_dto.getN_deposit());

			count = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return count;
	}
	// nonbuy 업데이트 끝

	// 삭제
	public int deleteNonbuy(NonbuyDTO nonbuy_dto) {
		String sql = "delete from nonbuy where bigcat =? and smallcat =? ";
		conn = DBUtil.getConnect();

		try {
			st = conn.prepareStatement(sql);
			st.setString(1, nonbuy_dto.getBigcat());
			st.setString(2, nonbuy_dto.getSmallcat());

			count = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return count;
	}
	// 삭제 끝

	// Nonbuy_DTO 생성
	public NonbuyDTO makeNonbuy_DTO(ResultSet rs2) throws SQLException {
		String bigcat = rs2.getString(1);
		String smallcat = rs2.getString(2);
		String n_place = rs2.getString(3);
		String n_time = rs2.getString(4);
		int n_deposit = rs2.getInt(5);
		return new NonbuyDTO(bigcat, smallcat, n_place, n_time, n_deposit);
	}
}
