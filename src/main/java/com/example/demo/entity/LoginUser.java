package com.example.demo.entity;

import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.Data;

@Repository
@Data
public class LoginUser {
	
	/*
	 * ユーザーID
	 */
	private Integer id;
	
	/*
	 * ログインID
	 */
	private String loginId;
	
	/*
	 * ユーザー名
	 */
	private String name;
	
	/*
	 * パスワード
	 */
	private String password;
	
	/*
	 * 登録日時
	 */
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;
	
	/*
	 * 更新日時
	 */
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateDate;
}
