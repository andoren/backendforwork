import hu.misi.feladat.service.impl.ProductService;
import jdk.nashorn.internal.objects.annotations.Getter;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
@Path("/public")
public class ProductEndpoints {
    @Inject
    ProductService service;

    @GET
    @Path("/authproducts")
    @Produces("application/json")
    public Response doGet() {

        return Response.ok(service.getAuthorizedProducts()).build();

    }
    @GET
    @Path("/authproducts")
    @Produces("application/json")
    public Response doExit() {

       Runtime.getRuntime().exit(1);
       return Response.ok("exit").build();

    }

}
