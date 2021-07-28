/*
https://eclipse-ee4j.github.io/jersey.github.io/documentation/latest/jaxrs-resources.html
GET : Récupération d’une ressource;
POST : Ajout d’une ressource;
PUT : Mise à jour complète d’une ressource;
PUT : Mise à jour partielle d’une ressource;
DELETE : Suppression d’une ressource;
HEAD : Similaire à GET, mais permet uniquement de récupérer les en-têtes HTTP.
*/

package _80_WebService;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/test/{userId}")
public class Demo {
    @DefaultValue("158")
    @QueryParam("userId")
    private int userId;

}
