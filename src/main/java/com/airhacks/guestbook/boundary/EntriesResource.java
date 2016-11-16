
package com.airhacks.guestbook.boundary;

import com.airhacks.guestbook.entity.GuestEntry;
import com.airhacks.guestbook.entity.GuestEntryContent;
import java.net.URI;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Path("entries")
public class EntriesResource {

    @Inject
    GuestService service;

    @GET
    public List<GuestEntry> all() {
        return service.all();
    }

    @GET
    @Path("{id}")
    public GuestEntry find(@PathParam("id") long id) {
        return this.service.find(id);
    }

    @POST
    public Response save(@GuestEntryContent GuestEntry entry, @Context UriInfo info) {
        GuestEntry created = this.service.save(entry);
        long id = created.getId();
        URI uri = info.
                getAbsolutePathBuilder().
                path("/" + id).
                build();
        return Response.
                created(uri).
                build();
    }
}
