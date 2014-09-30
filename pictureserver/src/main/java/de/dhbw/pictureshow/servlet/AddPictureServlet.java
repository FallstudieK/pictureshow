package de.dhbw.pictureshow.servlet;

import de.dhbw.pictureshow.database.Transaction;
import de.dhbw.pictureshow.database.dao.PictureDao;
import de.dhbw.pictureshow.database.dao.UserDao;
import de.dhbw.pictureshow.domain.PICTURE;
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
@WebServlet("/addpicture")
public class AddPictureServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UserServlet.class);

    @Inject
    PictureDao pictureDao;
    @Inject Transaction transaction;


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("UserServlet get");

        String userName = request.getParameter("userName");
        transaction.begin();                        // muss begonnen werden bevor datenbank verwendet wird
        Collection<PICTURE> pictures = pictureDao.list();

        PICTURE picture = new PICTURE();
        picture.setTitle("BILD " + Math.random());
        picture.setUsername(userName);
        pictureDao.persist(picture);
        transaction.commit();

        pictures = new ArrayList<>(pictures); // cloning the read-only list so that we can add something
        pictures.add(picture);


        response.setContentType("text/html");
        response.setBufferSize(8192);
        try (PrintWriter out = response.getWriter()) {
            out.println("<html lang=\"en\"><head><title>Servlet Hello</title></head>");

            // then write the data of the response
            out.println("<body  bgcolor=\"#ffffff\">"
                    + "<h2>Added Picture:</h2>");
            out.println(picture);

           // for(PICTURE p: pictures) {
             //   out.println(p + "<br/>");
            //}

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