import java.util.*;

class Tweet {
    int id;
    int timestamp;
    Tweet(int id, int timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }
}

public class Twitter {
    private static int timestamp = 0; // Global timestamp for ordering tweets
    private Map<Integer, List<Tweet>> userTweets;
    private Map<Integer, Set<Integer>> userFollowers;
    
    public Twitter() {
        userTweets = new HashMap<>();
        userFollowers = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!userTweets.containsKey(userId)) {
            userTweets.put(userId, new ArrayList<>());
        }
        userTweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> tweets = new ArrayList<>();
        
        // Collect tweets from the user and the users they follow
        if (userTweets.containsKey(userId)) {
            tweets.addAll(userTweets.get(userId));
        }
        
        if (userFollowers.containsKey(userId)) {
            for (int followeeId : userFollowers.get(userId)) {
                if (userTweets.containsKey(followeeId)) {
                    tweets.addAll(userTweets.get(followeeId));
                }
            }
        }
        
        // Sort tweets by timestamp in descending order and collect the top 10
        tweets.sort((a, b) -> b.timestamp - a.timestamp);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < Math.min(tweets.size(), 10); i++) {
            result.add(tweets.get(i).id);
        }
        
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // A user cannot follow themselves
        
        if (!userFollowers.containsKey(followerId)) {
            userFollowers.put(followerId, new HashSet<>());
        }
        userFollowers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // A user cannot unfollow themselves
        
        if (userFollowers.containsKey(followerId)) {
            userFollowers.get(followerId).remove(followeeId);
        }
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