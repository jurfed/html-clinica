package ru.lesson.servlets;

import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;

public class UserEditServletTest extends Mockito {

    @Test
    public void doPost() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);


        when(request.getParameter("id")).thenReturn("2");
        when(request.getParameter("login")).thenReturn("Ivan");
        when(request.getParameter("email")).thenReturn("ivanmail.ru");

        new UserEditServlet().doPost(request,response);

    }
}