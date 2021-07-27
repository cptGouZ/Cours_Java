//http://localhost:8080/Cours_Java_Web_exploded/WebService/Produces.html
package _80_WebService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;

@Path("/produce")
public class Produce {
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
