package com.techonologycoop;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("check")
public class MyResource {


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(@QueryParam("url") String url) {
        return url;
    }
}
