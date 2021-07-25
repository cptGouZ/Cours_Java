package _80_WebService;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/webservice")
public class WebServiceConfig extends ResourceConfig {
    public WebServiceConfig(){
        //Il est possible d'ajouter des propriété ou des class à l'API
        //packages(package.to.add.to.webservice)
        //register(ClassToAddToWebService.class);
        //property(JerseyPropertiesFeature.RESSOURCE_PATH, "app.properties"
        //ceci avec un fichier app.properties contenant les propriétées perso
        register(MultiPartFeature.class);
        packages("_80_WebService");
    }
}

