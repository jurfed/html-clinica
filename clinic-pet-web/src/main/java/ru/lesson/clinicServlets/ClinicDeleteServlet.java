package ru.lesson.clinicServlets;


import ru.lesson.lessons.Cat;
import ru.lesson.lessons.Client;
import ru.lesson.lessons.CreateClientException;
import ru.lesson.lessons.PetException;
import ru.lesson.store.ClinicCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO: comment
 *
 * @author jurfed
 * @since 17.04.2015
 */
public class ClinicDeleteServlet extends HttpServlet {

    private static final ClinicCache CLINIC_CACHE = ClinicCache.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.CLINIC_CACHE.delete(req.getParameter("clientName"));
//        this.CLINIC_CACHE.getClinic().deleteClient(req.getParameter("clientName"));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/clinic/view"));
    }
}
