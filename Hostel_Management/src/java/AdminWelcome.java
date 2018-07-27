/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Akki
 */
public class AdminWelcome extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter p=response.getWriter();
    p.println("<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"<style>\n" +
"body {\n" +
"  padding: 0 2em;\n" +
"  font-family: sans-serif;\n" +
"  color: #024457;\n" +
"  background: #99a2e3;\n" +
"  text-align: center;\n" +
"}\n" +
"input {\n" +
"    background-color: #4CAF50; /* Green */\n" +
"    border: none;\n" +
"    color: white;\n" +
"    padding: 15px 32px;\n" +
"    text-align: center;\n" +
"    text-decoration: none;\n" +
"    display: inline-block;\n" +
"    font-size: 16px;\n" +
"    margin: 4px 2px;\n" +
"    cursor: pointer;\n" +
"}\n" +
"input[type=\"text\"]{\n" +
"  background: rgba(255,255,255,0.1);\n" +
"  font-size: 16px;padding: 15px;\n" +
"  width: 50%;\n" +
"  background-color: #e8eeef;\n" +
"  color: #8a97a0;\n" +
"  margin-bottom: 30px;\n" +
"\n" +
"}\n" +
"\n" +
"\n" +
"\n" +
"#bt1 {background-color: #008CBA;} /* Blue */\n" +
"#bt2 {background-color: #f44336;} /* Red */ \n" +
"#bt3 {background-color:  #4CAF50;}  \n" +
"#bt4 {background-color: #555555;} \n" +
"</style>\n" +
"</head>\n" +
"<body>\n" +
"<h1>Welcome Owner</h1>\n" +
"<h2>Services for you</h2>\n" +
"<p>Simply click on Button for the services you Want.</p>\n" +
"\n" +
"\n" +
"<form action=\"Alter\" method=\"post\">\n" +
"  <label>Change Color:</label>\n" +
"<input type=\"checkbox\" name=\"head\" value=\"Header\">Header Color\n" +
"<input type=\"checkbox\" name=\"foot\" value=\"Footer\">Footer Color<br>\n" +
"\n" +
"<label>Enter Email or User Name:</label>\n" +
"<input type=\"text\" name=\"em\">\n" +
"\n" +
"\n" +
"<input type=\"Submit\" name=\"search\" value=\"Search\" id=\"bt1\"><br>\n" +
"<input type=\"Submit\" name=\"inb\" value=\"INBOX\" id=\"bt2\"><br>\n" +
"<input type=\"Submit\" name=\"sta\" value=\"VIEW ALL USERS\" id=\"bt3\">\n" +
"<input type=\"Submit\" name=\"pay\" value=\"DO PAYMENT\" id=\"bt4\">\n" +
"</form>\n" +
"<div id=\"footer\" style=\"margin-top: 200px\">\n" +
"  <p>© 2017 by Akash Developers. All Rights Reserved</p>\n" +
"  <div>\n" +
"</body>\n" +
"</html>");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
