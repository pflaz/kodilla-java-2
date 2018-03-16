package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.FacebookPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {
        // Given
        MillennialsUser john = new MillennialsUser("John");
        YGenerationUser adam = new YGenerationUser("Adam");
        ZGenerationUser chris = new ZGenerationUser("Chris");

        // When
        String johnsPublication = john.sharePost();
        System.out.println("John published: " + johnsPublication);
        String adamsPublication = adam.sharePost();
        System.out.println("Adam published: " + adamsPublication);
        String chrisesPublication = chris.sharePost();
        System.out.println("Chris published: " + chrisesPublication);

        // Then
        Assert.assertEquals("Published by Snapchat", johnsPublication);
        Assert.assertEquals("Published by Facebook", adamsPublication);
        Assert.assertEquals("Published by Twitter", chrisesPublication);
    }

    @Test
    public void testIndividualSharingStrategy() {
        // Given
        MillennialsUser john = new MillennialsUser("John");

        // When
        String johnsPublication = john.sharePost();
        System.out.println("John published:" + johnsPublication);

        john.setSocialPublisher(new FacebookPublisher());
        johnsPublication = john.sharePost();
        System.out.println("Now John published: " + johnsPublication);

        // Then
        Assert.assertEquals("Published by Facebook", johnsPublication);
    }
}