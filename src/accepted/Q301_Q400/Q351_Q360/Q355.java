package accepted.Q301_Q400.Q351_Q360;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Design a simplified version of Twitter where users can post tweets,
 * follow/unfollow another user and is able to see the 10 most recent
 * tweets in the user's news feed. Your design should support the following methods:
 * <p>
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed.
 * Each item in the news feed must be posted by users who the user followed or by the user herself.
 * Tweets must be ordered from most recent to least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 * <p>
 * Example:
 * <p>
 * Twitter twitter = new Twitter();
 * <p>
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 * <p>
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 * <p>
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 * <p>
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 * <p>
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 * <p>
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 * <p>
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 */
public class Q355 {

    int seed = 0;
    Map<Integer, Deque<Tweet>> tweetMap;
    Map<Integer, Set<Integer>> followerMap;
    Map<Integer, Set<Tweet>> newsFeedMap;

    /**
     * Initialize your data structure here.
     */
    public Q355() {
        tweetMap = new HashMap<>();
        followerMap = new HashMap<>();
        newsFeedMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(seed++, tweetId);
        Deque<Tweet> tweets = tweetMap.get(userId);
        if (tweets == null) {
            tweets = new ArrayDeque<>();
            tweetMap.put(userId, tweets);
        }
        tweets.push(tweet);

        Set<Tweet> selfNews = newsFeedMap.get(userId);
        if (selfNews == null) {
            selfNews = new TreeSet<>((t1, t2) -> t2.seq - t1.seq);
            newsFeedMap.put(userId, selfNews);
        }
        selfNews.add(tweet);

        Set<Integer> followers = followerMap.get(userId);
        if (followers != null) {
            for (Integer follower : followers) {
                Set<Tweet> news = newsFeedMap.get(follower);
                if (news == null) {
                    news = new TreeSet<>((t1, t2) -> t2.seq - t1.seq);
                    newsFeedMap.put(follower, news);
                }
                news.add(tweet);
            }
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {

        Set<Tweet> news = newsFeedMap.get(userId);
        List<Integer> res = new ArrayList<>();
        if (news == null || news.isEmpty()) {
            return res;
        }

        int i = 0;
        Iterator<Tweet> it = news.iterator();
        while (it.hasNext() && i < 10) {
            res.add(it.next().tweetId);
            i++;
        }
        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {

        if (followerId == followeeId) {
            return;
        }

        Set<Integer> followers = followerMap.get(followeeId);
        if (followers == null) {
            followers = new HashSet<>();
            followerMap.put(followeeId, followers);
        } else if (followers.contains(followerId)) {
            return;
        }
        followers.add(followerId);

        Deque<Tweet> tweets = tweetMap.get(followeeId);
        if (tweets == null || tweets.isEmpty()) {
            return;
        }

        Set<Tweet> news = newsFeedMap.get(followerId);
        if (news == null) {
            news = new TreeSet<>((t1, t2) -> t2.seq - t1.seq);
            newsFeedMap.put(followerId, news);
        }
        for (Tweet t : tweets) {
            news.add(t);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {

        Set<Integer> followers = followerMap.get(followeeId);
        if (followers == null || followers.isEmpty()
                || !followers.contains(followerId)) {
            return;
        }
        followers.remove(Integer.valueOf(followerId));

        Deque<Tweet> tweets = tweetMap.get(followeeId);
        if (tweets == null || tweets.isEmpty()) {
            return;
        }

        Set<Tweet> news = newsFeedMap.get(followerId);
        for (Tweet t : tweets) {
            news.remove(t);
        }
    }
}

class Tweet {
    int seq;
    int tweetId;

    Tweet(int seq, int tweetId) {
        this.seq = seq;
        this.tweetId = tweetId;
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
