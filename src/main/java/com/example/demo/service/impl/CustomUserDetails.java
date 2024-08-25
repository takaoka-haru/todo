package com.example.demo.service.impl;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LoginUser;

@Service
public class CustomUserDetails implements UserDetails{
	
	//自分で作成したLoginUserをフィールドに持たせる
	private final LoginUser user;

	/*
	 * コンストラクタ
	 * @param user
	 */
	public CustomUserDetails(LoginUser user) {
		this.user = user;
	}

	@Override
	/*
	 * ロールの取得（今回は使用しない）
	 */
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	/*
	 * パスワードの取得
	 * ログインユーザーのパスワードをGetする
	 */
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	/*
	 * ユーザー名の取得
	 * ログインユーザーの名前をGetする
	 */
	public String getUsername() {
		return this.user.getName();
	}
	
	/**
	 * アカウントが有効期限でないか(使わないので常にtrue)
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	/**
	 * アカウントがロックされていないか(使わないので常にtrue)
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	/**
	 * 認証情報が有効期限切れでないか(使わないので常にtrue)
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	/**
	 * アカウントが有効であるかどうか(使わないので常にtrue)
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}
}
