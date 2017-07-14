package com.xardas008.swagger.swaggeruiserver.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * Provider for returning multiple {@link SwaggerResource}
 */
@Component
@Primary
public class MultipleRessourcesProvider implements SwaggerResourcesProvider {

    @Value("#{${swagger.ressources}}")
    private Map<String, String> resources;

    /**
     * Returns a list of {@link SwaggerResource}. The resources are provided through a property inside application.property.
     * One SwaggerResource has to conform to the following scheme
     * key:value,key:value
     * whereas key is the name of the service and value has to conform the following scheme:
     * http(s)://server:port/path/to/swagger.json~apiVersion
     * The ~ is very important here, because this will determine the version of the api.
     *
     * Example:
     * <p>
     *     {'PetClinic':'http://localhost:8080/api/swagger.json~1.0','PetClinicShop':'http://localhost:8180/api/swagger.json~2.0'}
     * </p>
     * @return
     */
    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> res = new ArrayList<>();
        for (String key : this.resources.keySet()) {
            String value = this.resources.get(key);
            String[] pair = value.split("~");   // The value part of the map has the form url~version, ~ is the delimiter here so we can get the version of the service here.
            res.add(swaggerResource(key, pair[0], pair[1]));
        }

        return res;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setLocation(location);
        swaggerResource.setName(name);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
