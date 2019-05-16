package ru.lesson.servlets;

import ru.lesson.lessons.Animal;
import ru.lesson.lessons.Dog;
import ru.lesson.lessons.Pet;
import ru.lesson.lessons.PetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ClinicServlet extends HttpServlet {
    final List<Pet> pets = new CopyOnWriteArrayList<Pet>();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setCharacterEncoding("UTF-8");
        resp.setContentType ("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        writer.append(
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        "     <title>Clinic Pets</title>" +
                        "</head>" +
                        "<body>" +
                        "     <form action='" + req.getContextPath() + "/' method='post'>" +
                        "         Имя : <input type='text' name='name'>" +
                        "         Поиск : <input type='text' name='search'>" +
                        "         <input type='submit' value='Submit'>" +
                        "     <form>" +
                        this.viewPets(req) +
                        "</body>" +
                        "</html>"
        );
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String petName = req.getParameter("name");
            if(!petName.equals("")){
                this.pets.add(new Dog(new Animal(petName)));
            };
        } catch (PetException e) {
            e.printStackTrace();
        }
        doGet(req, resp);
    }

    private String viewPets(HttpServletRequest req){
        StringBuilder sb = new StringBuilder();
        sb.append("<p>Pets<p>");
        sb.append("<table style='border : 1px solid black'>");
        String search = req.getParameter("search");
        for(Pet pet:pets){

            if(search!=null && search!="" && search.equals(pet.getName()) || search==null || search=="" ){
                sb.append("<tr><td style='border : 1px solid black'>").append(pet.getName()).append("</td></tr>");
            }
        }
        sb.append("</table>");
        return sb.toString();
    }

}
