package GohvTwitter.GUI.GohvTwitter;
import GohvTwitter.Tweet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import twitter4j.TwitterException;

/**
 * Created by gohv on 09.06.16.
 */


public class Controller {
    @FXML private TextField tweetField;

    @FXML  Tweet tweet = new Tweet();


    public Controller() throws TwitterException {
    }

    public void tweet(ActionEvent actionEvent) {
        try {
            tweet.tweetStatus(tweetField.getText());
            tweetField.setText("");
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }


}
