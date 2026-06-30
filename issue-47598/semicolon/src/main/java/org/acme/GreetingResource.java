package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;
import org.jboss.resteasy.reactive.RestMatrix;
import org.jboss.resteasy.reactive.RestQuery;

import java.net.URI;

@Path("")
public class GreetingResource {

    @Path("ex")
    @GET
    public String ex(UriInfo uriInfo, @RestMatrix String m1, @RestMatrix String m2, @RestQuery String q1, @RestQuery String q2) {
        return "ex: "+uriInfo.getRequestUri()
                + " m1: "+m1
                + " m2: "+m2
                + " q1: "+q1
                + " q2: "+q2
                +" query params: "+uriInfo.getQueryParameters()
                + " segments: " + uriInfo.getPathSegments()
                + " matrix params: "+uriInfo.getPathSegments().get(0).getMatrixParameters();
    }
}
