package dev.hirooka.gateway;

import dev.hirooka.domain.blog.Blog;
import dev.hirooka.domain.blog.Blogs;
import dev.hirooka.domain.blog.Categories;
import dev.hirooka.domain.blog.Category;
import dev.hirooka.infra.HatenaDriver;
import dev.hirooka.port.HatenaPort;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class HatenaGateway implements HatenaPort {

    static final Logger logger = Logger.getLogger(HatenaGateway.class);

    public HatenaGateway(HatenaDriver driver) {
        this.driver = driver;
    }

    private HatenaDriver driver;

    @Override
    public Blogs findBlogs() throws Exception {
        List<Blog> blogList = driver.getAllPublishedEntries()
                .getFeed().stream()
                .map(f -> {
                    List<Category> categories =
                            f.getCategory()
                                    .stream()
                                    .map(c -> new Category(c.getTerm())).collect(Collectors.toList());
                    return new Blog(f.getTitle(), f.getPublished(), new Categories(categories));
                }).collect(Collectors.toList());
        return new Blogs(blogList);
    }
}
