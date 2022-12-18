import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Painter extends JFrame {
    Mypanel panel;
    JMenuBar menuBar;
    JMenu clearMethod,chooser,color;
    JMenuItem eraser,clear,exit;
    JRadioButtonMenuItem blue,red,green;
    ButtonGroup group;
    Color c;
    int flag;
    public Painter(){
        setTitle("面板");
        setSize(450,550);
        double w = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double h = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        setLocation((int)(w-450)/2,(int)(h-550)/2);
        panel = new Mypanel();
        add(panel);
        setVisible(true);
        menuBar = new JMenuBar();
        clearMethod = new JMenu("清除方式");
        eraser = new JMenuItem("橡皮");
        clear = new JMenuItem("清除");
        exit = new JMenuItem("退出");

        menuBar.add(clearMethod);
        clearMethod.add(eraser);
        clearMethod.add(clear);
        clearMethod.addSeparator();
        clearMethod.add(exit);

        chooser = new JMenu("选择画笔");
        color = new JMenu("颜色");
        blue = new JRadioButtonMenuItem("蓝色");
        green = new JRadioButtonMenuItem("蓝色");
        red = new JRadioButtonMenuItem("红色");
        group = new ButtonGroup();
        group.add(blue);
        group.add(green);
        group.add(red);
        menuBar.add(chooser);
        chooser.add(color);
        color.add(blue);color.add(green);color.add(red);
        setJMenuBar(menuBar);
        eraser.addActionListener(new MyListener());
        clear.addActionListener(new MyListener());
        exit.addActionListener(new MyListener());
        blue.addActionListener(new MyListener());
        green.addActionListener(new MyListener());
        red.addActionListener(new MyListener());


    }


    class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==blue){
                c=Color.BLUE;
                flag = 0;
            }else if(e.getSource()==green){
                c = Color.green;
                flag = 0;
            }else if(e.getSource()==red){
                c = Color.red;
                flag = 0;
            }else if(e.getSource()==eraser){
                c = getBackground();
                flag = 1;
            }else if(e.getSource()==clear){
                panel.repaint();
            }else if(e.getSource()==exit){
                System.exit(0);
            }

        }
    }

    class Mypanel extends JPanel implements MouseMotionListener {
        public Mypanel(){
            addMouseMotionListener(this);
        }
        @Override
        public void mouseDragged(MouseEvent e) {
            Graphics g = getGraphics();
            g.setColor(c);
            if(flag==0){
                g.fillOval(e.getX()-3,e.getY()-3,6,6);

            }else{
                g.fillOval(e.getX()-12,e.getY()-12,24,24);
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }
    public static void main(String[] args) {
        Painter painter = new Painter();
    }
}

