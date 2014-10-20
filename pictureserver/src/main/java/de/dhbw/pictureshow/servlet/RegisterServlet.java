package de.dhbw.pictureshow.servlet;

import de.dhbw.pictureshow.database.Transaction;
import de.dhbw.pictureshow.database.dao.UserDao;
import de.dhbw.pictureshow.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(RegisterServlet.class);
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
        log.debug("RegisterServlet get");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String userName = request.getParameter("user"); //hier bekommt man eingabe aus userfeld
            String password = request.getParameter("password"); //hier wird HTML von Java aufgefangen
            String email = request.getParameter("email"); //hier wird HTML von Java aufgefangen
            transaction.begin();                        // muss begonnen werden bevor datenbank verwendet wird

          Collection<User> userlist = userDao.findByName(userName);
          log.debug(userlist.toString());
            User loggedin = null;


          if(userlist.isEmpty()){

          User user = new User();
            user.setName(userName);
            user.setEmail(email);
            user.setPassword(password);
            userDao.persist(user);
            transaction.commit();
            log.debug("Commit Successful");

            String url = "http://localhost:8087/pictureserver/startseite.jsp";

            HttpSession session = request.getSession(); //des user ist jetzt die Session zugeordnet worden
            session.setAttribute ("user", userName);
            session.setAttribute("email", user.getEmail());
            log.debug("Session Successful");
            response.sendRedirect(url);


        }else{

            loggedin = userlist.iterator().next();
            String url = "http://localhost:8087/pictureserver/Login.html";
            response.sendRedirect(url);
            }}
        finally {
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

