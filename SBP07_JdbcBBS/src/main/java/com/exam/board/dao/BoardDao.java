package com.exam.board.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.exam.board.dto.BoardDto;

@Repository
public class BoardDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

// 글목록 보기
	public List<BoardDto> listDao() {
		System.out.println("listDao()");
		String sql = "select * from board order by num desc";
		List<BoardDto> boardDtoList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BoardDto.class));
		return boardDtoList;
	}

// 글내용 보기
	public BoardDto viewDao(String num) {
		System.out.println("viewDao()");
		String sql = "select * from board where num=" + num;
		BoardDto boardDto = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
		return boardDto;
	}

//글쓰기
	public int writeDao(String writer, String title, String content) {
		System.out.println("writeDao()");
		String sql = "insert into board (writer, title, content) ";
		sql += "values (?, ?, ?)";
		int rtnCnt = jdbcTemplate.update(sql, writer, title, content);
		return rtnCnt;
	}

//글삭제
	public int deleteDao(String num) {
		System.out.println("deleteDao()");
		String sql = "delete from board where num=?";
		int rtnCnt = jdbcTemplate.update(sql, Integer.parseInt(num));
		return rtnCnt;
	}
}
