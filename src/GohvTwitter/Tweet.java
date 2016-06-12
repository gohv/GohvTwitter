package GohvTwitter;

import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * build Twitter API - twitter4j
 */

public class Tweet {
// Generated from Twitter:

    private final String CONSUMER_KEY = "CRRVcMV2IE4onuZ2l7AT2NJ4b";
    private final String CONSUMER_SECRET = "fa58YQIetZJ0bGt47zrwH15dne7PEJyxAsdsNGEPLsnZJTiEpN";
    private final String ACCESS_TOKEN = "2655769404-EZU1CS7xLZGelGYFh1vajZvuJcPogpBC0dRdh2m";
    private final String ACCESS_TOKEN_SECRET = "epMhSqOvR6IEXG80rHeZBHTcJHi9gRYGO5ZRsNJD3sNsN";

    private ConfigurationBuilder config = new ConfigurationBuilder();
    private twitter4j.Twitter twitter;

    public Tweet() throws TwitterException {

        buildConfig();


    }

    // initial config for my first twitter app:
    public void buildConfig() throws TwitterException {
        config.setDebugEnabled(true);
        config.setOAuthConsumerKey(CONSUMER_KEY);
        config.setOAuthConsumerSecret(CONSUMER_SECRET);
        config.setOAuthAccessToken(ACCESS_TOKEN);
        config.setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
        // pass the config:
        TwitterFactory twitterFactory = new TwitterFactory(config.build());
        // Returns a instance associated with the configuration bound to this factory.
        twitter = twitterFactory.getInstance();
    }

    public void tweetStatus(String message) throws TwitterException {
        StatusUpdate status = new StatusUpdate(message);
        Status setStatus = twitter.updateStatus(status);
    }

    public void getFeedPrint() throws TwitterException {
            // creating a list of Statuses:
        // TODO : make it readable by my FX GUI:
        List<Status> tweets = twitter.getHomeTimeline();
        for (Status s : tweets) {
            System.out.println(s.getUser().getName() + "------>" + s.getText());
        }
    }

 public HashMap<String, String> getFeedList() throws TwitterException {
        List<Status> tweets = twitter.getHomeTimeline();
     HashMap<String, String> list= new HashMap<>();

     for (Status s : tweets) {
         String name = s.getUser().getName();
         String text = s.getText();
         list.put(name, text);

     }
    return list;

    }

 /*   public static void main(String[] args) {
        Tweet twitter;
        try {
            twitter = new Tweet();
            System.out.println(twitter.getFeedList());
        } catch (TwitterException e) {
            e.printStackTrace();
        }


    }*/

}
