package com.palthomassen.synnedata.resources;

import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/synne")
@Produces(MediaType.TEXT_HTML)
public class HTMLView {

    @GET
    @Timed
    public ViewTemplateRender getSynneData() {
        return new ViewTemplateRender();
    }
}
