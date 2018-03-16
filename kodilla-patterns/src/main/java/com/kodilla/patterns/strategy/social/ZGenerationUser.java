package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.TwitterPublisher;

public class ZGenerationUser extends User {
    public ZGenerationUser(String name) {
        super(name);
        this.socialPublisher = new TwitterPublisher();
    }
}
