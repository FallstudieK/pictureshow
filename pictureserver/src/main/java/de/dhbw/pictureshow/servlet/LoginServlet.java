package de.dhbw.pictureshow.servlet;

import de.dhbw.pictureshow.database.Transaction;
import de.dhbw.pictureshow.database.dao.UserDao;
import de.dhbw.pictureshow.database.dao.UserListDao;
import de.dhbw.pictureshow.domain.USERS;
import de.dhbw.pictureshow.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(LoginServlet.class);
    /**
     * Processes requests for both HTTP //post und get werden durch eine Methode aufgenommen
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    @Inject
    UserListDao userListDao;
    @Inject
    Transaction transaction;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.debug("LoginServlet get");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head><title>Login!</title></head>");
            out.println("<body>"); //in body sind die Java Befehle
           String  userName = request.getParameter("user"); //hier bekommt man eingabe aus userfeld
            String password = request.getParameter("password"); //hier wird HTML von Java aufgefangen
            String email = request.getParameter("email"); //hier wird HTML von Java aufgefangen


            out.println("<html> <head> <title> Erfolgreich Registriert! </title> " +
                    "<h1> Herzlichen Glückwunsch " + userName + "! </h1> </head> " +
                    "<body> Du hast dich erfolgreich angemeldet! </br>" +
                    "<a href=\"userlist?userName=" + userName +"\"> Alle User anzeigen. </a> </body> </html>");



            // if (userName != null && !userName.trim().isEmpty()) { //Prüfen: ist was in die Felder eingefügt worden
            // Name vorhanden -> begruessen
            // out.println("<h2>Hallo " + userName + "!</h2>"); //Printed: Namen den man eingegeben hat
            //out.println("<a href=\"login\">Zurück</a>"); //Link mit Zurück implementiert

            //String def_user ="Chani";
            //String def_password="1234";

            //transaction.begin();                        // muss begonnen werden bevor datenbank verwendet wird
            //Collection<USERS> userlist = userListDao.list();

            //USERS user = new USERS();
            //user.setName(userName);
            //user.setEmail(email);
           // user.setPassword(password);
            //userListDao.persist(user);
            //transaction.commit();


           // if (userName != null && !userName.trim().isEmpty()) {
             //   if (userName.equals(def_user) && password.equals(def_password)) { //Prüfen: ist was in die Felder eingefügt worden
                    // Name vorhanden -> begruessen
               //     out.println("<h2>Hallo " + userName + "!</h2>"); //Printed: Namen den man eingegeben hat
                 //   out.println("<a href=\"login\">Zurück</a>"); //Link mit Zurück implementiert
                //}
            //}else {
                // kein Name -> Eingabeformular anzeigen
               // out.println("<h2>Anmeldungsseite</h2>"); //h2 ist die Übeschrift
               // out.println("<form method=\"POST\" action=\"login\">");//formular wird ausgegeben; hier post methode
              //  out.println("Benutzer");
              //  out.println("<input type=\"text\" name=\"user\">");//inputfeld text für user
              //  out.println("E-mail:");
            // out.println("<input type=\"email\" name=\"email\">");//inputfeld text für user
              //  out.println("Passwort");
              //  out.println("<input type=\"password\" name=\"password\">");//input feld text für user
                //out.println("<input type=\"submit\" value=\"Login\">");//submit Button
              //  out.println("</form>");
            //}
          // out.println("</body>");
           // out.println("</html>");
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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

