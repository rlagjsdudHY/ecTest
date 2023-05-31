package com.exam.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberShipAccess {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<MemInfo> mtdList() {

		String sql = "select * from memberList order by num desc";
		List<MemInfo> objList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<MemInfo>(MemInfo.class));

		return objList;

	}

	public List<MemInfo> searchByID(String searchID) {
		String sql = "SELECT * FROM memberList WHERE userID = ?";
		List<MemInfo> objList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(MemInfo.class), searchID);
		return objList;
	}
	
	public List<MemInfo> deleteByID(String userID) {
		String sql = "DELETE FROM memberList WHERE userID = ?";
		jdbcTemplate.update(sql, userID);
		return null;
	}

}
