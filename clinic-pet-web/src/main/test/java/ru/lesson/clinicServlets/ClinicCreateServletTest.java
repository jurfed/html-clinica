package ru.lesson.clinicServlets;

import org.junit.Test;
import org.mockito.Mockito;
import ru.lesson.store.ClinicCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;

public class ClinicCreateServletTest extends Mockito {

    final ClinicCache cache = ClinicCache.getInstance();

    @Test
    public void createUser() throws ServletException, IOException {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("petType")).thenReturn("dog");
        when(request.getParameter("clientName")).thenReturn("Mister Swith");
        when(request.getParameter("petName")).thenReturn("diggy-puggy");

        new ClinicCreateServlet().doPost(request, response);

        assertEquals(cache.getClinic().findClientByClientName("Mister Swith").getPet().getName(),"diggy-puggy");


        when(request.getParameter("petType")).thenReturn("cat");
        when(request.getParameter("clientName")).thenReturn("Missis Down");
        when(request.getParameter("petName")).thenReturn("citty-pissy");

        new ClinicCreateServlet().doPost(request, response);

        assertEquals(cache.getClinic().findClientByClientName("Missis Down").getPet().getName(),"citty-pissy");

    }

}