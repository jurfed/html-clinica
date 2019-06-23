package ru.lesson.models;

import java.util.Set;

/**
 * Пользователь содержит: идентификатор, логин и почту
 * @author jurfed
 * @since 17.04.2015
 */
public class User extends Base {
	private String login;
	private String email;
	private Role role;
	private Set<Message> messages;

	public User() {
	}

	public User(final int id, final String login, final String email, final String name) {
		this.id = id;
		this.login = login;
		this.email = email;
		this.role = new Role(name);
	}

	public Role getRole() {
		if(role==null || role.getName()==null){
			role = new Role();
		}

		return role;
	}

	public String rol="222";

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	public String getLogin() {
		return this.login;
	}

	public String getEmail() {
		return this.email;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
