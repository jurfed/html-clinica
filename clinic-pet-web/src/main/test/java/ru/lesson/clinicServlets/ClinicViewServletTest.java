package ru.lesson.clinicServlets;

import org.junit.Test;
import org.mockito.Mockito;
import ru.lesson.store.ClinicCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;

public class ClinicViewServletTest extends Mockito {
    static final ClinicCache cache = ClinicCache.getInstance();

    @Test(expected = NullPointerException.class)
    public void viewUser() throws ServletException, Exception {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);


        new ClinicViewServlet().doGet(request, response);


    }
}