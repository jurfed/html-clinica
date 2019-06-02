package ru.lesson.clinicServlets;

import ru.lesson.lessons.PetException;
import ru.lesson.store.ClinicCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class ClinicEditServlet extends HttpServlet {

    final AtomicInteger ids = new AtomicInteger();

    private static final ClinicCache CLINIC_CACHE = ClinicCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("client", CLINIC_CACHE.getClinic().findClientByClientName(req.getParameter("clientid")));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/clinic/EditClient.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.CLINIC_CACHE.editClient(req.getParameter("oldName"), req.getParameter("newName"));
        this.CLINIC_CACHE.editPet(req.getParameter("oldPetName"), req.getParameter("newPetName"));

        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/clinic/view"));
    }
}
