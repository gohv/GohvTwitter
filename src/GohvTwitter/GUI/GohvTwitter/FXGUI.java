package GohvTwitter.GUI.GohvTwitter;/**
 * Created by gohv on 08.06.16.
 */

import GohvTwitter.Tweet;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import twitter4j.TwitterException;

import java.io.IOException;

public class FXGUI extends Application {

    TextField nameField = new TextField("Type here:");
    Button btn = new Button("Click");
    GridPane grid = new GridPane();
    Group root = new Group();
    Text text = new Text("Sup?");
    Label label = new Label("Name: ");
    Tweet tweet = new Tweet();

    public FXGUI() throws TwitterException {
    }


    @Override
    public void start(Stage primaryStage) throws IOException {

        //  Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));


        grid.add(label, 0, 0);
        grid.add(nameField, 1, 0);
        //   grid.setGridLinesVisible(true);
        text.setFont(new Font("DejaVu Serif Bold", 30));
        grid.add(btn, 1, 1);
        grid.setHgap(10);

        btn.setOnAction(evt -> {
            try {
                tweet.tweetStatus(nameField.getText());
            } catch (TwitterException e) {
               System.err.println("Some Twitter Exception occurred");
                e.printStackTrace();
            }
        });
        VBox box = new VBox();

        box.getChildren().addAll(text, grid);
        root.getChildren().add(box);
        primaryStage.setTitle("Sup");
        primaryStage.setScene(new Scene(root, 370, 275));
        primaryStage.show();
    }

    private void setMessage() throws TwitterException {



    }

    private void getFeed() throws TwitterException {
        tweet.getFeed();
    }

    public static void main(String[] args) {


        launch(args);

    }
}
