package de.dhbw.pictureshow.servlet;

import de.dhbw.pictureshow.database.Transaction;
import de.dhbw.pictureshow.database.dao.FolderDao;
import de.dhbw.pictureshow.database.dao.PicturesDao;
import de.dhbw.pictureshow.database.dao.UserDao;
import de.dhbw.pictureshow.database.dao.UserListDao;
import de.dhbw.pictureshow.domain.Folder;
import de.dhbw.pictureshow.domain.Pictures;
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

/**
 *
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
  private static final Logger log = LoggerFactory.getLogger(UserServlet.class);

  @Inject
  UserDao userDao;
  @Inject
  FolderDao folderDao;
  @Inject
  UserListDao userlistDao;
  @Inject
  PicturesDao picturesDao;
  @Inject
  Transaction transaction;


  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    log.debug("UserServlet get");

    transaction.begin();                        // muss begonnen werden bevor datenbank verwendet wird
    Collection<User> users = userDao.list();

    User user = new User();
    user.setName("User " + users.size());
    userDao.persist(user);

    Collection<Pictures> picturelist = picturesDao.list();

    Pictures picture1 = new Pictures();
    picture1.setTitle("Picture " + picturelist.size());
    picturesDao.persist(picture1);

    Collection<User> userlist = userlistDao.list();

    User user2 = new User();
    user2.setName("User " + userlist.size());
    userlistDao.persist(user2);


    Collection<Folder> folders = folderDao.list();
    Folder folder = new Folder();
    folder.setFname("Testname");
    folderDao.persist(folder);

    transaction.commit();

    users = new ArrayList<>(users); // cloning the read-only list so that we can add something
    users.add(user);


    response.setContentType("text/html");
    response.setBufferSize(8192);
    try (PrintWriter out = response.getWriter()) {
      out.println("<html lang=\"en\"><head><title>Servlet Hello</title></head>");

      // then write the data of the response
      out.println("<body  bgcolor=\"#ffffff\">"
          + "<h2>Known users:</h2>");

      for (User u : users) {
        out.println(u + "<br/>");
      }

      String username = request.getParameter("username");
      if (username != null && username.length() > 0) {
        RequestDispatcher dispatcher =
            getServletContext().getRequestDispatcher("/response");

        if (dispatcher != null) {
          dispatcher.include(request, response);
        }
      }
      out.println("</body></html>");
    }
  }

}
