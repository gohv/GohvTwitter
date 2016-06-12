package GohvTwitter.GUI.GohvTwitter;/**
 * Created by gohv on 08.06.16.
 */

import GohvTwitter.Tweet;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import twitter4j.TwitterException;

import java.io.IOException;

public class FXGUI extends Application {

    TextField tweetField = new TextField();
    Button tweetButton = new Button("Tweet");

    GridPane grid = new GridPane();
    Group root = new Group();
    Text text = new Text("Post to Twitter?");
    Label label = new Label("Type here:");
    Tweet tweet = new Tweet();

    public FXGUI() throws TwitterException {
    }


    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));


        primaryStage.setTitle("GohvTwitter");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }

    private void setMessage() throws TwitterException {



    }


    public static void main(String[] args) {


        launch(args);

    }
}
