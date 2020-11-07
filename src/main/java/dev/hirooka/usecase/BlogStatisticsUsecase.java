package dev.hirooka.usecase;

import dev.hirooka.domain.blog.statistic.BlogStatistics;
import dev.hirooka.port.HatenaPort;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BlogStatisticsUsecase {

    private HatenaPort hatenaPort;

    public BlogStatisticsUsecase(HatenaPort hatenaPort) {
        this.hatenaPort = hatenaPort;
    }


    public BlogStatistics getBlogStatics() throws Exception{
        return hatenaPort.findBlogs().createStatistics();
    }
}
