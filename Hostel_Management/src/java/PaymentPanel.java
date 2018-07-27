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
public class PaymentPanel extends HttpServlet {

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
            String a,a2,a3,a4,a5,a6,a7,un,e_mail;
            if(request.getParameter("go")!=null){
                try {
                    a=request.getParameter("em");
                    String query="select * from user_records where username='"+a+"' or email='"+a+"'";
                    connect c=new connect();
                    c.c_open();
                    Statement stmt=c.conn.createStatement();
                    ResultSet rs=stmt.executeQuery(query);
                    boolean b=rs.next();
                    
                    if(b==true){
                         
                        a2=rs.getString("firstname");
                        a3=rs.getString("lastname");
                        a4=rs.getString("aadhar");
                        a5=rs.getString("city");
                        a6=rs.getString("mobile");
                        un=rs.getString("username");
                        e_mail=rs.getString("email");
                        
                        info.setFname(a2);
                        info.setLname(a3);
                        info.setAdhar(a4);
                        info.setCity(a5);
                        info.setMob(a6);
                        info.setUname(un);
                        info.setEm(e_mail);
                        
                        RequestDispatcher rd=request.getRequestDispatcher("Alter");
                        rd.forward(request, response);
                    }  
                  c.c_close();
                } catch (SQLException ex) {
                    Logger.getLogger(PaymentPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            if(request.getParameter("make")!=null){
            
                try {
                    String  Dt=request.getParameter("date");
                    String amount=request.getParameter("pay");
                    connect c=new connect();
                    c.c_open();
                    Statement stmt=c.conn.createStatement();
                    String query="insert into user_payment values('"+info.getFname()+"','"+info.getEm()+"','"+info.getUname()+"','paid','"+amount+"','"+Dt+"')";
                    int n=stmt.executeUpdate(query);
                    if(n>0){
                        p.println("Payment Successfull");
                        RequestDispatcher rd=request.getRequestDispatcher("Alter");
                        rd.forward(request, response);
                    }
                    else{
                        p.println("Payment Successfull");
                        RequestDispatcher rd=request.getRequestDispatcher("Alter");
                        rd.forward(request, response);
                    }  c.c_close();
                } catch (SQLException ex) {
                    Logger.getLogger(PaymentPanel.class.getName()).log(Level.SEVERE, null, ex);
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
