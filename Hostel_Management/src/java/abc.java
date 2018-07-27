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
public class abc extends HttpServlet {

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
       if(request.getParameter("register")!=null){
       p.println("<head>\n" +
"        <meta charset=\"utf-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <title>Sign Up Form</title>\n" +
"      <style type=\"text/css\">\n" +
"        body {\n" +
"  font-family: sans-serif;\n" +
"  color: #384047;}\n" +
"  form {\n" +
"  max-width: 480px;\n" +
"  margin: 10px auto;\n" +
"  padding: 10px 20px;\n" +
"  background: #f4f7f8;\n" +
"  border-radius: 8px;\n" +
"}\n" +
"h1 {\n" +
"  margin: 0 0 30px 0;\n" +
"  text-align: center;\n" +
"}\n" +
"input[type=\"text\"],\n" +
"input[type=\"password\"],select {\n" +
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
"textarea{\n" +
"  background-color: #e8eeef;\n" +
"  width: 100%;\n" +
"\n" +
"}\n" +
"input[type=\"radio\"]{\n" +
"  margin: 0 4px 8px 0;\n" +
"}\n" +
"select {\n" +
"  padding: 6px;\n" +
"  height: 32px;\n" +
"  border-radius: 2px;\n" +
"}\n" +
"fieldset {\n" +
"  margin-bottom: 30px;\n" +
"  border: none;\n" +
"}\n" +
"legend {\n" +
"  font-size: 1.4em;\n" +
"  margin-bottom: 10px;\n" +
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
"\n" +
"\n" +
"      </style>\n" +
"    </head>\n" +
"    <body>\n" +
"\n" +
"      <form action=\"userRegister\" method=\"post\">\n" +
"      \n" +
"        <h1>Sign Up</h1>\n" +
"        \n" +
"        <fieldset>\n" +
"          <legend>Your basic info</legend>\n" +
"          <label> First Name:</label>\n" +
"          <input type=\"text\" name=\"fn\">\n" +
"\n" +
"           <label> Last Name:</label>\n" +
"          <input type=\"text\" name=\"ln\">\n" +
"\n" +
"           <label> Aadhar No:</label>\n" +
"          <input type=\"text\" name=\"adhar\">\n" +
"\n" +
"          <label>Gender:</label>\n" +
"        <input type=\"radio\" name=\"gender\" value=\"male\"> Male\n" +
"        <input type=\"radio\" name=\"gender\" value=\"female\"> Female\n" +
"           \n" +
"          <label>Email:</label>\n" +
"          <input type=\"text\" name=\"em\">\n" +
"\n" +
"          <label> Address:</label>\n" +
"          <textarea rows=\"4\" cols=\"50\" name=\"add\" ></textarea>\n" +
"\n" +
"           <label> City:</label>\n" +
"          <input type=\"text\"  name=\"cst\">\n" +
"\n" +
"           <label> State:</label>\n" +
"          <select name=\"st\">\n" +
"          <option>UP</option>\n" +
"          <option>MP</option>\n" +
"          <option>MAHARASTRA</option>\n" +
"          <option>DELHI</option>\n" +
"          </select>\n" +
"\n" +
"           <label> User Name:</label>\n" +
"          <input type=\"text\" name=\"un\">\n" +
"\n" +
"\n" +
"         <label>Password:</label>\n" +
"          <input type=\"password\" name=\"pw\">\n" +
"          \n" +
"           <label> Security Question:</label>\n" +
"          <select name=\"sec\">\n" +
"          <option>Your pet name?</option>\n" +
"          <option>Your Favorite Teacher Name?</option>\n" +
"          <option>Your Favorite Book Name?</option>\n" +
"          <option>Your Best Friend Name?</option>\n" +
"          </select>\n" +
"\n" +
"           <label> Answer:</label>\n" +
"          <input type=\"text\" name=\"ans\">\n" +
"\n" +
"           <label> Mobile No:</label>\n" +
"          <input type=\"text\" name=\"mob\">\n" +
"           </fieldset>\n" +
"        \n" +
"        \n" +
"        \n" +
"        \n" +
"        <input id=\"btn\" type=\"submit\" value=\"Sign up\" name=\"reg\">\n" +
"        <input id=\"btn\" type=\"reset\" value=\"Clear\">\n" +
"      </form>\n" +
"      <a href='hostelHome.html'>Go to Home Page</a>\n" +
"      \n" +
"    </body>\n" +
"</html>");
       }
       else{
       p.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no\">\n" +
"  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"  <title>Login form using Material Design - Demo by W3lessons</title>\n" +
"  <!-- CORE CSS-->\n" +
"  \n" +
"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css\">\n" +
"\n" +
"<style type=\"text/css\">\n" +
"html,\n" +
"body {\n" +
"    height: 100%;\n" +
"}\n" +
"html {\n" +
"    display: table;\n" +
"    margin: auto;\n" +
"}\n" +
"body {\n" +
"    display: table-cell;\n" +
"    vertical-align: middle;\n" +
"}\n" +
".margin {\n" +
"  margin: 0 !important;\n" +
"}\n" +
"</style>\n" +
"  \n" +
"</head>\n" +
"\n" +
"<body class=\"red\">\n" +
"\n" +
"\n" +
"  <div id=\"login-page\" class=\"row\">\n" +
"    <div class=\"col s12 z-depth-6 card-panel\">\n" +
"      <form class=\"login-form\" action=\"UserLogin\" method=\"post\">\n" +
"        <div class=\"row\">\n" +
"          <div class=\"input-field col s12 center\">\n" +
"            <img src=\"Images\\hostel-management-logo.png\" alt=\"\" class=\"responsive-img valign profile-image-login\">\n" +
"            <p class=\"center login-form-text\">Welcome...please log yourself in</p>\n" +
"          </div>\n" +
"        </div>\n" +
"        <div class=\"row margin\">\n" +
"          <div class=\"input-field col s12\">\n" +
"            <i class=\"mdi-social-person-outline prefix\"></i>\n" +
"            <input class=\"validate\" id=\"email\" type=\"text\" name=\"em\">\n" +
"            <label for=\"email\" data-error=\"wrong\" data-success=\"right\" class=\"center-align\">Email</label>\n" +
"           </div>\n" +
"           <p style=\"margin-left: 140px\">Or</p>\n" +
"            </div>\n" +
"       <div class=\"row margin\">\n" +
"          <div class=\"input-field col s12\">\n" +
"            <i class=\"mdi-social-person-outline prefix\"></i>\n" +
"            <input class=\"validate\" type=\"text\" name=\"Un\">\n" +
"            <label for=\"user\">User Name</label>\n" +
"           </div>\n" +
"        <div class=\"row margin\">\n" +
"          <div class=\"input-field col s12\">\n" +
"            <i class=\"mdi-action-lock-outline prefix\"></i>\n" +
"            <input id=\"password\" type=\"password\" name=\"pass\">\n" +
"            <label for=\"password\">Password</label>\n" +
"          </div>\n" +
"        </div>\n" +
"        <div class=\"row\">          \n" +
"          \n" +
"          </div>\n" +
"        </div>\n" +
"        <div class=\"row\" align=\"center\">\n" +
"          <div class=\"input-field col s14\">\n" +
"            <input type=\"Submit\" value=\"Login\" class=\"btn waves-effect waves-light col s12\" style=\"color: red\">\n" +
"          </div>\n" +
"\n" +
"        </div>\n" +
"        <div class=\"row\">\n" +
"          <div class=\"input-field col s6 m6 l6\">\n" +
"            <p class=\"margin medium-small\"><a href=\"signup.html\">Register Now!</a></p>\n" +
"          </div>\n" +
"          <div class=\"input-field col s6 m6 l6\">\n" +
"              <p class=\"margin right-align medium-small\"><a href=\"Forgot password.html\">Forgot password?</a></p>\n" +
"          </div>          \n" +
"        </div>\n" +
"\n" +
"      </form>\n" +
"    </div>\n" +
"  </div>\n" +
"\n" +
"\n" +
"  <center>\n" +
"    <script async src=\"//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js\"></script>\n" +
"<!-- Post Page - Responsive -->\n" +
"<ins class=\"adsbygoogle\"\n" +
"     style=\"display:inline-block;width:300px;height:250px\"\n" +
"     data-ad-client=\"ca-pub-5104998679826243\"\n" +
"     data-ad-slot=\"3470684978\"></ins>\n" +
"<script>\n" +
"(adsbygoogle = window.adsbygoogle || []).push({});\n" +
"</script>\n" +
"</center>\n" +
"\n" +
"\n" +
"\n" +
"  <!-- ================================================\n" +
"    Scripts\n" +
"    ================================================ -->\n" +
"\n" +
"  <!-- jQuery Library -->\n" +
" <script type=\"text/javascript\" src=\"//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\n" +
"  <!--materialize js-->\n" +
"  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/js/materialize.min.js\"></script>\n" +
"\n" +
"  <script>\n" +
"  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\n" +
"  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\n" +
"  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\n" +
"  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');\n" +
"\n" +
"  ga('create', 'UA-27820211-3', 'auto');\n" +
"  ga('send', 'pageview');\n" +
"\n" +
"</script><script src=\"//load.sumome.com/\" data-sumo-site-id=\"1cf2c3d548b156a57050bff06ee37284c67d0884b086bebd8e957ca1c34e99a1\" async=\"async\"></script>\n" +
"\n" +
"\n" +
"   <footer class=\"page-footer\">\n" +
"          <div class=\"footer-copyright\">\n" +
"            <div class=\"container\">\n" +
"            © 2017 Aakash@Developers.\n" +
"            \n" +
"            </div>\n" +
"          </div>\n" +
"  </footer>\n" +
"</body>\n" +
"\n" +
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
