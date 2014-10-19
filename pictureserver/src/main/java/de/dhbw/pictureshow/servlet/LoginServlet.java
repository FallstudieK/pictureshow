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
import javax.servlet.http.HttpSession;
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
    UserDao userDao;
    @Inject
    Transaction transaction;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.debug("LoginServlet get");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String  userName = request.getParameter("user"); //hier bekommt man eingabe aus userfeld
            String password = request.getParameter("password"); //hier wird HTML von Java aufgefangen
            String email = request.getParameter("email"); //hier wird HTML von Java aufgefangen

            //transaction.begin();                        // muss begonnen werden bevor datenbank verwendet wird
            User loggedin = null;
            User user=null;
                Collection<User> userlist = userDao.findByName(userName);
            loggedin = userlist.iterator().next();
           // transaction.commit();

            if(userlist.size()>0) {
                log.debug(userlist.toString());
                //user= userlist.iterator().next();
                //log.debug(user.toString());
                for (User u : userlist) {
                    if (userName.equals(u.getName())) {
                        if (password.equals(u.getPassword())) {
                            String url = "http://localhost:8087/pictureserver/startseite.jsp";

                            HttpSession session = request.getSession(); //des user ist jetzt die Session zugeordnet worden
                            session.setAttribute ("user", userName);
                            session.setAttribute("email", loggedin.getEmail());

                            response.sendRedirect(url);
                        }
                    else {

                        String url ="http://localhost:8087/pictureserver/Login.html?userName=" + userName + "&msg=FalschesPasswort";
                        response.sendRedirect(url);
                    }
                    }
                }
            }
            else{
                String url ="http://localhost:8087/pictureserver/Register.html?userName=" + userName;
                response.sendRedirect(url);
            }



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

