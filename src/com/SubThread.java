package com;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
class ClockFrame extends JFrame {
    public JLabel lbl_clock;

    public JLabel getLbl_clock() {
        return lbl_clock;
    }

    public void setLbl_clock(JLabel lbl_clock) {
        this.lbl_clock = lbl_clock;
    }

    public ClockFrame(){
        this.setTitle("时钟");
        this.setSize(400,300);
        lbl_clock = new JLabel();
        lbl_clock.setFont(new Font("微软雅黑",Font.BOLD,30));
        lbl_clock.setForeground(Color.red);
        lbl_clock.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lbl_clock);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}


public class SubThread extends Thread{
    private ClockFrame clockFrame;
    public SubThread(ClockFrame clockFrame) {
        this.clockFrame = clockFrame;
    }

    @Override
    public void run() {
        while(true){
            //获取系统时间
            Date date =new Date();
            int hour = date.getHours();
            int minute = date.getMinutes();
            int second = date.getSeconds();
            //获取显示时间的标签
            JLabel lbl_clock = clockFrame.getLbl_clock();
            lbl_clock.setText(hour+"时："+minute+"分"+second+"秒");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Test {
    public static void main(String[] args) {
        ClockFrame clockFrame = new ClockFrame();
        clockFrame.setVisible(true);
        //创建线程对象
        SubThread subThread = new SubThread(clockFrame);
        //启动线程
        subThread.start();
    }
}