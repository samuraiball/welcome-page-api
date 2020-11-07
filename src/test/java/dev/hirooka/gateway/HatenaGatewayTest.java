package dev.hirooka.gateway;

import dev.hirooka.domain.blog.Blog;
import dev.hirooka.domain.blog.Blogs;
import dev.hirooka.domain.blog.Categories;
import dev.hirooka.domain.blog.Category;
import dev.hirooka.infra.HatenaDriver;
import dev.hirooka.infra.dto.Entry;
import dev.hirooka.infra.dto.Feed;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class HatenaGatewayTest {

    @InjectMocks
    HatenaGateway hatenaGateway;

    @Mock
    HatenaDriver driver;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findBlogs() throws Exception {
        when(driver.getAllPublishedEntries()).thenReturn(setUpMocks());
        Blogs expected = setUpExpected();
        assertThat(hatenaGateway.findBlogs()).isEqualToComparingFieldByFieldRecursively(expected);
    }


    private Feed setUpMocks() {
        return new Feed(
                List.of(
                        new Entry(
                                "title1",
                                "published1",
                                "",
                                null,
                                List.of(
                                        new dev.hirooka.infra.dto.Category("Java1"),
                                        new dev.hirooka.infra.dto.Category("Spring")),
                                "",
                                null),
                        new Entry(
                                "title2",
                                "published2",
                                "",
                                null,
                                List.of(
                                        new dev.hirooka.infra.dto.Category("Java2"),
                                        new dev.hirooka.infra.dto.Category("Quarkus")),
                                "",
                                null)));
    }

    private Blogs setUpExpected() {
        return
                new Blogs(
                        List.of(
                                new Blog(
                                        "title1",
                                        "published1",
                                        new Categories(
                                                List.of(
                                                        new Category("Java1"),
                                                        new Category("Spring")))),
                                new Blog(
                                        "title2",
                                        "published2",
                                        new Categories(
                                                List.of(
                                                        new Category("Java2"),
                                                        new Category("Quarkus"))))));
    }
}