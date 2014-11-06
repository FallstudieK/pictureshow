package de.dhbw.pictureshow.rest;

import com.google.gson.Gson;
import de.dhbw.pictureshow.database.Transaction;
import de.dhbw.pictureshow.database.dao.FolderDao;
import de.dhbw.pictureshow.database.dao.PicturesDao;
import de.dhbw.pictureshow.database.dao.UserDao;
import de.dhbw.pictureshow.domain.Folder;
import de.dhbw.pictureshow.domain.Pictures;
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
import java.util.Collection;
import java.util.List;

import static de.dhbw.pictureshow.database.dao.UserDao.*;

/**
 * Created by zaiser on 05.11.2014.
 */

@WebServlet(name="minBilder", urlPatterns ={"/BilderService"})
public class BilderService extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Inject UserDao userDao;
    @Inject Transaction transaction;
    @Inject PicturesDao picturesDao;
    @Inject FolderDao folderDao;


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String albumname = request.getParameter("album");               //angefordertes album aus url auslesen
        log.debug(albumname);

        HttpSession session = request.getSession(true);
        String user= (String) session.getAttribute("user");
        log.debug(user);//  Nutzerobjekt suchen mit Email - Nutzer herausfinden
        User angemeldet = null;
        Collection<User> meineUsers = userDao.findByName(user);
        angemeldet = meineUsers.iterator().next();
        log.debug(angemeldet.getName());

       // Collection<Folder> alben = FolderDao.findByTitleUser(albumname, angemeldet);
       // Folder album=alben.iterator().next();
       // List<Pictures> picture = PicturesDao.findByAlbum(album);
        Collection <Pictures> picturelist = picturesDao.findByUser(angemeldet.getName());

        String json = new Gson().toJson(picturelist);                 //Umwandeln des Java Bildobjektes mit GSON in JSON für JavaScript
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

}