package dev.hirooka.util;


import dev.hirooka.infra.HatenaDriver;
import io.quarkus.scheduler.Scheduled;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DataRefresher {

    static final Logger logger = Logger.getLogger(DataRefresher.class);

    final HatenaDriver hatenaDriver;

    public DataRefresher(HatenaDriver hatenaDriver) {
        this.hatenaDriver = hatenaDriver;
    }


    @Scheduled(every = "1h")
    public void invalidateCache() throws Exception{
        logger.info("reload blog data");
        hatenaDriver.getAppPublisherEntries();
        hatenaDriver.getAllPublishedEntries();
    }
}
