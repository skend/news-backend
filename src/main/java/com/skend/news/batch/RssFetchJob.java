package com.skend.news.batch;

import com.skend.news.batch.readers.RssReader;
import com.skend.news.entities.RssFeed;
import com.skend.news.services.RssFeedService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Log4j2
public class RssFetchJob {

    private final String readersPath = "com.skend.news.batch.readers";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private final RssFeedService rssFeedService;

    @Autowired
    public RssFetchJob(RssFeedService rssFeedService) {
        this.rssFeedService = rssFeedService;
    }

    @Scheduled(fixedRate=5000)
    public void fetchRssFeeds() {
        log.info(String.format("Starting RSS fetch at {}", dateFormat.format(new Date())));

        List<RssFeed> feeds = rssFeedService.getAllFeeds();

        for (RssFeed feed : feeds) {
            String className = String.format("{0}.{1}Reader", readersPath, feed.getPublisher().getName());
            try {
                Class<?> reader = Class.forName(className);
                Method read = reader.getMethod("read", RssFeed.class);
                read.invoke(feed);
            } catch (ClassNotFoundException cnf) {
                log.error(String.format("Could not find class with name: {}", className));
                cnf.printStackTrace();
            } catch (Exception e) {
                log.error(String.format("Exception occurred after instantiating class {} with reflection", className));
            }

        }
    }

}
