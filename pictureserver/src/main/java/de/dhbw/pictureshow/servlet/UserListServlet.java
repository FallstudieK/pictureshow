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

/**
 * Created by koeppent on 25.09.2014.
 */

@WebServlet("/userlist")
public class UserListServlet extends HttpServlet{
        private static final Logger log = LoggerFactory.getLogger(UserListServlet.class);

        @Inject
        UserListDao userListDao;
        @Inject
        Transaction transaction;


        @Override
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            log.debug("UserListServlet get");

            transaction.begin();                        // muss begonnen werden bevor datenbank verwendet wird
            Collection<USERS> userlist = userListDao.list();

            //USERS user = new USERS();
            //user.setName("User " + userlist.size());
            //userListDao.persist(user);
            transaction.commit();

           userlist = new ArrayList<>(userlist); // cloning the read-only list so that we can add something
           //userlist.add(user);

            String  userName = request.getParameter("userName");
            response.setContentType("text/html");
            response.setBufferSize(8192);
            try (PrintWriter out = response.getWriter()) {
                out.println("<html lang=\"en\"><head><title>Benutzerliste </title></head>");
                out.println("<form name=\"input\" method=\"Get\" action=\"/pictureserver/picture?userName=" + userName +"\">  " +
                                "<input type=\"submit\" value=\"Zu meinen Bildern\"> </form>");
                out.println("<form name=\"input\" method=\"Get\" action=\"/pictureserver/addpicture\">  " +
                        "<input type=\"submit\" value=\"Bild hinzufügen\">" +
                        //"<input type=\"hidden\" value=userName " +
                        " </form>");
                // then write the data of the response
                out.println("<body  bgcolor=\"#ffffff\">"
                        + "<h2>Liste aller Benutzer: "+ userName + "</br> </h2>" +
                        "<h3>E-mail ; Passwort</h3>");

                for(USERS u: userlist) {
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
