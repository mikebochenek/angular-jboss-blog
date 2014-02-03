package ca.bochenek.blog.rest;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ca.bochenek.blog.data.PostListProducer;
import ca.bochenek.blog.model.Post;

/**
 * This class produces a RESTful service to read/write the contents of the posts table.
 */
@Path("/posts")
@RequestScoped
public class PostResourceRESTService {
    
    @Inject
    private Logger log;

    @Inject
    private PostListProducer listProducer;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> listAllPosts() {
        return listProducer.loadAll();
    }

    /*
    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Post lookupPostById(@PathParam("id") long id) {
        Post post = listProducer.findById(id);
        if (post == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return post;
    }
    */
    
    @GET
    @Path("/{year:[2][0][0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> lookupPostByYear(@PathParam("year") long year) {
        List<Post> post = listProducer.findByYear(year);
        if (post == null || post.size() == 0) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return post;
    }
    
}
