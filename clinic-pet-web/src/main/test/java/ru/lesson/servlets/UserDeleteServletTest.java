package ru.lesson.servlets;

import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;

public class UserDeleteServletTest extends Mockito {

    @Test
    public void doGet() throws ServletException, IOException {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);


        when(request.getParameter("id")).thenReturn("2");

        new UserDeleteServlet().doGet(request,response);

    }
}