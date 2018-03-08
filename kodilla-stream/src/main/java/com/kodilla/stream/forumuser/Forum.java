package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    List<ForumUser> theUsersList = new ArrayList<>();

    public Forum() {
        theUsersList.add(new ForumUser(1, "john", 'M', LocalDate.of(1998,2,16), 10));
        theUsersList.add(new ForumUser(2, "mary", 'F', LocalDate.of(1990,5,5), 1));
        theUsersList.add(new ForumUser(3, "greg", 'M', LocalDate.of(1955,3,14), 0));
        theUsersList.add(new ForumUser(4, "alan", 'M', LocalDate.of(1989,8,18), 20));
        theUsersList.add(new ForumUser(5, "usertest", 'F', LocalDate.of(2001,10,19), 64));
        theUsersList.add(new ForumUser(6, "dan", 'M', LocalDate.of(2011,4,30), 32));
        theUsersList.add(new ForumUser(7, "garry", 'M', LocalDate.of(1999,5,1), 21));
    }

    public final List<ForumUser> getUserList() {
        return new ArrayList<>(theUsersList);
    }


}
