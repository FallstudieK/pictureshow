package de.dhbw.pictureshow.servlet;

import de.dhbw.pictureshow.database.Transaction;
import de.dhbw.pictureshow.database.dao.PicturesDao;
import de.dhbw.pictureshow.domain.Pictures;
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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 */
@WebServlet("/picture")
public class PictureServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UserServlet.class);

    @Inject
    PicturesDao picturesDao;
    @Inject
    Transaction transaction;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("PictureServlet get");

        transaction.begin();                        // muss begonnen werden bevor datenbank verwendet wird
        Collection<Pictures> pictures = picturesDao.list();


        pictures = new ArrayList<>(pictures); // cloning the read-only list so that we can add something


        String  userName = request.getParameter("userName");
        response.setContentType("text/html");
        response.setBufferSize(8192);
        try (PrintWriter out = response.getWriter()) {
            out.println("<html lang=\"en\"><head><title>Picture</title></head>");

            // then write the data of the response
            out.println("<body  bgcolor=\"#ffffff\">"
                    + "<h2>Hallo " + userName + " Deine Bilder:</h2>");


            for (Pictures p : pictures) {
                String pictureOwner = "test";       ///test muss durch user ersetzt werden, der über uuid zum entsprechendem bild gehört
                if (userName.equals(pictureOwner)) {
                    out.println(p + "<br/>");
                }
            }

                   // for (PICTURE p : pictures) {
                    //    out.println(p + "<br/>");
                    //}


                    // String username = request.getParameter("username");
                    if (userName != null && userName.length() > 0) {
                        RequestDispatcher dispatcher =
                                getServletContext().getRequestDispatcher("/response");

                        if (dispatcher != null) {
                            dispatcher.include(request, response);
                        }
                    }
                    out.println("</body></html>");
                    transaction.commit();
                }
            }

        }