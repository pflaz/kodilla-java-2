package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.*;


public class ForumTestSuite {

    @Before
    public void before() {
        System.out.println("test case: begin");
    }

    @After
    public void after() {
        System.out.println("test case: end");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("test suite: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("test suite: end");
    }

    @Test
    public void testCaseUsername() {
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser", "John Smith");
        //When
        String result = simpleUser.getUsername();
        System.out.println("Testing: " + result);
        //Then
        Assert.assertEquals("theForumUser", result);
    }

    @Test
    public void testRealName() {
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser", "John Smith");
        // When
        String result = simpleUser.getRealName();
        System.out.println("testing: " + result);
        //Then
        Assert.assertEquals("John Smith", result);
    }
}
