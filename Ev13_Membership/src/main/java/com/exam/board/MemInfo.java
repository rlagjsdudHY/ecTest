package com.exam.board;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemInfo {
	
	private int num;
	private String userID;
	private String userName;
	private int userAge;
	private Timestamp joinTM;

}
