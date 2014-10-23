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

/**
 * Created by koeppent on 23.10.2014.
 */

@WebServlet("/logout")
public class LogoutServlet  extends HttpServlet {
  private static final Logger log = LoggerFactory.getLogger(LoginServlet.class);
  /**
   * Processes requests for both HTTP //post und get werden durch eine Methode aufgenommen
   * <code>GET</code> and
   * <code>POST</code> methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws javax.servlet.ServletException if a servlet-specific error occurs
   * @throws java.io.IOException if an I/O error occurs
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



      HttpSession session = request.getSession(true);
      session.invalidate();
      String url = "http://localhost:8087/pictureserver/Logout.html";
        response.sendRedirect(url);


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
   * @param request  servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException      if an I/O error occurs
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
   * @param request  servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurso
   * @throws IOException      if an I/O error occurs
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

