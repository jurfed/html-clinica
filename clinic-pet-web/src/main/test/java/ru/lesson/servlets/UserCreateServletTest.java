package ru.lesson.servlets;

import org.junit.Test;
import org.mockito.Mockito;
import ru.lesson.store.UserCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class UserCreateServletTest extends Mockito {

    final UserCache cache = UserCache.getInstance();

    @Test
    public void createUser() throws ServletException, IOException{

        /**
         * создаем заглушки
         */
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        //проверяем что список пользователей пустой
        assertTrue(cache.values().isEmpty());

        //указываем какие значения передать при запросе нашим сервлетом раметров login и email
        when(request.getParameter("login")).thenReturn("testLogin");
        when(request.getParameter("email")).thenReturn("testEmail");


        //создаем наш сервлет и посылаем в медот doPost указанные параметры
        new UserCreateServlet().doPost(request,response);

        //проверяем, что пользователь успешно создан
        assertEquals(cache.get(1).getLogin(),"testLogin");
        assertEquals(cache.get(1).getEmail(),"testEmail");

        /**
         * проверяем, что хотя бы 1 раз был вызван метод getParameter с параметрод "login" и "email"
         */
        verify(request,atLeast(1)).getParameter("login");
        verify(request,atLeast(1)).getParameter("email");
    }

}