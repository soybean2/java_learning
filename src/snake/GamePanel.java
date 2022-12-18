package src.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    //绘制面板
    int length;
    int[] snakeX = new int[600];
    int[] snakeY = new int[500];
    String fx;
    boolean isStart;//游戏状态
    Timer timer = new Timer(100,this);
    //构造器
    public GamePanel() {
        init();
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
    }

    //初始化方法
    public void init(){
        length = 3;
        snakeX[0]=100;snakeY[0]=100;
        snakeX[1]=75;snakeY[1]=100;
        snakeX[2]=50;snakeY[2]=100;

        fx = "R";
        isStart = false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
//        Data.header.paintIcon(this,g,25,11);
        g.fillRect(25,75,850,600);//默认界面
        if(fx.equals("R")){
            Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if(fx.equals("L")){
            Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if(fx.equals("U")){
            Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if(fx.equals("D")){
            Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);
        }

        Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        for (int i = 1; i < length; i++) {
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);
        }
        if(isStart==false){
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("按下空格开始游戏",300,300);
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_SPACE){
            isStart = !isStart;
            repaint();
        }
        if(keyCode == KeyEvent.VK_UP){
            fx = "U";
        }else if(keyCode == KeyEvent.VK_DOWN){
            fx = "D";
        }else if(keyCode == KeyEvent.VK_LEFT){
            fx = "L";
        }else if(keyCode == KeyEvent.VK_RIGHT){
            fx = "R";
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(isStart){

            for (int i = length-1; i > 0; i--) {
                snakeX[i] = snakeX[i-1];
                snakeY[i] = snakeY[i-1];
            }

            if(fx.equals("R")){
                snakeX[0]= snakeX[0]+25;
                if(snakeX[0]>850){snakeX[0]=25;}
            }else if(fx.equals("L")){
                snakeX[0] = snakeX[0]-25;
                if(snakeX[0]<25){snakeX[0]=850;}
            }else if(fx.equals("U")){
                snakeY[0] = snakeY[0]-25;
                if(snakeY[0]<75){snakeY[0] = 650;}
            } else if (fx.equals("D")) {
                snakeY[0] = snakeY[0]+25;
                if (snakeY[0]>650){snakeY[0] = 75;}
            }

            repaint();
            timer.start();
        }
    }
}
