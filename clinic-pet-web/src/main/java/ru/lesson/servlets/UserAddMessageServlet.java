package ru.lesson.servlets;


import ru.lesson.models.Message;
import ru.lesson.models.User;
import ru.lesson.store.UserCache;

import javax.servlet.RequestDispatcher;
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
public class UserAddMessageServlet extends HttpServlet {

	final AtomicInteger ids = new AtomicInteger();

	private static final UserCache USER_CACHE = UserCache.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("user", this.USER_CACHE.get(Integer.valueOf(req.getParameter("id"))));
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/UserAddMessage.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.USER_CACHE.addMessage(new Message(this.USER_CACHE.get(Integer.valueOf(req.getParameter("id"))),req.getParameter("message")));
		resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/user/view"));

	}
}
