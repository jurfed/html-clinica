package ru.lesson.clinicServlets;


import ru.lesson.store.ClinicCache;
import ru.lesson.store.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO: comment
 * @author jurfed
 * @since 17.04.2015
 */
public class ClinicViewServlet extends HttpServlet {

	private static final ClinicCache CLINIC_CACHE = ClinicCache.getInstance();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("clients", this.CLINIC_CACHE.getClinic().getClientList());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/clinic/ClinicView.jsp");
		dispatcher.forward(req, resp);
	}
}
