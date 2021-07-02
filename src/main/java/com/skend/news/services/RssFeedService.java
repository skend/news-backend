package com.skend.news.services;

import com.skend.news.entities.RssFeed;
import com.skend.news.repos.rssfeed.RssFeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RssFeedService {

    private final RssFeedRepository rssFeedRepository;

    @Autowired
    public RssFeedService(RssFeedRepository rssFeedRepository) {
        this.rssFeedRepository = rssFeedRepository;
    }

    public RssFeed addFeed(RssFeed rssFeed) {
        return rssFeedRepository.save(rssFeed);
    }

    public List<RssFeed> getAllFeeds() {
        return rssFeedRepository.findAll();
    }

}
