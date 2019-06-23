package ru.lesson.models;

import java.util.List;

/**
 * Пользователь содержит: идентификатор, логин и почту
 * @author jurfed
 * @since 17.04.2015
 */
public class User extends Base{
	private String login;
	private String email;


	public User(){

	}

	public User(final int id, final String login, final String email) {
		this.id = id;
		this.login = login;
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public String getEmail() {
		return this.email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
