//http://localhost:8080/Cours_Java_Web_exploded/WebService/Parametres.html
//https://dennis-xlc.gitbooks.io/restful-java-with-jax-rs-2-0-2rd-edition/content/en/part1/chapter5/jax_rs_injection.html
package _80_WebService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.Providers;

@Path("/parametres")
public class Parametres {
    //http://localhost:8080/Cours_Java_Web_exploded/webservice/parametres/queryparam?queryParamKey=queryParamValue
    @GET @Path("/queryparam")
    public String getQueryParam (@QueryParam("queryParamKey") String parametre){
        return parametre;
    }

    //http://localhost:8080/Cours_Java_Web_exploded/webservice/parametres/pathparam/pathParamValue
    @GET @Path("/pathparam/{pathParamKey}")
    public String getPathParam (@PathParam("pathParamKey") String parametre){
        return parametre;
    }

    //http://localhost:8080/Cours_Java_Web_exploded/webservice/parametres/cookieParam
    @GET @Path("/cookieParam")
    public String getCookieParam (@CookieParam("cookieParam") String parametre){
        return parametre;
    }

    //http://localhost:8080/Cours_Java_Web_exploded/webservice/parametres/headerParam
    //Cette méthode permet d'accéder à un élément spécifique du header de la requête reçue.
    //Faire F12 sur chrome pour la liste des paramètres contenus dans le header.
    @GET @Path("/headerParam")
    public String getHeaderParam (@HeaderParam("accept") String parametre){
        return parametre;
    }

    //http://localhost:8080/Cours_Java_Web_exploded/webservice/parametres/contextParam
    @GET @Path("/contextParam")
    public String getContextParam(@Context UriInfo uriInfo,
                                    @Context HttpHeaders httpHeaders,
                                    @Context SecurityContext securityContext,
                                    @Context ResourceContext resourceContext,
                                    @Context Request request,
                                    @Context Application application,
                                    @Context Configuration configuration,
                                    @Context Providers providers,
                                    @Context HttpServletRequest httpServletRequest,
                                    @Context HttpServletResponse httpServletResponse,
                                    @Context ServletContext servletContext,
                                    @Context ServletConfig servletConfig,
                                    @Context MediaType mediaType){
        return "beaucoup d'infos possibles";
    }

    //http://localhost:8080/Cours_Java_Web_exploded/webservice/parametres/formParam
    @POST @Path("/formParam")
    public String formParam(@FormParam("formParamKey") String parametre){
        return parametre;
    }

    //http://localhost:8080/Cours_Java_Web_exploded/webservice/parametres/beanParam
    @POST @Path("/beanParam")
    public String postBean(@BeanParam Bean bean){
        return bean.getPrenom() + bean.getId();
    }
}
