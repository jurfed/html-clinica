package ru.lesson.clinicServlets;

import org.junit.Test;
import org.mockito.Mockito;
import ru.lesson.store.ClinicCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.junit.Assert.*;

public class ClinicEditServletTest extends Mockito {


    static final ClinicCache cache = ClinicCache.getInstance();

    @Test
    public void editUser() throws ServletException, Exception {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("oldName")).thenReturn("Bob2");
        when(request.getParameter("newName")).thenReturn("Bobic");
        when(request.getParameter("oldPetName")).thenReturn("Cat2");
        when(request.getParameter("newPetName")).thenReturn("coty");

        new ClinicEditServlet().doPost(request, response);


        assertEquals(cache.getClinic().findClientByClientName("Bobic").getPet().getName(), "coty");


    }

}