package _80_WebService;

import com.sun.xml.internal.ws.client.sei.ResponseBuilder;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test")
public class Api {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Bean test(){
        System.out.println("tata");
        return new Bean();
    }

    @POST
    @Path("/{param}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(@PathParam("param") String json) {
        System.out.println(json);
    }
}
