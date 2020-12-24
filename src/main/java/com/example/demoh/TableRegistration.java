package com.example.demoh;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TableRegistration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String ansver ="<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n"+
"<html lang=en>"+
"<head>"+
    "<title>registration</title>"+
  " <meta charset=utf-8>"+
   "<style>"+
   "    * {"+
          "box-sizing: border-box;"+
            "font-family: Arial, Helvetica, sans-serif;"+
       " }"+

       " body {"+
           " margin: 0;"+
          " font-family: Arial, Helvetica, sans-serif;"+
       "}"+

        ".topnav {"+
          "overflow: hidden;"+
            "background-color: skyblue;"+
       "}"+

      " .topnav a {"+
           " float: left;"+
            "display: block;"+
           " color: #f2f2f2;"+
            "text-align: center;"+
            "padding: 14px 16px;"+
            "text-decoration: none;"+
       "}"+
       " .topnav a:hover {"+
        "   background-color: #ddd;"+
         "  color: black;"+
      "  }"+
       " .content {"+
           " background-color: lightcyan;"+
          "  padding: 10px;"+
           " height: 500px;"+
        "}"+
       " .footer {"+
          " background-color: #f1f1f1;"+
           "padding: 10px;"+
       " }"+
       " h1{"+
          "  color: darkblue;"+
       " }"+
        "input[type=text], select {"+
           " width: 30%;"+
        " padding: 12px 20px;"+
        "  margin: 8px 0;"+
        "  display: inline-block;"+
        "    border: 1px solid skyblue;"+
        "   border-radius: 4px;"+
        "   box-sizing: border-box;"+
        " }"+

        "  input[type=submit] {"+
        "    width: 15%;"+
        "     background-color: skyblue;"+
        "    padding: 14px 20px;"+
        "    margin: 8px 0;"+
        "    border: none;"+
        "    border-radius: 4px;"+
        "    cursor: pointer;"+
        " }"+

        " input[type=reset] {"+
        "    width: 15%;"+
        "    background-color: skyblue;"+
        "    padding: 14px 20px;"+
        "    margin: 8px 0;"+
        "    border: none;"+
        "    border-radius: 4px;"+
        "    cursor: pointer;"+
        " }"+
        " button{"+
        "   width: 30%;"+
        "    background-color: skyblue;"+
        "    padding: 14px 20px;"+
        "    margin: 8px 0;"+
        "    border: none;"+
        "    border-radius: 4px;"+
        "    cursor: pointer;"+
        "    text-align: center;"+
        "}"+
        " a:link, a:visited {"+

        "   text-decoration: none;"+
        "   display: inline-block;"+
        "}"+
        "</style>"+
        "</head>"+
        "<body>"+

        "<div class=topnav>"+
        "<h1>Registration User</h1>"+

        "</div>"+

        "<div class=content>"+

        " <form action=writeUser method=post>"+
        "    <label for=fname> Login</label><br>"+
        "   <input type=text id=fname name=login placeholder=Your login><br>"+

        "    <label for=lname> Password</label><br>"+
        "     <input type=text id=lname name=password placeholder=Your password><br>"+
        " <input type=submit value=Submit>"+
        "    <input type=reset value=Delete >"+
        " </form >"+
        "</div>"+
        "<div class=footer>"+
        "<p>Footer</p>"+
        "</div>"+
        "</body>"+
        "</html>";
        resp.getWriter().println(ansver);
    }
}
