package _80_WebService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedHashMap;
import java.util.Map;


@Path("/test")
public class Api {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Bean test(){
        return new Bean();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(LinkedHashMap<String, Object> json) {

        Response.ResponseBuilder response = Response.status(Response.Status.NO_CONTENT); //PUT defaults to no content

        for (Map.Entry<String, Object> entry : json.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + value);
            if(key.equalsIgnoreCase("action")) {
                response.entity("{\"status\":\"ok\"}");
            }
        }
        return response.build();
    }
}
