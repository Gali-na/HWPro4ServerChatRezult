package com.example.demoh;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.HttpCookie;
import java.util.HashMap;
import java.util.Set;

public class WriteUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        HashMap<String, String> listUsers = DataUsers.getLodinParolUser();
        Set<String> listKey = listUsers.keySet();
        for (String key : listKey) {
            if (key.equals(login)) {
                resp.sendRedirect("http://localhost:8080/demoh_war_exploded/TableRegis");
            }
        }
        HttpSession session = req.getSession();
        session.setAttribute(login, login);
        session.setAttribute(password, password);
        listUsers.put(login, password);
        resp.sendRedirect("http://localhost:8080/demoh_war_exploded/printingGeneralMessages");
    }
}
