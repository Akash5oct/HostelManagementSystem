/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mypackage.connect;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Akki
 */
public class UserLogin extends HttpServlet {

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
            String a1,a2,query,a3;
            a1=request.getParameter("Un");
            a2=request.getParameter("pass");
            a3=request.getParameter("em");
       try{
           query= "select * from user_records where USERNAME='"+a1+"' or email='"+a3+"' and password='"+a2+"'";
                connect c=new connect();
            c.c_open();
            
            Statement stmt=c.conn.createStatement();
            
                ResultSet rs1=stmt.executeQuery(query);
               
               boolean x=false;
                x=rs1.next();
                if(x==true){
                HttpSession hs=request.getSession();
                hs.setAttribute("User_Name", a1);
                hs.setAttribute("e_mail", a3);
               p.println("<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"<style>\n" +
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
"body {\n" +
"  padding: 0 2em;\n" +
"  font-family: sans-serif;\n" +
"  color: #024457;\n" +
"  background: #f2f2f2;\n" +
"  text-align: center;\n" +
"}\n" +
"\n" +
"#bt1 {background-color: #008CBA;} /* Blue */\n" +
"#bt2 {background-color: #f44336;} /* Red */ \n" +
"#bt3 {background-color: #dda1c8; color: black;} /* Gray */ \n" +
"#bt4 {background-color: #555555;} /* Black */\n" +
"</style>\n" +
"</head>\n" +
"<body>\n" +
"<h1>Welcome User</h1>\n" +
"<h2>Services for you</h2>\n" +
"<p>Simply click on Button for the services you Want.</p>\n" +
"<form action=\"userWelcome\" method=\"post\">\n" +
"<input type=\"Submit\" name=\"inbox\" value=\"INBOX\" id=\"bt1\">\n" +
"<input type=\"Submit\" name=\"msg\" value=\"SEND MESSAGE\" id=\"bt2\"><br>\n" +
"<input type=\"Submit\" name=\"status\" value=\"STATUS\" id=\"bt3\">\n" +
"<input type=\"Submit\" name=\"pay\" value=\"VIEW PAYMENT\" id=\"bt4\">\n" +
"</form>\n" +
"</body>\n" +
"</html>");
             
               
            }
            else{
            
            p.println("incorrect user name and password");
            }
            c.c_close();
        } catch (SQLException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
