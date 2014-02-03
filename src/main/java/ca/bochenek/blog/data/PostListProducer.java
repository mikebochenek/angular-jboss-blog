package ca.bochenek.blog.data;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ca.bochenek.blog.model.Post;

@RequestScoped
public class PostListProducer {

    @Inject
    private EntityManager em;

    @SuppressWarnings("unchecked")
	public List<Post> loadAll() {
    	return em.createQuery("select p from Post p").getResultList();
    }
    
    public Post findById(long id) {
    	return em.find(Post.class, id);
    }

	public List<Post> findByYear(long year) {
		String dateStr = " where post_date between '" + year + "-01-01' and '" + year + "-12-31'";
    	return em.createQuery("select p from Post p " + dateStr).getResultList();
    }

}
