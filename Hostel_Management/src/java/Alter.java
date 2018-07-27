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
import javax.servlet.http.HttpSession;
import mypackage.connect;

/**
 *
 * @author Akki
 */
public class Alter extends HttpServlet {

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
        
       
       if(request.getParameter("search")!=null){
            try {
              
                String a=request.getParameter("em");
                
                String query="select * from user_records where username='"+a+"' or email='"+a+"'";
                connect c=new connect();
                c.c_open();
                 Statement stmt=c.conn.createStatement();
              ResultSet rs=stmt.executeQuery(query);
                boolean b=rs.next();
                 if(b==true){
                     HttpSession hs=request.getSession();
                     hs.setAttribute("a1", a);
                    p.println("<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"	<title>User Table</title>\n" +
"	<style type=\"text/css\">\n" +
"	.dynamic{\n" +
"		margin: 1em 0;\n" +
"		width: 100%;\n" +
"		overflow: hidden;\n" +
"		background: #FFF;\n" +
"		color: #024457;\n" +
"		border-radius: 10px;\n" +
"		border: 1px solid #167F92;\n" +
"	}	\n" +
"	.dynamic tr{\n" +
"		border: 1px solid #D9E4E6;\n" +
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
"<body>\n" +
"<h1 style=\"font-family: Verdana;\n" +
"  font-weight: normal;\n" +
"  color: #024457\">All User Data</h1>\n" +
"<table class=\"dynamic\">\n" +
"	\n" +
"	<tr>\n" +
"		<th>S.No.</th>\n" +
"		<th>FIRST NAME</th>\n" +
"		<th>LAST NAME</th>\n" +
"		<th>AADHAR</th>\n" +
"		<th>E-MAIL</th>\n" +
"		<th>CITY</th>\n" +
"		<th>STATE</th>\n" +
"		<th>USER NAME</th>\n" +
"        <th>MOBILE NO.</th>\n" +
"		<th>STATUS</th>\n" +
"	</tr>");
                    p.println("<form action=\"delete\" method=\"post\">\n" +
"	<tr>\n" +
"		<TD>"+rs.getString("id")+"</TD>\n" +
"		<TD>"+rs.getString("firstname")+"</TD>\n" +
"		<TD>"+rs.getString("lastname")+"</TD>\n" +
"		<TD>"+rs.getString("aadhar")+"</TD>\n" +
"		<TD>"+rs.getString("email")+"</TD>\n" +
"		<TD>"+rs.getString("city")+"</TD>\n" +
"		<TD>"+rs.getString("sstate")+"</TD>\n" +
"		<TD>"+rs.getString("username")+"</TD>\n" +
"		<TD>"+rs.getString("mobile")+"</TD>\n" +
"		<TD>"+rs.getString("status")+"</TD>\n" +
"		<td><input type='submit' value='DELETE' name=\"del\"></td>\n" +
"	</tr>\n" +
"</form>");
                    p.println("</table>\n" +
"\n" +
"</body>\n" +
"</html>");
                    
                    
                    
                    

              
            }
                c.c_close();
            } catch (SQLException ex) {
                Logger.getLogger(Alter.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       
       if(request.getParameter("inb")!=null){
            
            try {
                String query3="select * from userfeedback where response IS NULL";
                connect c=new connect();
                c.c_open();
                
                Statement stmt=c.conn.createStatement();
                ResultSet rs=stmt.executeQuery(query3);
                boolean b=rs.next();
                if(b==true){
              p.println("<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"	<title>User Table</title>\n" +
"	<style type=\"text/css\">\n" +
"	.dynamic{\n" +
"		margin: 1em 0;\n" +
"		width: 100%;\n" +
"		overflow: hidden;\n" +
"		background: #FFF;\n" +
"		color: #024457;\n" +
"		border-radius: 10px;\n" +
"		border: 1px solid #167F92;\n" +
"		width: 70%;\n" +
"	}	\n" +
"	.dynamic tr{\n" +
"		border: 1px solid #D9E4E6;\n" +
"	}\n" +
"       input[type=\"text\"]{\n" +
"		background: #D9E4E6;\n" +
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
"<body>\n" +
"<h1 style=\"font-family: Verdana;\n" +
"  font-weight: normal;\n" +
"  color: #024457\">All User Incoming Messages</h1>\n" +
"<table class=\"dynamic\">\n" +
"	\n" +
"	<tr>\n" +
"		\n" +
"		<th>E-MAIL</th>\n" +
"		<th>Message Code</th>\n" +
"		<th>Message</th>\n" +
"		\n" +
"	</tr>\n");
              do{
p.println("	<form action=\"replybox\" method=\"post\">\n" +
"	<tr>\n" +
"		<TD style=\"width: 20%\"><input type=\"text\" name=\"abc\" value=\""+rs.getString("email")+"\" readonly=\"\"></TD>\n" +
"		<TD style=\"width: 20%\">"+rs.getString("message_code")+"</TD>\n" +
"		<TD>"+rs.getString("message")+"</TD>\n" +
"		<td style=\"width: 10%\"><input type='submit' value='REPLY' name=\"rply\"></td>\n" +
"	</tr>\n" +
"</form>\n");}while(rs.next()); 
p.println("</table>\n" +
"\n" +
"</body>\n" +
"</html>");
                        
                }
                else{p.println("no messages");}
                c.c_close();
            } catch (SQLException ex) {
                Logger.getLogger(Alter.class.getName()).log(Level.SEVERE, null, ex);
            }
           
       
       }
       if(request.getParameter("sta")!=null){
            try {
                String Query4="select * from user_records";
                connect c=new connect();
                c.c_open();
                Statement stmt=c.conn.createStatement();
                ResultSet rs=stmt.executeQuery(Query4);
                boolean b=rs.next();
                String x1,x2,x3,x4,x5,x6,x7,x8,x9,x10;
                
                
               
                p.println("<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"	<title>User Table</title>\n" +
"	<style type=\"text/css\">\n" +
"	.dynamic{\n" +
"		margin: 1em 0;\n" +
"		width: 100%;\n" +
"		overflow: hidden;\n" +
"		background: #FFF;\n" +
"		color: #024457;\n" +
"		border-radius: 10px;\n" +
"		border: 1px solid #167F92;\n" +
"	}	\n" +
"	.dynamic tr{\n" +
"		border: 1px solid #D9E4E6;\n" +
"	}\n" +
"	.dynamic tr:nth-child(odd){\n" +
"		background-color: #EAF3F3;\n" +
"	}\n" +
"       input[type=\"text\"]:nth-child(odd){\n" +
"		background: #D9E4E6;\n" +
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
"<body>\n" +
"<h1 style=\"font-family: Verdana;\n" +
"  font-weight: normal;\n" +
"  color: #024457\">All User Data</h1>\n" +
"  <form action=\"delete\" method=\"post\">\n" +
"<table class=\"dynamic\">\n" +
"	\n" +
"	<tr>\n" +
"		<th>S.No.</th>\n" +
"		<th>FIRST NAME</th>\n" +
"		<th>LAST NAME</th>\n" +
"		<th>AADHAR</th>\n" +
"		<th>E-MAIL</th>\n" +
"		<th>CITY</th>\n" +
"		<th>STATE</th>\n" +
"		<th>USER NAME</th>\n" +
"        <th>MOBILE NO.</th>\n" +
"		<th>STATUS</th>\n" +
"	</tr>\n" +

"	<tr>");
                do{
p.println("		<TD><input type=\"radio\" name=\"sn\">"+rs.getString("id")+"</TD>\n" +
"		<TD>"+rs.getString("firstname")+"</TD>\n" +
"		<TD>"+rs.getString("lastname")+"</TD>\n" +
"		<TD>"+rs.getString("aadhar")+"</TD>\n" +
"		<TD style=\"width: 20%\"><input type=\"text\" name=\"rec\" value=\""+rs.getString("email")+"\" readonly=\"\" style=\"width: 95%\"></TD>\n" +
"		<TD>"+rs.getString("city")+"</TD>\n" +
"		<TD>"+rs.getString("sstate")+"</TD>\n" +
"		<TD>"+rs.getString("username")+"</TD>\n" +
"		<TD>"+rs.getString("mobile")+"</TD>\n" +
"		<TD>"+rs.getString("status")+"</TD>\n" +
"		<td><input type=\"Submit\" Value=\"DELETE\" Name=\"del\"></td>\n" +
"	</tr> " );}while(rs.next());

p.println("</form>\n" +
"</table>\n" +
"\n" +
"</body>\n" +
"</html>");
                
               c.c_close();
            } catch (SQLException ex) {
                Logger.getLogger(Alter.class.getName()).log(Level.SEVERE, null, ex);
            }
   
       
       
       }
       
       if(request.getParameter("pay")!=null){
       p.println("<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"<meta charset=\"utf-8\">\n" +
" <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"<title>Sign Up Form</title>\n" +
"<style type=\"text/css\">\n" +
"body {\n" +
"font-family: sans-serif;\n" +
"color: #384047;}\n" +
"form {\n" +
"  max-width: 480px;\n" +
"  margin: 10px auto;\n" +
"  padding: 10px 20px;\n" +
"  background: #f4f7f8;\n" +
"  border-radius: 8px;\n" +
"}\n" +
"input[type=\"text\"] {\n" +
"  background: rgba(255,255,255,0.1);\n" +
"  border: none;\n" +
"  font-size: 16px;\n" +
"  height: auto;\n" +
"  margin: 0;\n" +
"  outline: 0;\n" +
"  padding: 15px;\n" +
"  width: 100%;\n" +
"  background-color: #e8eeef;\n" +
"  color: #8a97a0;\n" +
"  box-shadow: 0 1px 0 rgba(0,0,0,0.03) inset;\n" +
"  margin-bottom: 30px;\n" +
"}\n" +
"input[type=\"date\"]{\n" +
"  background-color: #e8eeef;\n" +
"  width: 50%;\n" +
"  margin-bottom: 10px;\n" +
"}\n" +
"input[type=\"radio\"]{\n" +
"  margin: 0 4px 8px 0;\n" +
"}\n" +
"fieldset {\n" +
"  margin-bottom: 0px;\n" +
"  border: none;\n" +
"}\n" +
"label {\n" +
"  display: block;\n" +
"  margin-bottom: 8px;\n" +
"}\n" +
"#btn{\n" +
"  padding: 19px 39px 18px 39px;\n" +
"  color: #FFF;\n" +
"  background-color: #4bc970;\n" +
"  font-size: 18px;\n" +
"  text-align: center;\n" +
"  font-style: normal;\n" +
"  border-radius: 5px;\n" +
"  width: 40%;\n" +
"  border: 1px solid #3ac162;\n" +
"  border-width: 1px 1px 3px;\n" +
"}\n" +
"</style>\n" +
" </head>\n" +
"<body>\n" +
"<form action=\"PaymentPanel\" method=\"post\"><br>\n" +
"\n" +
"<h1>Welcome  to Payment Panel</h1>\n" +
" <fieldset>\n" +
"<label> Enter Email Or Username:</label>\n" +
"<input type=\"text\" value=\""+info.getEm()+"\" name=\"em\" required=\"\" style=\"width: 80%\"><input type=\"submit\" value=\"Go\" name=\"go\">\n" +
"\n" +
"<h4>and confirm the details below</h4>\n" +
"<label> First Name:</label>\n" +
"<input type=\"text\" value=\""+info.getFname()+"\" name=\"fn\" readonly=\"\">\n" +
" <label> Last Name:</label>\n" +
" <input type=\"text\" value=\""+info.getLname()+"\" name=\"ln\" readonly=\"\">\n" +
"<label> Aadhar No:</label>\n" +
" <input type=\"text\" value=\""+info.getAdhar()+"\" name=\"adhar\" readonly=\"\">\n" +
"<label> City:</label>\n" +
" <input type=\"text\" value=\""+info.getCity()+"\" name=\"cst\" readonly=\"\">\n" +
" <label> Mobile No:</label>\n" +
"  <input type=\"text\" value=\""+info.getMob()+"\" readonly=\"\">\n" +
" <label> Date:</label>\n" +
" <input id=\"meeting\" type=\"date\" value=\"select\" name=\"date\">\n" +
" <label> Payament Recieved:</label>\n" +
"  <input type=\"text\" name=\"pay\">\n" +
"  </fieldset>\n" +
" <input id=\"btn\" type=\"submit\" value=\"Make Payement\" name=\"make\" >\n" +
"  <input id=\"btn\" type=\"reset\" value=\"Clear\">\n" +
" </form>\n" +
"</body>\n" +
"</html>");
       
       
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
