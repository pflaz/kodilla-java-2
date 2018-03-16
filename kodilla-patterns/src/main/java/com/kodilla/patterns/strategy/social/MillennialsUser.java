package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.SnapchatPublisher;

public class MillennialsUser extends User {
    public MillennialsUser(String name) {
        super(name);
        this.socialPublisher = new SnapchatPublisher();
    }
}
