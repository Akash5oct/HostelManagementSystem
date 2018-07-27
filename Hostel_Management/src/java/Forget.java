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

/**
 *
 * @author Akki
 */
public class Forget extends HttpServlet {

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
     String a=request.getParameter("em");
     String b=request.getParameter("sec");
     String c=request.getParameter("ans");
      RequestDispatcher rd;
     
     String query="select * from user_records where question='"+b+"' and answer='"+c+"' and email='"+a+"'";
     if(request.getParameter("res")!=null){
            try {
                connect co=new connect();
                co.c_open();
                Statement stmt=co.conn.createStatement();
                ResultSet rs= stmt.executeQuery(query);
                boolean pass=rs.next();
                if(pass==true){
                    String psw=request.getParameter("pw");
                    String query2="update user_records set password='"+psw+"' where email='"+a+"'";
                    int x=stmt.executeUpdate(query2);
                    if(x>0){
                        rd=request.getRequestDispatcher("/Login.html");
                        rd.include(request, response);
                        p.println("Password Change ");
                    }
                    else{
                        rd=request.getRequestDispatcher("/Forgot password.html");
                        rd.include(request, response);
                        
                        p.println("Passowrd not Change ");
                    }
                    
                }
                else{
                    rd=request.getRequestDispatcher("/Forgot password.html");
                    rd.include(request, response);
                    p.println("Email and Answer Not matched ");
                }co.c_close();
            } catch (SQLException ex) {
                Logger.getLogger(Forget.class.getName()).log(Level.SEVERE, null, ex);
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
