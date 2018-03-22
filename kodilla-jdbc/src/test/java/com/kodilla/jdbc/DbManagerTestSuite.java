package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuite {
    @Test
    public void testConnection() throws SQLException {
        // Given
        //When
        DbManager dbManager = DbManager.getInstance();
        // Then
        Assert.assertNotNull(dbManager.getConnection());
    }

    @Test
    public void testSelectUsers() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();

        // When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        // Then
        int counter = 0;
        while(rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(7, counter);
    }

    @Test
    public void testSelectUsersAndPosts() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();

        // When
        String sqlQuery = "select u.firstname, u.lastname, count(*) as posts_number " +
                "from users u, posts p " +
                "where u.ID = p.USER_ID " +
                "group by u.ID " +
                "having posts_number >= 2;";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        // Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getString("FIRSTNAME") + " " + rs.getString("LASTNAME") +
                    " (posts: " + rs.getInt("posts_number") + ")");
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(2, counter);
    }

}