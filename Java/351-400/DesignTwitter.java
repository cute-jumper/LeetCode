public class Twitter {

    Map<Integer, Set<Integer>> followingMap = new HashMap<>();
    Map<Integer, List<Tweet>> tweetsMap = new HashMap<>();
    static class Tweet implements Comparable<Tweet> {
        int id;
        int time;
        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
        @Override
        public int compareTo(Tweet that) {
            return that.time - this.time;
        }
    }
    int time = 0;

    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (tweetsMap.containsKey(userId)) {
            tweetsMap.get(userId).add(new Tweet(tweetId, time));
        } else {
            List<Tweet> tweets = new ArrayList<>();
            tweets.add(new Tweet(tweetId, time));
            tweetsMap.put(userId, tweets);
        }
        time++;
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> followings = followingMap.get(userId);
        List<List<Tweet>> tweets = new ArrayList<>();
        if (tweetsMap.containsKey(userId)) tweets.add(tweetsMap.get(userId));
        if ((followings == null || followings.size() == 0) && tweets.size() == 0) return res;
        if (followings != null) {
            for (int i : followings) {
                if (tweetsMap.containsKey(i)) tweets.add(tweetsMap.get(i));
            }
        }
        int[] indices = new int[tweets.size()];
        for (int i = 0; i < 10; i++) {
            Tweet maxTweet = new Tweet(0, -1);
            int maxIndex = -1;
            for (int j = 0; j < tweets.size(); j++) {
                List<Tweet> tList = tweets.get(j);
                if (indices[j] < tList.size()) {
                    Tweet t = tList.get(tList.size() - 1 - indices[j]);
                    if (t.time > maxTweet.time) {
                        maxTweet = t;
                        maxIndex = j;
                    }
                }
            }
            if (maxIndex == -1) break;
            res.add(maxTweet.id);
            indices[maxIndex]++;
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (followingMap.containsKey(followerId)) {
            followingMap.get(followerId).add(followeeId);
        } else {
            Set<Integer> followees = new HashSet<>();
            followees.add(followeeId);
            followingMap.put(followerId, followees);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followingMap.containsKey(followerId)) {
            followingMap.get(followerId).remove(Integer.valueOf(followeeId));
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
