package ua.org.oa.podkopayv.zmarket4.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.org.oa.podkopayv.zmarket4.model.Product;
import ua.org.oa.podkopayv.zmarket4.repository.ProductRepository;
import ua.org.oa.podkopayv.zmarket4.repository.ProductRepositoryImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/product")
public class ProductRest {

    @Autowired
    private ProductRepository productRepository;

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GET
    @Transactional
    @Produces("application/json")
    public Response getAll() {
        System.out.println("REST getAll()");
//        ProductRepository productRepository = new ProductRepositoryImpl();
        List<Product> products = productRepository.getAll();
        if (products.isEmpty()) {
            System.out.println("Empty result.");
        } else {
            System.out.println("Products list:");
            for (Product p : products) {
                Gson gson = new GsonBuilder().create();
                String json = gson.toJson(p);
                System.out.println("REST GSON product = " + json);
                System.out.println(p);
            }
        }
        return Response.ok(products, MediaType.APPLICATION_JSON_TYPE).build();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response getById(@PathParam("id") long id) {
        ProductRepository productRepository = new ProductRepositoryImpl();
        Product result = productRepository.getById(id);
        System.out.println("REST getById(" + id + "); product = " + result);
        return Response.ok(result, MediaType.APPLICATION_JSON_TYPE).build();
    }

    @GET
    @Path("/itemsList/{list}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response getByIdList(@QueryParam("list") List<String> list) {
        for (int i = 0; i < list.size(); ++i) {
            System.out.println(list.get(i));
        }
        ProductRepository productRepository = new ProductRepositoryImpl();
        return Response.ok(productRepository.getAll(), MediaType.APPLICATION_JSON_TYPE).build();
    }

    @DELETE
    @Path("{id}")
    @Produces("application/json")
    public Response delete(@PathParam("id") long id) {
        System.out.println("REST delete(" + id + ");");
        ProductRepository productRepository = new ProductRepositoryImpl();
        Product product = new Product();
        product.setId(id);
        productRepository.delete(product);
        return Response.ok(productRepository.getAll(),
                MediaType.APPLICATION_JSON_TYPE).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response add(Product product) {
        System.out.println("REST add() product = " + product);
        ProductRepository productRepository = new ProductRepositoryImpl();
        productRepository.create(product);
        return Response.ok(productRepository.getAll(), MediaType.APPLICATION_JSON_TYPE).build();
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(Product product) {
        System.out.println("REST update() product = " + product);
        ProductRepository productRepository = new ProductRepositoryImpl();
        productRepository.update(product);
        return Response.ok(productRepository.getAll(), MediaType.APPLICATION_JSON_TYPE).build();
    }

}
