package ru.lesson.clinicServlets;

import org.junit.Test;
import org.mockito.Mockito;
import ru.lesson.store.ClinicCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.junit.Assert.*;

public class ClinicDeleteServletTest extends Mockito {

    final ClinicCache cache = ClinicCache.getInstance();

    @Test
    public void deleteUser() throws ServletException, IOException {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);


        when(request.getParameter("clientName")).thenReturn("Bob1");
        new ClinicDeleteServlet().doGet(request, response);


        assertEquals(cache.getClinic().findClientByClientName("Bob1"),null);


    }

}