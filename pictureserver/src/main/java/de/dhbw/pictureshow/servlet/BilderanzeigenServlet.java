package de.dhbw.pictureshow.servlet;

import de.dhbw.pictureshow.database.Transaction;
import de.dhbw.pictureshow.database.dao.FolderDao;
import de.dhbw.pictureshow.database.dao.PicturesDao;
import de.dhbw.pictureshow.domain.Folder;
import de.dhbw.pictureshow.domain.Pictures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.New;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by koeppent on 21.10.2014.
 */

@WebServlet("/Bilderanzeigen")


public class BilderanzeigenServlet extends HttpServlet {
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
  PicturesDao picturesDao;
  @Inject
  Transaction transaction;


  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    log.debug("BIlderanzeigenServlet get");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      HttpSession session = request.getSession(true);
      //String username = request.getParameter("user");
      String title = request.getParameter("title"); //hier bekommt man eingabe aus userfeld
      String username = (String) session.getAttribute("user");
      String userId = (String) request.getParameter("userid");

      Collection<Pictures> picturelist = picturesDao.findByUser(username);

      picturelist = new ArrayList<>(picturelist);
      //ArrayList<String> picturelist = new ArrayList<String>();
      for (Pictures item: picturelist){
        System.out.println("retrieved element: " + item);
      }


    //  picturelist = new ArrayList<>(picturelist); // cloning the read-only list so that we can add something
    //  picturelist.add(picturelist);
     // String url = "http://localhost:8087/pictureserver/startseite.jsp"; // Add alertmbox dass folder erfolgreich angelegt
     // response.sendRedirect(url);

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


