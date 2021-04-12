import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TodoList extends JFrame{
    public String but;
    private List<String> tasks;
    JLabel label_up = new JLabel();
    JLabel label_down = new JLabel();
    JTextArea ta = new JTextArea(15 , 50);
    JTextField tb = new JTextField(38);
    JButton button=new JButton();

    public TodoList(){
        setBounds(200, 200, 500, 400);
        setTitle("TodoList");
        JPanel pBasic=new JPanel();
        pBasic.setLayout(new BorderLayout());
        setContentPane(pBasic);
        JPanel up=new JPanel();
        JPanel mid=new JPanel();
        JPanel down=new JPanel();
        up.setSize(470, 25);
        mid.setSize(470, 180);
        down.setSize(470, 40);
        pBasic.add(up,BorderLayout.NORTH);
        pBasic.add(mid,BorderLayout.CENTER);
        pBasic.add(down,BorderLayout.SOUTH);
        up.setBackground(Color.lightGray);
        mid.setBackground(Color.green);
        down.setBackground(Color.gray);
        label_up.setText("TodoList");
        up.add(label_up);
        ta.setLineWrap(true);
        JScrollPane scroll=new JScrollPane(ta);
        mid.add(scroll);
        label_down.setText("Input the action you want to perform here, input the content in console");
        down.add(label_down,BorderLayout.WEST);
        down.add(tb,BorderLayout.CENTER);
        button.setText("Send");
        down.add(button,BorderLayout.EAST);

        final class ShareListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                but = "";
                String taText=ta.getText();
                String tfText=tb.getText()+"\r\n";
                ta.setText(taText);
                //tb.setText("");
                but = tb.getText();
                System.out.println(but);
                if(but.contains("Add")){
                    tasks.add(askTask());
                }
                else if(but.contains("Remove")){
                    tasks.remove(askTask().replaceAll("\n",""));
                }
                else if(but.contains("InsertAt")){
                    tasks.add(askIndex("add where"), askTask());
                }
                else if(but.contains("DeleteFrom")){
                    tasks.remove(askIndex("remove from"));
                }
                else if(but.contains("MoveTo")){
                    int from = askIndex("move from index");
                    int to = askIndex("move to index");
                    String task = tasks.get(from);
                    tasks.remove(from);
                    tasks.add(to, task);
                }
                taskDisplay();
            }
        }
        button.addActionListener(new ShareListener());
        tb.addActionListener(new ShareListener());
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public void readTasks(String fname){
        try{

            Scanner sc = new Scanner(new File(fname));
            tasks = new ArrayList<String>();
            while(sc.hasNext())
                tasks.add(sc.next());
            sc.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public String askTask(){
        System.out.println("please input the name  of the task");
        //ta.setText(ta.getText().concat("please input the name  of the task"+"\n"));
        Scanner kb = new Scanner(System.in);
        return kb.nextLine();
    }

    public int askIndex(String prompt){
        System.out.println(prompt);
        Scanner kb = new Scanner(System.in);
        return kb.nextInt();
    }

    public void taskDisplay(){
        System.out.println(this.tasks.size()+" tasks to be done today!");
        ta.setText(ta.getText().concat(this.tasks.size()+" tasks to be done today!"+"\n"));
        Iterator <String> iter = tasks.iterator();
        while(iter.hasNext()){
            String buf = iter.next();
            ta.setText(ta.getText().concat(buf+"\n"));
            System.out.println(buf);
        }
        but = " ";
    }

    public static void main(String[] args){
        TodoList tl1 = new TodoList();
        tl1.readTasks("C:\\Users\\Frank\\IdeaProjects\\CPT102 DS\\test.txt");
        tl1.taskDisplay();

    }
}
