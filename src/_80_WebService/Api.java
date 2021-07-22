package _80_WebService;

import _30_Design_Patterns.AbstractFactory.bo.ProductA1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class Api {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Bean test(){
        return new Bean();
    }
}
