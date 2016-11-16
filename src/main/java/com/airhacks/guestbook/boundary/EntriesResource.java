
package com.airhacks.guestbook.boundary;

import com.airhacks.guestbook.entity.GuestEntry;
import com.airhacks.guestbook.entity.GuestEntryContent;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import static java.util.concurrent.CompletableFuture.supplyAsync;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Path("entries")
public class EntriesResource implements Serializable {

    @Inject
    GuestService service;

    @Resource
    ManagedExecutorService mes;

    @GET
    public void all(@Suspended AsyncResponse response) {
        response.setTimeout(1, TimeUnit.SECONDS);
        supplyAsync(service::all, mes).
                whenComplete((result, error) -> Optional.ofNullable(error).ifPresent(response::resume)).
                thenApply(this::provideTypeInformation).
                thenAccept(response::resume);
    }

    GenericEntity<List<GuestEntry>> provideTypeInformation(List<GuestEntry> entry) {
        return new GenericEntity<List<GuestEntry>>(entry) {
        };
    }


    @GET
    @Path("{id}")
    public void find(@PathParam("id") long id, @Suspended AsyncResponse response) {
        response.setTimeout(1, TimeUnit.SECONDS);
        supplyAsync(() -> this.service.find(id), mes).
                whenComplete((result, error) -> Optional.ofNullable(error).ifPresent(response::resume)).
                thenAccept(response::resume);
    }

    @POST
    public void save(@GuestEntryContent GuestEntry entry, @Context UriInfo info,
            @Suspended AsyncResponse response) {
        supplyAsync(() -> this.service.save(entry)).thenApply(g -> g.getId()).
                whenComplete((result, error) -> Optional.ofNullable(error).ifPresent(response::resume)).
                thenApply(id -> info.getAbsolutePathBuilder().path("/" + id).build()).
                thenApply(uri -> Response.created(uri).build()).
                thenAccept(response::resume);
    }
}
