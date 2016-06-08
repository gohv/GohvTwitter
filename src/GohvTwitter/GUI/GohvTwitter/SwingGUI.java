package GohvTwitter.GUI.GohvTwitter;

import GohvTwitter.Tweet;
import twitter4j.TwitterException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by gohv on 08.06.16.
 */
public class SwingGUI extends JFrame implements ActionListener {

    public SwingGUI(){
        visualise();
    }

    private void visualise(){
        setLayout(null);
        setBounds(100,100,500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        btn.setBounds(10,10,50,50);
        field.setBounds(90,90,300,50);
        btn.addActionListener(this);
        add(btn);
        add(field);
        add(get);
        get.setBounds(100,200,50,50);
    }

    public static void main(String[] args) {
        SwingGUI gui = new SwingGUI();
        gui.setVisible(true);
    }
    Button btn = new Button("Tweet");
    TextField field = new TextField();
    Button get = new Button("Get");

    @Override
    public void actionPerformed(ActionEvent e) {
        String test = null;
        Object src = e.getSource();
        if (src == btn) {
            try {
                Tweet tweet = new Tweet();
                tweet.getFeed();
            } catch (TwitterException e1) {
                e1.printStackTrace();
            }

        }
        else if (src == get) {
           test = field.getText();
        }

    }
    

}
