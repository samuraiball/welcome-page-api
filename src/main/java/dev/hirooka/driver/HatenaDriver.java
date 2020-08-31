package dev.hirooka.driver;


import dev.hirooka.conifg.HatenaConfig;
import dev.hirooka.dto.Entry;
import dev.hirooka.dto.Feed;
import dev.hirooka.dto.PageLink;
import io.quarkus.cache.CacheInvalidate;
import io.quarkus.cache.CacheResult;
import okhttp3.*;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.xml.bind.JAXB;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class HatenaDriver {


    static final Logger logger = Logger.getLogger(HatenaDriver.class);

    final OkHttpClient okHttpClient = new OkHttpClient();

    private final HatenaConfig hatenaConfig;

    public HatenaDriver(HatenaConfig hatenaConfig) {
        this.hatenaConfig = hatenaConfig;
    }

    // fixme: error handling
    @CacheResult(cacheName = "hatena-entries")
    public Feed getAllPublishedEntries() throws Exception {

        logger.info("url : " + hatenaConfig.apiEndpoint());
        List<Entry> entries =
                getEntries(hatenaConfig.apiEndpoint())
                        .stream()
                        .filter(i -> i.getControl().getDraft().equals("no"))
                        .collect(Collectors.toList());
        return new Feed(entries);
    }

    @CacheInvalidate(cacheName = "hatena-entries")
    public void getAppPublisherEntries() throws Exception {
    }

    private List<Entry> getEntries(String url) throws Exception {
        List<Entry> entries = new ArrayList<>();

        while (url != null) {
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader(
                            "Authorization",
                            Credentials.basic(
                                    hatenaConfig.username(),
                                    hatenaConfig.apiKey()
                            )).build();
            Call call = okHttpClient.newCall(request);

            Response response = call.execute();

            Feed hatenaBlog = JAXB.unmarshal(new StringReader(response.body().string()), Feed.class);

            url = null;
            for (PageLink pageLink : hatenaBlog.getLink()) {
                if (pageLink.getRel().equals("next")) {
                    url = pageLink.getHref();
                    break;
                } else {
                    url = null;
                }
            }
            entries.addAll(hatenaBlog.getFeed());
        }

        return entries;
    }
}
