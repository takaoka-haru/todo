package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.entity.LoginUser;

@Component
public class LoginUserDao {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	/**
	 * ユーザ検索するメソッド
	 */
	public LoginUser searchByUserName(String userName) {
		
		String query = "SELECT * FROM user WHERE name LIKE ?";
		
		//SQL実行
		List<Map<String, Object>> list = jdbc.queryForList(query,userName);
		
		return getLoginUser(list);
	}
	
	/*
	 * 検索結果をLoginUserクラスに詰める
	 * @param result
	 * @return
	 */
	private LoginUser getLoginUser(List<Map<String, Object>> result) {
		
		LoginUser loginUser = new LoginUser();
		
		for(int i = 0; i < result.size(); i++) {
			String name = (String)result.get(i).get("name");
			String password = (String)result.get(i).get("password");
			
			loginUser.setName(name);
			loginUser.setPassword(password);
		}
		
		return loginUser;
	}
}
