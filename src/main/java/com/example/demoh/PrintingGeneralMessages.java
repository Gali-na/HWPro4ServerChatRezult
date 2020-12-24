package com.example.demoh;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PrintingGeneralMessages extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ansver = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "<title> My Telegram</title>\n"
                + "<meta charset=\"utf-8\">\n" +
                "<style>\n" +


                "box-sizing: border-box;\n"
                + "font-family: Arial, Helvetica, sans-serif;\n}"
                + "body { margin: 0;font-family: Arial, Helvetica, sans-serif;\n}"
                + "\n +.topnav {\n" +
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
                "\n" +
                "</div>\n" +
                "\n" +
                "<div class=\"content\">\n";
        for (Messag messag : ListMessages.getLisMessages()) {
            ansver += "<p>" + messag.getDate() + "<br>" +
                    messag.getName() + "<br>" +
                    messag.getText() + "<br>" + "</p>";
            ansver += "<p>" + "" + "</p>";
        }

        ansver += "</div>\n" +
                "<div class=\"footer\">\n" +
                "    <p>Footer</p>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";

        resp.getWriter().println(ansver);
    }
}