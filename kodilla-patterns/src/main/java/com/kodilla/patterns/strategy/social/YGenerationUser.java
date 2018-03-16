package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.FacebookPublisher;

public class YGenerationUser extends User {
    public YGenerationUser(String name) {
        super(name);
        this.socialPublisher = new FacebookPublisher();
    }
}
