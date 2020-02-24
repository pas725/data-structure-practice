package com.design;

import java.util.*;

/*
 * https://leetcode.com/problems/design-twitter/
 * Created by piyush_sagar on 3/27/19.Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

    - postTweet(userId, tweetId): Compose a new tweet.
    - getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
    - follow(followerId, followeeId): Follower follows a followee.
    - unfollow(followerId, followeeId): Follower unfollows a followee.
 *
 */
public class TwitterDesign {
    /** Initialize your data structure here. */

    private Map<Integer, Set<Integer>> followers = new HashMap<>();
    private Map<Integer, Set<Integer>> following = new HashMap<>();

    private Map<Integer, List<Integer>> feed = new HashMap<>();
    private Map<Integer, Set<Integer>> posts = new HashMap<>();

    public TwitterDesign() {

    }

    public static void main(String[] args) {
         //* Your Twitter object will be instantiated and called as such:
        TwitterDesign obj = new TwitterDesign();

         obj.postTweet(1,1);
         List<Integer> param_2 = obj.getNewsFeed(1);
        System.out.println("List : " + param_2);
         obj.follow(2,1);
        //obj.postTweet(2,6);

        param_2 = obj.getNewsFeed(2);
        System.out.println("List : " + param_2);
         obj.unfollow(2,1);
        param_2 = obj.getNewsFeed(2);
        System.out.println("List : " + param_2);
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        checkOrInitUser(userId);
        feed.get(userId).add(0, tweetId);
        posts.get(userId).add(tweetId);

        for (int follower : followers.get(userId)) {
            feed.get(follower).add(0, tweetId);
        }
    }

    private void checkOrInitUser(int userId) {
        if (feed.get(userId) == null) {
            feed.put(userId, new LinkedList<>());
            followers.put(userId, new HashSet<>());
            following.put(userId, new HashSet<>());
            posts.put(userId, new HashSet<>());
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        checkOrInitUser(userId);
        List<Integer> list = feed.get(userId);
        int toIndex = list.size() > 10 ? 10 : list.size();
        return list.subList(0, toIndex);
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        checkOrInitUser(followerId);
        checkOrInitUser(followeeId);
        followers.get(followeeId).add(followerId);
        following.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        checkOrInitUser(followerId);
        checkOrInitUser(followeeId);
        followers.get(followeeId).remove(followerId);
        following.get(followerId).remove(followeeId);

        List<Integer> userFeed = feed.get(followerId);
        for (Integer post : posts.get(followeeId)) {
            userFeed.remove(post);
        }
    }
}
