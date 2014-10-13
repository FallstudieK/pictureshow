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
            boolean loginTest = false;
            String  userName = request.getParameter("user"); //hier bekommt man eingabe aus userfeld
            String password = request.getParameter("password"); //hier wird HTML von Java aufgefangen
            String email = request.getParameter("email"); //hier wird HTML von Java aufgefangen

            transaction.begin();                        // muss begonnen werden bevor datenbank verwendet wird
            //Collection<USERS> userlist = userListDao.list();
            USERS user=null;
            Collection<USERS> userlist = userListDao.findByName(userName);
            transaction.commit();
            if(userlist.size()>0) {
                log.debug(userlist.toString());
                //user = userlist.iterator().next();


                //userlist = new ArrayList<>(userlist); // cloning the read-only list so that we can add something
                //userlist.add(user);

               for (USERS u : userlist) {
                if (userName.equals(u.getName())) {
                    if (password.equals(u.getPassword())) {

                    String url = "http://localhost:8087/pictureserver/startseite.html?userName=" + userName;
                    response.sendRedirect(url);
                    }
                else {
                    out.println("<h2> falsches Passwort </h2> </body> </html>");
                }}
            }}

            else{String url ="http://localhost:8087/pictureserver/Register.html?userName=" + userName;
                response.sendRedirect(url);}

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

