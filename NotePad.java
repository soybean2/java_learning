import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NotePad extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu file,edit;
    JMenuItem build,open,save,all,exit,copy,paste,shear;
    JTextArea textArea;
    JFileChooser fileChooser;
    Clipboard clipboard;
    public NotePad(){
        setTitle("java记事本");
        setSize(500,400);
        double w = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double h = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        setLocation((int)(w-450)/2,(int)(h-550)/2);
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        file = new JMenu("文件");
        edit = new JMenu("编辑");
        build= new JMenuItem("新建");
        open= new JMenuItem("打开");
        save= new JMenuItem("保存");
        all= new JMenuItem("全选");
        exit= new JMenuItem("退出");
        copy = new JMenuItem("粘贴");
        paste= new JMenuItem("复制");
        shear= new JMenuItem("剪切");
        textArea = new JTextArea();

        file.add(build);file.add(open);
        file.add(save);file.add(exit);
        edit.add(all);edit.add(copy);
        edit.add(paste);edit.add(shear);

        menuBar.add(file);
        menuBar.add(edit);
        add(textArea);

        open.addActionListener(new MyListener());
        save.addActionListener(new MyListener());
        build.addActionListener(new MyListener());
        exit.addActionListener(new MyListener());
        all.addActionListener(new MyListener());
        copy.addActionListener(new MyListener());
        paste.addActionListener(new MyListener());
        shear.addActionListener(new MyListener());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == open) {
                fileChooser = new JFileChooser();
                fileChooser.showOpenDialog(null);
                String path = fileChooser.getSelectedFile().getPath();
                char ch[] = new char[1024];
                try {
                    FileReader fr = new FileReader(path);
                    while (fr.read(ch) != -1) ;
                    fr.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                textArea.setText(String.valueOf(ch));
            }
            else if(e.getSource() == save) {
                fileChooser = new JFileChooser();
                fileChooser.showSaveDialog(null);
                String path = fileChooser.getSelectedFile().getPath();
                String str = textArea.getText();
                try {
                    FileWriter fw = new FileWriter(path);
                    fw.write(str);
                    fw.flush();
                    fw.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            else if(e.getSource() == build){
                textArea.setText("");
            }
            else if(e.getSource() == exit){
                System.exit(0);
            }
            else if(e.getSource() == all){
                textArea.selectAll();
            }
            else if(e.getSource() == copy){
                String string = textArea.getSelectedText();
                clipboard  = getToolkit().getSystemClipboard();
                Transferable text = new StringSelection(string);
                clipboard.setContents(text,null);
            }
            else if(e.getSource() == paste){
                Transferable s = clipboard.getContents(null);
                try {
                    String string = (String) s.getTransferData(DataFlavor.stringFlavor);
                    textArea.replaceSelection(string);
                }catch (UnsupportedFlavorException e1) {
                    e1.printStackTrace();
                }catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            else if(e.getSource() == shear){
                String string = textArea.getSelectedText();
                clipboard = getToolkit().getSystemClipboard();
                Transferable text = new StringSelection(string);
                clipboard.setContents(text,null);
                textArea.replaceSelection("");
            }
        }

    }

    public static void main(String[] args) {
        NotePad notePad = new NotePad();
    }
}

