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
import java.util.ArrayList;

public class PrivateChat extends HttpServlet {
    private ListMessadesPrivatChat privatChat = new ListMessadesPrivatChat();

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
        privatChat.addMassege(msg);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session =req.getSession();
        String login= (String) session.getAttribute("login");
        String password= (String) session.getAttribute("password");
        if (password==null) {

            String path = "/stopMessage";
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
            requestDispatcher.forward(req, resp);
        }


        if(!(login.equals("galina")&& password.equals("1122")||login.equals("nataliy")&& password.equals("1133")
                ||login.equals("sergey")&& password.equals("1144"))) {


            String path = "/stopMessage";
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
            requestDispatcher.forward(req, resp);

        }

        String ansver ="<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n" +
                "<html lang=\"en\">\n"+
                "<head>\n"+
                "<title> My Telegram</title>\n"
                +"<meta charset=\"utf-8\">\n"+
                "<style>\n"+


                "box-sizing: border-box;\n"
                +"font-family: Arial, Helvetica, sans-serif;\n}"
                +"body { margin: 0;font-family: Arial, Helvetica, sans-serif;\n}"
                +  "\n +.topnav {\n" +
                "            overflow: hidden;\n" +
                "            background-color: skyblue;\n" +
                "        }\n" +
                "\n" +
                "        .topnav a {\n" +
                "            float: left;\n" +
                "            display: block;\n" +
                "            color: #f2f2f2;\n" +
                "            text-align: center;\n" +
                "            padding: 14px 16px;\n" +
                "            text-decoration: none;\n" +
                "        }\n" +
                "        .topnav a:hover {\n" +
                "            background-color: #ddd;\n" +
                "            color: black;\n" +
                "        }\n" +

                "        .content {\n" +
                "            background-color: lightcyan;\n" +
                "            padding: 10px;\n" +
                "            height: 500px;\n" +
                "        }\n" +

                "        .footer {\n" +
                "            background-color: #f1f1f1;\n" +
                "            padding: 10px;\n" +
                "        }\n" +
                "        h1{\n" +
                "            color: darkblue;\n" +
                "        }\n" +

                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<div class=\"topnav\">\n" +
                "    <h1>My Telegram</h1>\n" +
               " <h1>Privat Chat</h1>\n"+
                "\n" +
                "</div>\n" +
                "\n" +
                "<div class=\"content\">\n" ;
      for(Messag messag :ListMessadesPrivatChat.getListPrivatChat()){
            ansver+= "<p>"+messag.getDate()+"<br>"+
                    messag.getName()+"<br>"+
                    messag.getText()+"<br>"+ "</p>";
            ansver+= "<p>"+""+"</p>";
        }
        ansver+="</div>\n" +
                "<div class=\"footer\">\n" +
                "    <p>Footer</p>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";

        resp.getWriter().println(ansver);

    }
}
