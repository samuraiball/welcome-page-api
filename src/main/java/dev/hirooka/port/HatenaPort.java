package dev.hirooka.port;

import dev.hirooka.domain.blog.Blogs;

public interface HatenaPort {
    public Blogs findBlogs() throws Exception;
}
