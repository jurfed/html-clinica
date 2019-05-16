package ru.lesson.clinicServlets;


import ru.lesson.lessons.*;
import ru.lesson.store.ClinicCache;

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
public class ClinicCreateServlet extends HttpServlet {

	private static final ClinicCache CLINIC_CACHE = ClinicCache.getInstance();


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			try {

				if(req.getParameter("petType").equals("dog")){
					this.CLINIC_CACHE.getClinic().addClient(new Client(req.getParameter("clientName"),new Dog(new Animal(req.getParameter("petName")))));
				}else{
					this.CLINIC_CACHE.getClinic().addClient(new Client(req.getParameter("clientName"),new Cat(req.getParameter("petName"))));
				}


			} catch (PetException e) {
				e.printStackTrace();
			}
		} catch (CreateClientException e) {
			e.printStackTrace();
		}

		resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/clinic/view"));
	}
}
