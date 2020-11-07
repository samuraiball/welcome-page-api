package dev.hirooka.usecase;

import dev.hirooka.domain.blog.Blogs;
import dev.hirooka.domain.blog.statistic.BlogStatistics;
import dev.hirooka.port.HatenaPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class BlogStatisticsUsecaseTest {

    @InjectMocks
    private BlogStatisticsUsecase blogStatisticsUsecase;

    @Mock
    private Blogs blogs;

    @Mock
    private HatenaPort port;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getStatics() throws Exception{
        BlogStatistics expected = new BlogStatistics();
        when(blogs.createStatistics()).thenReturn(expected);
        when(port.findBlogs()).thenReturn(blogs);
        assertThat(blogStatisticsUsecase.getBlogStatics()).isEqualTo(expected);
        verify(blogs).createStatistics();
        verify(port).findBlogs();
    }
}