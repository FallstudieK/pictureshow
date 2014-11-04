package de.dhbw.pictureshow.rest;

import groovy.lang.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import de.dhbw.pictureshow.database.dao.UserDao;
import de.dhbw.pictureshow.domain.User;
import de.dhbw.pictureshow.domain.UuidId;
import groovy.lang.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;


/**
 * Created by mangelma on 04.11.2014.
 */

    @Path("/api/bild")
    @Produces({"application/json"}) // mime type "text/xml",
    @Singleton
    public class BildService {
        private static final Logger log = LoggerFactory.getLogger(UserService.class);

        //@Path("/list")
        @GET
        @Path("{userid}/{bild}")
        @Produces("image/jpeg")
        public Response getBild(@PathParam("userid") String uid, @PathParam("bild") String bildId) throws IOException {
            String path = "c:/bilder/" + uid + "/" + bildId + ".jpg";
            File file = new File(path);
            return Response.ok(new FileInputStream(file)).build();
        }

    }


