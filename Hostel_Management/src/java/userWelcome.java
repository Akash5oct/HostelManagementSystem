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
import javax.servlet.http.HttpSession;
import mypackage.connect;
/**
 *
 * @author Akki
 */
public class userWelcome extends HttpServlet {

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
        
     
     if(request.getParameter("inbox")!=null){
            try {
                
                String a;
                connect c=new connect();
                c.c_open();
                Statement stmt=c.conn.createStatement();
                    
                String query="select response from userfeedback where username='"+hs.getAttribute("User_Name")+"' or email='"+hs.getAttribute("e_mail")+"' ";
                    
                ResultSet rs=stmt.executeQuery(query);
                
                if(rs.next()){
                       p.println("<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "<head>\n" +
                        "	<title>Inbox</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "From:<input type=\"text\" value=\"Akash Shukla\" ><br>\n" +
                        "<textarea rows=\"4\" cols=\"50\" value=\"\" > "+rs.getString("response")+"</textarea><br>\n" +
                        "</body>\n" +
                        "</html>"); }
                else{
                p.println("No messages");
                }
            } catch (SQLException ex) {
                Logger.getLogger(userWelcome.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
     
     
     
     if(request.getParameter("msg")!=null){
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
" form {\n" +
"  max-width: 480px;\n" +
"  margin: 10px auto;\n" +
"  padding: 10px 20px;\n" +
"  background: #f4f7f8;\n" +
"  \n" +
"}\n" +
"#bt2 {background-color: #555555;}\n" +
"#bt1 {background-color: #555555;}\n" +
"\n" +
"\n" +
"</style>\n" +
"</head>\n" +
"<body>\n" +
"\n" +
"<form action=\"send\" method=\"post\">\n" +
"To:<input type=\"text\" value=\"Akash Shukla\" readonly=\"\"><br>\n" +
"<span style=\"padding-bottom: 100px\">Message:</span>\n" +
"<textarea rows=\"4\" cols=\"50\" name=\"msg\" >Message should be in 60 characters only...</textarea><br>\n" +
"<input type=\"Submit\" value=\"send\" name=\"send\" id=\"bt1\">\n" +
"<input type=\"reset\" value=\"clear\" id=\"bt2\">\n" +
"\n" +
"</form>\n" +
"</body>\n" +
"</html>" );
      
      }
     if(request.getParameter("status")!=null){
         
            try {
               String query="select status from user_records where userName='"+hs.getAttribute("User_name")+"'or email='"+hs.getAttribute("e_mail")+"' "; 
               connect c=new connect();
                c.c_open();
                Statement stmt=c.conn.createStatement();
                ResultSet rs=stmt.executeQuery(query);
                boolean   x=rs.next();
                if(x==true){
                    p.println("<h2 style='color:red'>ACTIVE</h2>");
                }
                else{
                    p.println("<h1 style='color:red'>Sorry!!!</h1>");
                    p.println("<h2 style='color:red'>Your Membership has been Expired.</h1>");
                }
                c.c_close();
            } catch (SQLException ex) {
                Logger.getLogger(userWelcome.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
     if(request.getParameter("pay")!=null){
            try {
                connect c=new connect();
                c.c_open();
                Statement stmt=c.conn.createStatement();
                String query="select * from user_payment where username='"+hs.getAttribute("User_Name")+"'or email='"+hs.getAttribute("e_mail")+"'" ;
                ResultSet rs=stmt.executeQuery(query);
               boolean b=rs.next();
               if(b==false){
               p.println("No record Found");
               }
               else{
                p.println("<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"	<title>User Table</title>\n" +
"	<style type=\"text/css\">\n" +
"	.dynamic{\n" +
"		margin: 1em 0;\n" +
"		width: 20%;\n" +
"		overflow: hidden;\n" +
"		background: #FFF;\n" +
"		color: #024457;\n" +
"		border-radius: 10px;\n" +
"		border: 1px solid #167F92;\n" +
"	}	\n" +
"	.dynamic tr{\n" +
"		border: 1px solid c;\n" +
"	}\n" +
"	.dynamic tr:nth-child(odd){\n" +
"		background-color: #EAF3F3;\n" +
"	}\n" +
"	.dynamic th{\n" +
"		display:table-cell;\n" +
"		border: 1px solid #FFF;\n" +
"		background-color: #167F92;\n" +
"		color: #FFF;\n" +
"		padding: 1em;\n" +
"	}\n" +
"	\n" +
".dynamic th, .dynamic td {\n" +
"  text-align: left;\n" +
"  margin: .5em 1em;\n" +
"}\n" +
".dynamic td{\n" +
"  display: table-cell;\n" +
"  text-align: center;\n" +
"  border-right: 2px solid #D9E4E6;\n" +
"  max-width: 7em;\n" +
"}\n" +
"body {\n" +
"  padding: 0 2em;\n" +
"  font-family: Arial, sans-serif;\n" +
"  color: #024457;\n" +
"  background: #f2f2f2;\n" +
"}\n" +
"\n" +
"\n" +
"\n" +
"	</style>\n" +
"\n" +
"</head>\n" +
"<body style=\"padding-left: 40%\">\n" +
"<h1 style=\"font-family: Verdana;\n" +
"  font-weight: normal;\n" +
"  color: #024457\">All User Data</h1>\n" +
"<table class=\"dynamic\">\n" +
"	\n" +
"	<tr>\n" +
"		<th>Date</th>\n" +
"		<th>Amount</th>\n" +
"		\n" +
"	</tr>");
                do{
p.println("	<tr>\n" +
"		<TD>"+rs.getString("dat")+"</TD>\n" +
"		<TD>"+rs.getString("amount")+"</TD>\n" +
"		</tr>");}while(rs.next());
p.println("	</table>\n" +
"\n" +
"</body>\n" +
"</html>");}
               c.c_close();
                
            } catch (SQLException ex) {
                Logger.getLogger(userWelcome.class.getName()).log(Level.SEVERE, null, ex);
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
