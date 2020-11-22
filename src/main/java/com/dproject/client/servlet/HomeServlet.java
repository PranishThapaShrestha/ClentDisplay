/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dproject.client.servlet;

import com.dproject.client.repository.ClientRepository;
import com.dproject.client.repository.impl.ClientRepositoryImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pranish
 */
@WebServlet(name = "home",urlPatterns ={"/","/home"})
public class HomeServlet extends HttpServlet {

    private ClientRepository repository = new ClientRepositoryImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("clients", repository.findAll());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        request.getRequestDispatcher("/WEB-INF/views/home.jsp")
                .forward(request, response);
    }

}
 