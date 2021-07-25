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
public class Medias {
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

    @POST @Path("/postJson")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(LinkedHashMap<String, Object> json) {
        for (Map.Entry<String, Object> entry : json.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + value);
        }
        if((new Date()).getTime()%2 == 0) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }else{
            return Response.ok(new Bean(), MediaType.APPLICATION_JSON).build();
        }
    }
    //Méthode d'ajout d'un fichier sur le serveur
    @POST @Path("/addFile")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public Response setFile(@FormDataParam("userName") String userName,
                            @FormDataParam("checkBox") boolean checkBoxValue,
                            @FormDataParam("file") InputStream fis,
                            @FormDataParam("file") FormDataContentDisposition fileMetaData) throws Exception {
        String UPLOAD_PATH = "C:\\Users\\Julien\\Pictures\\";
        try
        {
            int read = 0;
            byte[] bytes = new byte[1024];
            OutputStream out = new FileOutputStream(new File(UPLOAD_PATH + fileMetaData.getFileName()));
            while ((read = fis.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e){
            throw new WebApplicationException("Error while uploading file. Please try again !!");
        }
        return Response.ok("Data uploaded successfully !!").build();
    }
}
