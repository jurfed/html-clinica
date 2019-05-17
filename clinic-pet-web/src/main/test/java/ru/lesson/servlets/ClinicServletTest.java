package ru.lesson.servlets;

import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;

public class ClinicServletTest extends Mockito {


/*    @Test
    public void doGet() {
    }*/

    @Test(expected = NullPointerException.class)
    public void doPost() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("name")).thenReturn("Bob1");
        new ClinicServlet().doPost(request, response);

        verify(request,atLeast(1)).getParameter("name");
    }
}