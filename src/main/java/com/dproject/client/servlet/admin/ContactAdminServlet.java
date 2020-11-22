/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dproject.client.servlet.admin;

import com.dproject.client.entity.Contact;
import com.dproject.client.repository.ContactRepository;
import com.dproject.client.repository.impl.ContactRepositoryImpl;
import com.dproject.core.util.MyHelper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pranish
 */
@WebServlet(name = "contact-admin", urlPatterns = "/admin/contacts/*")
public class ContactAdminServlet extends HttpServlet {

    private ContactRepository repository = new ContactRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "index";
        boolean isRedirect = false;
        try {
            String uri = request.getRequestURI();
            if (uri.contains("/create")) {
                page = "create";
            } else if (uri.contains("/edit")) {
                page = "edit";
                String idString = request.getParameter("id");
                if (idString == null || idString.isEmpty()
                        || !MyHelper.isNumeric(idString)) {
                    isRedirect = true;
                    response.sendRedirect(
                            request.getContextPath()
                            + "/admin/contacts?error");
                } else {
                    int id = Integer.parseInt(idString);
                    Contact contact = repository.findById(id);
                    if (contact == null) {
                        response.sendRedirect(request.getContextPath()
                                + "/admin/contacts?error");
                    } else {
                        request.setAttribute("contact", contact);
                    }
                }
            } else if (uri.contains("/delete")) {
                String idString = request.getParameter("id");
                if (idString == null || idString.isEmpty()
                        || !MyHelper.isNumeric(idString)) {
                    isRedirect = true;
                    response.sendRedirect(
                            request.getContextPath()
                            + "/admin/contacts?error");
                } else {
                    int id = Integer.parseInt(idString);
                    repository.delete(id);
                    isRedirect = true;
                    response.sendRedirect(
                            request.getContextPath()
                            + "/admin/contacts?delsuccess");
                }

            } else {
                request.setAttribute("contacts",
                        repository.findAll());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (!isRedirect) {
            request.getRequestDispatcher(
                    "/WEB-INF/views/admin/contacts/" + page + ".jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Contact contact = new Contact();
            contact.setName(request.getParameter("name"));
            contact.setEmail(request.getParameter("email"));

            String idString = request.getParameter("id");
            if (idString != null && !idString.isEmpty()
                    && MyHelper.isNumeric(idString)) {
                contact.setId(Integer.parseInt(idString));
                repository.update(contact);

            } else {
                repository.insert(contact);
            }
            response.sendRedirect(
                    request.getContextPath() + "/admin/contacts?success");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
