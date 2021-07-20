package _80_WebService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/test")
public class Api {
    @GET
    public String test(){
        return "test";
    }
}
