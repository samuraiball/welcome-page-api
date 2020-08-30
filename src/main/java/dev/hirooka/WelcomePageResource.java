package dev.hirooka;

import dev.hirooka.driver.HatenaDriver;
import dev.hirooka.dto.Feed;
import dev.hirooka.util.DataRefresher;
import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RoutingExchange;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.RoutingContext;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WelcomePageResource {

    private final HatenaDriver hatenaDriver;
    private final DataRefresher dataRefresher;

    public WelcomePageResource(HatenaDriver hatenaDriver, DataRefresher dataRefresher) {
        this.dataRefresher = dataRefresher;
        this.hatenaDriver = hatenaDriver;
    }

    @Route(methods = HttpMethod.GET, path = "/hatena/entries")
    Feed getEntries(RoutingExchange ex) throws Exception {
        return hatenaDriver.getAllPublishedEntries();
    }

    @Route(methods = HttpMethod.GET, path = "/hatena/entries/refresh")
    void hello(RoutingContext rc) throws Exception {
        dataRefresher.invalidateCache();
        rc.response().end("Invalidate Cache");
    }
}