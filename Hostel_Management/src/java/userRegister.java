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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import mypackage.connect;

/**
 *
 * @author Akki
 */
public class userRegister extends HttpServlet {

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
            String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,query;
           int n;
            String q="select seq_user.nextval from dual";
            a1=request.getParameter("fn");
            a2=request.getParameter("ln");
            a3=request.getParameter("adhar");
            a4=request.getParameter("gender");
            a5=request.getParameter("em");
            a6=request.getParameter("add");
            a7=request.getParameter("cst");
            a8=request.getParameter("st");
            a9=request.getParameter("un");
            a10=request.getParameter("pw");
            a11=request.getParameter("sec");
            a12=request.getParameter("ans");
            a13=request.getParameter("mob");
            
          
          try{
               
             connect c=new connect();
            c.c_open();
            
            Statement stmt1=c.conn.createStatement();
              ResultSet rs= stmt1.executeQuery(q);
             if(rs.next()){
              n=rs.getInt(1);
            
             query="insert into User_Records values("+n+",'"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"','"+a8+"','"+a9+"','"+a10+"','"+a11+"','"+a12+"','Active','"+a13+"')";
            Statement stmt2=c.conn.createStatement();
             int x=stmt2.executeUpdate(query);
           
            if(x>0){
            p.println("<p style=color:red>Congratulations!!!"
                    + "Registration Succesfull.</p>");
            p.println("<p style=color:blue>now go back and login</p>");
            }
              }
            else{
            p.println("Sorry.....Please Retry");
            }
            c.c_close();
        } catch (SQLException ex) {
            Logger.getLogger(userRegister.class.getName()).log(Level.SEVERE, null, ex);
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
