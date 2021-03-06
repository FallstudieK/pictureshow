package de.dhbw.pictureshow.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.dhbw.pictureshow.database.Transaction;
import de.dhbw.pictureshow.database.dao.FolderDao;
import de.dhbw.pictureshow.database.dao.PicturesDao;
import de.dhbw.pictureshow.database.dao.UserListDao;
import de.dhbw.pictureshow.domain.Folder;
import de.dhbw.pictureshow.domain.Pictures;
import de.dhbw.pictureshow.domain.User;
import de.dhbw.pictureshow.domain.UuidId;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * A Java servlet that handles file upload from client.
 *
 * @author www.codejava.net
 */

@WebServlet(name = "Upload", urlPatterns = {"/uploadFile"})

public class FileUploadServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(RegisterServlet.class);
    @Inject
    UserListDao userlistDao;
    @Inject
    FolderDao folderDao;
    @Inject
    Transaction transaction;
    @Inject
    PicturesDao picturesDao;
    private static final long serialVersionUID = 1L;

    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "upload";

    // upload settings
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

    /**
     * Upon receiving file upload submission, parses the request to read
     * upload data and saves the file on disk.
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // checks if the request actually contains upload file

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(true); //des user ist jetzt die Session zugeordnet worden
        String username = (String) session.getAttribute("user");
        String title = request.getParameter("title");
        // UuidId userId = (UuidId) session.getAttribute("user_id");
        //  User loggedin = null;
        //  Collection<USERS> userlist= UserListDao.findByEmail("email");
        //  loggedin =userlist.iterator().next();
        if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }

        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        // factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        File file2 = new File("upload");        //not temporary file
        file2.createNewFile();
        log.debug(file2.toString());
        ServletFileUpload upload = new ServletFileUpload(factory);

        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // constructs the directory path to store upload file
        // this path is relative to application's directory
        //   String uploadPath = getServletContext().getRealPath("")
        //    + File.separator + file2;//UPLOAD_DIRECTORY; instead of file 2 for temp path
        //String uploadPath = "C:\\Users\\koeppent\\Desktop\\Fallstudie\\PictureShow\\pictureserver\\uploadbilder";
        String uploadPath = "C:/bilder/"+username;
        log.debug(uploadPath.toString());

        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            // parses the request's content to extract file data
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
            log.debug(formItems.toString());
            if (formItems != null && formItems.size() > 0) {
                // iterates over form's fields
                for (FileItem item : formItems) {
                    // processes only fields that are not form fields
                    if (!item.isFormField()) {

                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        String bildname = fileName.substring(0, fileName.length() - 4);
                        transaction.begin();
                        Pictures picture1 = new Pictures();
                        picture1.setTitle(bildname);
                        picture1.setUsername(username);
                        // picture1.setUser(userId);
                        picture1.setFoldername("Standard");
                        picturesDao.persist(picture1);

                        transaction.commit();


                        // saves the file on disk
                        item.write(storeFile);
                        request.setAttribute("message",
                                "Upload has been done successfully!");
                    }
                }
            }
        } catch (Exception ex) {
            request.setAttribute("message",
                    "There was an error: " + ex.getMessage());
        }
        // redirects client to message page
        getServletContext().getRequestDispatcher("/message.jsp").forward(
                request, response);
    }
}
