import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;


public class Calculator {
    static String s="",b="",a="";
    char op;
    JFrame frame = new JFrame("计算器");
    JTextField TextField = new JTextField(20);
    JButton clear_Button = new JButton("清 除");
    /* 数字键0到9 */
    JButton btn0 = new JButton("0");
    JButton btn1 = new JButton("1");
    JButton btn2 = new JButton("2");
    JButton btn3 = new JButton("3");
    JButton btn4 = new JButton("4");
    JButton btn5 = new JButton("5");
    JButton btn6 = new JButton("6");
    JButton btn7 = new JButton("7");
    JButton btn8 = new JButton("8");
    JButton btn9 = new JButton("9");
    //加减乘除小数点
    JButton btn_jia = new JButton("+");
    JButton btn_jian = new JButton("—");
    JButton btn_cheng = new JButton("*");
    JButton btn_chu = new JButton("/");
    JButton btn_dy = new JButton("=");
    JButton btn_dian = new JButton(".");

    public Calculator() {

        TextField.setHorizontalAlignment(JTextField.RIGHT);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));
        panel.setSize(400, 300);

        panel.add(btn1);panel.add(btn2);panel.add(btn3);panel.add(btn_jia);
        panel.add(btn4);panel.add(btn5);panel.add(btn6);panel.add(btn_jian);
        panel.add(btn7);panel.add(btn8);panel.add(btn9);panel.add(btn_cheng);
        panel.add(btn0);panel.add(btn_dian);panel.add(btn_dy);panel.add(btn_chu);

        JPanel panel2 = new JPanel();
        panel2.add(TextField, BorderLayout.WEST);
        panel2.add(clear_Button, BorderLayout.EAST);
        frame.add(panel2,BorderLayout.NORTH);
        frame.add(panel,BorderLayout.CENTER);
        frame.setLocation(400, 200);
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        clear_Button.addActionListener(new MyListener());
        btn1.addActionListener(new MyListener());
        btn2.addActionListener(new MyListener());
        btn3.addActionListener(new MyListener());
        btn_jia.addActionListener(new MyListener());
        btn4.addActionListener(new MyListener());
        btn5.addActionListener(new MyListener());
        btn6.addActionListener(new MyListener());
        btn_jian.addActionListener(new MyListener());
        btn7.addActionListener(new MyListener());
        btn8.addActionListener(new MyListener());
        btn9.addActionListener(new MyListener());
        btn_cheng.addActionListener(new MyListener());
        btn0.addActionListener(new MyListener());
        btn_dian.addActionListener(new MyListener());
        btn_dy.addActionListener(new MyListener());
        btn_chu.addActionListener(new MyListener());

    }


    private class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource().equals(btn0)) {
                s += "0";
                b+="0";
                TextField.setText(s);
            }
            if (e.getSource().equals(btn1)) {
                s += "1";
                b+="1";
                TextField.setText(s);
            }
            if (e.getSource().equals(btn2)) {
                s += "2";
                b+="2";
                TextField.setText(s);
            }
            if (e.getSource().equals(btn3)) {
                s += "3";
                b+="3";
                TextField.setText(s);
            }
            if (e.getSource().equals(btn4)) {
                s += "4";
                b+="4";
                TextField.setText(s);
            }
            if (e.getSource().equals(btn5)) {
                s += "5";
                b+="5";
                TextField.setText(s);
            }
            if (e.getSource().equals(btn6)) {
                s += "6";
                b+="6";
                TextField.setText(s);
            }
            if (e.getSource().equals(btn7)) {
                s += "7";
                b+="7";
                TextField.setText(s);
            }
            if (e.getSource().equals(btn8)) {
                s += "8";
                b+="8";
                TextField.setText(s);
            }
            if (e.getSource().equals(btn9)) {
                s += "9";
                b+="9";
                TextField.setText(s);
            }
            if (e.getSource().equals(btn_cheng)) {
                a=s;
                op = '*';
                s += "*";
                b = "";
                TextField.setText(s);
            }
            if (e.getSource().equals(btn_chu)) {
                a=s;
                op = '/';
                s += "/";
                b="";
                TextField.setText(s);
            }
            if (e.getSource().equals(btn_dian)) {
                s += ".";
                b += ".";
                TextField.setText(s);
            }
            if (e.getSource().equals(btn_jia)) {
                a= s;
                op = '+';
                s += "+";
                b="";
                TextField.setText(s);
            }
            if (e.getSource().equals(btn_jian)) {
                a=s;
                op = '-';
                s += "-";
                b="";
                TextField.setText(s);
            }
            if(e.getSource().equals(clear_Button)){
                s="";
                a ="";
                b="";
                TextField.setText(s);
            }

            if(e.getSource().equals(btn_dy)){
                BigDecimal bd1 = new BigDecimal(a);
                BigDecimal bd2 = new BigDecimal(b);
                if(op=='+'){
                    BigDecimal bd3 = bd1.add(bd2);
                    TextField.setText(bd3.toString());
                    s=bd3.toString();
                    a = bd3.toString();
                } else if (op == '-') {
                    BigDecimal bd3 = bd1.subtract(bd2);
                    TextField.setText(bd3.toString());
                    s=bd3.toString();
                    a = bd3.toString();
                }else if (op == '*') {
                    BigDecimal bd3 = bd1.multiply(bd2);
                    TextField.setText(bd3.toString());
                    s=bd3.toString();
                    a = bd3.toString();
                }else if (op == '/') {
                    BigDecimal bd3 = bd1.divide(bd2, 2,BigDecimal.ROUND_HALF_UP);
                    TextField.setText(bd3.toString());
                    s=bd3.toString();
                    a = bd3.toString();
                }
            }


        }
    }

    public static void main(String[] args) {
        Calculator cal = new Calculator();
    }
}
