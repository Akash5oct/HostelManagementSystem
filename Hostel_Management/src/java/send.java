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
import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mypackage.connect;
/**
 *
 * @author Akki
 */
public class send extends HttpServlet {

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
           
            HttpSession hs=request.getSession();
            String a=request.getParameter("msg");
          
            String qw="select * from user_records where username='"+hs.getAttribute("User_Name")+"' or email ='"+hs.getAttribute("e_mail")+"'";
          
            try{ 
               
            connect c=new connect();
            
            c.c_open();
         
            Statement stmt=c.conn.createStatement();
            
            ResultSet rs=stmt.executeQuery(qw);
          
            boolean   x=rs.next();
         
            if(x==true){
                 
               
                 String uname=rs.getString("username");
                String data=rs.getString("email");
                 
                String query="insert into USERFEEDBACK values('"+uname+"','"+data+"','"+a+"','','') ";
           
                int n=stmt.executeUpdate(query);
               
                if(n>0){
                    p.println("Message Send succefully");
                }
                else{
                    p.println("Msg was not send please retry");
                }
            } c.c_close();  } catch (SQLException ex) {
            Logger.getLogger(send.class.getName()).log(Level.SEVERE, null, ex);
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
