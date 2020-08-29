package dev.hirooka;

import dev.hirooka.driver.HatenaDriver;
import dev.hirooka.dto.Feed;
import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RoutingExchange;
import io.vertx.core.http.HttpMethod;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WelcomePageResource {

    private final HatenaDriver hatenaDriver;

    public WelcomePageResource(HatenaDriver hatenaDriver) {
        this.hatenaDriver = hatenaDriver;
    }

    @Route(methods = HttpMethod.GET, path = "/")
    Feed getEntries(RoutingExchange ex) throws Exception {
        return hatenaDriver.getAllPublishedEntries();
    }
}