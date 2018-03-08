package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumUser;
import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import org.junit.*;

public class ForumTestSuite {

    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("This is the end of tests");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddPost() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");

        //When
        forumUser.addPost("mrsmith", "Hello, this is first post.");

        //Then
        Assert.assertEquals(1, forumUser.getPostsQuantity());
    }

    @Test
    public void testAddComment() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost forumPost = new ForumPost("Hello, first post", "mrsmith");

        //When
        forumUser.addComment(forumPost, "mrsmith", "First comment");

        //Then
        Assert.assertEquals(1, forumUser.getCommentsQuantity());

    }

    @Test
    public void testGetPost() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello, first post", "mrsmith");
        forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());


        //When
        ForumPost retrievedPost;
        retrievedPost = forumUser.getPost(0);

        //Then
        Assert.assertEquals(thePost, retrievedPost);

    }

    @Test
    public void testGetComment() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello, first post", "mrsmith");
        ForumComment theComment = new ForumComment(thePost, "First comment", "mrsmith");
        forumUser.addComment(thePost, theComment.getAuthor(), theComment.getCommentBody());

        //When
        ForumComment retrievedComment;
        retrievedComment = forumUser.getComment(0);

        //Then
        Assert.assertEquals(theComment, retrievedComment);

    }

    @Test
    public void testRemovePostNotExisting() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost forumPost = new ForumPost("Hello, first post", "mrsmith");

        //When
        boolean result = forumUser.removePost(forumPost);

        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveCommentNotExisting() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost forumPost = new ForumPost("Hello, first post", "mrsmith");
        ForumComment forumComment = new ForumComment(forumPost, "First comment", "mrsmith");

        //When
        boolean result = forumUser.removeComment(forumComment);

        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemovePost() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost forumPost = new ForumPost("Hello, first post", "mrsmith");
        forumUser.addPost(forumPost.getAuthor(), forumPost.getPostBody());

        //When
        boolean result = forumUser.removePost(forumPost);

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, forumUser.getPostsQuantity());

    }

    @Test
    public void testRemoveComment() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost forumPost = new ForumPost("Hello, first post", "mrsmith");
        ForumComment forumComment = new ForumComment(forumPost, "Hello, first comment", "mrsmith");
        forumUser.addComment(forumPost, forumComment.getAuthor(), forumComment.getCommentBody());

        //When
        boolean result =  forumUser.removeComment(forumComment);

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, forumUser.getCommentsQuantity());

    }


}
