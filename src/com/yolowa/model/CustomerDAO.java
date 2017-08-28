package com.yolowa.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBUtil;

public class CustomerDAO {

	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int count;
	String sql;

	// 회원가입
	public int insertCustomer(CustomerDTO customer_dto) {
		sql = "insert into customer values(sq_custom.nextval,?,?,?,?,?)";
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, customer_dto.getC_id());
			st.setString(2, customer_dto.getC_password());
			st.setString(3, customer_dto.getC_name());
			st.setString(4, customer_dto.getC_phone());
			st.setInt(5, customer_dto.getC_point());
			count = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return count;
	}

	public int selectC_num(CustomerDTO customer_dto) {
		String sql = "select max(c_num) from customer";
		conn = util.DBUtil.getConnect();
		int c_num = 0;
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				c_num = makec_num(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c_num;
	}

	private int makec_num(ResultSet rs) throws SQLException {
		int c_num = rs.getInt(1);
		return c_num;
	}

	// 회원정보수정
	public int updateCustomer(CustomerDTO customer_dto) {
		sql = "update customer set c_password=?,c_phone=?,c_point=? where c_num=?";
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, customer_dto.getC_password());
			st.setString(2, customer_dto.getC_phone());
			st.setInt(3, customer_dto.getC_point());
			st.setInt(4, customer_dto.getC_num());
			count = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return count;
	}

	//전체검색
	public List<CustomerDTO> selectAll() {
		List<CustomerDTO> customer_list = new ArrayList<>();
		String sql = "select * from customer";
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				CustomerDTO customer_dto = makeCustomer(rs);
				customer_list.add(customer_dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return customer_list;
	}
	
	// id로 검색하기
	public CustomerDTO selectByC_id(String c_id) {
		CustomerDTO customer_dto = null;
		sql = "select * from CUSTOMER where c_id=?";
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, c_id);
			rs = st.executeQuery();
			while (rs.next()) {
				customer_dto = makeCustomer(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return customer_dto;
	}

	// 아이디, 비밀번호 확인
	public CustomerDTO selectByC_idpass(String c_id, String c_password) {
		CustomerDTO customer_dto = null;
		sql = "select * from CUSTOMER where c_id=? and c_password=?";
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, c_id);
			st.setString(2, c_password);
			rs = st.executeQuery();
			while (rs.next()) {
				customer_dto = makeCustomer(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return customer_dto;
	}

	// 이름, 전화번호로 id 찾기
	public CustomerDTO selectByC_namephone(String c_name, String c_phone) {
		CustomerDTO customer_dto = null;
		sql = "select * from CUSTOMER where c_name=? and c_phone=?";
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, c_name);
			st.setString(2, c_phone);
			rs = st.executeQuery();
			while (rs.next()) {
				customer_dto = makeCustomer(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return customer_dto;
	}

	// id, 이름, 전화번호로 password 찾기
	public CustomerDTO selectByC_idnamephone(String c_id, String c_name, String c_phone) {
		CustomerDTO customer_dto = null;
		sql = "select * from CUSTOMER where c_id=? and c_name=? and c_phone=?";
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, c_id);
			st.setString(2, c_name);
			st.setString(3, c_phone);
			rs = st.executeQuery();
			while (rs.next()) {
				customer_dto = makeCustomer(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return customer_dto;
	}

	// 회원탈퇴
	public int deleteCustomer(String c_id, String c_password) {
		sql = "delete from customer where c_id=? and c_password=?";
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
