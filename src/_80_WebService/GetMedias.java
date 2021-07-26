package _80_WebService;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.validation.constraints.NotEmpty;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedSet;

@Path("/medias")
public class GetMedias {
    //Retour de texte
    @GET @Path("/getText")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getText(){
        return Response.ok("Ma chaine").build();
    }
    //Retour d'objet au jormat JSON
    @GET @Path("/getJson")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(){
        return Response.ok(new Bean()).build();
    }
    //Retour d'objet au format XML
    @GET @Path("/getXml")
    @Produces(MediaType.APPLICATION_XML)
    public Response getXml(){
        return Response.ok(new Bean()).build();
    }
    //Retour de fichier
    @GET @Path("/getFile")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getFile(){
        File file = new File("C:\\Users\\Julien\\Pictures\\2020-05-03 21_10_18-Elite - Dangerous (CLIENT).png");
        return Response.ok(file).build();
    }


}
