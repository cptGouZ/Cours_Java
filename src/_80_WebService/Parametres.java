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
    @GET @Path("/queryParam")
    public String getQueryParam (@QueryParam("queryParamKey") String parametre){
        return parametre;
    }

    //http://localhost:8080/Cours_Java_Web_exploded/webservice/parametres/pathparam/pathParamValue
    //Ce type de paramètre peut également être inclus dans le @Path de la classe
    //Il est possible d'ajouter une expression régulière après le nom deu paramètre pour en faire la vérification {param: \w{5,10}}
    @GET @Path("/pathParam/{pathParamKey}")
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
    public String formParam(@FormParam("formInputName") String parametre){
        return parametre;
    }

    //http://localhost:8080/Cours_Java_Web_exploded/webservice/parametres/beanParam
    @POST @Path("/beanParam")
    public String postBean(@BeanParam Bean bean){
        return bean.getPrenom() + bean.getId();
    }


    //Il est également possible de définir des variables de classe qui proviennent des paramètres de la requête avec une valeur par défaut
    @DefaultValue("valeurDeParametreParDefaut")
    @QueryParam("queryParamClass")
    private String queryParamClass;
    @DefaultValue("valeurDeCookieParDefaut")
    @CookieParam("cookieParamClass")
    private String cookieParamClass;
    //http://localhost:8080/Cours_Java_Web_exploded/webservice/parametres?queryParamClass=queryValue
    @GET
    public String getParamClass(){
        return queryParamClass + ' ' + cookieParamClass;
    }
}
