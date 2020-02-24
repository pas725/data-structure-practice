package com.ps;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Created by piyush_sagar on 10/23/19.
 */
public class UserTest {
    public static void main(String[] args) {
        Comparator<User> userComparator = (o1, o2) -> {
            if (o1.gethId() > o2.gethId())
                return 1;
            else if (o1.gethId() < o2.gethId())
                return -1;
            return o1.getTimestamp() > o2.getTimestamp() ? 1 : -1;
        };

        List<User> users = new ArrayList<>();
        users.add(new User(1, 1, 101));
        users.add(new User(1, 2, 105));
        users.add(new User(1, 1, 108));
        users.add(new User(2, 1, 103));
        users.add(new User(2, 2, 108));

        Map<Integer, List<User>> listMap = users.stream().collect(Collectors.groupingBy(
           User::getUserId
        ));

        Map<Integer, Map<Integer, Long>> map = new HashMap<>();
        listMap.forEach((k, v) -> {
            Map<Integer, Long> l =  v.stream().collect(Collectors.groupingBy(
                    User::gethId,
                    Collectors.counting()
            ));
            map.put(k, l);
        });


        System.out.println(listMap.size());
    }
}


class User {
    int userId;
    int hId;
    int timestamp;

    public User(int userId, int hId, int timestamp) {
        this.userId = userId;
        this.hId = hId;
        this.timestamp = timestamp;
    }

    public int getUserId() {
        return userId;
    }

    public int gethId() {
        return hId;
    }

    public int getTimestamp() {
        return timestamp;
    }


}
