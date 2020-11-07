package dev.hirooka.domain.blog;


import dev.hirooka.domain.blog.statistic.BlogStatistics;
import dev.hirooka.domain.blog.statistic.CategoriesStatistics;
import dev.hirooka.domain.blog.statistic.CategoryStatistics;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BlogsTest {

    @Test
    void createStatistics() {
        BlogStatistics expected = setUpExpected();
        Blogs blogs = seUpBlogs();
        assertThat(blogs.createStatistics()).isEqualToComparingFieldByField(expected);
    }

    private BlogStatistics setUpExpected() {
        return new BlogStatistics(
                new CategoriesStatistics(
                        List.of(
                                new CategoryStatistics(new Category("Java"), 2),
                                new CategoryStatistics(new Category("Spring"), 1))));
    }

    private Blogs seUpBlogs() {
        return new Blogs(List.of(
                new Blog("title1", "published", new Categories(
                        List.of(
                                new Category("Java"),
                                new Category("Spring")))),

                new Blog("title1", "published", new Categories(
                        List.of(
                                new Category("Java"))))));
    }
}