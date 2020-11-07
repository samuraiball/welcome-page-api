package dev.hirooka.resource;

import dev.hirooka.domain.blog.statistic.BlogStatistics;
import dev.hirooka.infra.HatenaDriver;
import dev.hirooka.infra.dto.Feed;
import dev.hirooka.resource.dto.BlogsStatistics;
import dev.hirooka.resource.dto.CategoryStatistics;
import dev.hirooka.usecase.BlogStatisticsUsecase;
import dev.hirooka.util.DataRefresher;
import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RoutingExchange;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.RoutingContext;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class WelcomePageResource {

    private final HatenaDriver hatenaDriver;
    private final DataRefresher dataRefresher;
    private final BlogStatisticsUsecase blogStatisticsUsecase;

    public WelcomePageResource(
            HatenaDriver hatenaDriver,
            DataRefresher dataRefresher,
            BlogStatisticsUsecase blogStatisticsUsecase
    ) {
        this.dataRefresher = dataRefresher;
        this.hatenaDriver = hatenaDriver;
        this.blogStatisticsUsecase = blogStatisticsUsecase;
    }

    @Route(methods = HttpMethod.GET, path = "/hatena/entries")
    Feed getEntries(RoutingExchange ex) throws Exception {
        return hatenaDriver.getAllPublishedEntries();
    }

    @Route(methods = HttpMethod.GET, path = "/hatena/entries/refresh")
    void refreshBlogsData(RoutingContext rc) throws Exception {
        dataRefresher.invalidateCache();
        rc.response().end("Invalidate Cache");
    }

    @Route(methods = HttpMethod.GET, path = "/hatena/statics")
    BlogsStatistics getBlogStatics(RoutingContext rc) throws Exception {
        return createBlogsStatisticsResponse(blogStatisticsUsecase.getBlogStatics());
    }

    private BlogsStatistics createBlogsStatisticsResponse(BlogStatistics blogsStatistics) {
        List<CategoryStatistics> categoryStatistics = blogsStatistics
                .getCategoriesStatistics().getList()
                .stream()
                .map(c ->
                        new CategoryStatistics(c.getCategory().getValue(), c.getNumber()))
                .collect(Collectors.toList());
        return new BlogsStatistics(categoryStatistics);
    }
}