package com.yolowa.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBUtil;

//수정시 자기이름_ver00 형태로 올리기
public class CustomerDAO {

	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int count;
	String sql;

	// 회원가입
	public int insertCustomer(CustomerDTO cdto) {
		sql = "insert into customer values(sq_custom.nextval,?,?,?,?,?)";
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, cdto.getC_id());
			st.setString(2, cdto.getC_password());
			st.setString(3, cdto.getC_name());
			st.setString(4, cdto.getC_phone());
			st.setInt(5, cdto.getC_point());
			count = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return count;
	}

	// 회원정보수정
	public int updateCustomer(CustomerDTO cdto) {
		sql = "update customer set c_password=?,c_phone=?,c_point=? where c_id=?";
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, cdto.getC_password());
			st.setString(2, cdto.getC_phone());
			st.setInt(3, cdto.getC_point());
			st.setString(4, cdto.getC_id());
			count = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return count;
	}

	// id로 검색하기
	public CustomerDTO selectByC_id(String c_id) {
		CustomerDTO cdto = null;
		sql = "select * from CUSTOMER where c_id=?";
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, c_id);
			rs = st.executeQuery();
			while (rs.next()) {
				cdto = makeCustomer(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return cdto;
	}

	// 비밀번호 확인
	public CustomerDTO selectByC_idpass(String c_id, String c_password) {
		CustomerDTO cdto = null;
		sql = "select * from CUSTOMER where c_id=? and c_password=?";
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, c_id);
			st.setString(2, c_password);
			rs = st.executeQuery();
			while (rs.next()) {
				cdto = makeCustomer(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return cdto;
	}

	// 회원탈퇴
	public int deleteCustomer(String c_id, String c_password) {
		sql = "deleate from customer where c_id=? and c_password=?";
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, c_id);
			st.setString(2, c_password);
			count = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return count;
	}

	private CustomerDTO makeCustomer(ResultSet rs) throws SQLException {
		int c_num = rs.getInt(1);
		String c_id = rs.getString(2);
		String c_password = rs.getString(3);
		String c_name = rs.getString(4);
		String c_phone = rs.getString(5);
		int c_point = rs.getInt(6);
		return new CustomerDTO(c_num, c_id, c_password, c_name, c_phone, c_point);
	}
}
