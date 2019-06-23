package ru.lesson.servlets;


import ru.lesson.models.User;
import ru.lesson.store.UserCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO: comment
 * @author jurfed
 * @since 17.04.2015
 */
public class UserCreateServlet extends HttpServlet {

	final AtomicInteger ids = new AtomicInteger();

	private final UserCache USER_CACHE = UserCache.getInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.USER_CACHE.add(new User(this.ids.incrementAndGet(), req.getParameter("login"), req.getParameter("email"), req.getParameter("role")));
		resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/user/view"));
	}
}
