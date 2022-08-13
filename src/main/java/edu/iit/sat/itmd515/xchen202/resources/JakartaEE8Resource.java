package edu.iit.sat.itmd515.xchen202.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * program default creates the file
 */
@Path("rest")
public class JakartaEE8Resource {

    /**
     *
     * @return
     */
    @GET
    public Response ping() {
        return Response
                .ok("ping")
                .build();
    }
}
