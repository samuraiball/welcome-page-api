package dev.hirooka;

import dev.hirooka.driver.HatenaDriver;
import dev.hirooka.dto.Feed;
import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RoutingExchange;
import io.vertx.core.http.HttpMethod;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class WelcomaPageResource {

    @Inject
    HatenaDriver hatenaDriver;

    @Route(methods = HttpMethod.GET, path = "/")
    Feed getEntries(RoutingExchange ex) throws Exception {
        return hatenaDriver.getAllPublishedEntries();
    }
}