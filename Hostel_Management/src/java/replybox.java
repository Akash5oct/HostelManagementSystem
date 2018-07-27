/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mypackage.connect;

/**
 *
 * @author Akki
 */
public class replybox extends HttpServlet {

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
      String a=request.getParameter("abc");
     
      
      p.println("<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"	<title>send mesage</title>\n" +
"	<style type=\"text/css\">\n" +
"		input ,textarea{\n" +
"    background-color: #d0ffff; \n" +
"    border: none;\n" +
"    color: black;\n" +
"    padding: 15px 32px;\n" +
"    text-align: center;\n" +
"    text-decoration: none;\n" +
"    display: inline-block;\n" +
"    font-size: 16px;\n" +
"    margin: 4px 2px;\n" +
"    cursor: pointer;}\n" +
"body {\n" +
"  padding: 0 2em;\n" +
"  font-family: sans-serif;\n" +
"  color: #024457;\n" +
"  background: #f2f2f2;\n" +
"  text-align: center;\n" +
"}\n" +
"\n" +
"#bt2 {background-color: #555555;}\n" +
"#bt1 {background-color: #555555;}\n" +
"\n" +
"\n" +
"</style>\n" +
"</head>\n" +
"<body>\n" +
"<form action=\"replybox\" method=\"post\">\n" +
"To:<input type=\"text\" value=\""+a+"\" readonly=\"\" name=\"to\"><br>\n" +
"<span style=\"padding-bottom: 100px\">Message:</span>\n" +
"<textarea rows=\"4\" cols=\"50\" name=\"msg\" ></textarea><br>\n" +
"<input type=\"Submit\" value=\"send\" name=\"se\" id=\"bt1\">\n" +
"<input type=\"reset\" value=\"clear\" id=\"bt2\">\n" +
"\n" +
"</form>\n" +
"</body>\n" +
"</html>");
      
      
      
      if(request.getParameter("se")!=null){
            try {
                
                connect c=new connect();
                
               
                String res=request.getParameter("msg");
                String To=request.getParameter("to");
                c.c_open();
               
                String query2="update userfeedback set response='"+res+"' where email='"+To+"'";
                Statement stmt=c.conn.createStatement();
                
                 
                int n=stmt.executeUpdate(query2);
                  
                if(n>0){
                   
                p.println("Send Succesfull");
                }
                c.c_close();
                 }
            catch (SQLException ex) {
                Logger.getLogger(replybox.class.getName()).log(Level.SEVERE, null, ex);
            }
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
