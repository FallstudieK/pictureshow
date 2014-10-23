package de.dhbw.pictureshow.servlet;

import de.dhbw.pictureshow.database.Transaction;
import de.dhbw.pictureshow.database.dao.PicturesDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.ws.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Identity;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.*;
import javax.ws.rs.core.Response.Status;
/**
 * Created by koeppent on 07.10.2014.
 */
@WebServlet("/savepicture")
public class SavePictureServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UserServlet.class);

    @Inject
    PicturesDao picturesDao;
    @Inject
    Transaction transaction;


   /* protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.debug("RegisterServlet get");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String userName = request.getParameter("user"); //hier bekommt man eingabe aus userfeld
            String password = request.getParameter("password"); //hier wird HTML von Java aufgefangen
            String email = request.getParameter("email"); //hier wird HTML von Java aufgefangen


            transaction.begin();                        // muss begonnen werden bevor datenbank verwendet wird
            Collection<PICTURE> pictures = PictureDao.list();

            PICTURE picture = new PICTURE();
            picture.setTitle(userName);
            picture.setUsername(email);
            picture.setPicture(byte [] );
            PictureDao.persist(picture);
            transaction.commit();
            log.debug("Commit Successful");


        } finally {
            if (out != null) {
                out.close();
            }
        }
    } */






   /* @POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.debug("SavePictureServlet post");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

        BufferedReader reader = request.getReader();
        String str = "";
        while ((str = reader.readLine()) != null) {
            out.println(str);
        }

        String file = request.getParameter("file");
           out.println("<html> <body>TEST TEST TEST TEST TEST");
        out.println(file + "</body> </html> ");
    }finally {
            if (out != null) {
                out.close();
    }}}*/

   /* @XmlRootElement
    public class MyJaxBean {
        @XmlElement public String param1;
        @XmlElement public String param2;
    }

    @POST @Consumes("application/json")
    @Path("/create")
    public void create(final MyJaxBean input) {
        System.out.println("param1 = " + input.param1);
        System.out.println("param2 = " + input.param2);
    }*/

/*    @POST
   public

        JOptionPane.showMessageDialog(null, "Test", "Test Titel", JOptionPane.OK_CANCEL_OPTION);


    };*/
    // class get(){

/*




    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("UserServlet get");
/*
        try
        {
            String strpath=request.getParameter("Image");
            String filepath=strpath.substring(strpath.lastIndexOf("\\")+1);
            PICTURE imgfile = new PICTURE(strpath);
            FileInputStream fin = new FileInputStream(imgfile);
            Connection connection=null;
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            PreparedStatement pre = connection.prepareStatement("insert into PICTURE(username,picture) values(?,?)");
            pre.setUsername(1,);
            //pre.setBinaryStream(1,fin,(int)imgfile.length());
           // pre.setString(2,filepath);
            pre.setLong(2,imgfile.length());
            pre.executeUpdate();
            pre.close();
            String L_url1=response.encodeRedirectURL("Device.jsp");
            response.sendRedirect(L_url1);
        }
        catch(Exception ex){
            System.out.println("Exception in InsertImage : "+ex.getMessage());
        }
    }

*/


    // String file = request.getParameter("files[]");

    // transaction.begin();                        // muss begonnen werden bevor datenbank verwendet wird
    //Collection<PICTURE> pictures = pictureDao.list();

    // PICTURE picture = new PICTURE();
    // picture.setTitle("BILD " + Math.random());
    // picture.setUsername(userName);
    //  picture.setFile(fileName);
    //  pictureDao.persist(picture);
    //  transaction.commit();

    // pictures = new ArrayList<>(pictures); // cloning the read-only list so that we can add something
    // pictures.add(picture);


    //  response.setContentType("text/html");
    //response.setBufferSize(8192);
    // try (PrintWriter out = response.getWriter()) {
    //   out.println("<html lang=\"en\"><head><title>Servlet Hello</title></head>");

    // then write the data of the response
    //  out.println("<body " + file +
    //  "<form name=\"input\"  action=\"/pictureserver/picture\" method=\"get\">  " +
    //        "<input type=\"hidden\" name=\"userName\" value="+ file +" /> " +
    //    "<input type=\"submit\" value=\"Zu meinen Bildern\"> </form>");

    // for(PICTURE p: pictures) {
    //   out.println(p + "<br/>");
    //}

    //  String username = request.getParameter("username");
    // if (username != null && username.length() > 0) {
    //  RequestDispatcher dispatcher =
                /*        getServletContext().getRequestDispatcher("/response");

                if (dispatcher != null) {
                    dispatcher.include(request, response);
                }
            }
            out.println("</body></html>");
        }
    }*/

}