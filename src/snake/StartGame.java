package src.snake;

import javax.swing.*;
import java.lang.Math.*;
import java.util.Random;

public class StartGame {
    public static void main(String[] args) {
        JFrame jf = new JFrame("贪吃蛇");
        jf.setBounds(10,10,900,720);
        jf.setVisible(true);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.add(new GamePanel());
    }
}


