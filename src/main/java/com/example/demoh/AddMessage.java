package com.example.demoh;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AddMessage extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream ins= req.getInputStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[10240];
        int r;

        do {
            r = ins.read(buf);
            if (r > 0) bos.write(buf, 0, r);
        } while (r != -1);


        byte[] buf1 =  bos.toByteArray();
        String bufStr = new String(buf1, StandardCharsets.UTF_8);
        Messag msg = Messag.fromJson(bufStr);
        ListMessages listMessages= new ListMessages();
        listMessages.addMassege(msg);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session =req.getSession();
        String login= (String) session.getAttribute("login");
        String password= (String) session.getAttribute("password");
        if (password==null) {
            String path = "/TableRegis";
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
            requestDispatcher.forward(req, resp);
        }

        if (!password.equals(DataUsers.getLodinParolUser().get(login))) {
            String path = "/TableRegis";
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
            requestDispatcher.forward(req, resp);

        }
             String path = "/printingGeneralMessages";
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
            requestDispatcher.forward(req, resp);
    }
}
