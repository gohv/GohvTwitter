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

    Button btn = new Button("Tweet");
    TextField field = new TextField();
    Button get = new Button("Get");
    Tweet tw = new Tweet();

    public SwingGUI() throws TwitterException {
        try {
            visualise();
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }

    private void visualise() throws TwitterException {

        setLayout(null);
        setBounds(100,100,1500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        btn.setBounds(10,10,50,50);
        field.setBounds(90,90,1500,500);
        btn.addActionListener(this);
        add(btn);
        add(field);
        add(get);
        get.setBounds(30,30,50,50);
        get.addActionListener(this);

    }




    @Override
    public void actionPerformed(ActionEvent e) {
        try {
           // tw.getFeedList();
            field.setText(tw.getFeedList().toString());
            tw.getFeedPrint();
        } catch (TwitterException e1) {
            e1.printStackTrace();
        }

    }

    public static void main(String[] args) throws TwitterException {
        SwingGUI gui = new SwingGUI();
        gui.setVisible(true);

    }

}
